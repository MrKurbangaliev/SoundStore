package com.example.soundstore.ui.favorites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.soundstore.Song;
import com.example.soundstore.SongAdapter;
import com.example.soundstore.databinding.FragmentFavoritesBinding;

import java.util.ArrayList;

public class FavoritesFragment extends Fragment {

    private FragmentFavoritesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentFavoritesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ArrayList<Song> favorite_songs = new ArrayList<>();
        favorite_songs.add(this.getArguments().getParcelable("liked_song"));

        SongAdapter itemsAdapter = new SongAdapter(requireActivity(), favorite_songs);
        ListView listView = binding.getRoot();
        listView.setAdapter(itemsAdapter);
        registerForContextMenu(listView);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}