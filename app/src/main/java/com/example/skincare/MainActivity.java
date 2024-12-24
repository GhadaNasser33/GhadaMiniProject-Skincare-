package com.example.skincare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

    Handler gg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
         gg=new Handler();
         gg.postDelayed(new Runnable() {
             @Override
             public void run() {
                 Intent N=new Intent(MainActivity.this,RegisterUI.class);
                 startActivity(N);
                 finish();
             }
         },3000);



    }
}