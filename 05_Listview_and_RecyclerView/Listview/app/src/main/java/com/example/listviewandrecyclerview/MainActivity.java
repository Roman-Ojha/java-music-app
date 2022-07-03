package com.example.listviewandrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String arr[]={"This is","Item","Item2","Another Items","another","neu","mail3","Roman","mail4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);
        // to show the listView from the DataSource that we need as Adapter to Adapt the data and give to the Listview
        // here in this case we are using Array for the DataSource

        // Using Built in array adapter
//         ArrayAdapter ad=new ArrayAdapter(this, android.R.layout.simple_list_item_1,arr);
        // -> ArrayAdapter ad=new ArrayAdapter(<context(from_where)>, <which_layout_list>,<What_to_Show>);
        // here "android.R.layout.simple_list_item_1" this is the built in layout because we use android.
        // if we will use R. then those are our layout
        // listView.setAdapter(ad);
        // listener for built in ArrayAdapter Listview
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, "You Clicked on: "+position, Toast.LENGTH_SHORT).show();
//            }
//        });

        // Using Custom Adapter
        // now we have to make another layout in the folder res/layout
        RomanAdapter ad=new RomanAdapter(this,R.layout.my_roman_layout,arr);
        listView.setAdapter(ad);

        // Built in layout
        // -> https://developer.android.com/reference/android/R.layout
        // code of built in layout
        // -> https://github.com/aosp-mirror/platform_frameworks_base/tree/master/core/res/res/layout
    }
}