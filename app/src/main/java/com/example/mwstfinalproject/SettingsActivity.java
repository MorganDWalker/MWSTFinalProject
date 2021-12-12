package com.example.mwstfinalproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;

public class SettingsActivity extends AppCompatActivity {

    Button btnClearData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("  Spending Tracker | Settings");
        DatabaseHelper dataBaseHelper = new DatabaseHelper(SettingsActivity.this);

        //submit button code
        btnClearData = findViewById(R.id.btnClearData);
        btnClearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                DatabaseHelper helper = new DatabaseHelper(SettingsActivity.this);
                helper.clearTable();
                startActivity(new Intent(SettingsActivity.this, MainActivity.class));
            }
        });
    }
}