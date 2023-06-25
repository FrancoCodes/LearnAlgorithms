package com.nubsauce.learnalgorithms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class AlgorithmTwo extends AppCompatActivity {


    ArrayList finalValues, values;

    Animation scaleUp, scaleDown;

    BarDataSet barDataSet;

    int [] intArray;

    int[] colors;

    BarChart barChart;
    private Button generate;

    private ImageButton backButton;

    private TextView textView11, textView13, textView14, textView19, textView20, textView21, textView22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_algorithm_two);

        barChart = findViewById(R.id.barChart);

        generate = (Button) findViewById(R.id.generate);

        backButton = (ImageButton) findViewById(R.id.backbutton);

        textView11 = (TextView) findViewById(R.id.textView11);

        textView13 = (TextView) findViewById(R.id.textView13);

        textView14 = (TextView) findViewById(R.id.textView14);

        textView19 = (TextView) findViewById(R.id.textView19);

        textView20 = (TextView) findViewById(R.id.textView20);

        textView21 = (TextView) findViewById(R.id.textView21);

        textView22 = (TextView) findViewById(R.id.textView22);



        textView19.setVisibility(View.INVISIBLE);
        textView20.setVisibility(View.INVISIBLE);
        textView21.setVisibility(View.INVISIBLE);
        textView22.setVisibility(View.INVISIBLE);

        textView11.setVisibility(View.INVISIBLE);
        textView13.setVisibility(View.INVISIBLE);
        textView14.setVisibility(View.INVISIBLE);
        barChart.setVisibility(View.INVISIBLE);






        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final int randomCompany = new Random().nextInt(4);

                if(randomCompany ==0){

                    textView19.setVisibility(View.VISIBLE);
                    textView20.setVisibility(View.INVISIBLE);
                    textView21.setVisibility(View.INVISIBLE);
                    textView22.setVisibility(View.INVISIBLE);


                }
                if(randomCompany ==1){
                    textView19.setVisibility(View.INVISIBLE);
                    textView20.setVisibility(View.VISIBLE);
                    textView21.setVisibility(View.INVISIBLE);
                    textView22.setVisibility(View.INVISIBLE);


                }
                if(randomCompany ==2){
                    textView19.setVisibility(View.INVISIBLE);
                    textView20.setVisibility(View.INVISIBLE);
                    textView21.setVisibility(View.VISIBLE);
                    textView22.setVisibility(View.INVISIBLE);

                }
                if(randomCompany ==3){
                    textView19.setVisibility(View.INVISIBLE);
                    textView20.setVisibility(View.INVISIBLE);
                    textView21.setVisibility(View.INVISIBLE);
                    textView22.setVisibility(View.VISIBLE);
                }

                textView11.setVisibility(View.VISIBLE);
                textView13.setVisibility(View.VISIBLE);
                textView14.setVisibility(View.VISIBLE);
                barChart.setVisibility(View.VISIBLE);



                String text = "";
                String subtext = "";
                String greatest = "";

                int min = 100;

                int max = 150;

                values = new ArrayList<String>();

                intArray = new int[12];

                Random rand = new Random();
                for(int i =0; i<intArray.length; ++i){

                    int randomNum = rand.nextInt(max + min ) - min;

                    intArray[i] += randomNum;

                }

                System.out.print("[");
                text += "[";

                for(int i =0; i<intArray.length; ++i){

                    if(i!= intArray.length-1) {

                        System.out.print(intArray[i] + ", ");
                        text += (intArray[i] + ", ");

                    }
                    else{

                        System.out.print(intArray[i]);
                        text +=(intArray[i]);
                    }

                }
                System.out.print("]");
                text += ("]");

                System.out.println();
                textView11.setText(text);

                for(int i: intArray){

                    values.add(i);

                }

                int [] ans = maxSubArraySum(intArray);

                int firstIndex = ans[0];
                int secondIndex = ans[1];


                ArrayList<Integer> subArray = new ArrayList<>();
                for(int i = firstIndex; i<= secondIndex; ++i){

                    subArray.add((Integer) values.get(i));
                }

                System.out.println("Maximum contiguous sum is " + ans[2]);

                int storegreatest = ans[2] * 1000;

                NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
                String str1 = numberFormat.format(storegreatest);


                greatest += "$ " + str1;

                textView14.setText(greatest);


                System.out.println("The subarray is: ");

                System.out.print("[");
                subtext += "[";

                for(int i =0; i<subArray.size(); ++i){

                    if(i!= subArray.size()-1) {

                        System.out.print(subArray.get(i) + ", ");
                        subtext += subArray.get(i) + ", ";

                    }
                    else{

                        System.out.print(subArray.get(i));
                        subtext += subArray.get(i);
                    }

                }
                System.out.print("]");
                subtext += "]";


                textView13.setText(subtext);


                getData();
                barDataSet = new BarDataSet(finalValues,"Sales (Thousands)");
                BarData barData = new BarData(barDataSet);



                colors = new int[intArray.length];

                int j =0;

                for(int i: intArray){

                    if(i<0){
                        colors[j] = Color.RED;
                        ++j;
                    }
                    else if(i>0){
                        colors[j] = Color.GREEN;
                        ++j;
                    }
                    else if(i==0){
                        colors[j] = Color.GRAY;
                        ++j;
                    }

                }
                barDataSet.setColors(colors);


                // replace
                barChart.setData(barData);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);
                barDataSet.setBarBorderColor(Color.GRAY);

                barChart.getDescription().setEnabled(false);
                barChart.invalidate();
                barChart.refreshDrawableState();

            }
        });

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        generate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    generate.startAnimation(scaleUp);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    generate.startAnimation(scaleDown);
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

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAlgorithms();
            }
        });








    }
    private void getData(){

        finalValues = new ArrayList();

        float x = 2f;

        for(int i: intArray){

            finalValues.add(new BarEntry(x, i));
            ++x;



        }

    }
    static int[] maxSubArraySum(int a[])
    {
        int subarray_start = 0;
        int subarray_end = 0;
        int s = 0;
        int size = a.length;
        int currentMax = Integer.MIN_VALUE, newMax = 0;

        for (int i = 0; i < size; i++)
        {
            newMax = newMax + a[i];
            if (currentMax < newMax) {
                currentMax = newMax;
                subarray_start = s;
                subarray_end = i;
            }
            if (newMax < 0) {
                newMax = 0;
                s = i + 1;
            }
        }

        int [] ans = new int[3];

        ans[0] += subarray_start;
        ans[1] += subarray_end;
        ans[2] += currentMax;

        return ans;

    }


    public void openAlgorithms(){
        Intent intent = new Intent(this, algorithms.class);
        startActivity(intent);
        finish();
    }
}