package com.example.austcanteen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Iterator;
import java.util.Random;

public class ConfirmOrder extends AppCompatActivity {
    private TextView mOrderNumber, mPaidStatus, mReceived, mDisplayTotalCost;
    private Button mSaveBtn, mCompleteBtn;
    private String TABLE_NAME = "Order_No";
    private DatabaseHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);
        myDB = new DatabaseHelper(this);
        mOrderNumber = (TextView) findViewById(R.id.orderTextTV);
        mPaidStatus = (TextView) findViewById(R.id.paidTextTV);
        mReceived = (TextView) findViewById(R.id.receivedTextTV);
        mDisplayTotalCost = (TextView) findViewById(R.id.totalTextTV);
        mSaveBtn = (Button) findViewById(R.id.saveOrderBtn);
        mCompleteBtn = (Button) findViewById(R.id.completeOrderBtn);

        Random rand = new Random();

        int generateRandomNumber = rand.nextInt(100);

        mOrderNumber.setText(String.valueOf(generateRandomNumber));
        mPaidStatus.setText("No");
        mReceived.setText("No");
        mDisplayTotalCost.setText(CartMenu.totalFoodCost + " Taka");

        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveOrder();
            }
        });

        completeOrder();
    }

    private void saveOrder(){
        StringBuilder builder = new StringBuilder();
        Iterator<ListItems> it = CartMenu.listItems.iterator();
        while(it.hasNext()){
            ListItems o = it.next();
            builder.append(o.getName() + "\n\n");
        }

        boolean isSaved = myDB.insertOrder(Integer.parseInt(mOrderNumber.getText().toString()), builder.toString(), String.valueOf(CartMenu.totalFoodCost), mPaidStatus.getText().toString(), mReceived.getText().toString());
        if(isSaved){
            Toast.makeText(ConfirmOrder.this, "Order Saved", Toast.LENGTH_SHORT).show();
            CartMenu.listItems.clear();
            CartMenu.totalFoodCost = 0;
            finish();
        }
        else Toast.makeText(ConfirmOrder.this, "Failed", Toast.LENGTH_SHORT).show();
    }

    public void completeOrder(){
        mCompleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ConfirmOrder.this, "Thanks for Purchasing", Toast.LENGTH_SHORT).show();
                CartMenu.listItems.clear();
                CartMenu.totalFoodCost = 0;
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        saveOrder();
    }
}
