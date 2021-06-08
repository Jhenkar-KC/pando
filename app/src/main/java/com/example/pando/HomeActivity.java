package com.example.pando;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    Button login;
    Button about_us;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        login = (Button) findViewById(R.id.login_register);
        about_us = (Button) findViewById(R.id.about_us);
        login.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, SignInActivity.class);
            startActivity(intent);
        });
        about_us.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, AboutUsScrollingActivity.class);
            startActivity(intent);
        });

    }
}