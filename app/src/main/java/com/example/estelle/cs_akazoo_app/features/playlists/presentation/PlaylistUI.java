package com.example.estelle.cs_akazoo_app.features.playlists.presentation;

import android.os.Parcel;
import android.os.Parcelable;


public class PlaylistUI implements Parcelable {

    private String photoUrl;

    private String playlistId;
    private String name;
    private int itemCount;
    private int colorId;
    private int playlistNameFontSize;

    public PlaylistUI(String playlistId, String name, int itemCount) {
        this.playlistId = playlistId;
        this.name = name;
        this.itemCount = itemCount;
    }

    public PlaylistUI(String playlistId, String name, int itemCount, String photoUrl) {
        this.playlistId = playlistId;
        this.name = name;
        this.itemCount = itemCount;
        this.photoUrl = photoUrl;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public int getPlaylistNameFontSize() {
        return playlistNameFontSize;
    }

    public void setPlaylistNameFontSize(int playlistNameFontSize) {
        this.playlistNameFontSize = playlistNameFontSize;
    }

    protected PlaylistUI(Parcel in) {
        photoUrl = in.readString();
        playlistId = in.readString();
        name = in.readString();
        itemCount = in.readInt();
        colorId = in.readInt();
        playlistNameFontSize = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(photoUrl);
        dest.writeString(playlistId);
        dest.writeString(name);
        dest.writeInt(itemCount);
        dest.writeInt(colorId);
        dest.writeInt(playlistNameFontSize);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<PlaylistUI> CREATOR = new Parcelable.Creator<PlaylistUI>() {
        @Override
        public PlaylistUI createFromParcel(Parcel in) {
            return new PlaylistUI(in);
        }

        @Override
        public PlaylistUI[] newArray(int size) {
            return new PlaylistUI[size];
        }
    };
}