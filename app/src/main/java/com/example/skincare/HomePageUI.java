package com.example.skincare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePageUI extends AppCompatActivity {

    Button viewProdButton;
    Button selectProdButton;
    Button GetPriceButton;
    Button logoutButton;
    Button Admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_ui);

        viewProdButton =(Button) findViewById(R.id.b4);

        GetPriceButton =(Button) findViewById(R.id.b5);
        logoutButton =(Button) findViewById(R.id.b6);
        Admin=(Button) findViewById(R.id.admin) ;

        viewProdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gha = new Intent(HomePageUI.this, ProductItems.class);
                startActivity(gha);
            }
        });

        Admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent g = new Intent(HomePageUI.this, AdminUI.class);
                startActivity(g);
            }
        });

        GetPriceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AA = new Intent(HomePageUI.this, CalculateBill.class);
                startActivity(AA);

            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish current activity and navigate to login
                Intent intent = new Intent(HomePageUI.this, LoginUI.class);
                startActivity(intent);
                finish();


            }
        });
    }
}
