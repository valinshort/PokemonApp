package com.example.valindelsignore.pokemon_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImageFragment extends Fragment {
    private String baseURL = "https://pokeapi.co/docsv2/#pokemon-section";
    private Retrofit retrofit;
    private RetrofitPokemonApiCalls retrofitPokemonApiCalls;

    @BindView(R.id.pokemon_holder)
    protected ImageView ImageFragment;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      //  View view = inflater.inflate(R.layout.pokemonview, container, false);
      //  ButterKnife.bind(this, view);
       // return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        String pokemonName = getArguments().getString();

      ;



        buildRetrofit();
        makeApiCall(pokemonName);
    }

    private void makeApiCall(final String pokemonName) {
        retrofitPokemonApiCalls.getPokemonImage(pokemonName, pokemonName).enqueue(new Callback<RetrofitPokemonApiCalls.PokemonImage>() {
            @Override
            public void onResponse(Call<RetrofitPokemonApiCalls.PokemonImage> call, Response<RetrofitPokemonApiCalls.PokemonImage> response) {
                if (response.isSuccessful()) {
                    //lyrics_TextView.setText(response.body().getLyrics());
                  //  pokemonName.setText(response.body().getPokemonViewer());

                } else {
                    Toast.makeText(getContext(), "Error,try again", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<RetrofitPokemonApiCalls.PokemonImage> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }


    private void buildRetrofit() {

        retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitPokemonApiCalls = retrofit.create(RetrofitPokemonApiCalls.class);
    }

    public static ImageFragment newInstance() {

        Bundle args = new Bundle();

        ImageFragment fragment = new ImageFragment();
        fragment.setArguments(args);
        return fragment;

    }
}
