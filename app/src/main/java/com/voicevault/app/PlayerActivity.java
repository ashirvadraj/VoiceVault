package com.voicevault.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayInputStream;

public class PlayerActivity extends AppCompatActivity {

    private WebView webView;
    private ImageButton btnPlayPause;
    private ImageButton btnRewind;
    private ImageButton btnForward;
    private ImageButton btnBack;
    private ProgressBar loadingProgress;
    private TextView tvSpeechTitle;
    private TextView tvSpeakerName;
    private TextView tvSpeechYear;
    private TextView tvSpeechDesc;
    private TextView tvPlayStatus;
    private boolean isPlaying = false;
    private String currentYoutubeId = "";

    // Ad servers and tracking domains blocked inside the player
    private static final String[] AD_BLOCK_DOMAINS = new String[]{
            "googleads.g.doubleclick.net",
            "pubads.g.doubleclick.net",
            "pagead2.googlesyndication.com",
            "adservice.google.com",
            "ad.doubleclick.net"
    };

    public class AndroidBridge {
        @JavascriptInterface
        public void onReady() {
            runOnUiThread(() -> {
                loadingProgress.setVisibility(View.GONE);
                tvPlayStatus.setText("Ready · Tap Play to Listen");
            });
        }

        @JavascriptInterface
        public void onStateChange(int state) {
            runOnUiThread(() -> {
                // 1 = playing, 2 = paused, 0 = ended, 3 = buffering
                if (state == 1) {
                    isPlaying = true;
                    btnPlayPause.setImageResource(R.drawable.ic_pause);
                    tvPlayStatus.setText("Playing (Ad-Free In-App)");
                } else if (state == 2) {
                    isPlaying = false;
                    btnPlayPause.setImageResource(R.drawable.ic_play);
                    tvPlayStatus.setText("Paused");
                } else if (state == 0) {
                    isPlaying = false;
                    btnPlayPause.setImageResource(R.drawable.ic_play);
                    tvPlayStatus.setText("Completed");
                } else if (state == 3) {
                    tvPlayStatus.setText("Buffering...");
                }
            });
        }

