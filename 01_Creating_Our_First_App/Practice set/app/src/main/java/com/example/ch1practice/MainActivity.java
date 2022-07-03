package com.example.ch1practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText n1,n2;
    Button button,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Good Morning", Toast.LENGTH_SHORT).show();
        // Practice Q1)
        textView =findViewById(R.id.text);
        textView.setText("Good Morning");

        // Practice 02)
        button=findViewById(R.id.button);
        n1=findViewById(R.id.n1);
        n2=findViewById(R.id.n2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sum=Integer.parseInt( n1.getText().toString())+Integer.parseInt(n2.getText().toString());
                textView.setText("The Sum is: "+sum);
            }
        });

        // Practice 03)
        button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int multiplication=Integer.parseInt(n1.getText().toString())*Integer.parseInt(n2.getText().toString());
                textView.setText("The Muliplication is: "+multiplication);
            }
        });
    }
}