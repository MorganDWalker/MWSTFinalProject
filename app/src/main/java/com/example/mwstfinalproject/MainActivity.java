package com.example.mwstfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {

    TextView date;
    TextView total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper dataBaseHelper = new DatabaseHelper(MainActivity.this);

        date = findViewById(R.id.dateText);
        total = findViewById(R.id.dailySpendingTxt);

        date.setText(LocalDate.now().toString());
        total.setText("$" + dataBaseHelper.getTodaystTotal() + "\n Spent So Far");

    }
}