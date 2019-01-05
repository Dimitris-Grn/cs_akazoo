package com.example.estelle.cs_akazoo_app.rest.responses;

import com.example.estelle.cs_akazoo_app.features.tracks.domain.TrackDomain;

import java.util.ArrayList;

public class TracksResponseItem {

    private ArrayList<TrackDomain> Items;

    public ArrayList<TrackDomain> getItems() {
        return Items;
    }

    public void setItems(ArrayList<TrackDomain> items) {
        Items = items;
    }

}
