package com.example.soundstore;

public class Song {

    private final String mSongTitle;
    private final String mArtistName;
    private final int mAlbumArt;

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

    public Song(String SongTitle, String ArtistName, int AlbumArt) {
        mSongTitle = SongTitle;
        mArtistName = ArtistName;
        mAlbumArt = AlbumArt;
    }
}