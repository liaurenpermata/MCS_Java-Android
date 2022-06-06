package com.example.assignment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edxEmail, edxPassword;
    Button signin, signup;
    String email, phone;
    boolean delete=false;

    private com.example.assignment.UserHelper helper = new com.example.assignment.UserHelper(this);;

    protected void init() {
        edxEmail = findViewById(R.id.editTextEmail);
        edxPassword = findViewById(R.id.editTextPassword);
        signin = findViewById(R.id.buttonLogin);
        signup = findViewById(R.id.buttonRegister);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        signin.setOnClickListener(view -> loginShow());
        signup.setOnClickListener(view -> registerShow());
        if(delete=true && email!=null){
            helper.delete(email, phone);
            delete=false;
        }
    }

    private void loginShow() {
        String email = edxEmail.getText().toString();
        String password = edxPassword.getText().toString();


        helper.open();
        ArrayList<com.example.assignment.User> userList = helper.searchUser(email, password);
        helper.close();

        if(!userList.get(0).getEmail().equals("not found")  && !userList.get(0).getPassword().equals("not found")){

            Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
            homeIntent.putExtra("email", userList.get(0).getEmail());
            homeIntent.putExtra("password", userList.get(0).getPassword());

            startActivity(homeIntent);

        } else{
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder
                    .setMessage("Incorrect email or password!")
                    .setNegativeButton("Retry", null).create().show();
        }
    }

    private void registerShow() {
        Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(registerIntent);
    }
}