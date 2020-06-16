package com.example.projectfood1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginUser extends AppCompatActivity {
    Button btn1, btn2, back;
    EditText et1, et2;
   /* private FirebaseAuth firebaseAuth;
String username,userpass;
Context CTX=this;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
        getSupportActionBar().setTitle("Login Form");
        btn1 = (Button) findViewById(R.id.b1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LoginUser.this, Act4.class));
            }
        });
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginUser.this, MainActivity.class));
            }
        });
       // firebaseAuth = FirebaseAuth.getInstance();
        btn2 = (Button) findViewById(R.id.b2);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(et1.getText().toString())){
                    Toast.makeText(LoginUser.this, "Please Enter Email Address", Toast.LENGTH_SHORT).show();
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(et1.getText().toString()).matches()){
                    Toast.makeText(LoginUser.this, "Please Enter Valid Email Address", Toast.LENGTH_SHORT).show();
                }
                else  if(TextUtils.isEmpty(et2.getText().toString())){
                    Toast.makeText(LoginUser.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }
                else if(et2.getText().toString().length()<6){
                    Toast.makeText(LoginUser.this, "Please Enter 6 or more than 6 digit Password", Toast.LENGTH_SHORT).show();
                }
                else{
                    login();
                }
            }
        });


       /* btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Bundle b=getIntent().getExtras();
                //int status=b.getInt("status");
                *//*if(status==1){*//*
                    Toast.makeText(getBaseContext(),"Please wait..",Toast.LENGTH_SHORT).show();
                    username=et1.getText().toString();
                    userpass=et2.getText().toString();
                    DatabaseOperations DOP=new DatabaseOperations(CTX);
                    Cursor CR=DOP.getInformation(DOP);
                    CR.moveToFirst();
                    boolean loginstatus=false;
                    String NAME="";

                    do{
                        if(username.equals(CR.getString(0))&&(userpass.equals(CR.getString(1)))){
                            loginstatus=true;
                            NAME=CR.getString(0);

                        }


                    }while(CR.moveToNext());
                    if (loginstatus) {
                        Toast.makeText(getBaseContext(),"Login Success",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),Activity2.class));

                    }
                    else{
                        Toast.makeText(getBaseContext(),"Login Failed...",Toast.LENGTH_SHORT).show();
                        finish();

                    }


            }
        });
*/
       /* btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = et1.getText().toString().trim();
                String password = et2.getText().toString().trim();

                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginUser.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(getApplicationContext(),Activity2.class));

                                } else {
                                    Toast.makeText(LoginUser.this,"Login Failed",Toast.LENGTH_SHORT).show();

                                }

                                // ...
                            }

                        });
            }


        });*/


    }

    private void login() {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(et1.getText().toString(), et2.getText().toString())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(LoginUser.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginUser.this, Dashboard.class));
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(LoginUser.this, "Failed..", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}