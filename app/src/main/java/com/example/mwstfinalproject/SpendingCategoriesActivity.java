package com.example.mwstfinalproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SpendingCategoriesActivity extends AppCompatActivity {

    Bundle bundle;
    String month;
    String today;

    ExpandableListView listView;
    ExpandableListAdapter listAdapter;
    List<String> title;
    HashMap<String, List<String>> detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spending_categories);
        bundle = getIntent().getExtras();
        month = bundle.getString("month");
        today = bundle.getString("date");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("  Spending Tracker | Spending Categories ");
        DatabaseHelper databaseHelper = new DatabaseHelper(SpendingCategoriesActivity.this);

        listView = (ExpandableListView) findViewById(R.id.categoryListing);

        if (month == null){
            detail = databaseHelper.GetTodayCategories(today);
        }
        else {
            detail = databaseHelper.GetMonthlyCategories(month);
        }
        title = new ArrayList<String>(detail.keySet());
        listAdapter = new ExpandableListAdapter(SpendingCategoriesActivity.this, title, detail);
        listView.setAdapter(listAdapter);

    }
}