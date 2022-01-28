package com.example.soundstore.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.soundstore.R;
import com.example.soundstore.Song;
import com.example.soundstore.databinding.ActivityNowPlayingBinding;
import com.example.soundstore.ui.favorites.FavoritesFragment;

import java.util.ArrayList;

public class NowPlayingActivity extends AppCompatActivity {

    private ActivityNowPlayingBinding binding;
    Animation scaleUp, scaleDown;
    ArrayList<Song> playlist;
    int songPosition;

    // A boolean is used to determine whether play button was activated.
    boolean playEnabled = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNowPlayingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Enable navigation arrow in an action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Retrieve a list of songs with a position of clicked item in the list from an incoming intent.
        songPosition = getIntent().getIntExtra("song_position", 0);
        playlist = getIntent().getParcelableArrayListExtra("songs_list");
        displaySongInfo(playlist.get(songPosition));

        // Animation for player navigation buttons.
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);
        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);

        // Binding of the clickListener
        binding.previousSong.setOnClickListener(clickListener);
        binding.playButton.setOnClickListener(clickListener);
        binding.nextSong.setOnClickListener(clickListener);
    }

    private final View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Perform a click animation and skip to previous song.
            if (binding.previousSong.equals(view)) {
                view.startAnimation(scaleUp);
                if (songPosition > 0) songPosition--;
                else {
                    songPosition = playlist.size() - 1;
                }
                displaySongInfo(playlist.get(songPosition));
                view.startAnimation(scaleDown);
            }

            //Perform a click animation, display toast and change play/pause icon for play button.
            if (binding.playButton.equals(view) && playEnabled) {
                view.startAnimation(scaleUp);
                binding.playButton.setImageResource(R.drawable.ic_pause);
                playEnabled = false;
                Toast.makeText(NowPlayingActivity.this, "Play song", Toast.LENGTH_SHORT).show();
                view.startAnimation(scaleDown);

            } else if (!playEnabled) {
                view.startAnimation(scaleUp);
                binding.playButton.setImageResource(R.drawable.ic_play);
                playEnabled = true;
                Toast.makeText(NowPlayingActivity.this, "Pause song", Toast.LENGTH_SHORT).show();
                view.startAnimation(scaleDown);
            }

            //Perform a click animation and skip to the next song.
            if (binding.nextSong.equals(view)) {
                view.startAnimation(scaleUp);
                if (songPosition < playlist.size() - 1) songPosition++;
                else {
                    Toast.makeText(NowPlayingActivity.this, "End of the playlist", Toast.LENGTH_SHORT).show();
                    songPosition = 0;
                }
                displaySongInfo(playlist.get(songPosition));
                view.startAnimation(scaleDown);
            }
        }
    };

    /**
     * Displays a selected song into a user interface
     * @param selectedSong An item from an ArrayList
     */
    private void displaySongInfo(Song selectedSong) {
        binding.songTitleField.setText(selectedSong.getSongTitle());
        binding.artistNameField.setText(selectedSong.getArtistName());
        binding.albumArt.setImageResource(selectedSong.getAlbumArt());
    }
}