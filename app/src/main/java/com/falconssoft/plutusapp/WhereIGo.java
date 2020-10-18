package com.falconssoft.plutusapp;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WhereIGo extends AppCompatActivity {
List<String> list;
WhereICanGoAdapter whereICanGoAdapter;
RecyclerView whereRecyclerView ;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.where_i_go_activity);

        whereRecyclerView=findViewById(R.id.whereRecyclerView);

        list=new ArrayList<>();
        list.add("حبوب");
        list.add("القيصر");
        list.add("Burger Maker");
        list.add("الوجبه الذهبية");
        list.add("شاورما الموصلي");
        list.add("مخابز برادايس");
        list.add("Gas Station");


        whereRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        whereICanGoAdapter = new WhereICanGoAdapter(this, list);
        whereRecyclerView.setAdapter(whereICanGoAdapter);
    }
}
