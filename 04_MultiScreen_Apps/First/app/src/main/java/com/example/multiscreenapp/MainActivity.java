package com.example.multiscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name;
    public static final String EXTRA_NAME="com.example.multiscreenapp.extra.NAME";
                                        // this string or name is the unique key of the intent
                                        // we don't want any other name to conflict with this name so we don't use other name
                                        // rather then we will use fully classified name
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
            # Intent:
                -> An activity is started with an Intent. An intent is a message from one activity to another activity. We can pass information from one activity to another using intents.
                -> Types of intents:
                    1) Implicit Intent: -> Target component not known
                    2) Explicit Intent: -> Target of the intent is known
                                        -> Fully classified Classname of a specific activity know.

                -> To create a new activity you have to go the the File/new/Activity
                -> after making another activity you have to go to the Manifest folder 'AndroidManifest.xml' to change
                -> we have to make a parentActivity for this new activity by inserting attribute inside the new Activity xml in 'AndroidManifest.xml' like:
                    -><activity android:name=".MainActivity2"
                        android:label="Second Activity"
                        android:parentActivityName=".MainActivity"
                        >
                    </activity>
                -> here we use 'label' as will where we put some value which is 'Second Activity' because of that now when we will go to the another activity we will see the name 'Second Activity' at the top (label)
                -> and because of 'parentActivityName' we can go back to the defined activity

         */

    }
    public void openActivity(View v){
        Toast.makeText(this, "Opening Second Activity", Toast.LENGTH_SHORT).show();
        // here now we are linking the two activity when the button is click then we want to go the the another activity
        Intent intent=new Intent(this,MainActivity2.class);
                // here 'this' means This activity
        name=findViewById(R.id.name);
        String nameText=name.getText().toString();
        // We can send data across activity using intent extras
        // Intent extras are key/value pairs in a Bundle
        intent.putExtra(EXTRA_NAME,nameText);
        // -> intent.putExtra(<key>,<value>);
        // now this data will go to the 'MainActivity2'
        startActivity(intent);
        // now this will start the activity
    }
    // if you want to know about intent filter
    // https://developer.android.com/guide/components/intents-filters#:~:text=An%20intent%20filter%20is%20an,a%20certain%20kind%20of%20intent.
}