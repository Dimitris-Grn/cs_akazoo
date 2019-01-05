package com.example.estelle.cs_akazoo_app.features.playlists.presentation;

import android.content.Context;

import com.example.estelle.cs_akazoo_app.R;
import com.example.estelle.cs_akazoo_app.features.playlists.data.PlaylistsInteractorImpl;
import com.example.estelle.cs_akazoo_app.features.playlists.domain.PlaylistDomain;
import com.example.estelle.cs_akazoo_app.features.playlists.domain.PlaylistOwner;
import com.example.estelle.cs_akazoo_app.features.playlists.domain.PlaylistsInteractor;
import com.example.estelle.cs_akazoo_app.features.playlists.domain.PlaylistsPresenter;
import com.example.estelle.cs_akazoo_app.features.playlists.domain.PlaylistsView;

import java.util.ArrayList;

public class PlaylistsPresenterImpl implements PlaylistsPresenter,
        PlaylistsInteractor.OnPlaylistsFinishListener {

    PlaylistsView playlistsView;
    PlaylistsInteractor interactor;

    public PlaylistsPresenterImpl(PlaylistsView playlistsView) {
        this.playlistsView = playlistsView;
        interactor = new PlaylistsInteractorImpl();
    }

    @Override
    public void getPlaylists(Context ctx, Boolean refresh) {
        interactor.getPlaylists(this, ctx, refresh);
    }

    @Override
    public void getFilteredPlaylists(String filterString) {
        interactor.getFilteredPlaylists(this, filterString);
    }


    @Override
    public void onSuccess(ArrayList<PlaylistDomain> playlists) {
        ArrayList<PlaylistUI> playlistsUI = new ArrayList<>();
        if (playlists != null && !playlists.isEmpty()) {
            for (PlaylistDomain playlist : playlists) {
                PlaylistUI playlistUI = new PlaylistUI(
                        playlist.getPlaylistId(),
                        playlist.getName(),
                        playlist.getItemCount(),
                        playlist.getPhotoUrl()
                );
                setNameColorBsedOnTrackCount(playlistUI);
                setNameFontSizeBasedOnOwner(playlist, playlistUI);
                playlistsUI.add(playlistUI);
            }
        }
        playlistsView.showPlaylists(playlistsUI);
    }

    private void setNameFontSizeBasedOnOwner(PlaylistDomain playlist, PlaylistUI playlistUI) {
        if (playlist.getOwnerNickName().equals(PlaylistOwner.ZERVOS.getString()))
            playlistUI.setPlaylistNameFontSize(13);
        else if (playlist.getOwnerNickName().equals(PlaylistOwner.IOS_TESTER.getString()))
            playlistUI.setPlaylistNameFontSize(16);
        else if (playlist.getOwnerNickName().equals(PlaylistOwner.AKAZOO_RECOMMENDER.getString()))
            playlistUI.setPlaylistNameFontSize(20);
    }

    private void setNameColorBsedOnTrackCount(PlaylistUI playlistUI) {
        if (playlistUI.getItemCount() > 40)
            playlistUI.setColorId(R.color.red);
        else
            playlistUI.setColorId(R.color.blue);
    }

    @Override
    public void onError() {
        playlistsView.showGeneralError();
    }
}
