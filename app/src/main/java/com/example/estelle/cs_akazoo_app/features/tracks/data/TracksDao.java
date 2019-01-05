package com.example.estelle.cs_akazoo_app.features.tracks.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import com.example.estelle.cs_akazoo_app.features.playlists.domain.PlaylistDomain;
import com.example.estelle.cs_akazoo_app.features.tracks.domain.TrackDomain;

import java.util.ArrayList;
import java.util.List;

@Dao
public abstract class TracksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract void insertTracks(ArrayList<TrackDomain> tracks);

    @Query("SELECT * FROM track")
    abstract List<TrackDomain> getAllTracks();

    @Query("SELECT * FROM track WHERE playlistId=:playlistId")
    abstract List<TrackDomain> getTracksForPlaylistId(String playlistId);

    @Query("DELETE FROM track WHERE playlistId=:playlistId")
    abstract void deleteTracksForPlaylistId(String playlistId);

    @Transaction
    void updateTracksForPlaylist(ArrayList<TrackDomain> tracks, String playlistId) {
        deleteTracksForPlaylistId(playlistId);
        insertTracks(tracks);
    }

    @Query("DELETE FROM track")
    abstract void nuke();

}
