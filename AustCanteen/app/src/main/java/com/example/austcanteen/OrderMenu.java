package com.example.austcanteen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class OrderMenu extends AppCompatActivity {
    private TextView orderNumber, paidStatus, receivedStatus;
    private Button showItemsBtn;
    private final String TABLE_NAME = "Order_No";
    private List<ListItems> listItems;
    private DatabaseHelper myDB;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_menu);
        myDB = new DatabaseHelper(this);

        orderNumber = (TextView) findViewById(R.id.orderMenuOrderNo);
        paidStatus = (TextView) findViewById(R.id.orderMenuPaidStatus);
        receivedStatus = (TextView) findViewById(R.id.orderMenuReceivedStatus);
        showItemsBtn = (Button) findViewById(R.id.orderMenuShowItemsbtn);

        recyclerView = (RecyclerView) findViewById(R.id.orderedMenuRecylcerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        listItems = myDB.getOrderItemsList(TABLE_NAME);

        adapter = new OrderMenuAdapter(listItems, this);
        recyclerView.setAdapter(adapter);
    }
}
