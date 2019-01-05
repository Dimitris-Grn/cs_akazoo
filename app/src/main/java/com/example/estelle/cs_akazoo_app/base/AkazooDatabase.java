package com.example.estelle.cs_akazoo_app.base;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.estelle.cs_akazoo_app.features.playlists.data.PlaylistsDao;
import com.example.estelle.cs_akazoo_app.features.playlists.domain.PlaylistDomain;
import com.example.estelle.cs_akazoo_app.features.tracks.data.TracksDao;
import com.example.estelle.cs_akazoo_app.features.tracks.domain.TrackDomain;

@Database(entities = {PlaylistDomain.class, TrackDomain.class}, version = 2, exportSchema = false)
abstract public class AkazooDatabase extends RoomDatabase {

    public abstract PlaylistsDao playlistsDao();

    public abstract TracksDao tracksDao();

    static private AkazooDatabase INSTANCE;

    public static AkazooDatabase getDatabase(Context ctx) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(ctx.getApplicationContext(),
                    AkazooDatabase.class, "akazoo_databse")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
}
