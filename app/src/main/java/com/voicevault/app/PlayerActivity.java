package com.voicevault.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlayerActivity extends AppCompatActivity {

    private WebView webView;
    private ImageButton btnPlayPause;
    private ImageButton btnBack;
    private Button btnOpenYouTube;
    private ProgressBar loadingProgress;
    private TextView tvSpeechTitle;
    private TextView tvSpeakerName;
    private TextView tvSpeechYear;
    private TextView tvSpeechDesc;
    private TextView tvPlayStatus;
    private boolean isPlaying = false;
    private String currentYoutubeId = "";

    public class AndroidBridge {
        @JavascriptInterface
        public void onReady() {
            runOnUiThread(() -> {
                loadingProgress.setVisibility(View.GONE);
                tvPlayStatus.setText("Ready to Play");
            });
        }

        @JavascriptInterface
        public void onStateChange(int state) {
            runOnUiThread(() -> {
                // 1 = playing, 2 = paused, 0 = ended, 3 = buffering
                if (state == 1) {
                    isPlaying = true;
                    btnPlayPause.setImageResource(R.drawable.ic_pause);
                    tvPlayStatus.setText("Playing");
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
                tvPlayStatus.setText("Embed restricted: Tap 'Watch on YouTube' below");
            });
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        // Get speech data from intent
        String title = getIntent().getStringExtra("title");
        String speaker = getIntent().getStringExtra("speaker");
        String year = getIntent().getStringExtra("year");
        currentYoutubeId = getIntent().getStringExtra("youtubeId");
        String description = getIntent().getStringExtra("description");

        // Init views
        webView = findViewById(R.id.youtubeWebView);
        btnPlayPause = findViewById(R.id.btnPlayPause);
        btnBack = findViewById(R.id.btnBack);
        btnOpenYouTube = findViewById(R.id.btnOpenYouTube);
        loadingProgress = findViewById(R.id.loadingProgress);
        tvSpeechTitle = findViewById(R.id.tvSpeechTitle);
        tvSpeakerName = findViewById(R.id.tvSpeakerName);
        tvSpeechYear = findViewById(R.id.tvSpeechYear);
        tvSpeechDesc = findViewById(R.id.tvSpeechDesc);
        tvPlayStatus = findViewById(R.id.tvPlayStatus);

        // Set speech info
        tvSpeechTitle.setText(title != null ? title : "Unknown Speech");
        tvSpeakerName.setText(speaker != null ? speaker : "Unknown Speaker");
        tvSpeechYear.setText(year != null ? year : "");
        if (description != null && !description.isEmpty()) {
            tvSpeechDesc.setVisibility(View.VISIBLE);
            tvSpeechDesc.setText(description);
        } else {
            tvSpeechDesc.setVisibility(View.GONE);
        }

        // Back button
        btnBack.setOnClickListener(v -> finish());

        // Open in YouTube app button
        if (btnOpenYouTube != null) {
            btnOpenYouTube.setOnClickListener(v -> {
                if (currentYoutubeId != null && !currentYoutubeId.isEmpty()) {
                    Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + currentYoutubeId));
                    Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=" + currentYoutubeId));
                    try {
                        startActivity(appIntent);
                    } catch (Exception ex) {
                        startActivity(webIntent);
                    }
                }
            });
        }

        // Setup WebView
        setupWebView(currentYoutubeId);

        // Play/Pause button
        btnPlayPause.setOnClickListener(v -> {
            if (isPlaying) {
                webView.evaluateJavascript("pauseVideo();", null);
            } else {
                webView.evaluateJavascript("playVideo();", null);
            }
        });
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void setupWebView(String youtubeId) {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        settings.setUserAgentString("Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Mobile Safari/537.36");

        webView.addJavascriptInterface(new AndroidBridge(), "AndroidBridge");
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                loadingProgress.setVisibility(View.GONE);
            }
        });

        webView.setBackgroundColor(0xFF0D1642);

        String html = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta name='viewport' content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no'>\n" +
                "<style>\n" +
                "  * { margin: 0; padding: 0; box-sizing: border-box; }\n" +
                "  body { background: #0D1642; overflow: hidden; }\n" +
                "  #player { width: 100%; height: 100vh; }\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div id='player'></div>\n" +
                "<script>\n" +
                "  var tag = document.createElement('script');\n" +
                "  tag.src = 'https://www.youtube-nocookie.com/iframe_api';\n" +
                "  var firstScriptTag = document.getElementsByTagName('script')[0];\n" +
                "  firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);\n" +
                "  var player;\n" +
                "  function onYouTubeIframeAPIReady() {\n" +
                "    player = new YT.Player('player', {\n" +
                "      videoId: '" + youtubeId + "',\n" +
                "      host: 'https://www.youtube-nocookie.com',\n" +
                "      playerVars: {\n" +
                "        'playsinline': 1,\n" +
                "        'autoplay': 1,\n" +
                "        'controls': 1,\n" +
                "        'rel': 0,\n" +
                "        'modestbranding': 1,\n" +
                "        'enablejsapi': 1,\n" +
                "        'origin': 'https://www.youtube-nocookie.com'\n" +
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
                "  }\n" +
                "  function onPlayerStateChange(event) {\n" +
                "    if (window.AndroidBridge) { window.AndroidBridge.onStateChange(event.data); }\n" +
                "  }\n" +
                "  function onPlayerError(event) {\n" +
                "    if (window.AndroidBridge) { window.AndroidBridge.onError(event.data); }\n" +
                "  }\n" +
                "  function playVideo() {\n" +
                "    if (player && player.playVideo) player.playVideo();\n" +
                "  }\n" +
                "  function pauseVideo() {\n" +
                "    if (player && player.pauseVideo) player.pauseVideo();\n" +
                "  }\n" +
                "</script>\n" +
                "</body>\n" +
                "</html>";

        webView.loadDataWithBaseURL("https://www.youtube-nocookie.com", html, "text/html", "utf-8", null);
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
