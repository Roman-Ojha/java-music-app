package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button openURL;
    private EditText url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openURL=findViewById(R.id.openURL);
        url=findViewById(R.id.url);
        openURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urlText=url.getText().toString();
                Toast.makeText(MainActivity.this, urlText, Toast.LENGTH_SHORT).show();
                // Implicit : Intent to open a webpage
                Uri webpage =Uri.parse(urlText);
                Intent intent=new Intent(Intent.ACTION_VIEW,webpage);
                if(intent.resolveActivity(getPackageManager())!=null){
                    startActivity(intent);
                    // now after that we get to the the input url
                }
                else
                {
                    // cant handle the intent
                }
                // we can find this kind of intent in the documentation
                // -> https://developer.android.com/guide/components/intents-common


            }
        });

    }
    public void openSecondActivity(View view){
//        Intent intent =new Intent(this,MainActivity2.class);
//        startActivity(intent);

        // Implicit: Intent to open an email sending app
        String []addresses={"razzroman99@gmail.com","razzroman98@gmail.com"};
        String urlText=url.getText().toString();
        Intent  intent = new Intent(Intent.ACTION_SEND);
          intent.setType("*/*");
            intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Roman subject");
        intent.putExtra(Intent.EXTRA_TEXT, urlText);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        else
        {
            // can't handle the intent
        }
    }
}