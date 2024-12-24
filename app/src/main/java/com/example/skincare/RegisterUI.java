package com.example.skincare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterUI extends AppCompatActivity {
    EditText Email,pass;
    Button register;
    TextView login;
    ProgressBar pro;
  FirebaseAuth FA;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_ui);

        FA=FirebaseAuth.getInstance();
        Email = (EditText) findViewById(R.id.ed1);

        pass = (EditText) findViewById(R.id.ed3);

        register = (Button) findViewById(R.id.btt);
        pro = (ProgressBar) findViewById(R.id.pro1);
        login=(TextView) findViewById(R.id.signIn) ;

      login.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent m= new Intent(RegisterUI.this,LoginUI.class);
              startActivity(m);
          }
      });

      register.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {


        RegisterNewUser();


          }
      });

    }

     public void RegisterNewUser(){

     pro.setVisibility(View.VISIBLE);
         String em = Email.getText().toString();

         String ps = pass.getText().toString();


     if(TextUtils.isEmpty(em)){
         Toast.makeText(getApplicationContext(),"pls enter your email",
                 Toast.LENGTH_LONG).show();
         return;
     }
     if ((TextUtils.isEmpty(ps))){
         Toast.makeText(getApplicationContext(),"pls enter your password",
                 Toast.LENGTH_LONG).show();
         return;
     }
          FA.createUserWithEmailAndPassword(em,ps).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
              @Override
              public void onComplete(@NonNull Task<AuthResult> task) {
                  if (task.isSuccessful()){
                      Toast.makeText(getApplicationContext(),"Register is Successful",
                              Toast.LENGTH_LONG).show();
                      pro.setVisibility(View.VISIBLE);
                       Intent m= new  Intent(RegisterUI.this,LoginUI.class);
                       startActivity(m);


                  }
                  else {
                      Toast.makeText(getApplicationContext(),"Register  Faild try agian",
                              Toast.LENGTH_LONG).show();
                      pro.setVisibility(View.GONE);
                  }
              }
          });
     }
}