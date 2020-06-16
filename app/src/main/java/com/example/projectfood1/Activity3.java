package com.example.projectfood1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

EditText adminUser,adminPass;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
       getSupportActionBar().setTitle("ADMIN LOGIN");
adminUser = findViewById(R.id.adminUser);
adminPass = findViewById(R.id.adminPass);
        btn1=(Button)findViewById(R.id.button6);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = adminUser.getText().toString();
                String passWord = adminPass.getText().toString();
                if((userName.equalsIgnoreCase("admin")) && (passWord.equalsIgnoreCase("admin"))){
                    Toast.makeText(Activity3.this, "Welcome", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Activity3.this,AdminNext.class));
                }
                else{
                    if(userName == "" || passWord == ""){
                        Toast.makeText(Activity3.this, "Fill the empty fields", Toast.LENGTH_SHORT).show();
                    }
            }}
        });

        }
}
