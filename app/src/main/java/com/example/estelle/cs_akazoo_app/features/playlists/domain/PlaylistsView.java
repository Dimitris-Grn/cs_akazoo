package com.example.estelle.cs_akazoo_app.features.playlists.domain;

import com.example.estelle.cs_akazoo_app.features.playlists.presentation.PlaylistUI;

import java.util.ArrayList;

public interface PlaylistsView {

    void showPlaylists(ArrayList<PlaylistUI> playlists);

    void showGeneralError();

}
