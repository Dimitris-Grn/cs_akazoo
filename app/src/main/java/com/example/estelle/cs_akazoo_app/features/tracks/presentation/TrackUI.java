package com.example.estelle.cs_akazoo_app.features.tracks.presentation;

public class TrackUI {

    private String trackName;
    private String trackArtist;
    private String trackLogoUrl;
    private int trackNameColorid;

    public TrackUI(String trackName, String trackArtist, String trackLogoUrl, int trackNameColorid) {
        this.trackName = trackName;
        this.trackArtist = trackArtist;
        this.trackLogoUrl = trackLogoUrl;
        this.trackNameColorid = trackNameColorid;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackArtist() {
        return trackArtist;
    }

    public void setTrackArtist(String trackArtist) {
        this.trackArtist = trackArtist;
    }

    public String getTrackLogoUrl() {
        return trackLogoUrl;
    }

    public void setTrackLogoUrl(String trackLogoUrl) {
        this.trackLogoUrl = trackLogoUrl;
    }

    public int getTrackNameColorid() {
        return trackNameColorid;
    }

    public void setTrackNameColorid(int trackNameColorid) {
        this.trackNameColorid = trackNameColorid;
    }
}
