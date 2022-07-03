package com.example.creatingourfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    // here we are inheriting class 'AppCompatActivity'
    // here we have to inherit this class because it had already made and we are using this 'AppcompatActivity' to make our main activity


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // here onCreate is the method where it will set the view when we are opening the app
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // so to run the app we need the device
    // here we will use virtual device

    // viewGroup is the container and the view is the object
}