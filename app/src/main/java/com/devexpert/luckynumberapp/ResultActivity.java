package com.devexpert.luckynumberapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView numberResult = findViewById(R.id.luckyNumberResult);
        Button shareResults = findViewById(R.id.shareResultButton);
        Intent intent = getIntent();
        String username = intent.getStringExtra("name");

        int randomNumber = generateRandomNumber();
        numberResult.setText(String.format("%d", randomNumber));

        shareResults.setOnClickListener(view -> {
            shareData(username, randomNumber);
        });

    }


    public int generateRandomNumber() {
        Random random = new Random();
        int upperLimit = 1000;
        return random.nextInt(upperLimit);
    }

    public void shareData(String userName, int randomNum) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_SUBJECT, userName + " got lucky today!");
        intent.putExtra(Intent.EXTRA_TEXT, "Your results is" + randomNum);

        startActivity(Intent.createChooser(intent, "Choose Platform"));

    }
}