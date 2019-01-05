package com.example.estelle.cs_akazoo_app.features.playlists.domain;

public enum PlaylistOwner {

    IOS_TESTER("Apostolos Zervos"),
    AKAZOO_RECOMMENDER("test ios"),
    ZERVOS("Akazoo Recommends");

    private final String string;

    PlaylistOwner(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
