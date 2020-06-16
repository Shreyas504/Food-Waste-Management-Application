package com.example.projectfood1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity {
Button btnnotify, btnSignout, btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().setTitle("Dashboard");
        btnBack = findViewById(R.id.btnback);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, LoginUser.class));
            }
        });
    btnnotify = findViewById(R.id.btnnotify);
        getSupportActionBar().setTitle("Dashboard");
    btnnotify.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(Dashboard.this, Activity2.class));
        }
    });

    btnSignout = findViewById(R.id.btnSignout);
    btnSignout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(Dashboard.this, LoginUser.class));
        }
    });
    }
}
