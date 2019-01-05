package com.example.estelle.cs_akazoo_app.features.tracks.presentation;

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
import com.example.estelle.cs_akazoo_app.features.tracks.domain.OnTrackClickListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TracksRvAdapter extends RecyclerView.Adapter<TracksRvAdapter.TracksViewHolder> {

    private ArrayList<TrackUI> tracks;
    private OnTrackClickListener listener;
    private Context context;

    public TracksRvAdapter(ArrayList<TrackUI> tracks, OnTrackClickListener listener, Context context) {
        this.tracks = tracks;
        this.listener = listener;
        this.context = context;
    }

    public static class TracksViewHolder extends RecyclerView.ViewHolder {

        TextView mTracksName;
        TextView mTracksArtist;
        TextView mTracksCategory;
        ImageView mTracksLogo;
        RelativeLayout mTrackItemRoot;

        public TracksViewHolder(View v) {
            super(v);
            mTracksName = v.findViewById(R.id.track_name);
            mTracksArtist = v.findViewById(R.id.track_artist);
            mTracksCategory = v.findViewById(R.id.track_category);
            mTracksLogo = v.findViewById(R.id.track_logo);
            mTrackItemRoot = v.findViewById(R.id.track_item_root);
        }
    }

    @NonNull
    @Override
    public TracksViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.view_track_item, viewGroup, false);
        TracksRvAdapter.TracksViewHolder vh = new TracksRvAdapter.TracksViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull TracksViewHolder viewHolder, int i) {

        final int pos = i;

        viewHolder.mTracksName.setText(tracks.get(i).getTrackName());

        viewHolder.mTracksLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onTrackLogoClick(tracks.get(pos));
            }

        });

        viewHolder.mTrackItemRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onTrackClick(tracks.get(pos));
            }
        });
        viewHolder.mTracksName.setTextColor(context.getResources().getColor(tracks.get(pos).getTrackNameColorid()));
        viewHolder.mTracksArtist.setText(tracks.get(i).getTrackArtist());
        Picasso.get().load(tracks.get(i).getTrackLogoUrl()).into(viewHolder.mTracksLogo);
    }

    @Override
    public int getItemCount() {
        return tracks.size();
    }
}
