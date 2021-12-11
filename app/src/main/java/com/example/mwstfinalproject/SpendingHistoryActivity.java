package com.example.mwstfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SpendingHistoryActivity extends AppCompatActivity implements View.OnClickListener {

    Button[][] buttonArray = new Button[4][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spending_history);

        buttonArray[0][0] = findViewById(R.id.JanButton);
        buttonArray[0][1] = findViewById(R.id.FebButton);
        buttonArray[0][2] = findViewById(R.id.MarchButton);
        buttonArray[1][0] = findViewById(R.id.AprilButton);
        buttonArray[1][1] = findViewById(R.id.MayButton);
        buttonArray[1][2] = findViewById(R.id.JuneButton);
        buttonArray[2][0] = findViewById(R.id.JulyButton);
        buttonArray[2][1] = findViewById(R.id.AugButton);
        buttonArray[2][2] = findViewById(R.id.SepButton);
        buttonArray[3][0] = findViewById(R.id.OctButton);
        buttonArray[3][1] = findViewById(R.id.NovButton);
        buttonArray[3][2] = findViewById(R.id.DecButton);
        for (int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                buttonArray[i][j].setOnClickListener(this);
            }
        }

    }

    @Override
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        Intent intent;
        switch (view.getId()){
            case R.id.JanButton:
                intent = new Intent(this, SpendingCategoriesActivity.class);
                bundle.putString("month", "01");
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.FebButton:
                intent = new Intent(this, SpendingCategoriesActivity.class);
                bundle.putString("month", "02");
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.MarchButton:
                intent = new Intent(this, SpendingCategoriesActivity.class);
                bundle.putString("month", "03");
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.AprilButton:
                intent = new Intent(this, SpendingCategoriesActivity.class);
                bundle.putString("month", "04");
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.MayButton:
                intent = new Intent(this, SpendingCategoriesActivity.class);
                bundle.putString("month", "05");
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.JuneButton:
                intent = new Intent(this, SpendingCategoriesActivity.class);
                bundle.putString("month", "06");
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.JulyButton:
                intent = new Intent(this, SpendingCategoriesActivity.class);
                bundle.putString("month", "07");
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.AugButton:
                intent = new Intent(this, SpendingCategoriesActivity.class);
                bundle.putString("month", "08");
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.SepButton:
                intent = new Intent(this, SpendingCategoriesActivity.class);
                bundle.putString("month", "09");
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.OctButton:
                intent = new Intent(this, SpendingCategoriesActivity.class);
                bundle.putString("month", "10");
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.NovButton:
                intent = new Intent(this, SpendingCategoriesActivity.class);
                bundle.putString("month", "11");
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.DecButton:
                intent = new Intent(this, SpendingCategoriesActivity.class);
                bundle.putString("month", "12");
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }

    }
}