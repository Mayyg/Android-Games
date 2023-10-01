package com.example.apiproj.Activity.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apiproj.Activity.Models.Game;
import com.example.apiproj.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Objects;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.MyViewHolder> {

    private ArrayList<Game> dataSet;

    public GameAdapter (ArrayList<Game>dataSet){
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_first , parent , false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TextView textViewName = holder.textName;
        TextView textViewRelesed = holder.textReleased;
        TextView textViewRating = holder.textRating;
        TextView textViewPlatform = holder.textPlatform;
        TextView textViewGenre = holder.textGenre;
        TextView textViewStore = holder.textStore;
        TextView textViewTags = holder.textTags;
        TextView textViewMetacritic = holder.textMetacritic;

        Game game = dataSet.get(position);



        if(game.getName() != null){
        textViewName.setText(game.getName());}
        if(game.getReleased() != null){
        textViewRelesed.setText(game.getReleased());}
        if(game.getRating() != null){
        textViewRating.setText(game.getRating());}
        if(game.getPlatform() != null){
        textViewPlatform.setText(game.getPlatform().toString());}
        if(game.getGenre() != null){
        textViewGenre.setText(game.getGenre().toString());}
        if(game.getStore() != null){
        textViewStore.setText(game.getStore().toString());}
        if(game.getTags() != null){
        textViewTags.setText(game.getTags().toString());}
        if(game.getMetacritic() != null){
        textViewMetacritic.setText(game.getMetacritic());}
        if(game.getImage() != null){
            Picasso.get().load(game.getImage()).into(holder.gameImageView, new com.squareup.picasso.Callback() {
                //.placeholder(R.drawable.placeholder_image)
                @Override
                public void onSuccess() {
                    // Image loaded successfully
                }

                @Override
                public void onError(Exception e) {
                    // Error occurred while loading the image
                    e.printStackTrace();
                }
            });}

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView gameImageView;
        TextView textName;
        TextView textReleased;
        TextView textRating;
        TextView textPlatform;
        TextView textGenre;
        TextView textStore;
        TextView textTags;
        TextView textMetacritic;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textViewName);
            textReleased = itemView.findViewById(R.id.textViewRelesed);
            textRating = itemView.findViewById(R.id.textViewRating);
            textPlatform = itemView.findViewById(R.id.textViewPlatform);
            textGenre = itemView.findViewById(R.id.textViewGenre);
            textStore = itemView.findViewById(R.id.textViewStore);
            textTags = itemView.findViewById(R.id.textViewTags);
            textMetacritic = itemView.findViewById(R.id.textViewMetacritic);
            gameImageView = itemView.findViewById(R.id.gameImageView);


        }
    }


}
