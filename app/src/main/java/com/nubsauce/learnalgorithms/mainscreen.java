package com.nubsauce.learnalgorithms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class mainscreen extends AppCompatActivity {

    private static int SPLASH_SCREEN = 2500;

    private MediaPlayer mediaPlayer;


    ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_mainscreen);


        //Hooks
        image = findViewById(R.id.RetroLife);

        image.setBackgroundColor(Color.argb(255, 255, 255, 255));


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(mainscreen.this,algorithms.class);
                finish();
                startActivity(intent);
            }
        },SPLASH_SCREEN);

    }


}