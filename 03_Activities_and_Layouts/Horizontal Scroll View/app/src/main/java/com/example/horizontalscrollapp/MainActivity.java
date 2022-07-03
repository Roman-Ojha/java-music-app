package com.example.horizontalscrollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "There is a click on this button", Toast.LENGTH_SHORT).show();

                //  We can log a message to the console using:
                // Log.d("tag' 'log this message');
                // Similarly we can use log.i for info, log.e fro error etc.
                Log.d("Tag","This is the message");
            }
        });
    }
}