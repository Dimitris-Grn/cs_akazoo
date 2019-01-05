package com.example.estelle.cs_akazoo_app.features.playlists.domain;

import android.content.Context;

import java.util.ArrayList;

public interface PlaylistsInteractor {

    void getPlaylists(OnPlaylistsFinishListener listener, Context ctx, Boolean refresh);

    void getFilteredPlaylists(OnPlaylistsFinishListener listener, String filterString);

    interface OnPlaylistsFinishListener {

        void onSuccess(ArrayList<PlaylistDomain> playlists);

        void onError();

    }

}
