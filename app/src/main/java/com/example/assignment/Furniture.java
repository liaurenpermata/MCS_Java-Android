package com.example.assignment;

public class Furniture {
    int gambar;
    String furnitureTitle, furniturePrice;

    public Furniture (int gambar, String furnitureTitle, String furniturePrice){
        this.gambar = gambar;
        this.furnitureTitle = furnitureTitle;
        this.furniturePrice = furniturePrice;
    }

    public int getGambar(){
        return gambar;
    }
    public String getFurnitureTitle(){
        return furnitureTitle;
    }
    public String getFurniturePrice(){
        return furniturePrice;
    }
}
