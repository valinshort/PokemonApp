package com.example.valindelsignore.pokemon_app;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    public static final String POKEMON_NAME = "pokemon_name";


    @BindView(R.id.pokemon_name)
    protected TextInputEditText pokemonName;


    private ImageFragment imageFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();

    }

    @OnClick(R.id.submit_button)
    protected void submitClicked() {
        if (pokemonName.getText().toString().isEmpty()) {
            Toast.makeText(this, "this feild required. Try again", Toast.LENGTH_LONG).show();
        } else {
            imageFragment = ImageFragment.newInstance();
            Bundle bundle = new Bundle();
            bundle.putString(POKEMON_NAME, pokemonName.getText().toString());
           // bundle.putString(SONG_TITLE, songEditText.getText().toString());
            //lyricsFragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction().replace(R.id.pokemon_holder,imageFragment).commit();
        }

    }

}

