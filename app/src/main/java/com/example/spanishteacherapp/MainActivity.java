package com.example.spanishteacherapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button black, blue, green, red, white;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        black = findViewById(R.id.blackButton);
        blue = findViewById(R.id.blueButton);
        green = findViewById(R.id.greenButton);
        white = findViewById(R.id.whiteButton);
        red = findViewById(R.id.redButton);


        red.setOnClickListener(this);
        black.setOnClickListener(this);
        white.setOnClickListener(this);
        blue.setOnClickListener(this);
        green.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View view) {

        int clickedBtnId = view.getId();

        if (clickedBtnId == R.id.redButton){
            play(R.raw.pronunciation_es_rojo);
        } else if (clickedBtnId == R.id.blackButton) {
            play(R.raw.pronunciation_es_negro);
        } else if (clickedBtnId == R.id.blueButton) {
            play(R.raw.pronunciation_es_azul);
        } else if (clickedBtnId == R.id.whiteButton) {
            play(R.raw.pronunciation_es_blanco);
        } else if (clickedBtnId == R.id.greenButton) {
            play(R.raw.pronunciation_es_verde);
        }
    }

    public void play(int id){
        MediaPlayer mediaPlayer = MediaPlayer.create(this,id);
        mediaPlayer.start();
    }
}