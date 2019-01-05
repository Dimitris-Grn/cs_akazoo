package com.example.estelle.cs_akazoo_app.features.playlists.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import com.example.estelle.cs_akazoo_app.features.playlists.domain.PlaylistDomain;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Dao
public abstract class PlaylistsDao {

    @Insert()
    abstract void insertPlaylists(ArrayList<PlaylistDomain> playlists);

    @Query("SELECT * FROM playlist")
    abstract List<PlaylistDomain> getAllPlaylists();

    @Query("DELETE FROM playlist")
    abstract void nuke();

    @Transaction
    void updatePlaylists(ArrayList<PlaylistDomain> playlists) {
        nuke();
        insertPlaylists(playlists);
    }

}
