package com.example.estelle.cs_akazoo_app.features.tracks.presentation;

import android.content.Context;

import com.example.estelle.cs_akazoo_app.R;
import com.example.estelle.cs_akazoo_app.features.tracks.data.TracksInteractorImpl;
import com.example.estelle.cs_akazoo_app.features.tracks.domain.TrackDomain;
import com.example.estelle.cs_akazoo_app.features.tracks.domain.TracksInteractor;
import com.example.estelle.cs_akazoo_app.features.tracks.domain.TracksPresenter;
import com.example.estelle.cs_akazoo_app.features.tracks.domain.TracksView;

import java.util.ArrayList;

public class TracksPresenterImpl implements TracksPresenter,
        TracksInteractor.OnTracksFinishListener {

    TracksView view;
    TracksInteractor interactor;

    public TracksPresenterImpl(TracksView view) {
        this.view = view;
        interactor = new TracksInteractorImpl();
    }


    @Override
    public void getTracks(String playlistId, Context ctx) {
        interactor.getTracks(this, playlistId, ctx);
    }


    @Override
    public void onSuccess(ArrayList<TrackDomain> tracks) {
        ArrayList<TrackUI> tracksUI = new ArrayList<>();
        for (TrackDomain trackd : tracks) {
            TrackUI trackUi = new TrackUI(trackd.getTrackName(),
                    trackd.getArtistName(),
                    trackd.getImageUrl(),
                    R.color.colorPrimaryDark);
            tracksUI.add(trackUi);
        }
        view.showTracks(tracksUI);
    }

    @Override
    public void onError() {

    }
}
