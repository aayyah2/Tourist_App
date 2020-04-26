package com.example.touristapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Attraction testAttraction = new Attraction(1,1,1);
        System.out.println(testAttraction.getAttractionID());

    }
}
