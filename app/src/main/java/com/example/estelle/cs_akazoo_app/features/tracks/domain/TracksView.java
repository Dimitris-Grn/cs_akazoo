package com.example.estelle.cs_akazoo_app.features.tracks.domain;

import com.example.estelle.cs_akazoo_app.features.tracks.presentation.TrackUI;

import java.util.ArrayList;

public interface TracksView {

    void showTracks(ArrayList<TrackUI> tracks);

}
