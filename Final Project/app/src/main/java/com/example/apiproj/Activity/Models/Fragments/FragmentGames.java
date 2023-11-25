package com.example.apiproj.Activity.Models.Fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.apiproj.Activity.Adapters.GameAdapter;
import com.example.apiproj.Activity.Models.Game;
import com.example.apiproj.Activity.Services.DataService;
import com.example.apiproj.R;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class FragmentGames extends Fragment {
    private ImageView imageView;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private GameAdapter addapter;


    public FragmentGames() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_games, container, false);

        setContentView(R.layout.fragment_games);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        ArrayList<Game> dataSet = DataService.getArrGame();



        Picasso.Builder builder = new Picasso.Builder(this);
        builder.downloader(new OkHttp3Downloader(this, Integer.MAX_VALUE));
        Picasso built = builder.build();
        built.setIndicatorsEnabled(true); // For debugging, remove this in production
        built.setLoggingEnabled(true); // For debugging, remove this in production
        Picasso.setSingletonInstance(built);

        addapter = new GameAdapter(dataSet);
        recyclerView.setAdapter(addapter);
    }


        return  v;
    }
}