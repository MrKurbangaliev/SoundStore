package com.example.soundstore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter(@NonNull Context context, ArrayList<Song> song) {
        super(context, 0, song);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Song currentSong = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID song_title
        TextView songTitle = (TextView) listItemView.findViewById(R.id.song_title);
        //Assign a song to a view
        songTitle.setText(currentSong.getSongTitle());

        // Find the TextView in the list_item.xml layout with the ID artist_name
        TextView artistName = (TextView) listItemView.findViewById(R.id.artist_name);
        //Assign a song to a view
        artistName.setText(currentSong.getArtistName());

        // Find the ImageView in the list.xml layout with the ID album_art_image
        ImageView albumArt = (ImageView) listItemView.findViewById(R.id.album_art_image);
        //Assign an album art picture to a view
        albumArt.setImageResource(currentSong.getAlbumArt());

        return listItemView;
    }


}
