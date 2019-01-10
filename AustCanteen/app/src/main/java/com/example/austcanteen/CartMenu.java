package com.example.austcanteen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


public class CartMenu extends AppCompatActivity {
    public static List<ListItems> listItems = new ArrayList<>();
    public static int totalFoodCost;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private DatabaseHelper myDB;
    private Button mConfirmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_menu);
        myDB = new DatabaseHelper(this);
        TextView mTotalFoodCost = (TextView) findViewById(R.id.totalFinalAmount);
        mConfirmBtn = (Button) findViewById(R.id.confirmBtn);

        if(totalFoodCost <= 0) mConfirmBtn.setEnabled(false);

        recyclerView = (RecyclerView) findViewById(R.id.cartMenuRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CartMenuAdapter(listItems, this, mTotalFoodCost, mConfirmBtn);
        recyclerView.setAdapter(adapter);

        confirmOrder();
    }

    private void confirmOrder(){
        mConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CartMenu.this, ConfirmOrder.class);
                startActivity(i);
                mConfirmBtn.setEnabled(false);
                finish();
            }
        });
    }

}