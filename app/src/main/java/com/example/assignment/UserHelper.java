package com.example.assignment;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class UserHelper {
    private Context context;
    private com.example.assignment.DatabaseHelper database_helper;

    private SQLiteDatabase database;

    public UserHelper(Context context){
        this.context = context;
    }

    public void open() throws SQLException{
        database_helper = new com.example.assignment.DatabaseHelper(context);
        database = database_helper.getWritableDatabase();
    }

    public void close() throws SQLException{
        database_helper.close();
    }

    public ArrayList<com.example.assignment.User> viewUser() {
        ArrayList<com.example.assignment.User> userList = new ArrayList<>();

        String query = "Select * from MsUser";

        Cursor cursor = database.rawQuery(query, null);
        cursor.moveToFirst();

        com.example.assignment.User emp;
        String tempEmail, tempUsername, tempPhone, tempPassword;

        if(cursor.getCount() > 0){
            do {
                tempEmail = cursor.getString(cursor.getColumnIndexOrThrow("Email"));
                tempUsername = cursor.getString(cursor.getColumnIndexOrThrow("Username"));
                tempPhone = cursor.getString(cursor.getColumnIndexOrThrow("PhoneNumber"));
                tempPassword = cursor.getString(cursor.getColumnIndexOrThrow("Password"));

                emp = new com.example.assignment.User(tempEmail,tempUsername,tempPhone,tempPassword);
                userList.add(emp);

                cursor.moveToNext();
            }while(!cursor.isAfterLast());
        }
        cursor.close();

        return userList;
    }

    public ArrayList<com.example.assignment.User> searchUser(String email, String password) {
        ArrayList<com.example.assignment.User> userList = new ArrayList<>();

        String query = "Select * from MsUser where Email ='"+email+"' AND Password = '"+password+"'";

        Cursor cursor = database.rawQuery(query, null);
        cursor.moveToFirst();

        com.example.assignment.User emp;
        String tempEmail, tempUsername, tempPhone, tempPassword;

        if(cursor!=null && cursor.moveToFirst()){
            tempEmail = cursor.getString(cursor.getColumnIndexOrThrow("Email"));
            tempUsername = cursor.getString(cursor.getColumnIndexOrThrow("Username"));
            tempPhone = cursor.getString(cursor.getColumnIndexOrThrow("PhoneNumber"));
            tempPassword = cursor.getString(cursor.getColumnIndexOrThrow("Password"));

            emp = new com.example.assignment.User(tempEmail,tempUsername,tempPhone,tempPassword);
            userList.add(emp);
        }
        else {
            emp = new com.example.assignment.User("not found", "not found", "not found", "not found");

            userList.add(emp);
        }
        cursor.close();

        return userList;
    }

    public void insert(String email, String username, String phoneNumber, String password){
        String query = "Select Email, Username, PhoneNumber, Password from MsUser";

        Cursor cursor = database.rawQuery(query, null);

        if(cursor!=null && cursor.moveToLast()){
            query = "Insert Into MsUser Values ('"+email+"','"+username+"','"+phoneNumber+"','"+password+"')";

            database.execSQL(query);
        }
    }

    public void editUsername(String email, String phoneNumber, String usernameNew){
            String query = "Update MsUser Set Username = '"+usernameNew+"' where PhoneNumber = '"+phoneNumber+"' AND Email = '"+email+"'";
            database.execSQL(query);
    }

    public void delete(String email, String phoneNumber){
        String query = "Delete From MsUser where PhoneNumber = '"+phoneNumber+"' AND Email = '"+email+"'";
        database.execSQL(query);
    }
}
