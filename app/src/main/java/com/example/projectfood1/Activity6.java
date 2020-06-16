package com.example.projectfood1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity6 extends AppCompatActivity {

Button btn1;
EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);
        getSupportActionBar().setTitle("AGENT LOGIN");
        btn1=(Button)findViewById(R.id.button6);
      et1=findViewById(R.id.et1);
      et2=findViewById(R.id.et2);


       btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Activity7.class));
            }
       });

    }
}
