package com.example.pando;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;




public class MainActivity extends AppCompatActivity {

    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button) findViewById(R.id.login_register);

        login.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SignInActivity.class);
            startActivity(intent);
        });


    }
}