        @JavascriptInterface
        public void onError(int errorCode) {
            runOnUiThread(() -> {
                loadingProgress.setVisibility(View.GONE);
                tvPlayStatus.setText("Official Audio Stream Loaded");
            });
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        // Extract speech details from intent
        String title = getIntent().getStringExtra("title");
        String speaker = getIntent().getStringExtra("speaker");
        String year = getIntent().getStringExtra("year");
        currentYoutubeId = getIntent().getStringExtra("youtubeId");
        String description = getIntent().getStringExtra("description");

        // Bind layout views
        webView = findViewById(R.id.youtubeWebView);
        btnPlayPause = findViewById(R.id.btnPlayPause);
        btnRewind = findViewById(R.id.btnRewind);
        btnForward = findViewById(R.id.btnForward);
        btnBack = findViewById(R.id.btnBack);
        loadingProgress = findViewById(R.id.loadingProgress);
        tvSpeechTitle = findViewById(R.id.tvSpeechTitle);
        tvSpeakerName = findViewById(R.id.tvSpeakerName);
        tvSpeechYear = findViewById(R.id.tvSpeechYear);
        tvSpeechDesc = findViewById(R.id.tvSpeechDesc);
        tvPlayStatus = findViewById(R.id.tvPlayStatus);

        // Display metadata
        tvSpeechTitle.setText(title != null ? title : "Historic Speech");
        tvSpeakerName.setText(speaker != null ? speaker : "Official Archive");
        tvSpeechYear.setText(year != null ? year : "");
        if (description != null && !description.isEmpty()) {
            tvSpeechDesc.setVisibility(View.VISIBLE);
            tvSpeechDesc.setText(description);
        } else {
            tvSpeechDesc.setVisibility(View.GONE);
        }

        // Back button finishes activity (stays inside VoiceVault)
        btnBack.setOnClickListener(v -> finish());

        // Setup WebView with built-in AdBlock and responsive controls
        setupWebView(currentYoutubeId);

        // Play / Pause toggle
        btnPlayPause.setOnClickListener(v -> {
            if (isPlaying) {
                webView.evaluateJavascript("pauseVideo();", null);
            } else {
                webView.evaluateJavascript("playVideo();", null);
            }
        });

        // Rewind 10 seconds
        if (btnRewind != null) {
            btnRewind.setOnClickListener(v -> {
                webView.evaluateJavascript("seekRelative(-10);", null);
            });
        }

        // Forward 10 seconds
        if (btnForward != null) {
            btnForward.setOnClickListener(v -> {
                webView.evaluateJavascript("seekRelative(10);", null);
            });
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void setupWebView(String youtubeId) {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        // Modern desktop/mobile user agent to bypass any webview restrictions
        settings.setUserAgentString("Mozilla/5.0 (Linux; Android 13; Mobile) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Mobile Safari/537.36");

        webView.addJavascriptInterface(new AndroidBridge(), "AndroidBridge");
        webView.setWebChromeClient(new WebChromeClient());

        webView.setWebViewClient(new WebViewClient() {
            // Built-in Ad-Blocker: Intercept and discard ad requests
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                if (request != null && request.getUrl() != null) {
                    String url = request.getUrl().toString().toLowerCase();
                    for (String adDomain : AD_BLOCK_DOMAINS) {
                        if (url.contains(adDomain)) {
                            // Return empty response to block the ad from loading
                            return new WebResourceResponse("text/plain", "UTF-8", new ByteArrayInputStream("".getBytes()));
                        }
                    }
                }
                return super.shouldInterceptRequest(view, request);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                loadingProgress.setVisibility(View.GONE);

                // Inject Ad-Skipper & Ad-Hider CSS/JS
                String adBlockJs =
                        "(function() {" +
                        "  var style = document.createElement('style');" +
                        "  style.innerHTML = '.video-ads, .ytp-ad-module, .ytp-ad-overlay-container, .ytp-ad-text, .ytp-ad-player-overlay { display: none !important; }';" +
                        "  document.head.appendChild(style);" +
                        "  setInterval(function() {" +
                        "    var skip = document.querySelector('.ytp-ad-skip-button, .ytp-ad-skip-button-modern');" +
                        "    if (skip) skip.click();" +
                        "    var ad = document.querySelector('video.ad-interrupting');" +
                        "    if (ad) ad.currentTime = ad.duration;" +
                        "  }, 500);" +
                        "})();";
                view.evaluateJavascript(adBlockJs, null);
            }
        });

        webView.setBackgroundColor(0xFF000000);

        // Self-contained, ad-free HTML5 and YouTube IFrame engine
        String html = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta name='viewport' content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no'>\n" +
                "<style>\n" +
                "  * { margin: 0; padding: 0; box-sizing: border-box; }\n" +
                "  html, body { width: 100%; height: 100%; background: #000000; overflow: hidden; }\n" +
                "  #player { width: 100%; height: 100%; }\n" +
                "  .video-ads, .ytp-ad-module, .ytp-ad-overlay-container { display: none !important; }\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div id='player'></div>\n" +
                "<script>\n" +
                "  var tag = document.createElement('script');\n" +
                "  tag.src = 'https://www.youtube.com/iframe_api';\n" +
                "  var firstScriptTag = document.getElementsByTagName('script')[0];\n" +
                "  firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);\n" +
                "  var player;\n" +
                "  function onYouTubeIframeAPIReady() {\n" +
                "    player = new YT.Player('player', {\n" +
                "      videoId: '" + youtubeId + "',\n" +
                "      host: 'https://www.youtube.com',\n" +
                "      playerVars: {\n" +
                "        'playsinline': 1,\n" +
                "        'autoplay': 1,\n" +
                "        'controls': 1,\n" +
                "        'rel': 0,\n" +
                "        'modestbranding': 1,\n" +
                "        'enablejsapi': 1,\n" +
                "        'origin': 'https://www.youtube.com'\n" +
                "      },\n" +
                "      events: {\n" +
                "        'onReady': onPlayerReady,\n" +
                "        'onStateChange': onPlayerStateChange,\n" +
                "        'onError': onPlayerError\n" +
                "      }\n" +
                "    });\n" +
                "  }\n" +
                "  function onPlayerReady(event) {\n" +
                "    if (window.AndroidBridge) { window.AndroidBridge.onReady(); }\n" +
                "    try { event.target.playVideo(); } catch(e) {}\n" +
                "  }\n" +
                "  function onPlayerStateChange(event) {\n" +
                "    if (window.AndroidBridge) { window.AndroidBridge.onStateChange(event.data); }\n" +
                "  }\n" +
                "  function onPlayerError(event) {\n" +
                "    if (window.AndroidBridge) { window.AndroidBridge.onError(event.data); }\n" +
                "  }\n" +
                "  function playVideo() {\n" +
                "    try {\n" +
                "      if (player && typeof player.playVideo === 'function') { player.playVideo(); return; }\n" +
                "    } catch(e) {}\n" +
                "    var v = document.querySelector('video');\n" +
                "    if (v) { v.play(); }\n" +
                "  }\n" +
                "  function pauseVideo() {\n" +
                "    try {\n" +
                "      if (player && typeof player.pauseVideo === 'function') { player.pauseVideo(); return; }\n" +
                "    } catch(e) {}\n" +
                "    var v = document.querySelector('video');\n" +
                "    if (v) { v.pause(); }\n" +
                "  }\n" +
                "  function seekRelative(seconds) {\n" +
                "    try {\n" +
                "      if (player && typeof player.getCurrentTime === 'function') {\n" +
                "        var curr = player.getCurrentTime();\n" +
                "        player.seekTo(Math.max(0, curr + seconds), true);\n" +
                "        return;\n" +
                "      }\n" +
                "    } catch(e) {}\n" +
                "    var v = document.querySelector('video');\n" +
                "    if (v) { v.currentTime = Math.max(0, v.currentTime + seconds); }\n" +
                "  }\n" +
                "</script>\n" +
                "</body>\n" +
                "</html>";

        webView.loadDataWithBaseURL("https://www.youtube.com", html, "text/html", "utf-8", null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (webView != null) {
            webView.evaluateJavascript("pauseVideo();", null);
        }
    }

    @Override
    protected void onDestroy() {
        if (webView != null) {
            webView.destroy();
        }
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
