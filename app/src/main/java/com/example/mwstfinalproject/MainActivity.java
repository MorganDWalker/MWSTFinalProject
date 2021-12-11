package com.example.mwstfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.view.View;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
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

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("  Spending Tracker | Home");
        DatabaseHelper dataBaseHelper = new DatabaseHelper(MainActivity.this);

        FloatingActionButton floatingActionButton = findViewById(R.id.add_expense);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddExpenseActivity.class));
            }
        });

        date = findViewById(R.id.dateText);
        total = findViewById(R.id.dailySpendingTxt);

        date.setText(LocalDate.now().toString());
        total.setText("$" + dataBaseHelper.getTodaystTotal() + "\n Spent So Far");

    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {

        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Handles menu selection operations
    @Override
    public boolean onOptionsItemSelected( @NonNull MenuItem item ) {

        switch (item.getItemId()){
            case R.id.action_settings:
                Intent settings = new Intent(this, SettingsActivity.class);
                startActivity(settings);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}