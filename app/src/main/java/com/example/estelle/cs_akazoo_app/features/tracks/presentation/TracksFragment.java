package com.example.estelle.cs_akazoo_app.features.tracks.presentation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.estelle.cs_akazoo_app.R;
import com.example.estelle.cs_akazoo_app.features.playlists.presentation.PlaylistUI;
import com.example.estelle.cs_akazoo_app.features.tracks.domain.OnTrackClickListener;
import com.example.estelle.cs_akazoo_app.features.tracks.domain.TracksPresenter;
import com.example.estelle.cs_akazoo_app.features.tracks.domain.TracksView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * A simple {@link Fragment} subclass.
 */
public class TracksFragment extends Fragment implements TracksView {

    RecyclerView mTracksRv;
    TracksPresenter presenter;

    @BindView(R.id.playlist_name)
    TextView mPlaylistName;

    public TracksFragment() {

    }

    public static TracksFragment newInstance(PlaylistUI playlist) {
        TracksFragment myFragment = new TracksFragment();
        Bundle args = new Bundle();
        args.putParcelable("playlist", playlist);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        PlaylistUI playlist = getArguments().getParcelable("playlist");
        Timber.e(playlist.getPlaylistId());

        View v = inflater.inflate(R.layout.fragment_tracks, container, false);
        ButterKnife.bind(this, v);
        mPlaylistName.setText(playlist.getName());
        mTracksRv = v.findViewById(R.id.tracks_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mTracksRv.setLayoutManager(layoutManager);

        presenter = new TracksPresenterImpl(this);
        presenter.getTracks(playlist.getPlaylistId(), getActivity());
        return v;
    }



    @Override
    public void showTracks(final ArrayList<TrackUI> tracks) {

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TracksRvAdapter tracksRvAdapter = new TracksRvAdapter(tracks, new OnTrackClickListener() {
                    @Override
                    public void onTrackClick(TrackUI track) {
                        Toast.makeText(getActivity(), "the track "
                                + track.getTrackName() + " got clicked", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onTrackLogoClick(TrackUI track) {
                        Toast.makeText(getActivity(), "The track logo got clicked", Toast.LENGTH_LONG).show();
                    }
                }, getActivity());
                mTracksRv.setAdapter(tracksRvAdapter);
            }
        });

    }
}
