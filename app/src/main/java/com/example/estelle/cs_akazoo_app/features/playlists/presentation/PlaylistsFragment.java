package com.example.estelle.cs_akazoo_app.features.playlists.presentation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.estelle.cs_akazoo_app.R;
import com.example.estelle.cs_akazoo_app.base.HomeActivity;
import com.example.estelle.cs_akazoo_app.base.HomeView;
import com.example.estelle.cs_akazoo_app.features.playlists.domain.OnPlaylistClickListener;
import com.example.estelle.cs_akazoo_app.features.playlists.domain.PlaylistDomain;
import com.example.estelle.cs_akazoo_app.features.playlists.domain.PlaylistsPresenter;
import com.example.estelle.cs_akazoo_app.features.playlists.domain.PlaylistsView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlaylistsFragment extends Fragment implements PlaylistsView {

    @BindView(R.id.playslists_rv)
    RecyclerView playlistsRv;
    @BindView(R.id.filter_edit_text)
    EditText mFilterEditText;
    @BindView(R.id.playlists_root)
    SwipeRefreshLayout mPlaylistsRoot;

    PlaylistsPresenter presenter;

    public PlaylistsFragment() {
    }

    HomeView homeView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_playlists, container, false);
        ButterKnife.bind(this, v);
        homeView = (HomeView) getArguments().getSerializable("home_view");

        mPlaylistsRoot.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getPlaylists(getActivity(), true);
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        playlistsRv.setLayoutManager(layoutManager);
        presenter = new PlaylistsPresenterImpl(this);
        presenter.getPlaylists(getActivity(), false);
        return v;
    }

    @Override
    public void showPlaylists(final ArrayList<PlaylistUI> playlists) {
        mPlaylistsRoot.setRefreshing(false);
        getActivity().runOnUiThread(new Runnable() {

            PlaylistsRvAdapter playlistsRvAdapter = new PlaylistsRvAdapter(playlists, new OnPlaylistClickListener() {
                @Override
                public void onPlaylistClicked(PlaylistUI playlist) {
                    homeView.addTracksFragment(playlist);
                }
            }, getActivity());

            @Override
            public void run() {
                playlistsRv.setAdapter(playlistsRvAdapter);
            }
        });
    }

    @Override
    public void showGeneralError() {
        mPlaylistsRoot.setRefreshing(false);
        Toast.makeText(getContext(), getString(R.string.general_error_message), Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.filter_button)
    public void filterPlaylists(View view) {
        String filterText = mFilterEditText.getText().toString();
        presenter.getFilteredPlaylists(filterText);
    }

    public static PlaylistsFragment newInstance(HomeView homeView) {

        Bundle args = new Bundle();
        PlaylistsFragment fragment = new PlaylistsFragment();
        args.putSerializable("home_view", homeView);
        fragment.setArguments(args);
        return fragment;
    }
}
