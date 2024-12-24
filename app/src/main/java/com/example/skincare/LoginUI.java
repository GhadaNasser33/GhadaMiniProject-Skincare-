package com.example.skincare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class LoginUI extends AppCompatActivity {

    EditText email,pass;
    Button login;
    ProgressBar pp;
    FirebaseAuth FA;
    TextView reg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ui);

        FA=FirebaseAuth.getInstance();

        email =(EditText) findViewById(R.id.ed1);
        pass = (EditText) findViewById(R.id.ed2);
        login=(Button) findViewById(R.id.btn1);
        pp=(ProgressBar) findViewById(R.id.progressBar);
        reg=(TextView) findViewById(R.id.Reg) ;

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  UserLoginAccount();
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b= new Intent(LoginUI.this,RegisterUI.class);
                startActivity(b);
                finish();
            }
        });

    }
    public void  UserLoginAccount(){
        pp.setVisibility(View.VISIBLE);
        String em=email.getText().toString();
        String passWord=pass.getText().toString();

        if (TextUtils.isEmpty(em)){
            Toast.makeText(getApplicationContext(),"enter your email",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(passWord)){
            Toast.makeText(getApplicationContext(),"pls enter your pass",Toast.LENGTH_LONG).show();
            return;
        }
        FA.signInWithEmailAndPassword(em,passWord).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"login done successfully",Toast.LENGTH_LONG).show();
                    pp.setVisibility(View.VISIBLE);
                    Intent k=new Intent(LoginUI.this,HomePageUI.class);
                    startActivity(k);

                }
                else {
                    Toast.makeText(getApplicationContext(),"Login Failed, try again",Toast.LENGTH_LONG).show();
                    pp.setVisibility(View.GONE);
                }
            }
        });
    }
}