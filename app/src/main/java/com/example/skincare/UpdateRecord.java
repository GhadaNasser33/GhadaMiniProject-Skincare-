package com.example.skincare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class UpdateRecord extends AppCompatActivity {
    EditText Fname, Lname, phone, Email, ID;
    TextView backadmin;
    Button Update;
    DatabaseReference dbRef;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_record);

        Fname=(EditText) findViewById(R.id.efname);
        Lname=(EditText) findViewById(R.id.elname);
        phone=(EditText) findViewById(R.id.ephone);
        Email=(EditText) findViewById(R.id.eemil);
        ID=(EditText) findViewById(R.id.idid);
        Update=(Button) findViewById(R.id.updaterec);
        backadmin=(TextView) findViewById(R.id.taa);
        dbRef = FirebaseDatabase.getInstance().getReference("records");
        backadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m= new Intent(UpdateRecord.this,AdminUI.class);
                startActivity(m);
            }
        });

        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname= Fname.getText().toString();
                String lname=Lname.getText().toString();
                String id=ID.getText().toString();
                String phon=phone.getText().toString();
                String Emil=Email.getText().toString();

                if (id.isEmpty()) {
                    Toast.makeText(UpdateRecord.this, "please enter a valid ID", Toast.LENGTH_LONG).show();
                    return;

                }
                else {
                Map<String, Object> updates = new HashMap<>();
                updates.put("name", fname);
                updates.put("lastname",lname);
                updates.put("email", Emil);
                updates.put("phone", phon);


                dbRef.child(id).updateChildren(updates)
                        .addOnSuccessListener(aVoid -> Toast.makeText(UpdateRecord.this, "Record Updated", Toast.LENGTH_SHORT).show())
                        .addOnFailureListener(e -> Toast.makeText(UpdateRecord.this, "Update Failed", Toast.LENGTH_SHORT).show());
                return;
            }}});}}








