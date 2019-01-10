package com.example.austcanteen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class DrinksMenu extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<ListItems> listItems;
    private DatabaseHelper myDB;
    private final String TABLE_NAME = "Drinks";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_menu);
        myDB = new DatabaseHelper(this);
        TextView mTotalFoodCost = (TextView) findViewById(R.id.totalAmount);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        listItems = myDB.getList(TABLE_NAME);

        adapter = new MyAdapter(listItems, this, mTotalFoodCost);
        recyclerView.setAdapter(adapter);
    }
}
