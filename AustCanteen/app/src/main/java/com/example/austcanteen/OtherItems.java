package com.example.austcanteen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class OtherItems extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<ListItems> listItems;
    private DatabaseHelper myDB;
    private final String TABLE_NAME = "Other_Items";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_items);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myDB = new DatabaseHelper(this);
        TextView mTotalFoodCost = (TextView) findViewById(R.id.totalAmount);

        listItems = new ArrayList<>();

        listItems = myDB.getList(TABLE_NAME);

        adapter = new MyAdapter(listItems, this, mTotalFoodCost);
        recyclerView.setAdapter(adapter);
    }
}
