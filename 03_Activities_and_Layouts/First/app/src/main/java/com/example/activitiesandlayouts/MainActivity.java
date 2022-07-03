package com.example.activitiesandlayouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
            -> Activity is just the page of screen that we see the the phone
            -> Activity has Layouts
            -> Layouts defines How view will seen in the screen
            -> If you go to the palette, you will find a lot of layouts We can use any of these (LinearLayout,ConstraintLayout etc)
         */

        /*
            # LinearLayout(horizontal)
                -> Height,width: wrap content= wrap content meant adjust automatically according to the view(content)
                -> dp is density independent pixel
         */
        // we can store String to use it for the project and add it the the project by going to the res/Values/strings.xml
        // here in this project we use it in the  XML:
        // android:contentDescription="@string/joker"
        // android:text="@string/spiderMan"
        // after storing these colors and string in the 'colors.xml' and 'strings.xml' you can change to whole project where you use these value

        // -> you can search for the 'android launcher icon generator' to use launcher icon
        // -> and after you made the launcher icon and download the file then you can put those file in:
        // -> app/res and replace those file with the existing file
        // -> you can download ic_launcher and ic_launcher_round file and then replace it
    }
}