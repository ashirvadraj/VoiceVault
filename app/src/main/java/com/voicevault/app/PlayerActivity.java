package com.voicevault.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlayerActivity extends AppCompatActivity {

    private WebView webView;
    private ImageButton btnPlayPause;
    private ImageButton btnBack;
    private ProgressBar loadingProgress;
    private TextView tvSpeechTitle;
    private TextView tvSpeakerName;
    private TextView tvSpeechYear;
    private TextView tvSpeechDesc;
    private TextView tvPlayStatus;
    private boolean isPlaying = false;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        // Get speech data from intent
        String title = getIntent().getStringExtra("title");
        String speaker = getIntent().getStringExtra("speaker");
        String year = getIntent().getStringExtra("year");
        String youtubeId = getIntent().getStringExtra("youtubeId");
        String description = getIntent().getStringExtra("description");

        // Init views
        webView = findViewById(R.id.youtubeWebView);
        btnPlayPause = findViewById(R.id.btnPlayPause);
        btnBack = findViewById(R.id.btnBack);
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

        // Setup WebView
        setupWebView(youtubeId);

        // Play/Pause button
        btnPlayPause.setOnClickListener(v -> {
            if (isPlaying) {
                webView.evaluateJavascript("pauseVideo();", null);
                btnPlayPause.setImageResource(R.drawable.ic_play);
                tvPlayStatus.setText("Paused");
                isPlaying = false;
            } else {
                webView.evaluateJavascript("playVideo();", null);
                btnPlayPause.setImageResource(R.drawable.ic_pause);
                tvPlayStatus.setText("Playing");
                isPlaying = true;
            }
        });
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void setupWebView(String youtubeId) {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setDomStorageEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);

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
                "  iframe { width: 100%; height: 100%; border: none; }\n" +
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
                "      playerVars: {\n" +
                "        'playsinline': 1,\n" +
                "        'autoplay': 0,\n" +
                "        'controls': 1,\n" +
                "        'rel': 0,\n" +
                "        'modestbranding': 1,\n" +
                "        'fs': 1\n" +
                "      },\n" +
                "      events: {\n" +
                "        'onReady': onPlayerReady,\n" +
                "        'onStateChange': onPlayerStateChange\n" +
                "      }\n" +
                "    });\n" +
                "  }\n" +
                "  function onPlayerReady(event) {\n" +
                "    // Player is ready\n" +
                "  }\n" +
                "  function onPlayerStateChange(event) {\n" +
                "    // 1 = playing, 2 = paused\n" +
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
