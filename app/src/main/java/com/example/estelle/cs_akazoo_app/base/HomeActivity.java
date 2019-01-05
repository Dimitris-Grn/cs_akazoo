package com.example.estelle.cs_akazoo_app.base;

import android.os.Parcel;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.estelle.cs_akazoo_app.R;
import com.example.estelle.cs_akazoo_app.features.playlists.presentation.PlaylistUI;
import com.example.estelle.cs_akazoo_app.features.playlists.presentation.PlaylistsFragment;
import com.example.estelle.cs_akazoo_app.features.tracks.presentation.TracksFragment;

public class HomeActivity extends AppCompatActivity implements HomeView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlists);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.playlists_root, PlaylistsFragment.newInstance(this))
                .commit();
    }


    @Override
    public void addTracksFragment(PlaylistUI playlist) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.playlists_root, TracksFragment.newInstance(playlist))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void addPlaylistFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.playlists_root, PlaylistsFragment.newInstance(this))
                .commit();
    }
}
