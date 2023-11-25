package com.example.apiproj.Activity.Models;

import java.util.List;

public class Game {

    private String Name;
    private String Released;
    private String Image;
    private String Rating;
    private List<String> Platform;
    private List<String> Genre;
    private List<String> Store;
    private List<String> Tags;
    private String Metacritic;


    public Game(String image, String name, String released, String rating, List<String> platform,
                List<String> genre, List<String> store, List<String> tags, String metacritic) {



        this.Name = name;
        this.Released = released;
        this.Image = image;
        this.Rating = rating;
        this.Platform = platform;
        this.Genre = genre;
        this.Store = store;
        this.Tags = tags;
        this.Metacritic = metacritic;


    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getReleased() {
        return Released;
    }

    public void setReleased(String released) {
        Released = released;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public List<String> getPlatform() {
        return Platform;
    }

    public void setPlatform(List<String> platform) {
        Platform = platform;
    }

    public List<String> getGenre() {
        return Genre;
    }

    public void setGenre(List<String> genre) {
        Genre = genre;
    }

    public List<String> getStore() {
        return Store;
    }

    public void setStore(List<String> store) {
        Store = store;
    }

    public List<String> getTags() {
        return Tags;
    }

    public void setTags(List<String> tags) {
        Tags = tags;
    }

    public String getMetacritic() {
        return Metacritic;
    }

    public void setMetacritic(String metacritic) {
        Metacritic = metacritic;
    }
}

