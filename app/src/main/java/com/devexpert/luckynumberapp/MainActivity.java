package com.devexpert.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText enterYourName = findViewById(R.id.enterYourName);
        Button wishLuckButton = findViewById(R.id.wishLuckButton);

        wishLuckButton.setOnClickListener(view -> {
            String userName = enterYourName.getText().toString();

            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);

            intent.putExtra("name", userName);
            startActivity(intent);
        });

    }
}