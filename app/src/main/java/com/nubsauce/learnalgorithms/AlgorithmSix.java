package com.nubsauce.learnalgorithms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class AlgorithmSix extends AppCompatActivity {


// This code is contributed by Kunwar Desh Deepak Singh

    Animation scaleUp, scaleDown;

    private ImageButton backButton;

    private Button voteOne, voteTwo, voteThree, voteFour, voteFive, voteSix, submitbutton;

    private TextView textOne, textTwo, textThree, textFour, textFive, textSix, majorityIceCream;

    private int blackBerryVote = 0;
    private int almondVote = 0;
    private int MangoCoconutVote =0;
    private int mintVote =0;
    private int raspberryVote = 0;
    private int peachVote =0;
    int n =1105;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int startingBlack = 555;
        int startingPecan = 110;
        int startingMangoCoconut = 105;
        int startingMint = 115;
        int startingRaspberry = 100;
        int startingPeach = 120;

        setContentView(R.layout.activity_algorithm_six);

        voteOne = (Button) findViewById(R.id.VoteOne);
        voteTwo = (Button) findViewById(R.id.VoteTwo);
        voteThree = (Button) findViewById(R.id.VoteThree);
        voteFour = (Button) findViewById(R.id.VoteFour);
        voteFive = (Button) findViewById(R.id.VoteFive);
        voteSix = (Button) findViewById(R.id.VoteSix);
        submitbutton = (Button) findViewById(R.id.submitButton);

        textOne = (TextView) findViewById(R.id.textView30);
        textOne.setText(startingBlack + " Votes");
        textTwo = (TextView) findViewById(R.id.textView31);
        textTwo.setText(startingPecan + " Votes");
        textThree = (TextView) findViewById(R.id.textView32);
        textThree.setText(startingMangoCoconut + " Votes");
        textFour = (TextView) findViewById(R.id.textView33);
        textFour.setText(startingMint + " Votes");
        textFive = (TextView) findViewById(R.id.textView34);
        textFive.setText(startingRaspberry + " Votes");
        textSix = (TextView) findViewById(R.id.textView35);
        textSix.setText(startingPeach + " Votes");
        majorityIceCream = (TextView) findViewById(R.id.textView37);

        backButton = (ImageButton) findViewById(R.id.backitupnicely);

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAlgorithms();
            }

        });

        voteOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blackBerryVote = blackBerryVote + 1;
                n= n+1;
                textOne.setText((startingBlack +blackBerryVote )+ " Votes");
            }
        });

        voteTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                almondVote = almondVote + 1;
                n= n+1;
                textTwo.setText((startingPecan + almondVote) + " Votes");
            }
        });

        voteThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MangoCoconutVote = MangoCoconutVote + 1;
                n= n+1;
                textThree.setText((startingMangoCoconut + MangoCoconutVote) + " Votes");
            }
        });

        voteFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mintVote = mintVote + 1;
                n= n+1;
                textFour.setText((startingMint + mintVote) + " Votes");
            }
        });

        voteFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                raspberryVote = raspberryVote + 1;
                n= n+1;
                textFive.setText((startingRaspberry + raspberryVote) + " Votes");
            }
        });

        voteSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                peachVote = peachVote + 1;
                n= n+1;
                textSix.setText((startingPeach + peachVote) + " Votes");

            }
        });

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int arr[] = new int[n];
                    for(int j=0; j<(startingBlack +blackBerryVote); ++j){
                        arr[j] = startingBlack +blackBerryVote;
                    }
                    for(int j=startingBlack +blackBerryVote; j<(startingBlack +blackBerryVote + startingPecan + almondVote); ++j){
                        arr[j] = startingPecan + almondVote;
                    }
                    for(int j=startingBlack +blackBerryVote + startingPecan + almondVote; j<(startingBlack +blackBerryVote + startingPecan + almondVote +startingMangoCoconut + MangoCoconutVote); ++j){
                        arr[j] = startingMangoCoconut + MangoCoconutVote;
                    }
                    for(int j=startingBlack +blackBerryVote + startingPecan + almondVote +startingMangoCoconut + MangoCoconutVote; j<(startingBlack +blackBerryVote + startingPecan + almondVote +startingMangoCoconut + MangoCoconutVote+ startingMint + mintVote ); ++j){
                        arr[j] = startingMint + mintVote ;
                    }
                    for(int j=startingBlack +blackBerryVote + startingPecan + almondVote +startingMangoCoconut + MangoCoconutVote+ startingMint + mintVote ; j<(startingBlack +blackBerryVote + startingPecan + almondVote +startingMangoCoconut + MangoCoconutVote+ startingMint + mintVote +startingRaspberry +raspberryVote); ++j){
                        arr[j] = startingRaspberry +raspberryVote;
                    }
                    for(int j=startingBlack +blackBerryVote + startingPecan + almondVote +startingMangoCoconut + MangoCoconutVote+ startingMint + mintVote +startingRaspberry +raspberryVote; j<(startingBlack +blackBerryVote + startingPecan + almondVote +startingMangoCoconut + MangoCoconutVote+ startingMint + mintVote +startingRaspberry +raspberryVote + startingPeach + peachVote); ++j){
                        arr[j] = startingPeach + peachVote;
                    }
                int majority = findMajority(arr);
                String iceCreamFinal ="";
                if(startingBlack +blackBerryVote == majority){
                    iceCreamFinal = "BlackBerry Ice Cream!";
                }
                else if(startingPecan + almondVote == majority){
                    iceCreamFinal = "Pecan Ice Cream!";
                }
                else if(startingMangoCoconut + MangoCoconutVote == majority){
                    iceCreamFinal = "Mango Coconut Ice Cream!";
                }
                else if(startingMint + mintVote == majority){
                    iceCreamFinal = "Mint Ice Cream!";
                }
                else if(startingRaspberry + raspberryVote == majority){
                    iceCreamFinal = "Raspberry Ice Cream!";
                }
                else if(startingPeach + peachVote == majority){
                    iceCreamFinal = "Peach Ice Cream!";
                }
                else{
                    iceCreamFinal = "No Majority Vote Found!";
                }
                if(majority == -1){
                    majorityIceCream.setText("Majority Ice Cream is: "
                            + iceCreamFinal);
                }
                else {
                    majorityIceCream.setText("Majority Ice Cream is: "
                            + iceCreamFinal + " (" + majority + " votes!)");
                }
            }
        });

        voteOne.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    voteOne.startAnimation(scaleUp);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    voteOne.startAnimation(scaleDown);
                }
                return false;
            }
        });

        voteTwo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    voteTwo.startAnimation(scaleUp);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    voteTwo.startAnimation(scaleDown);
                }
                return false;
            }
        });

        voteThree.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    voteThree.startAnimation(scaleUp);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    voteThree.startAnimation(scaleDown);
                }
                return false;
            }
        });

        voteFour.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    voteFour.startAnimation(scaleUp);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    voteFour.startAnimation(scaleDown);
                }
                return false;
            }
        });

        voteFive.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    voteFive.startAnimation(scaleUp);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    voteFive.startAnimation(scaleDown);
                }
                return false;
            }
        });

        voteSix.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    voteSix.startAnimation(scaleUp);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    voteSix.startAnimation(scaleDown);
                }
                return false;
            }
        });

        submitbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    submitbutton.startAnimation(scaleUp);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    submitbutton.startAnimation(scaleDown);
                }
                return false;
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


    }

    public void openAlgorithms() {
        Intent intent = new Intent(this, algorithms.class);
        startActivity(intent);
        finish();
    }

    public static int findMajority(int[] nums)
    {

        int count = 0, candidate = -1;

        // Finding majority candidate
        for (int index = 0; index < nums.length; index++) {
            if (count == 0) {
                candidate = nums[index];
                count = 1;
            }
            else {
                if (nums[index] == candidate)
                    count++;
                else
                    count--;
            }
        }
        System.out.println(count);
        System.out.println(candidate);

        // Checking if majority candidate occurs more than
        // n/2 times
        count = 0;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == candidate)
                count++;
        }
        if (count >= (nums.length / 2))
            return candidate;
        return -1;
    }
}



