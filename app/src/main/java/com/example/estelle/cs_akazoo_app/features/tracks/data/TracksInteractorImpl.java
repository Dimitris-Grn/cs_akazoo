package com.example.estelle.cs_akazoo_app.features.tracks.data;

import android.content.Context;
import android.os.AsyncTask;

import com.example.estelle.cs_akazoo_app.base.AkazooDatabase;
import com.example.estelle.cs_akazoo_app.features.tracks.domain.TrackDomain;
import com.example.estelle.cs_akazoo_app.features.tracks.domain.TracksInteractor;
import com.example.estelle.cs_akazoo_app.rest.RestClient;
import com.example.estelle.cs_akazoo_app.rest.responses.TracksResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TracksInteractorImpl implements TracksInteractor {

    @Override
    public void getTracks(final OnTracksFinishListener listener, final String playlistId,
                          final Context ctx) {

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                final TracksDao dao = AkazooDatabase.getDatabase(ctx).tracksDao();
                List<TrackDomain> tracksFromDb = dao.getTracksForPlaylistId(playlistId);
                ArrayList<TrackDomain> arrayListFromDb = new ArrayList<>();
                arrayListFromDb.addAll(tracksFromDb);

                if (tracksFromDb.isEmpty()) {
                    Call<TracksResponse> call = RestClient.call().fetchTracks(playlistId);

                    call.enqueue(new Callback<TracksResponse>() {
                        @Override
                        public void onResponse(Call<TracksResponse> call, Response<TracksResponse> response) {
                            final ArrayList<TrackDomain> tracks = response.body().getResult().getItems();
                            AsyncTask.execute(new Runnable() {
                                @Override
                                public void run() {
                                    for (TrackDomain track : tracks) {
                                        track.setPlaylistId(playlistId);
                                    }
                                    dao.updateTracksForPlaylist(tracks, playlistId);
                                }
                            });
                            listener.onSuccess(tracks);
                        }

                        @Override
                        public void onFailure(Call<TracksResponse> call, Throwable t) {

                        }
                    });
                } else
                    listener.onSuccess(arrayListFromDb);
            }
        });


    }
}
