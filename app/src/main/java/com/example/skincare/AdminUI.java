package com.example.skincare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AdminUI extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_ui);



    }
    public void openAddRecord(View view) {
        startActivity(new Intent(this, AddRecord.class));
    }

    public void openUpdateRecord(View view) {
        startActivity(new Intent(this, UpdateRecord.class));
    }

    public void openDeleteRecord(View view) {
        startActivity(new Intent(this, DeleteRecord.class));
    }



    public void openHomePage(View view) {
        startActivity(new Intent(this, HomePageUI.class));
    }

}

