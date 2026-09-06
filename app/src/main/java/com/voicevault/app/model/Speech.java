package com.voicevault.app.model;

import java.io.Serializable;

public class Speech implements Serializable {
    private String title;
    private String year;
    private String youtubeId;
    private String speakerName;
    private String description;

    public Speech(String title, String year, String youtubeId, String speakerName, String description) {
        this.title = title;
        this.year = year;
        this.youtubeId = youtubeId;
        this.speakerName = speakerName;
        this.description = description;
    }

    public String getTitle() { return title; }
    public String getYear() { return year; }
    public String getYoutubeId() { return youtubeId; }
    public String getSpeakerName() { return speakerName; }
    public String getDescription() { return description; }
}
