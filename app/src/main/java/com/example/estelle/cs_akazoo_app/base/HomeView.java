package com.example.estelle.cs_akazoo_app.base;

import android.os.Parcelable;

import com.example.estelle.cs_akazoo_app.features.playlists.presentation.PlaylistUI;

import java.io.Serializable;

public interface HomeView extends Serializable{

     void addTracksFragment(PlaylistUI playlist);

     void addPlaylistFragment();
}
