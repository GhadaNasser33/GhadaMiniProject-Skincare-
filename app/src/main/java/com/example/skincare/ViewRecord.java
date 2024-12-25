package com.example.skincare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewRecord extends AppCompatActivity {
    EditText recordId;
    Button viewButton;
    TextView displayName, displayLastName, displayEmail, displayPhone, admingo;
    DatabaseReference dbRef;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_record);

        recordId = findViewById(R.id.id0);
        viewButton = findViewById(R.id.ViewButton);
        displayName = findViewById(R.id.displayName);
        displayLastName = findViewById(R.id.displayLastname);
        displayEmail = findViewById(R.id.display_email);
        displayPhone = findViewById(R.id.display_phone);
        admingo=(TextView) findViewById(R.id.adminback);
        dbRef = FirebaseDatabase.getInstance().getReference("records");

        admingo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m= new Intent(ViewRecord.this,AdminUI.class);
                startActivity(m);
            }
        });

        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = recordId.getText().toString().trim();

                if (id.isEmpty()) {
                    Toast.makeText(ViewRecord.this, "Please enter a valid Record ID", Toast.LENGTH_LONG).show();
                    return;
                }
                dbRef.child(id).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            // Retrieve values
                            String firstName = snapshot.child("firstName").getValue(String.class);
                            String lastName = snapshot.child("lastName").getValue(String.class);
                            String email = snapshot.child("email").getValue(String.class);
                            String phone = snapshot.child("phone").getValue(String.class);

                            // Display values
                            displayName.setText("Name: " +(firstName != null ? firstName : "N/A") );
                            displayLastName.setText("Last Name: " + (lastName != null ? lastName : "N/A"));
                            displayEmail.setText("Email: " + email);
                            displayPhone.setText("Phone: " + phone);
                        } else {
                            Toast.makeText(ViewRecord.this, "No record found with this ID", Toast.LENGTH_LONG).show();
                            return;
                        }
                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(ViewRecord.this, "Failed to retrieve data: " + error.getMessage(), Toast.LENGTH_LONG).show();
                   return;
                    }


                });
            }
        }

        );
    }
}