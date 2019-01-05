package com.example.estelle.cs_akazoo_app.features.playlists.domain;


import android.content.Context;

public interface PlaylistsPresenter {

    void getPlaylists(Context ctx, Boolean refresh);

    void getFilteredPlaylists(String filter);

}
