package com.nubsauce.learnalgorithms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class AlgorithmFive extends AppCompatActivity {

    Animation scaleUp, scaleDown;

     String valueOne;
     String valueTwo;

    private Button EnterButton;

    private EditText enterValueOne, enterValueTwo;

    static int N = 8;

    private ImageButton backButton;
    private TextView answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithm_five);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);


        enterValueOne = (EditText) findViewById(R.id.editTheTextOne);
        enterValueTwo = (EditText) findViewById(R.id.editTheTextTwo);

        answer = (TextView) findViewById(R.id.answer);
        answer.setVisibility(View.INVISIBLE);

        backButton = (ImageButton) findViewById(R.id.backitup);
        EnterButton = (Button) findViewById(R.id.tourButton);


        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAlgorithms();
            }

        });

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

        EnterButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    EnterButton.startAnimation(scaleUp);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    EnterButton.startAnimation(scaleDown);
                }
                return false;
            }
        });



        EnterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    valueOne = enterValueOne.getText().toString();
                    valueTwo = enterValueTwo.getText().toString();




                if(valueOne.isEmpty() || valueTwo.isEmpty()) {
                    answer.setVisibility(View.VISIBLE);
                    answer.setText("Enter Values!");
                    return;
                }


                long a = -1;
                long b = -1;
                
                try {
                     a = Long.parseLong(valueOne);
                     b = Long.parseLong(valueTwo);

                } catch (NumberFormatException nfe) {
                    answer.setVisibility(View.VISIBLE);
                    answer.setText("Number Too Large!");
                }



                long g;
                g = gcd(a, b);
                System.out.println("GCD(" + a + ", " + b + ") = " + g);


                if(a == -1 && b == -1) {
                    answer.setVisibility(View.VISIBLE);
                    answer.setText("Number Too Large!");
                }
                else {
                    answer.setVisibility(View.VISIBLE);
                    answer.setText("GCD(" + a + "," + b + ")" + " = " + g);
                }

            }
        });



    }

    public static long gcd(long a, long b)
    {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    public void openAlgorithms() {
        Intent intent = new Intent(this, algorithms.class);
        startActivity(intent);
        finish();
    }



}