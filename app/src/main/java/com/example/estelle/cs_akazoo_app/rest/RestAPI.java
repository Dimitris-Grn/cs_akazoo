package com.example.estelle.cs_akazoo_app.rest;

import com.example.estelle.cs_akazoo_app.rest.responses.PlaylistsResponse;
import com.example.estelle.cs_akazoo_app.rest.responses.TracksResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestAPI {

    @GET("playlists")
    Call<PlaylistsResponse> fetchPlaylists();

    @GET("playlist")
    Call<TracksResponse> fetchTracks(@Query("playlistid") String playlistsId);


}
