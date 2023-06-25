package com.nubsauce.learnalgorithms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class BinarySearch extends AppCompatActivity {

    String word;


    Animation scaleUp, scaleDown;

    private ImageButton backButton;
    private Button submitButton;
    private EditText anyWord;
    private TextView textView3, textView4, textView5, textView7, textView8, textView9, textView10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary_search);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);


        textView3 = (TextView) findViewById(R.id.textView3);
            textView3.setVisibility(TextView.INVISIBLE);
        textView4 = (TextView) findViewById(R.id.textView4);
            textView4.setVisibility(TextView.INVISIBLE);
        textView5 = (TextView) findViewById(R.id.textView5);
            textView5.setVisibility(TextView.INVISIBLE);
        textView7 = (TextView) findViewById(R.id.textView7);
            textView7.setVisibility(TextView.INVISIBLE);
        textView8 = (TextView) findViewById(R.id.textView8);
            textView8.setVisibility(TextView.INVISIBLE);
        textView9 = (TextView) findViewById(R.id.textView9);
            textView9.setVisibility(TextView.INVISIBLE);
        textView10 = (TextView) findViewById(R.id.textView10);
            textView10.setVisibility(TextView.INVISIBLE);

        anyWord = (EditText) findViewById(R.id.editText);
        submitButton = (Button) findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                word = anyWord.getText().toString();

                LinkedHashMap<Integer,String> map = (LinkedHashMap<Integer, String>) HashMapFromTextFile();


                int location = -1;

                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    if (entry.getValue().equals(word)) {
                        location = entry.getKey();
                    }
                }


                //set first to first index
                int first = 0;
                //set last to last elements in array
                int last=map.size()-1;

                //calculate mid of the array
                int mid = (first + last)/2;
                //while first and last do not overlap
                while( first <= last ){

                    //if the mid < key, then key to be searched is in the first half of array

                    if ( mid < location ){

                        first = mid + 1;

                    }else if ( mid == location ){
                        //if key = element at mid, then print the location
                        textView4.setText(NumberFormat.getNumberInstance(Locale.US).format(mid));
                            textView4.setVisibility(TextView.VISIBLE);
                        textView7.setText(map.get(mid - 1));
                            textView7.setVisibility(TextView.VISIBLE);
                        textView9.setText(map.get(mid + 1));
                            textView9.setVisibility(TextView.VISIBLE);
                        textView3.setVisibility(TextView.VISIBLE);
                        textView5.setVisibility(TextView.VISIBLE);
                        textView8.setVisibility(TextView.VISIBLE);
                        textView10.setVisibility(TextView.INVISIBLE);
                        System.out.println("The word is found at index: " + mid + ". The previous word is " + map.get(mid - 1) + " and the following word is: " + map.get(mid + 1));
                        break;

                    }else{
                        //the key is to be searched in the second half of the array
                        last = mid - 1;
                    }
                    mid = (first + last)/2;
                }
                //if first and last overlap, then key is not present in the array
                if ( first > last ){
                    System.out.println("word is FAKE!");
                    textView4.setVisibility(TextView.INVISIBLE);
                    textView7.setVisibility(TextView.INVISIBLE);
                    textView9.setVisibility(TextView.INVISIBLE);
                    textView3.setVisibility(TextView.INVISIBLE);
                    textView5.setVisibility(TextView.INVISIBLE);
                    textView8.setVisibility(TextView.INVISIBLE);
                    textView10.setVisibility(TextView.VISIBLE);
                }
            }
        });

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        submitButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    submitButton.startAnimation(scaleUp);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    submitButton.startAnimation(scaleDown);
                }
                return false;
            }
        });

        backButton = (ImageButton) findViewById(R.id.imageButton6);
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





    }
    public Map<Integer, String> HashMapFromTextFile()
    {

        Map<Integer, String> map = new LinkedHashMap<>();
        BufferedReader br = null;


        try {

           StringBuffer sbuffer = new StringBuffer();

           InputStream is = this.getResources().openRawResource(R.raw.dictionary);

            // create BufferedReader object from the File
            br = new BufferedReader(new InputStreamReader(is));

            String line = null;

            // read file line by line
            int position = 0;
            while ((line = br.readLine()) != null) {

                if (!line.equals("") ) {
                    map.put(position, line);
                    ++position;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {

            // Always close the BufferedReader
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                };
            }
        }

        return map;
    }


    public void openAlgorithms(){
        Intent intent = new Intent(this, algorithms.class);
        startActivity(intent);
        finish();
    }

}