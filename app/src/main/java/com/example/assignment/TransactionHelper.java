package com.example.assignment;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class TransactionHelper {
    private Context context;
    private com.example.assignment.DatabaseHelper database_helper;

    private SQLiteDatabase database;

    public TransactionHelper(Context context){this.context = context;}

    public void open() throws SQLException{
        database_helper = new com.example.assignment.DatabaseHelper(context);
        database = database_helper.getWritableDatabase();
    }

    public void close() throws SQLException{
        database_helper.close();
    }

    public ArrayList<com.example.assignment.TransactionHistoryList> viewHistory(String Email){
        ArrayList<com.example.assignment.TransactionHistoryList> historyList = new ArrayList<>();

        String query = "Select * from TransactionHistory where";

        return historyList;
    }
}
