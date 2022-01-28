package com.example.soundstore.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.soundstore.databinding.FragmentHomeBinding;
import com.example.soundstore.ui.AlbumsActivity;
import com.example.soundstore.ui.DownloadsActivity;
import com.example.soundstore.ui.PlaylistsActivity;
import com.example.soundstore.ui.SongsActivity;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final RelativeLayout playlists = binding.categoryPlaylists;
        final RelativeLayout songs = binding.categorySongs;
        final RelativeLayout albums = binding.categoryAlbums;
        final RelativeLayout downloads = binding.categoryDownloads;

        playlists.setOnClickListener(view -> startActivity(new Intent(getActivity(), PlaylistsActivity.class)));

        songs.setOnClickListener(view -> startActivity(new Intent(getActivity(), SongsActivity.class)));

        albums.setOnClickListener(view -> startActivity(new Intent(getActivity(), AlbumsActivity.class)));

        downloads.setOnClickListener(view -> startActivity(new Intent(getActivity(), DownloadsActivity.class)));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}