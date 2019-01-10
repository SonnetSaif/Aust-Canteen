package com.example.austcanteen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowOrderedItems extends AppCompatActivity {
    private String foodNames;
    private TextView itemShowField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_ordered_items);
        itemShowField = (TextView) findViewById(R.id.itemShowField);

        foodNames = getIntent().getStringExtra("foodname");
        itemShowField.setText(foodNames);
    }
}
