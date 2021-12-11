package com.example.mwstfinalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // creating a constant variables for our database

    public static final String PURCHASES = "PURCHASE_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_DATE = "PURCHASE_DATE";
    public static final String COLUMN_PURCHASE_NAME = "PURCHASE_NAME";
    public static final String COLUMN_AMOUNT = "AMOUNT";
    public static final String COLUMN_CATEGORY = "CATEGORY";


    // Constructor for Database Helper
    public DatabaseHelper(@Nullable Context context) {
        super(context, "purchases.db", null, 2);
    }

    // creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {


        String createPurchaseTable = "CREATE TABLE " + PURCHASES + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_DATE + " TEXT, " + COLUMN_PURCHASE_NAME + " TEXT, " + COLUMN_CATEGORY + " TEXT, " + COLUMN_AMOUNT + " REAL)";

        db.execSQL(createPurchaseTable);

    }


    // if newer version of database is available android executes onUpgrade method.
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + PURCHASES);
        onCreate(db);
    }


    /*
        Called when app is first launched will get the Sum of today's spending
     */
    public float getTodaystTotal() {

        String queryString = "SELECT " + COLUMN_DATE + ", SUM(" + COLUMN_AMOUNT + ") FROM " + PURCHASES +
                " WHERE " + COLUMN_DATE + " = date('now')";

        SQLiteDatabase db = this.getReadableDatabase();

        float total = 0;

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                total = cursor.getFloat(1);

            } while (cursor.moveToNext());

        }
        return total;
    }

    public HashMap<String, List<String>> GetMonthlyCategories(String month){
        HashMap<String, List<String>> listCategories = new HashMap<String, List<String>>();
        List<String> categories = new ArrayList<String>();
        List<Float> totals = new ArrayList<Float>();

        SQLiteDatabase db = this.getReadableDatabase();

        String queryString = "SELECT " + COLUMN_CATEGORY + ", SUM(" + COLUMN_AMOUNT + ") FROM " + PURCHASES +
                " WHERE " + "strftime('%m', " + COLUMN_DATE + ") = " + month + " GROUP BY " + COLUMN_CATEGORY;

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                categories.add(cursor.getString(0));
                totals.add(cursor.getFloat(1));

            } while (cursor.moveToNext());
        }
        for(int i=0; i<categories.size();i++){
            List<String> purchases = new ArrayList<String>();
            String secondQuery = "SELECT " + COLUMN_PURCHASE_NAME + ", " + COLUMN_AMOUNT + " FROM " + PURCHASES +
                    " WHERE " + "strftime('%m', " + COLUMN_DATE + ") = '" + month + "' AND " + COLUMN_CATEGORY + " = '" + categories.get(i) + "'";

            Cursor secondCursor = db.rawQuery(secondQuery, null);

            if (secondCursor.moveToFirst()) {
                do {
                    purchases.add(cursor.getString(0) + ": " + cursor.getFloat(1));
                } while (cursor.moveToNext());
            }

            listCategories.put(categories.get(i) + ": " + totals.get(i),purchases);

        }

        return listCategories;
    }

    public HashMap<String, List<String>> GetTodayCategories(String day){
        HashMap<String, List<String>> listCategories = new HashMap<String, List<String>>();
        List<String> categories = new ArrayList<String>();
        List<Float> totals = new ArrayList<Float>();

        SQLiteDatabase db = this.getReadableDatabase();

        String queryString = "SELECT " + COLUMN_CATEGORY + ", SUM(" + COLUMN_AMOUNT + ") FROM " + PURCHASES +
                " WHERE " + "date(" + COLUMN_DATE + ") = date('" + day + "') GROUP BY " + COLUMN_CATEGORY;

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                categories.add(cursor.getString(0));
                totals.add(cursor.getFloat(1));

            } while (cursor.moveToNext());
        }
        for(int i=0; i<categories.size();i++){
            List<String> purchases = new ArrayList<String>();
            String secondQuery = "SELECT " + COLUMN_PURCHASE_NAME + ", " + COLUMN_AMOUNT + " FROM " + PURCHASES +
                    " WHERE " + "date(" + COLUMN_DATE + ") = date('" + day + "') AND " + COLUMN_CATEGORY + " = '" + categories.get(i) + "'";

            Cursor secondCursor = db.rawQuery(secondQuery, null);

            if (secondCursor.moveToFirst()) {
                do {
                    purchases.add(secondCursor.getString(0) + ": " + secondCursor.getFloat(1));
                } while (secondCursor.moveToNext());
            }

            listCategories.put(categories.get(i) + ": " + totals.get(i),purchases);

        }

        return listCategories;
    }

    public void InsertDummyData(){
        SQLiteDatabase db = this.getWritableDatabase();

        // ContentValues stores the Key Value pair for column name and its data
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_PURCHASE_NAME,"Wendy's");
        cv.put(COLUMN_CATEGORY,"Food");
        cv.put(COLUMN_DATE, LocalDate.now().toString());
        cv.put(COLUMN_AMOUNT,20.50);

        // insert content values to our Student table.
        db.insert(PURCHASES, null, cv);

        // close the Database connection
        db.close();
    }

}
