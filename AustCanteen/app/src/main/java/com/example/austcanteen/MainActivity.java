package com.example.austcanteen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import at.markushi.ui.CircleButton;

public class MainActivity extends AppCompatActivity {
    private boolean doubleBackToExitPressedOnce = false;
    CircleButton mBreakfastbutton;
    CircleButton mLunchButton;
    CircleButton mDrinksButton;
    CircleButton mCartButton;
    CircleButton mComplaintButton;
    CircleButton mOtherItemButton;
    CircleButton mOrders;
    CircleButton mAboutUs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBreakfastbutton = (CircleButton) findViewById(R.id.breakfastBtn);
        mLunchButton = (CircleButton) findViewById(R.id.lunchBtn);
        mDrinksButton = (CircleButton) findViewById(R.id.drinksBtn);
        mCartButton = (CircleButton) findViewById(R.id.cartMenuBtn);
        mComplaintButton = (CircleButton) findViewById(R.id.complaintBoxBtn);
        mOtherItemButton = (CircleButton) findViewById(R.id.otherItemBtn);
        mOrders = (CircleButton) findViewById(R.id.orders);
        mAboutUs = (CircleButton) findViewById(R.id.aboutUs);

        mBreakfastbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), BreakFastMenu.class);
                startActivity(i);
            }
        });

        mLunchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), LunchMenu.class);
                startActivity(i);
            }
        });

        mDrinksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), DrinksMenu.class);
                startActivity(i);
            }
        });

        mCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CartMenu.class);
                startActivity(i);
            }
        });

        mComplaintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ComplaintBox.class);
                startActivity(i);
            }
        });

        mOtherItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), OtherItems.class);
                startActivity(i);
            }
        });

        mOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, OrderMenu.class);
                startActivity(i);
            }
        });

        mAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Developers.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press Back Again to Exit", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
