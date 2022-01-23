package com.example.soundstore.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.soundstore.R;
import com.example.soundstore.Song;
import com.example.soundstore.SongAdapter;
import com.example.soundstore.databinding.ListUniversalBinding;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListUniversalBinding binding = ListUniversalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);

        final ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("The Spin", "Greg Haines", R.drawable.album_art_example));
        songs.add(new Song("Dawn", "Jean-Yves Thibaude", R.drawable.album_art_example));
        songs.add(new Song("The Mountain", "Ludovico Einaudi", R.drawable.album_art_example));
        songs.add(new Song("Naval", "Yann Tiersen", R.drawable.album_art_example));
        songs.add(new Song("Reprise", "John Williams", R.drawable.album_art_example));
        songs.add(new Song("Rest", "Elijah Bossenbroek", R.drawable.album_art_example));
        songs.add(new Song("Reverie", "Claude Debussy", R.drawable.album_art_example));
        songs.add(new Song("Ambre", "Nils Frahm", R.drawable.album_art_example));
        songs.add(new Song("Awake", "Megan Wofford", R.drawable.album_art_example));
        songs.add(new Song("Leicester", "Lambert", R.drawable.album_art_example));
        songs.add(new Song("Plus tôt", "Alexandra Stréliski", R.drawable.album_art_example));

        SongAdapter itemsAdapter = new SongAdapter(this, songs);
        ListView listView = binding.getRoot();
        listView.setAdapter(itemsAdapter);

        //Set an onclick listener for each item in the list
        listView.setOnItemClickListener((AdapterView<?> adapterView, View view, int i, long l) -> {
            Intent intent = new Intent(SongsActivity.this, NowPlayingActivity.class);
            intent.putExtra("selected_song", );
            startActivity(intent);
        });
    }
}