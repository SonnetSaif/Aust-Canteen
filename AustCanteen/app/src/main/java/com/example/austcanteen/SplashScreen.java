package com.example.austcanteen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SplashScreen extends AppCompatActivity {
    //public static List<ListItems> listItems = new ArrayList<>();
    private DatabaseHelper myDb;
    private boolean doubleBackToExitPressedOnce = false;
    Animation mUptoDown, mDowntoUp;
    private boolean mAnimationDone = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageView mImageView;
        TextView mTextView;
        Button mButton;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        myDb = new DatabaseHelper(this);
        mImageView = (ImageView) findViewById(R.id.imageIV);
        //mTextView = (TextView) findViewById(R.id.splashText);
        mButton = (Button) findViewById(R.id.startButton);
        if(savedInstanceState != null){
            mAnimationDone = savedInstanceState.getBoolean("AnimationWork");
        }

        if(!mAnimationDone) {
            Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();
            mDowntoUp = AnimationUtils.loadAnimation(this, R.anim.downtoup);
            mUptoDown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
            //      mTextView.setAnimation(mDowntoUp);
            mImageView.setAnimation(mUptoDown);
            mButton.setAnimation(mDowntoUp);
            mAnimationDone = true;
        }

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("AnimationWork", mAnimationDone);
    }
}
