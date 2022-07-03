package com.example.unitconveterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
// here we are importing Button Widget
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    // here we are making a variable to get access to the of the method and the property
    private TextView textView;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button =findViewById(R.id.button);
        //  here we are selecting the button by id 'button'
        textView =findViewById(R.id.textView3);
        // and here we are selecting the textView by id 'textview'
        editText=findViewById(R.id.editText);

        // Now adding event listener to listen when the button will click
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hi Click Listener Worked", Toast.LENGTH_SHORT).show();
                // here Toast is the kind of the alert that we use to do in web dev
                String s =  editText.getText().toString();
                // here we are getting the value from the 'editText' id and converting into String
                int kg = Integer.parseInt(s);
                // here we are converting to parse of that String
                double pound= kg*2.20462;
                // here we are converting Kg to pound

                textView.setText("The cooresponding value in Pounds is: "+ pound);

            }

        });


        // now we are importing the image so to put the image in the project file you can put in inside the res/drawable
        // if you want to see the color that is used by app then you can go to res/values/colors.xml
        // you can find the apk file of the project inside the app\build\outputs\apk\debug
    }
    // we can use onClick attribute as well to add the event
    public void calculate(View view){
        String s =  editText.getText().toString();
        int kg = Integer.parseInt(s);
        double pound= kg*2.20462;
        textView.setText("The cooresponding value in Pounds is: "+ pound);
        Toast.makeText(this, "Thanks for using this app", Toast.LENGTH_SHORT).show();

    }

    // if you want to sue You Phone to use app the :
        // -> the you have to enable the use Debugging
        // -> and you can configure the "select USB Configuration' to PPT

}