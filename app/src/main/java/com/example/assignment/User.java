package com.example.assignment;

public class User {
    String email;
    String username;
    String phoneNumber;
    String password;

    public User(String email, String username, String phoneNumber, String password){
        this.email = email;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getEmail(){return email;}
    public String getUsername(){return username;}
    public String getPhoneNumber(){return phoneNumber;}
    public String getPassword(){return password;}

    public void setEmail(String email){
        this.email = email;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
