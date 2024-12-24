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

public class AddRecord extends AppCompatActivity {
    EditText Fname, Lname, phone, Email;
    TextView backadmin;
    Button add;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        Fname=(EditText) findViewById(R.id.efname);
        Lname=(EditText)findViewById(R.id.elname);
        phone=(EditText)findViewById(R.id.ephone);
        Email=(EditText)findViewById(R.id.eemil);
        add=(Button) findViewById(R.id.addrecord);
        backadmin=(TextView) findViewById(R.id.taa);

        dbRef = FirebaseDatabase.getInstance().getReference("records");

        backadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m= new Intent(AddRecord.this,AdminUI.class);
                startActivity(m);
            }
        });

       add.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String id = dbRef.push().getKey();
               Record record = new Record(id, Fname.getText().toString(), Lname.getText().toString(),
                       phone.getText().toString(),Email.getText().toString());
               dbRef.child(id).setValue(record);
               Toast.makeText(AddRecord.this, "Record Added", Toast.LENGTH_LONG).show();
               return;
           }
       });
    }
}