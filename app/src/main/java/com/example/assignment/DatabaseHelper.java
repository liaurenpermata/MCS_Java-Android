package com.example.assignment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    DatabaseHelper(Context context){
        super(context, "DatabaseName", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        String query = "Create table MsUser (Email, Username, PhoneNumber, Password)";
        String queryTransaction = "Create table TransactionHistory (Email, Product, Amount)";

        sqLiteDatabase.execSQL(queryTransaction);
        sqLiteDatabase.execSQL(query);

        query = "Insert into MsUser values('admin@binus.com','Admin','123','admin123')";
        queryTransaction = "Insert into TransactionHistory values('admin@binus.com', 0 , 3 )";
        sqLiteDatabase.execSQL(query);
        sqLiteDatabase.execSQL(queryTransaction);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int il){
        sqLiteDatabase.execSQL("drop table if exists MsUser");
        sqLiteDatabase.execSQL("drop table if exists TransactionHistory");
        onCreate(sqLiteDatabase);
    }
}
