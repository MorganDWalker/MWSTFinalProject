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
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class MainActivity extends AppCompatActivity {

    TextView date;
    TextView total;
    Button moreDetails;
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
        moreDetails = (Button) findViewById(R.id.detailsButton);

        moreDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                Intent intent;
                intent = new Intent(MainActivity.this, SpendingCategoriesActivity.class);
                bundle.putString("date", LocalDate.now().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        date.setText(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        total.setText("$" + String.format("%.2f",dataBaseHelper.getTodaystTotal()) + "\n Spent So Far");

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
            case R.id.history:
                Intent history = new Intent(this, SpendingHistoryActivity.class);
                startActivity(history);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}