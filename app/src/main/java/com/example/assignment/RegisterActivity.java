package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    TextView txtEmail, txtUsername, txtPhone, txtPassword;
    EditText edtEmail, edtUsername, edtPhone, edtPassword;
    Button signIn, signUp;

    private UserHelper helper;

    protected void init(){
        edtEmail = findViewById(R.id.editTextEmail);
        edtUsername = findViewById(R.id.editTextUsername);
        edtPhone = findViewById(R.id.editTextPhone);
        edtPassword = findViewById(R.id.editTextPassword);
        signIn = findViewById(R.id.buttonLogin);
        signUp = findViewById(R.id.buttonRegister);
        txtEmail = findViewById(R.id.textView);
        txtUsername = findViewById(R.id.textView2);
        txtPhone = findViewById(R.id.textView3);
        txtPassword = findViewById(R.id.textView4);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        signIn.setOnClickListener(view -> loginShow());
        signUp.setOnClickListener(view -> registerShow());
    }

    private void loginShow(){
        Intent loginIntent = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(loginIntent);
    }

    private void registerShow(){
        helper = new UserHelper(this);

        String email = edtEmail.getText().toString();
        String username = edtUsername.getText().toString();
        String phone = edtPhone.getText().toString();
        String password = edtPassword.getText().toString();
        String toastMessage;


        if(email.endsWith(".com")){
            if(edtUsername.getText().length() >= 3 && edtUsername.getText().length()<=20){
                String password_pattern = "(?=.*[a-z])(?=.*[0-9])";
                Pattern pattern = Pattern.compile(password_pattern);
                Matcher matcher = pattern.matcher(password);
                Boolean matchFound = matcher.find();
                if(matchFound){
                    helper.open();
                    helper.insert(email, username, phone, password);
                    helper.close();

                    Intent loginIntent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(loginIntent);
                }else {
                    toastMessage = "Password must be number and alphabet";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_LONG).show();
                }
            } else{
                toastMessage = "Username must contain between 3 and 20 characters!";
                Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_LONG).show();
            }
        } else {
            toastMessage = "Email must end with '.com'!";
            Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_LONG).show();
        }
    }
}