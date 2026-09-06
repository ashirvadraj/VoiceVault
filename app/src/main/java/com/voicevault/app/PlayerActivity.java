package com.voicevault.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.CookieManager;
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
                // 1 = playing, 2 = paused, 0 = ended
                if (state == 1) {
                    isPlaying = true;
                    btnPlayPause.setImageResource(R.drawable.ic_pause);
                    tvPlayStatus.setText("Playing (Ad-Free In-App)");
                    loadingProgress.setVisibility(View.GONE);
                } else if (state == 2) {
                    isPlaying = false;
                    btnPlayPause.setImageResource(R.drawable.ic_play);
                    tvPlayStatus.setText("Paused");
                } else if (state == 0) {
                    isPlaying = false;
                    btnPlayPause.setImageResource(R.drawable.ic_play);
                    tvPlayStatus.setText("Completed");
                }
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

        // Setup WebView
        setupWebView();

        // Play / Pause toggle
        btnPlayPause.setOnClickListener(v -> {
            webView.evaluateJavascript(
                "(function() {" +
                "  var v = document.querySelector('video');" +
                "  if (v) {" +
                "    if (v.paused) { v.play(); } else { v.pause(); }" +
                "  } else {" +
                "    var btn = document.querySelector('.ytp-play-button, .player-control-play-pause-icon, button[aria-label=\"Play\"], button[aria-label=\"Pause\"]');" +
                "    if (btn) btn.click();" +
                "  }" +
                "})();", null);
        });

        // Rewind 10 seconds
        if (btnRewind != null) {
            btnRewind.setOnClickListener(v -> {
                webView.evaluateJavascript(
                    "(function() {" +
                    "  var v = document.querySelector('video');" +
                    "  if (v) { v.currentTime = Math.max(0, v.currentTime - 10); }" +
                    "})();", null);
            });
        }

        // Forward 10 seconds
        if (btnForward != null) {
            btnForward.setOnClickListener(v -> {
                webView.evaluateJavascript(
                    "(function() {" +
                    "  var v = document.querySelector('video');" +
                    "  if (v) { v.currentTime = v.currentTime + 10; }" +
                    "})();", null);
            });
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void setupWebView() {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        // Modern Android Chrome user agent so YouTube serves HTML5 mobile video
        settings.setUserAgentString("Mozilla/5.0 (Linux; Android 13; Mobile) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Mobile Safari/537.36");

        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setAcceptThirdPartyCookies(webView, true);

        webView.addJavascriptInterface(new AndroidBridge(), "AndroidBridge");
        webView.setWebChromeClient(new WebChromeClient());

        webView.setWebViewClient(new WebViewClient() {
            // CRITICAL: Block external intents and redirects so playback NEVER leaves the app
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (request != null && request.getUrl() != null) {
                    String url = request.getUrl().toString();
                    return handleUrl(url);
                }
                return true;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return handleUrl(url);
            }

            private boolean handleUrl(String url) {
                if (url == null) return true;
                // Block intent:, vnd.youtube:, market:, and non-http schemes completely
                if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    return true; // Cancel and do NOT launch external app!
                }
                // Allow current video URL
                if (url.contains(currentYoutubeId)) {
                    return false;
                }
                // Block navigation to other videos, search, or channels
                return true;
            }

            // Block ad servers
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                if (request != null && request.getUrl() != null) {
                    String url = request.getUrl().toString().toLowerCase();
                    for (String adDomain : AD_BLOCK_DOMAINS) {
                        if (url.contains(adDomain)) {
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

                // Inject CSS to make player fill view & hide all external/suggested UI, headers, comments
                String hideUiCss =
                    "ytm-mobile-topbar-renderer, ytm-pivot-bar-renderer, ytm-single-column-watch-next-results-renderer, " +
                    ".engagement-panel, ytm-comment-section-renderer, ytm-item-section-renderer, " +
                    ".standalone-collection-badge-renderer, ytm-promoted-sparkles-web-renderer, " +
                    "ytm-companion-ad-renderer, .ad-showing, .ad-container, .ytp-ad-module, " +
                    "#header-bar, .ytp-chrome-top, .open-in-app-banner, .mobile-topbar-header { " +
                    "  display: none !important; " +
                    "} " +
                    "html, body { " +
                    "  background: #000000 !important; " +
                    "  overflow: hidden !important; " +
                    "  margin: 0 !important; padding: 0 !important; " +
                    "} " +
                    "#player-container-id, .player-container, .video-stream { " +
                    "  width: 100% !important; " +
                    "  height: 100% !important; " +
                    "  position: fixed !important; " +
                    "  top: 0 !important; left: 0 !important; " +
                    "  margin: 0 !important; padding: 0 !important; " +
                    "  z-index: 99999 !important; " +
                    "} " +
                    "video { " +
                    "  width: 100% !important; height: 100% !important; " +
                    "  object-fit: contain !important; " +
                    "}";

                String injectCssJs =
                    "(function() {" +
                    "  var style = document.createElement('style');" +
                    "  style.innerHTML = '" + hideUiCss.replace("'", "\\'") + "';" +
                    "  document.head.appendChild(style);" +
                    "})();";
                view.evaluateJavascript(injectCssJs, null);

                // Inject video event hooks and ad skipper
                String controllerJs =
                    "(function() {" +
                    "  function setup() {" +
                    "    var v = document.querySelector('video');" +
                    "    if (v && !v._vv_hooked) {" +
                    "      v._vv_hooked = true;" +
                    "      if (window.AndroidBridge) { window.AndroidBridge.onReady(); }" +
                    "      v.addEventListener('play', function() { if (window.AndroidBridge) window.AndroidBridge.onStateChange(1); });" +
                    "      v.addEventListener('pause', function() { if (window.AndroidBridge) window.AndroidBridge.onStateChange(2); });" +
                    "      v.addEventListener('ended', function() { if (window.AndroidBridge) window.AndroidBridge.onStateChange(0); });" +
                    "      try { v.play(); } catch(e) {}" +
                    "    }" +
                    "    var skip = document.querySelector('.ytp-ad-skip-button, .ytp-ad-skip-button-modern, .ytp-skip-ad-button');" +
                    "    if (skip) { skip.click(); }" +
                    "    var ad = document.querySelector('video.ad-interrupting, .ad-showing video');" +
                    "    if (ad && isFinite(ad.duration) && ad.duration > 0) { ad.currentTime = ad.duration; }" +
                    "  }" +
                    "  setInterval(setup, 300);" +
                    "  setup();" +
                    "})();";
                view.evaluateJavascript(controllerJs, null);
            }
        });

        webView.setBackgroundColor(0xFF000000);
        // Load the mobile YouTube video page
        webView.loadUrl("https://m.youtube.com/watch?v=" + currentYoutubeId);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (webView != null) {
            webView.evaluateJavascript("var v = document.querySelector('video'); if (v) v.pause();", null);
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
        if (webView != null) {
            webView.evaluateJavascript("var v = document.querySelector('video'); if (v) v.pause();", null);
        }
        super.onBackPressed();
    }
}
