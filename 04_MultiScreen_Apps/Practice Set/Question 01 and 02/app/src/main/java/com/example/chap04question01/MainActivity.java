package com.example.chap04question01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String[] question ={"Java is a person?","Java was introduced in 1233?","Java was created using Python?","Java has abstract Classes","Java supports interface?","Java was created by code with harry in india?"};
    private boolean[]answers={false,false,false,true,true,false};
    private int index=0;
    private int score=0;
    Button yes;
    Button no;
    TextView viewQuestion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes=findViewById(R.id.button);
        no=findViewById(R.id.button2);
        viewQuestion=findViewById(R.id.question);
        viewQuestion.setText(question[index]);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if the array is not going out of bounds
                if(index<=question.length-1){
                    // If you have given correct answer
                    if(answers[index]==true){
                        score++;
                    }
                    // go to the next question
                    index++;
                    if(index<=question.length-1){
                        viewQuestion.setText(question[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Your Score:"+score+"/"+question.length , Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Restart to play again", Toast.LENGTH_SHORT).show();
                }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if the array is not going out of bounds
                if(index<=question.length-1){
                    // If you have given correct answer
                    if(answers[index]==false){
                        score++;
                    }
                    index++;
                    if(index<=question.length-1){
                        viewQuestion.setText(question[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Your Score:"+score+"/"+question.length , Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Restart to play again", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}