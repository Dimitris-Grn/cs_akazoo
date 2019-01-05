package com.example.estelle.cs_akazoo_app.features.tracks.domain;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.example.estelle.cs_akazoo_app.features.playlists.domain.PlaylistDomain;

@Entity(tableName = "track",
        foreignKeys = @ForeignKey(entity = PlaylistDomain.class,
                parentColumns = "PlaylistId",
                childColumns = "playlistId",
                onDelete = ForeignKey.CASCADE)
)
public class TrackDomain {

    @PrimaryKey
    @NonNull
    private int ItemId;
    private String TrackName;
    private String ArtistName;
    private String ImageUrl;
    private String playlistId;

    public TrackDomain() {
    }

    public TrackDomain(int itemId, String trackName, String artistName, String imageUrl) {
        ItemId = itemId;
        TrackName = trackName;
        ArtistName = artistName;
        ImageUrl = imageUrl;
    }

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int itemId) {
        ItemId = itemId;
    }

    public String getTrackName() {
        return TrackName;
    }

    public void setTrackName(String trackName) {
        TrackName = trackName;
    }

    public String getArtistName() {
        return ArtistName;
    }

    public void setArtistName(String artistName) {
        ArtistName = artistName;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

}
