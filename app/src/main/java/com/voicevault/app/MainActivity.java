package com.voicevault.app;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.voicevault.app.adapter.SpeechListAdapter;
import com.voicevault.app.data.SpeechDatabase;
import com.voicevault.app.model.Speaker;
import com.voicevault.app.model.Speech;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SpeechListAdapter adapter;
    private EditText searchEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.speechRecyclerView);
        searchEditText = findViewById(R.id.searchEditText);

        // Setup RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Build initial list
        List<Object> displayList = SpeechDatabase.buildDisplayList();
        adapter = new SpeechListAdapter(this, displayList);

        adapter.setOnSpeechClickListener(speech -> {
            Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
            intent.putExtra("title", speech.getTitle());
            intent.putExtra("speaker", speech.getSpeakerName());
            intent.putExtra("year", speech.getYear());
            intent.putExtra("youtubeId", speech.getYoutubeId());
            intent.putExtra("description", speech.getDescription());
            startActivity(intent);
        });

        adapter.setOnSpeakerClickListener((speaker, position) -> {
            speaker.setExpanded(!speaker.isExpanded());
            adapter.updateItems(SpeechDatabase.buildDisplayList());
        });

        recyclerView.setAdapter(adapter);

        // Setup search
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String query = s.toString().trim();
                if (query.isEmpty()) {
                    adapter.updateItems(SpeechDatabase.buildDisplayList());
                } else {
                    adapter.updateItems(SpeechDatabase.getFilteredList(query));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
}
