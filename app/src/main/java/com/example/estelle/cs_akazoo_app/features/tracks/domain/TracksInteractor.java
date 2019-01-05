package com.example.estelle.cs_akazoo_app.features.tracks.domain;

import android.content.Context;

import java.util.ArrayList;

public interface TracksInteractor {

    void getTracks(OnTracksFinishListener listener, String playlistId, Context ctx);

    interface OnTracksFinishListener {
        void onSuccess(ArrayList<TrackDomain> tracks);

        void onError();
    }
}
