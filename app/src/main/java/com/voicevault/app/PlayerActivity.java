package com.voicevault.app;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class PlayerActivity extends AppCompatActivity {

    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer activeYouTubePlayer;
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
    private float currentSecond = 0f;
    private String currentYoutubeId = "";

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
        youTubePlayerView = findViewById(R.id.youtubePlayerView);
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

        // Attach YouTubePlayerView to lifecycle
        getLifecycle().addObserver(youTubePlayerView);

        // Native YouTubePlayer listener
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                activeYouTubePlayer = youTubePlayer;
                loadingProgress.setVisibility(View.GONE);
                tvPlayStatus.setText("Playing (In-App Ad-Free)");
                if (currentYoutubeId != null && !currentYoutubeId.isEmpty()) {
                    youTubePlayer.loadVideo(currentYoutubeId, 0f);
                }
            }

            @Override
            public void onStateChange(@NonNull YouTubePlayer youTubePlayer, @NonNull PlayerConstants.PlayerState state) {
                if (state == PlayerConstants.PlayerState.PLAYING) {
                    isPlaying = true;
                    btnPlayPause.setImageResource(R.drawable.ic_pause);
                    tvPlayStatus.setText("Playing (Ad-Free In-App)");
                    loadingProgress.setVisibility(View.GONE);
                } else if (state == PlayerConstants.PlayerState.PAUSED) {
                    isPlaying = false;
                    btnPlayPause.setImageResource(R.drawable.ic_play);
                    tvPlayStatus.setText("Paused");
                } else if (state == PlayerConstants.PlayerState.ENDED) {
                    isPlaying = false;
                    btnPlayPause.setImageResource(R.drawable.ic_play);
                    tvPlayStatus.setText("Completed");
                } else if (state == PlayerConstants.PlayerState.BUFFERING) {
                    tvPlayStatus.setText("Buffering...");
                }
            }

            @Override
            public void onCurrentSecond(@NonNull YouTubePlayer youTubePlayer, float second) {
                currentSecond = second;
            }

            @Override
            public void onError(@NonNull YouTubePlayer youTubePlayer, @NonNull PlayerConstants.PlayerError error) {
                loadingProgress.setVisibility(View.GONE);
                tvPlayStatus.setText("Ready");
            }
        });

        // Play / Pause toggle
        btnPlayPause.setOnClickListener(v -> {
            if (activeYouTubePlayer != null) {
                if (isPlaying) {
                    activeYouTubePlayer.pause();
                } else {
                    activeYouTubePlayer.play();
                }
            }
        });

        // Rewind 10 seconds
        if (btnRewind != null) {
            btnRewind.setOnClickListener(v -> {
                if (activeYouTubePlayer != null) {
                    activeYouTubePlayer.seekTo(Math.max(0f, currentSecond - 10f));
                }
            });
        }

        // Forward 10 seconds
        if (btnForward != null) {
            btnForward.setOnClickListener(v -> {
                if (activeYouTubePlayer != null) {
                    activeYouTubePlayer.seekTo(currentSecond + 10f);
                }
            });
        }
    }

    @Override
    protected void onDestroy() {
        if (youTubePlayerView != null) {
            youTubePlayerView.release();
        }
        super.onDestroy();
    }
}
