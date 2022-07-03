package com.codewithharry.sharedprefsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

//        SharedPreferences sP = getSharedPreferences("MyPref", MODE_PRIVATE);
        // By using MODE_PRIVATE Other application can't be able to access the data of our application
        // 'MyPref' is the name of the file where the data will going to store

//        SharedPreferences.Editor ed= sP.edit();
        // now after doing this we will got he editor
        // using ed we can write the data in the file

//        ed.putString("name","Roman");
        // now here we are storing the data through editor

        // ed.commit()
        // commit is the old way of commit the data to the file through synchronously

//        ed.apply();
        // This is recommended because this is Asynchronous way


        SharedPreferences sP = getSharedPreferences("MyPref", MODE_PRIVATE);
        String editVal = sP.getString("name", "No value as of now");
        textView.setText(editVal);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = editText.getText().toString();
                SharedPreferences sP = getSharedPreferences("MyPref", MODE_PRIVATE);
                SharedPreferences.Editor ed = sP.edit();
                ed.putString("name", val);
                ed.apply();
                textView.setText(val);
                // here we are getting the data from the sharedPreferences file inside the phone
            }
        });

    }
}