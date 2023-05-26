package com.example.animalhospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        Intent intent=getIntent();
        ((TextView)findViewById(R.id.txtItemname)).setText(intent.getStringExtra("itemName"));
        ((TextView)findViewById(R.id.txtCount)).setText(intent.getStringExtra("itemCount"));
        ((TextView)findViewById(R.id.txtPrice)).setText(intent.getStringExtra("itemPrice"));
    }
}