package com.nubsauce.learnalgorithms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class AlgorithmFour extends AppCompatActivity {

    private ImageButton backButton;

    private int screenWidth;
    private int screenHeight;

    private float ImageUpX;
    private float ImageUpY;
    private float ImageDownX;
    private float ImageDownY;
    private float ImageRightX;
    private float ImageRightY;
    private float ImageLeftX;
    private float ImageLeftY;



    private Handler handler = new Handler();
    private Timer timer = new Timer();

    Animation scaleUp, scaleDown, move_up, move_down, move_left, move_right;

    private ImageView animalone, animaltwo, animalthree, animalfour, animalfive, animalsix, animalseven, animaleight;

    private TextView speedone, speedtwo, speedthree, speedfour, speedfive, speedsix, speedseven, speedeight;

    private Button ArrangeButton, resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_algorithm_four);

        backButton = (ImageButton) findViewById(R.id.backbuttonimage);

        resetButton = (Button) findViewById(R.id.ResetButton);
        resetButton.setVisibility(View.INVISIBLE);
        ArrangeButton = (Button) findViewById(R.id.arrangeButton);

        speedone = (TextView) findViewById(R.id.wildbeestspeed);
        speedtwo = (TextView) findViewById(R.id.lionspeed);
        speedthree = (TextView) findViewById(R.id.rhinospeed);
        speedfour = (TextView) findViewById(R.id.cheetahspeed);
        speedfive = (TextView) findViewById(R.id.kangaroospeed);
        speedsix = (TextView) findViewById(R.id.polarbearspeed);
        speedseven = (TextView) findViewById(R.id.ostrichspeed);
        speedeight = (TextView) findViewById(R.id.jaguarspeed);

        animalone = (ImageView) findViewById(R.id.wildebeest);
        animaltwo = (ImageView) findViewById(R.id.lion);
        animalthree = (ImageView) findViewById(R.id.rhino);
        animalfour = (ImageView) findViewById(R.id.cheetah);
        animalfive = (ImageView) findViewById(R.id.kangaroo);
        animalsix = (ImageView) findViewById(R.id.polarbear);
        animalseven = (ImageView) findViewById(R.id.ostrich);
        animaleight = (ImageView) findViewById(R.id.jaguar);






        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAlgorithms();
            }

        });


        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        backButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    backButton.startAnimation(scaleUp);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    backButton.startAnimation(scaleDown);
                }
                return false;
            }
        });


        ArrangeButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    ArrangeButton.startAnimation(scaleUp);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    ArrangeButton.startAnimation(scaleDown);
                }
                return false;
            }
        });

        resetButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    resetButton.startAnimation(scaleUp);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    resetButton.startAnimation(scaleDown);
                }
                return false;
            }
        });

        ArrangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrangeButton.setVisibility(View.INVISIBLE);

                moveBearandWildee();

                Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        moveRhinoandlion();

                    }
                } ,750);


                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        animaltwo.setX(600);
                        speedtwo.setX(650);
                        moveLionandKanga();

                    }
                } ,1500);



                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        animaltwo.setX(600);
                        speedtwo.setX(650);
                        animaltwo.setY(410);
                        speedtwo.setY(635);
                        moveOstrichandCheetah();
                    }
                } ,2250);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        animaltwo.setX(100);
                        speedtwo.setX(150);
                        animaltwo.setY(800);
                        speedtwo.setY(1025);
                        moveLionandJaguar();
                    }
                } ,3000);


                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        animalone.setX(325);
                        speedone.setX(350);
                        animalone.setY(725);
                        speedone.setY(1050);

                        animaltwo.setX(800);
                        speedtwo.setX(850);
                        animaltwo.setY(800);
                        speedtwo.setY(1035);
                        moveWildeeandLion();
                    }
                } ,3750);


                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        animalfour.setX(550);
                        speedfour.setX(600);
                        animalfour.setY(875);
                        speedfour.setY(1040);

                        animalone.setX(850);
                        speedone.setX(875);
                        animalone.setY(725);
                        speedone.setY(1040);

                        moveCheetahandWildee();
                    }
                } ,4500);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        resetButton.setVisibility(View.VISIBLE);
                    }
                } ,5250);


            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
                resetButton.setVisibility(View.INVISIBLE);
            }
        });


    }

    public void openAlgorithms() {
        Intent intent = new Intent(this, algorithms.class);
        startActivity(intent);
        finish();
    }

    public void moveBearandWildee(){

        animalsix.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_bear
        ));
        speedsix.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_bear
        ));
        animalone.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_wildebeest
        ));
        speedone.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_wildebeest
        ));



    }
    public void moveRhinoandlion(){
        animaltwo.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_lion
        ));
        speedtwo.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_lion
        ));
        animalthree.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_rhino
        ));
        speedthree.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_rhino
        ));
    }
    public void moveLionandKanga(){
        animaltwo.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_lion_again
        ));
        speedtwo.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_lion_again
        ));
        animalfive.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_kangaroo
        ));
        speedfive.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_kangaroo
        ));
    }
    public void moveOstrichandCheetah(){
        animalfour.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_cheetah
        ));
        speedfour.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_cheetah
        ));
        animalseven.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_ostrich
        ));
        speedseven.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_ostrich
        ));
    }
    public void moveLionandJaguar(){
        animaleight.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_jaguar
        ));
        speedeight.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_jaguar
        ));
        animaltwo.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_lion_third_time
        ));
        speedtwo.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_lion_third_time
        ));
    }
    public void moveWildeeandLion(){
        animaltwo.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_lion_four
        ));
        speedtwo.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_lion_four
        ));
        animalone.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_wilde_two
        ));
        speedone.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_wilde_two
        ));
    }

    public void moveCheetahandWildee(){
        animalfour.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_cheetah_two
        ));
        speedfour.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_cheetah_two
        ));
        animalone.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_wildee_three
        ));
        speedone.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_wildee_three
        ));
    }


}