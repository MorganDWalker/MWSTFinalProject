package com.example.mwstfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.app.DatePickerDialog;

import java.util.Calendar;

public class AddExpenseActivity extends AppCompatActivity {

    DatePickerDialog picker;
    EditText expenseCategory;
    EditText expenseCost;
    EditText expenseDate;
    EditText expenseName;
    Button btnAddExpense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("  Spending Tracker | Add Expense");
        DatabaseHelper dataBaseHelper = new DatabaseHelper(AddExpenseActivity.this);

        expenseCategory = findViewById(R.id.txtExpenseCategory);
        expenseName = findViewById(R.id.txtPurchaseName);
        expenseCost = findViewById(R.id.txtExpenseCost);
        expenseDate = findViewById(R.id.txtExpenseDate);
        expenseDate.setInputType(InputType.TYPE_NULL);
        //code for date selection
        expenseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                //date picker dialog
                picker = new DatePickerDialog(AddExpenseActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        expenseDate.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                    }
                }, year, month, day);
                picker.show();
            }
        });
        //submit button code
        btnAddExpense = findViewById(R.id.btnAddExpense);
        btnAddExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                DatabaseHelper helper = new DatabaseHelper(AddExpenseActivity.this);
                helper.InsertPurchase(expenseCategory.getText().toString(),expenseName.getText().toString(),expenseDate.getText().toString(),Float.parseFloat(expenseCost.getText().toString()));
                startActivity(new Intent(AddExpenseActivity.this, MainActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void checkInput(){

    }
}