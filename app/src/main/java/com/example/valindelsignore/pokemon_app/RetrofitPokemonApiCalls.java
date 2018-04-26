package com.example.valindelsignore.pokemon_app;

import com.google.gson.annotations.SerializedName;

import java.util.function.ToDoubleBiFunction;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface RetrofitPokemonApiCalls {
    @GET("{id}/{name}")
    Call<PokemonImage> getPokemonImage(@Path("name") String artist, @Path("id") String title);



    class PokemonImage  {



       ////////////////////////////////////// //fix this part

        @SerializedName("PokemonImage")
        private String name ;

        public String getPokemonViewer() {
            return name;
        }

    }
    }
//GET api/v2/growth-rate/{id or name}