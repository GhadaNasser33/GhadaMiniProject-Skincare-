package com.example.skincare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProductItems extends AppCompatActivity {
    Button BackHomePage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_items);

        BackHomePage=(Button) findViewById(R.id.BackToHomePage) ;
        BackHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to Home Page
                Intent mm = new Intent(ProductItems.this, HomePageUI.class);
                startActivity(mm);
                finish();
            }
        });
    };
}
