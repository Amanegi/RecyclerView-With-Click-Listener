package com.example.aman_negi.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

//Click listener blog link
//https://android.jlelse.eu/click-listener-for-recyclerview-adapter-2d17a6f6f6c9
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private SingleRow singleRow;
    private ArrayList<SingleRow> singleRowArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //data source
        int[] image = {R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round};
        String[] name = {"Aman", "Kartik", "Pravesh", "Pranav", "Priya", "Rahul", "Tanya", "Abhishek", "Priyanka", "Aditya", "Divya", "Amit"};
        String[] number = {"1234567890", "1234567890", "1234567890", "1234567890", "1234567890", "1234567890", "1234567890", "1234567890", "1234567890", "1234567890", "1234567890", "1234567890"};

        singleRowArrayList = new ArrayList<>();
        for (int i = 0; i < image.length; i++) {
            singleRow = new SingleRow(image[i], name[i], number[i]);
            singleRowArrayList.add(singleRow);
        }

        RecyclerViewClickListener recyclerViewClickListener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(MainActivity.this, singleRowArrayList.get(position).name + " Clicked!!", Toast.LENGTH_SHORT).show();
            }
        };

        MyAdapter adapter = new MyAdapter(singleRowArrayList, recyclerViewClickListener);
        recyclerView.setAdapter(adapter);

    }
}
