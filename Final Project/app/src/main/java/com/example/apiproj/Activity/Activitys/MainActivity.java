package com.example.apiproj.Activity.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.apiproj.Activity.Adapters.GameAdapter;
import com.example.apiproj.Activity.Models.Game;
import com.example.apiproj.Activity.Services.DataService;
import com.example.apiproj.R;

import java.util.ArrayList;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private GameAdapter addapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        ArrayList<Game> dataSet = DataService.getArrGame();

//        for(int i = 0 ; i < DataService.getArrGame().size() ; i++){
//
//            dataSet.add (new Game(
//                    DataService.nameArray[i],
//                    DataService.versionArray[i],
//                    DataService.id_[i],
//                    DataService.drawableArray[i]
//
//
//            ));
//
//        }
        Picasso.Builder builder = new Picasso.Builder(this);
        builder.downloader(new OkHttp3Downloader(this, Integer.MAX_VALUE));
        Picasso built = builder.build();
        built.setIndicatorsEnabled(true); // For debugging, remove this in production
        built.setLoggingEnabled(true); // For debugging, remove this in production
        Picasso.setSingletonInstance(built);

        addapter = new GameAdapter(dataSet);
        recyclerView.setAdapter(addapter);
    }
}