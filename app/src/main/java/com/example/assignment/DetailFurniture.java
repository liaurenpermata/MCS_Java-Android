package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFurniture extends AppCompatActivity {

    String name, price;
    ImageView imgView;
    TextView nameTxt, priceTxt;
    EditText valueEdt;
    Button button;

    public void init(){
        imgView = findViewById(R.id.imageViewDetailFurniture);
        nameTxt = findViewById(R.id.textViewDetailName);
        priceTxt = findViewById(R.id.textViewDetailPrice);
        valueEdt = findViewById(R.id.editTextDetailFurniture);
        button = findViewById(R.id.buttonDetailFurniture);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_furniture);

        init();
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("nameProd");
        price = bundle.getString("priceProd");

        if (getIntent().hasExtra("imageProd")) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra("imageProd"), 0, getIntent().getByteArrayExtra("imageProd").length);
            imgView.setImageBitmap(bitmap);
        }



    }
}