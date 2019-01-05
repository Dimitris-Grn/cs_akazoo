package com.example.estelle.cs_akazoo_app.features.playlists.presentation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.estelle.cs_akazoo_app.R;
import com.example.estelle.cs_akazoo_app.features.playlists.domain.OnPlaylistClickListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlaylistsRvAdapter extends RecyclerView.Adapter<PlaylistsRvAdapter.PlaylistsViewHolder> {

    private ArrayList<PlaylistUI> playlists;
    private OnPlaylistClickListener listener;
    private Context context;

    public PlaylistsRvAdapter(ArrayList<PlaylistUI> playlists, OnPlaylistClickListener listener, Context context) {
        this.playlists = playlists;
        this.listener = listener;
        this.context = context;
    }

    public static class PlaylistsViewHolder extends RecyclerView.ViewHolder {
        TextView mPlaylistName;
        TextView mTracksNumber;
        ImageView mPlaylistLogo;
        RelativeLayout mPlaylistItemRoot;

        public PlaylistsViewHolder(View v) {
            super(v);
            mPlaylistName = v.findViewById(R.id.playlists_name);
            mTracksNumber = v.findViewById(R.id.tracks_number);
            mPlaylistLogo = v.findViewById(R.id.playlist_logo);
            mPlaylistItemRoot = v.findViewById(R.id.playlist_item_root);
        }
    }

    @NonNull
    @Override
    public PlaylistsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.view_playlist_item, viewGroup, false);
        PlaylistsViewHolder vh = new PlaylistsViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistsViewHolder viewHolder, int i) {
        final int position = i;
        final PlaylistUI playlist = playlists.get(position);

        viewHolder.mPlaylistName.setTextSize(playlist.getPlaylistNameFontSize());
        viewHolder.mPlaylistName.setTextColor(context.getResources().getColor(playlist.getColorId()));
        viewHolder.mPlaylistName.setText(playlist.getName());
        viewHolder.mTracksNumber.setText(String.valueOf(playlist.getItemCount()));
        viewHolder.mPlaylistItemRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onPlaylistClicked(playlist);
            }
        });


        Picasso.get().load(playlist.getPhotoUrl()).into(viewHolder.mPlaylistLogo);

    }

    @Override
    public int getItemCount() {
        return playlists.size();
    }
}
