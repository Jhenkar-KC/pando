package com.example.pando;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    Button sign_in_button;
    Button about_us;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        sign_in_button = (Button) findViewById(R.id.home_page);
        about_us = (Button) findViewById(R.id.about_us);
        sign_in_button.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, MenuActivity.class);
            startActivity(intent);
        });

        about_us.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, AboutUsScrollingActivity.class);
            startActivity(intent);
        });
    }

}