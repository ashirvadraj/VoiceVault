package com.voicevault.app.model;

import java.util.List;
import java.util.ArrayList;

public class Speaker {
    private String name;
    private String country;
    private String initials;
    private int avatarColor;
    private List<Speech> speeches;
    private boolean expanded;

    public Speaker(String name, String country, String initials, int avatarColor) {
        this.name = name;
        this.country = country;
        this.initials = initials;
        this.avatarColor = avatarColor;
        this.speeches = new ArrayList<>();
        this.expanded = false;
    }

    public void addSpeech(Speech speech) { speeches.add(speech); }
    public String getName() { return name; }
    public String getCountry() { return country; }
    public String getInitials() { return initials; }
    public int getAvatarColor() { return avatarColor; }
    public List<Speech> getSpeeches() { return speeches; }
    public boolean isExpanded() { return expanded; }
    public void setExpanded(boolean expanded) { this.expanded = expanded; }
    public int getSpeechCount() { return speeches.size(); }
}
