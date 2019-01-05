package com.example.estelle.cs_akazoo_app.rest.responses;

import com.example.estelle.cs_akazoo_app.features.playlists.domain.PlaylistDomain;

import java.util.ArrayList;

public class PlaylistsResponse {

    private ArrayList<PlaylistDomain> Result;

    public PlaylistsResponse(ArrayList<PlaylistDomain> result) {
        Result = result;
    }

    public ArrayList<PlaylistDomain> getResult() {
        return Result;
    }

    public void setResult(ArrayList<PlaylistDomain> result) {
        Result = result;
    }
}
