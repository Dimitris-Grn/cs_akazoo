package com.example.estelle.cs_akazoo_app.features.tracks.domain;

import android.content.Context;

public interface TracksPresenter {

    void getTracks(String playlistId, Context ctx);

}
