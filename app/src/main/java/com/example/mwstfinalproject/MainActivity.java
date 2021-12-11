package com.example.mwstfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {

    TextView date;
    TextView total;
    Button moreDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper dataBaseHelper = new DatabaseHelper(MainActivity.this);
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

        date.setText(LocalDate.now().toString());
        total.setText("$" + dataBaseHelper.getTodaystTotal() + "\n Spent So Far");

    }


}