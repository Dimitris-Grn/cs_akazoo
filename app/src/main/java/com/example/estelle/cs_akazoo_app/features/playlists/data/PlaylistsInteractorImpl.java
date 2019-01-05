package com.example.estelle.cs_akazoo_app.features.playlists.data;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.UiThread;

import com.example.estelle.cs_akazoo_app.base.AkazooDatabase;
import com.example.estelle.cs_akazoo_app.features.playlists.domain.PlaylistDomain;
import com.example.estelle.cs_akazoo_app.features.playlists.domain.PlaylistsInteractor;
import com.example.estelle.cs_akazoo_app.rest.RestClient;
import com.example.estelle.cs_akazoo_app.rest.responses.PlaylistsResponse;

import org.jetbrains.annotations.Async;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class PlaylistsInteractorImpl implements PlaylistsInteractor {


    @Override
    public void getPlaylists(final OnPlaylistsFinishListener listener, final Context ctx, final Boolean refresh) {

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                final PlaylistsDao playlistsDao = AkazooDatabase.getDatabase(ctx).playlistsDao();
                List<PlaylistDomain> playlistsFromDb = playlistsDao.getAllPlaylists();
                ArrayList<PlaylistDomain> arrayListFromDb = new ArrayList<>();
                arrayListFromDb.addAll(playlistsFromDb);
                if (playlistsFromDb.isEmpty() || refresh) {
                    Call<PlaylistsResponse> call = RestClient.call().fetchPlaylists();
                    call.enqueue(new Callback<PlaylistsResponse>() {

                        @Override
                        public void onResponse(Call<PlaylistsResponse> call, final Response<PlaylistsResponse> response) {
                            try {
                                AsyncTask.execute(new Runnable() {
                                    @Override
                                    public void run() {
                                        playlistsDao.updatePlaylists(response.body().getResult());
                                        listener.onSuccess(response.body().getResult());
                                    }
                                });
                            } catch (Exception e) {
                                onFailure(call, e);
                            }
                        }

                        @Override
                        public void onFailure(Call<PlaylistsResponse> call, Throwable t) {
                            Timber.e("Failed to fetch playlists from the server");
                            listener.onError();
                        }
                    });
                } else
                    listener.onSuccess(arrayListFromDb);
            }
        });
    }

    @Override
    public void getFilteredPlaylists(final OnPlaylistsFinishListener listener, final String filterString) {

        Call<PlaylistsResponse> call = RestClient.call().fetchPlaylists();
        call.enqueue(new Callback<PlaylistsResponse>() {
            @Override
            public void onResponse(Call<PlaylistsResponse> call, Response<PlaylistsResponse> response) {
                ArrayList<PlaylistDomain> filteredPlaylists = new ArrayList<>();
                ArrayList<PlaylistDomain> playlists = response.body().getResult();
                for (int i = 0; i < playlists.size(); i++) {
                    if (playlists.get(i).getName().startsWith(filterString))
                        filteredPlaylists.add(playlists.get(i));
                }
                listener.onSuccess(filteredPlaylists);
            }

            @Override
            public void onFailure(Call<PlaylistsResponse> call, Throwable t) {
                listener.onError();
            }
        });


    }
}
