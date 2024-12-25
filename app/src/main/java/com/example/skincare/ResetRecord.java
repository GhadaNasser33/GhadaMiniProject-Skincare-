package com.example.skincare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class ResetRecord extends AppCompatActivity {
    EditText recordIdInput;
    Button resetButton;
    TextView resetFeedback, backadmin;
    DatabaseReference dbRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_record);

        recordIdInput = findViewById(R.id.resetid);
        resetButton = findViewById(R.id.resetbutton);
        resetFeedback = findViewById(R.id.resetfeedback);
        backadmin= findViewById(R.id.backadmin0);

        dbRef = FirebaseDatabase.getInstance().getReference("records");

        backadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sn= new Intent(ResetRecord.this,AdminUI.class);
                startActivity(sn);

            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = recordIdInput.getText().toString().trim();

                if (id.isEmpty()) {
                    Toast.makeText(ResetRecord.this, "Please enter a valid Record ID", Toast.LENGTH_LONG).show();
                    return;
                }

                resetrecord(id);
            }
        });
    }

    private void resetrecord(String id) {
        // Default values for resetting the record
        Map<String, Object> resetValues = new HashMap<>();
        resetValues.put("name", "N/A");
        resetValues.put("lastname", "N/A");
        resetValues.put("email", "N/A");
        resetValues.put("phone", "N/A");
        dbRef.child(id).updateChildren(resetValues)
                .addOnSuccessListener(aVoid -> {
                    resetFeedback.setText("Record reset successfully!");
                    Toast.makeText(ResetRecord.this, "Record reset successfully", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e -> {
                    resetFeedback.setText("Failed to reset record: " + e.getMessage());
                    Toast.makeText(ResetRecord.this, "Failed to reset record", Toast.LENGTH_SHORT).show();
                });
    }
}
