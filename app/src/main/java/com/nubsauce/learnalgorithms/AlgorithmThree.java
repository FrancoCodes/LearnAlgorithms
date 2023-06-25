package com.nubsauce.learnalgorithms;

import androidx.annotation.RequiresApi;
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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class AlgorithmThree extends AppCompatActivity {

    private ImageButton backButton;

    private Button generate;

    Animation scaleUp, scaleDown;

    static String result ="";

    static ArrayList<String> HighlightedRoute = new ArrayList<>();

    static private TextView NodeA, NodeB, NodeC, NodeD, NodeE, NodeF, NodeG, NodeH, NodeI, textView10, textView11, textView12, textView13,
    textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22, textView23, textView24,
    shortestPath;

    private ImageView yellowBeam0, yellowBeam1, yellowBeam2, yellowBeam3, yellowBeam4, yellowBeam5, yellowBeam6, yellowBeam7, yellowBeam8, yellowBeam9,
            yellowBeam10, yellowBeam11, yellowBeam12, yellowBeam13, yellowBeam14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithm_three);

        //Initialize vertices

        NodeA = (TextView) findViewById(R.id.A);
        NodeB = (TextView) findViewById(R.id.B);
        NodeC = (TextView) findViewById(R.id.C);
        NodeD = (TextView) findViewById(R.id.D);
        NodeE = (TextView) findViewById(R.id.E);
        NodeF = (TextView) findViewById(R.id.F);
        NodeG = (TextView) findViewById(R.id.G);
        NodeH = (TextView) findViewById(R.id.H);
        NodeI = (TextView) findViewById(R.id.I);

        //initialize textViews
        textView10 = (TextView) findViewById(R.id.textView10);
        textView11 = (TextView) findViewById(R.id.textView11);
        textView12 = (TextView) findViewById(R.id.textView12);
        textView13 = (TextView) findViewById(R.id.textView13);
        textView14 = (TextView) findViewById(R.id.textView14);
        textView15 = (TextView) findViewById(R.id.textView15);
        textView16 = (TextView) findViewById(R.id.textView16);
        textView17 = (TextView) findViewById(R.id.textView17);
        textView18 = (TextView) findViewById(R.id.textView18);
        textView19 = (TextView) findViewById(R.id.textView19);
        textView20 = (TextView) findViewById(R.id.textView20);
        textView21 = (TextView) findViewById(R.id.textView21);
        textView22 = (TextView) findViewById(R.id.textView22);
        textView23 = (TextView) findViewById(R.id.textView23);
        textView24 = (TextView) findViewById(R.id.textView24);
        shortestPath = (TextView) findViewById(R.id.shortestPath);

        //Set textViews to Invisible
        textView10.setVisibility(View.INVISIBLE);
        textView11.setVisibility(View.INVISIBLE);
        textView12.setVisibility(View.INVISIBLE);
        textView13.setVisibility(View.INVISIBLE);
        textView14.setVisibility(View.INVISIBLE);
        textView15.setVisibility(View.INVISIBLE);
        textView16.setVisibility(View.INVISIBLE);
        textView17.setVisibility(View.INVISIBLE);
        textView18.setVisibility(View.INVISIBLE);
        textView19.setVisibility(View.INVISIBLE);
        textView20.setVisibility(View.INVISIBLE);
        textView21.setVisibility(View.INVISIBLE);
        textView22.setVisibility(View.INVISIBLE);
        textView23.setVisibility(View.INVISIBLE);
        textView24.setVisibility(View.INVISIBLE);

        //Initialize yellow beam highlighted ImageViews
        yellowBeam0 = (ImageView) findViewById(R.id.yellowbeam0);
        yellowBeam1 = (ImageView) findViewById(R.id.yellowbeam1);
        yellowBeam2 = (ImageView) findViewById(R.id.yellowbeam2);
        yellowBeam3 = (ImageView) findViewById(R.id.yellowbeam3);
        yellowBeam4 = (ImageView) findViewById(R.id.yellowbeam4);
        yellowBeam5 = (ImageView) findViewById(R.id.yellowbeam5);
        yellowBeam6 = (ImageView) findViewById(R.id.yellowbeam6);
        yellowBeam7 = (ImageView) findViewById(R.id.yellowbeam7);
        yellowBeam8 = (ImageView) findViewById(R.id.yellowbeam8);
        yellowBeam9 = (ImageView) findViewById(R.id.yellowbeam9);
        yellowBeam10 = (ImageView) findViewById(R.id.yellowbeam10);
        yellowBeam11 = (ImageView) findViewById(R.id.yellowbeam11);
        yellowBeam12 = (ImageView) findViewById(R.id.yellowbeam12);
        yellowBeam13 = (ImageView) findViewById(R.id.yellowbeam13);
        yellowBeam14 = (ImageView) findViewById(R.id.yellowbeam14);

        //Set yellow beam ImageViews to Invisible
        yellowBeam0.setVisibility(View.INVISIBLE);
        yellowBeam1.setVisibility(View.INVISIBLE);
        yellowBeam2.setVisibility(View.INVISIBLE);
        yellowBeam3.setVisibility(View.INVISIBLE);
        yellowBeam4.setVisibility(View.INVISIBLE);
        yellowBeam5.setVisibility(View.INVISIBLE);
        yellowBeam6.setVisibility(View.INVISIBLE);
        yellowBeam7.setVisibility(View.INVISIBLE);
        yellowBeam8.setVisibility(View.INVISIBLE);
        yellowBeam9.setVisibility(View.INVISIBLE);
        yellowBeam10.setVisibility(View.INVISIBLE);
        yellowBeam11.setVisibility(View.INVISIBLE);
        yellowBeam12.setVisibility(View.INVISIBLE);
        yellowBeam13.setVisibility(View.INVISIBLE);
        yellowBeam14.setVisibility(View.INVISIBLE);

        //Initialize generate Button
        generate = (Button) findViewById(R.id.generation);

        //Initialize animations
        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        //Initialize back Button
        backButton = (ImageButton) findViewById(R.id.backbuttonFire);

        //Create button click Animations
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

        //Generate Shortest Path
        generate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                //Set Edge value TextViews to Visible
                textView10.setVisibility(View.VISIBLE);
                textView11.setVisibility(View.VISIBLE);
                textView12.setVisibility(View.VISIBLE);
                textView13.setVisibility(View.VISIBLE);
                textView14.setVisibility(View.VISIBLE);
                textView15.setVisibility(View.VISIBLE);
                textView16.setVisibility(View.VISIBLE);
                textView17.setVisibility(View.VISIBLE);
                textView18.setVisibility(View.VISIBLE);
                textView19.setVisibility(View.VISIBLE);
                textView20.setVisibility(View.VISIBLE);
                textView21.setVisibility(View.VISIBLE);
                textView22.setVisibility(View.VISIBLE);
                textView23.setVisibility(View.VISIBLE);
                textView24.setVisibility(View.VISIBLE);

                //Set Highlighted edges to Invisible.
                yellowBeam0.setVisibility(View.INVISIBLE);
                yellowBeam1.setVisibility(View.INVISIBLE);
                yellowBeam2.setVisibility(View.INVISIBLE);
                yellowBeam3.setVisibility(View.INVISIBLE);
                yellowBeam4.setVisibility(View.INVISIBLE);
                yellowBeam5.setVisibility(View.INVISIBLE);
                yellowBeam6.setVisibility(View.INVISIBLE);
                yellowBeam7.setVisibility(View.INVISIBLE);
                yellowBeam8.setVisibility(View.INVISIBLE);
                yellowBeam9.setVisibility(View.INVISIBLE);
                yellowBeam10.setVisibility(View.INVISIBLE);
                yellowBeam11.setVisibility(View.INVISIBLE);
                yellowBeam12.setVisibility(View.INVISIBLE);
                yellowBeam13.setVisibility(View.INVISIBLE);
                yellowBeam14.setVisibility(View.INVISIBLE);


                //Random min max values
                int min = 1;
                int max = 97;
                Random rand = new Random();
                int randomWeight;
                LinkedList<Integer> WeightList = new LinkedList<>();

                //Generate Edges values
                for(int i =0; i< 15; ++i){
                    randomWeight = rand.nextInt(max + min + 1) + min;
                    WeightList.add(randomWeight);
                }

                //Create List of edges with starting and ending points given as source and dest. Give weight value to edges.
                List<Edge> edges = Arrays.asList(
                        new Edge(0, 1, WeightList.get(0)), new Edge(0, 2, WeightList.get(1)), new Edge(1, 2, WeightList.get(2)),
                        new Edge(1, 3, WeightList.get(3)), new Edge(1, 5, WeightList.get(4)), new Edge(2, 5, WeightList.get(5)),
                        new Edge(3, 4, WeightList.get(6)), new Edge(5, 4, WeightList.get(7)), new Edge(3, 6, WeightList.get(8)),
                        new Edge(4, 6, WeightList.get(9)), new Edge(4, 8, WeightList.get(10)), new Edge(4, 7, WeightList.get(11)),
                        new Edge(5, 7, WeightList.get(12)), new Edge(6, 8, WeightList.get(13)), new Edge(7, 8, WeightList.get(14))
                );



                // Number of nodes in graph
                int n = 9;

                // Create graph
                Graph graph = new Graph(edges, n);

                // Run Dijkstra's shortest path algorithm from node A to I
                findShortestPaths(graph, 0, n);

                //Create List storing path of highlighted edges
                ArrayList<String> pathedlights = new ArrayList<>(highlightedPath(HighlightedRoute));
                HighlightedRoute.clear();

                //loop pathedLights to highlight shortest path.
                for (int i = 0; i <= pathedlights.size()-1; ++i) {
                    if(pathedlights.get(i).equals("0")){
                        yellowBeam0.setVisibility(View.VISIBLE);
                    }
                    if(pathedlights.get(i).equals("1")){
                        yellowBeam1.setVisibility(View.VISIBLE);
                    }
                    if(pathedlights.get(i).equals("2")){
                        yellowBeam2.setVisibility(View.VISIBLE);
                    }
                    if(pathedlights.get(i).equals("3")){
                        yellowBeam3.setVisibility(View.VISIBLE);
                    }
                    if(pathedlights.get(i).equals("4")){
                        yellowBeam4.setVisibility(View.VISIBLE);
                    }
                    if(pathedlights.get(i).equals("5")){
                        yellowBeam5.setVisibility(View.VISIBLE);
                    }
                    if(pathedlights.get(i).equals("6")){
                        yellowBeam6.setVisibility(View.VISIBLE);
                    }
                    if(pathedlights.get(i).equals("7")){
                        yellowBeam7.setVisibility(View.VISIBLE);
                    }
                    if(pathedlights.get(i).equals("8")){
                        yellowBeam8.setVisibility(View.VISIBLE);
                    }
                    if(pathedlights.get(i).equals("9")){
                        yellowBeam9.setVisibility(View.VISIBLE);
                    }
                    if(pathedlights.get(i).equals("10")){
                        yellowBeam10.setVisibility(View.VISIBLE);
                    }
                    if(pathedlights.get(i).equals("11")){
                        yellowBeam11.setVisibility(View.VISIBLE);
                    }
                    if(pathedlights.get(i).equals("12")){
                        yellowBeam12.setVisibility(View.VISIBLE);
                    }
                    if(pathedlights.get(i).equals("13")){
                        yellowBeam13.setVisibility(View.VISIBLE);
                    }
                    if(pathedlights.get(i).equals("14")){
                        yellowBeam14.setVisibility(View.VISIBLE);
                    }

                }

                //Set resulting shortest path Text
               shortestPath.setText(result);
               result = "";



                //Loop through edge textView values and assign random weights
                for (int i = 10; i <= 24; ++i) {
                    String name = "textView" + i;
                    int resourceID = getResources().getIdentifier(name, "id",
                            getPackageName());
                    if (resourceID != 0) {
                        TextView tv = (TextView) findViewById(resourceID);
                        tv.setText(String.valueOf(WeightList.get(i-10)));

                    }
                }
            }
        });


    }

    private static void getRoute(int[] prev, int i, List<Integer> route) {
        if (i >= 0) {
            getRoute(prev, prev[i], route);
            route.add(i);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void findShortestPaths(Graph graph, int source, int n) {

        //Initialize min-heap
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));;

        //Add first node with distance 0
        minHeap.add(new Node(source, 0));

        //Initialize distance List with copies of node value and distance from infinity.
        List<Integer> distance = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));

        //set distance from source to itself to zero
        distance.set(source, 0);


        //boolean array identifies which vertices minimum cost have been found.
        boolean[] found = new boolean[n];
        found[source] = true;

        //Store previous vertex. Set source to -1.
        int[] previous = new int[n];
        previous[source] = -1;

        //loop through minHeap until empty
        while (!minHeap.isEmpty()) {

            //Remove and return best vertex at head of the Queue
            Node node = minHeap.poll();

            //Assign vertex number
            int u = node.vertex;

            // loop through adjacent edges for each neighbor `v` of `u`
            for (Edge edge : graph.adjList.get(u)) {
                int v = edge.dest;
                int weight = edge.weight;

                //Add to minHeap
                if (!found[v] && (distance.get(u) + weight) < distance.get(v)) {
                    distance.set(v, distance.get(u) + weight);
                    previous[v] = u;
                    minHeap.add(new Node(v, distance.get(v)));
                }
            }

            // mark vertex `u` as picked
            found[u] = true;
        }

        List<Integer> route = new ArrayList<>();

        String [] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};

        String startPath = "";
        String endPath = "";
        StringBuilder Routed = new StringBuilder("[");
        int i = 8;

        getRoute(previous, i, route);

        for(int j =0; j<9; ++j){
            if(source == j){
                startPath = (letters[j]);
            }
            if(i == j){
                endPath = (letters[j]);
            }
        }



        for(int w =0; w<route.size(); ++w){
            for(int j =0; j< 9; ++j){
                if(j == route.get(w) && w <route.size()-1){
                    Routed.append(letters[j]);
                    HighlightedRoute.add(letters[j]);
                    Routed.append((", "));
                }
                if(j == route.get(w) && w == route.size()-1){
                    Routed.append(letters[j]);
                    HighlightedRoute.add(letters[j]);
                    Routed.append("]");
                }
            }
        }


        String value = "Path [" + startPath + "-> " + endPath + "] : Minimum cost = " + distance.get(i) + " Route: " + Routed;


        System.out.printf("Path (%s —> %s): Minimum cost = %d, Route: %s\n",
                startPath, endPath, distance.get(i), Routed);

        result += value;


    }

    public static ArrayList<String> highlightedPath(List<String> values){
        ArrayList<String> result = new ArrayList<>();

        for(int i =0; i<= values.size()- 1; ++i){



            boolean nextValue;
            try {
                nextValue = values.contains(values.get(i+1));
            } catch (IndexOutOfBoundsException e) {
                nextValue = false;
            }

            if(nextValue){
                String firstValue = values.get(i);
                String secondValue = values.get(i+1);
                if(firstValue.equals("A") && secondValue.equals("B")){
                    result.add("0");
                }
                if(firstValue.equals("A") && secondValue.equals("C")){
                    result.add("1");
                }
                if(firstValue.equals("B") && secondValue.equals("C")){
                    result.add("2");
                }
                if(firstValue.equals("B") && secondValue.equals("D")){
                    result.add("3");
                }
                if(firstValue.equals("B") && secondValue.equals("F")){
                    result.add("4");
                }
                if(firstValue.equals("C") && secondValue.equals("F")){
                    result.add("5");
                }
                if(firstValue.equals("D") && secondValue.equals("E")){
                    result.add("6");
                }
                if(firstValue.equals("F") && secondValue.equals("E")){
                    result.add("7");
                }
                if(firstValue.equals("D") && secondValue.equals("G")){
                    result.add("8");
                }
                if(firstValue.equals("E") && secondValue.equals("G")){
                    result.add("9");
                }
                if(firstValue.equals("E") && secondValue.equals("I")){
                    result.add("10");
                }
                if(firstValue.equals("E") && secondValue.equals("H")){
                    result.add("11");
                }
                if(firstValue.equals("F") && secondValue.equals("H")){
                    result.add("12");
                }
                if(firstValue.equals("G") && secondValue.equals("I")){
                    result.add("13");
                }
                if(firstValue.equals("H") && secondValue.equals("I")){
                    result.add("14");
                }
            }
        }

        return result;
    }


    public void openAlgorithms(){
        Intent intent = new Intent(this, algorithms.class);
        startActivity(intent);
        finish();
    }
}

//Class stores graph edge
class Edge {
    int source, dest, weight;

    public Edge(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}


//Class stores heap node
class Node {
    int vertex, weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

//Graph object class
class Graph {
    //A list of lists for edges
    List<List<Edge>> adjList;


    Graph(List<Edge> edges, int n) {
        adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        //Add edges to graph
        for (Edge edge : edges) {
            adjList.get(edge.source).add(edge);
        }
    }
}