package com.example.skincare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DeleteRecord extends AppCompatActivity {

     EditText etId;
     DatabaseReference dbref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_record);

        etId = findViewById(R.id.del);
               dbref = FirebaseDatabase.getInstance().getReference("records");
    }

    public void deleteRecord(View view) {
        String id = etId.getText().toString();

        if (id.isEmpty()) {
            Toast.makeText(this, "Please enter a valid ID", Toast.LENGTH_LONG).show();
            return;
        }

        dbref.child(id).removeValue()
                .addOnSuccessListener(aVoid -> Toast.makeText(this, "Record Deleted", Toast.LENGTH_SHORT).show())
                .addOnFailureListener(e -> Toast.makeText(this, "Delete Failed", Toast.LENGTH_SHORT).show());
    }
    public void goadmin(View view) {
        startActivity(new Intent(this, AdminUI.class));
    }





}

