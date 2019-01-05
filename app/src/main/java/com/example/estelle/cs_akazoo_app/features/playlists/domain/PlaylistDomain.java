package com.example.estelle.cs_akazoo_app.features.playlists.domain;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "playlist")
public class PlaylistDomain {

    @PrimaryKey
    @NonNull
    private String PlaylistId;

    private String Name;
    private int Duration;
    private int ItemCount;
    private String PhotoUrl;
    private String OwnerNickName;

    public PlaylistDomain() {

    }

    public PlaylistDomain(String playlistId, String name, int duration, int itemCount, String photoUrl) {
        PlaylistId = playlistId;
        Name = name;
        Duration = duration;
        ItemCount = itemCount;
        PhotoUrl = photoUrl;
    }

    public String getPlaylistId() {
        return PlaylistId;
    }

    public void setPlaylistId(String playlistId) {
        PlaylistId = playlistId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }

    public int getItemCount() {
        return ItemCount;
    }

    public void setItemCount(int itemCount) {
        ItemCount = itemCount;
    }

    public String getPhotoUrl() {
        return PhotoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        PhotoUrl = photoUrl;
    }

    public String getOwnerNickName() {
        return OwnerNickName;
    }

    public void setOwnerNickName(String ownerNickName) {
        OwnerNickName = ownerNickName;
    }
}
