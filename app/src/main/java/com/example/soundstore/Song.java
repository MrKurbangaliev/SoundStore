package com.example.soundstore;

import android.os.Parcel;
import android.os.Parcelable;

public class Song implements Parcelable {

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };
    private final String mSongTitle;
    private final String mArtistName;
    private final String mAlbumTitle;
    private final int mAlbumArt;

    protected Song(Parcel in) {
        mSongTitle = in.readString();
        mArtistName = in.readString();
        mAlbumTitle = in.readString();
        mAlbumArt = in.readInt();
    }

    public Song(String SongTitle, String ArtistName, String AlbumTitle, int AlbumArt) {
        mSongTitle = SongTitle;
        mArtistName = ArtistName;
        mAlbumTitle = AlbumTitle;
        mAlbumArt = AlbumArt;
    }

    /**
     * Get a title of the song.
     */
    public String getSongTitle() {
        return mSongTitle;
    }

    /**
     * Get a name of an artist.
     */
    public String getArtistName() {
        return mArtistName;
    }

    /**
     * Get an image for album art.
     */
    public int getAlbumArt() {
        return mAlbumArt;
    }

    /**
     * Get a title of the song.
     */
    public String getAlbumTitle() {
        return mAlbumTitle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mSongTitle);
        parcel.writeString(mArtistName);
        parcel.writeString(mAlbumTitle);
        parcel.writeInt(mAlbumArt);
    }
}