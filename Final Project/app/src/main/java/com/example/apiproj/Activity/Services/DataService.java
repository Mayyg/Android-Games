package com.example.apiproj.Activity.Services;

import android.os.StrictMode;

import com.example.apiproj.Activity.Models.Game;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DataService {



    public static ArrayList<Game> getArrGame(){

        ArrayList<Game>arrGame = new ArrayList<>();

        String sURL = "https://api.rawg.io/api/games?key=d73be53b978c438184afa4afa84a3b98";

        URL url = null;

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try{
            url = new URL(sURL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        HttpURLConnection request = null;
        try {
            request = (HttpURLConnection) url.openConnection();
            request.connect();

            JsonParser jsonParser = new JsonParser();
            JsonElement root = jsonParser.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject rootObj = root.getAsJsonObject();
            JsonArray gamesArray = rootObj.getAsJsonArray("results");

            for (JsonElement je : gamesArray) {

                JsonObject obj = je.getAsJsonObject();
                JsonElement entrieName = obj.get("name");
                JsonElement entrieReleased = obj.get("released");
                JsonElement entrieImage = obj.get("background_image");
                JsonElement entrieRating = obj.get("rating");
                JsonElement entriePlatform = obj.get("platforms");
                JsonElement entrieGenre = obj.get("genres");
                JsonElement entrieStore = obj.get("stores");
                JsonElement entrieTags = obj.get("tags");
                JsonElement entrieMetacritic = obj.get("metacritic");

                String name = entrieName.toString().replace("\"", "");
                String released = entrieReleased.toString().replace("\"", "");
                String image = null;
                if (entrieImage != null) {
                    image = entrieImage.toString().replace("\"", "");
                } else entrieImage = null;
                String rating = entrieRating.toString().replace("\"", "");
                String metacritic = entrieMetacritic.toString().replace("\"", "");

                ArrayList<String> arrPlatform = new ArrayList<>();
                if (entriePlatform != null) {
                    JsonArray entriePlatformArray = entriePlatform.getAsJsonArray();
                    for (JsonElement j : entriePlatformArray) {
                        String s = j.getAsJsonObject().get("platform").getAsJsonObject().get("name").toString().replace("\"", "");
                        arrPlatform.add(s);
                    }
                } else {
                    arrPlatform = null;
                }

                ArrayList<String> arrGenre = new ArrayList<>();
                if (entrieGenre != null) {
                    JsonArray entrieGenreArray = entrieGenre.getAsJsonArray();
                    for (JsonElement j : entrieGenreArray) {
                        String s = j.getAsJsonObject().get("name").toString().replace("\"", "");
                        arrGenre.add(s);
                    }
                } else {
                    arrGenre = null;
                }

                ArrayList<String> arrStore = new ArrayList<>();
                if (entrieStore != null) {
                    JsonArray entrieStoreArray = entrieStore.getAsJsonArray();
                    for (JsonElement j : entrieStoreArray) {
                        String s = j.getAsJsonObject().get("store").getAsJsonObject().get("name").toString().replace("\"", "");
                        arrStore.add(s);
                    }
                } else {
                    arrStore = null;
                }

                ArrayList<String> arrTags = new ArrayList<>();
                if (entrieTags != null) {
                    JsonArray entrieTagsArray = entrieTags.getAsJsonArray();
                    for (JsonElement j : entrieTagsArray) {
                        String s = j.getAsJsonObject().get("name").toString().replace("\"", "");
                        arrTags.add(s);
                    }
                } else {
                    arrTags = null;
                }


                arrGame.add(new Game(image, name, released, rating, arrPlatform, arrGenre, arrStore, arrTags, metacritic));

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return arrGame;

    }

}
