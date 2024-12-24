package com.example.skincare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class CalculateBill extends AppCompatActivity {
    EditText ItemName;
    Button GetPrice;
    Button BackHomePage;
    TextView tv;

    HashMap<String, Double> itemPrices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_bill);

        ItemName = (EditText) findViewById(R.id.ItemName);
        GetPrice = (Button) findViewById(R.id.calculate);
        tv = (TextView) findViewById(R.id.displayPrice);
        BackHomePage=(Button) findViewById(R.id.BackToHomePage);
        initializeItemPrices();
        GetPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = ItemName.getText().toString().trim();
                if (itemPrices.containsKey(itemName)) {
                    double price = itemPrices.get(itemName);
                    tv.setText("Price: OMR" + price);
                } else {
                    tv.setText("Item not found!");


                }
            }
        });
    }
    private void initializeItemPrices() {
        itemPrices = new HashMap<>();
        itemPrices.put("Soup", 4.0);
        itemPrices.put("butter", 4.0);

        BackHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to Home Page
                Intent mm = new Intent(CalculateBill.this, HomePageUI.class);
                startActivity(mm);
                finish();
            }
        });



    }}



