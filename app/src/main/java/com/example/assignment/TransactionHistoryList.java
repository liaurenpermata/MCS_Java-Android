package com.example.assignment;

public class TransactionHistoryList {

    String Email;
    int Product;
    int Amount;

    public TransactionHistoryList(String email, int Product, int Amount){
        this.Email = email;
        this.Amount = Amount;
        this.Product = Product;
    }

    public String getEmail(){return Email;}
    public int getAmount(){return Amount;}
    public int getProduct(){return Product;}

    public void setEmail(String Email){this.Email = Email;}
    public void setAmount(int Amount){this.Amount = Amount;}
    public void setProduct(int Product){this.Product = Product;}

}
