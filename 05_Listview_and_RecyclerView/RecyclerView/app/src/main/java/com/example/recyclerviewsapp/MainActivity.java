package com.example.recyclerviewsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerviewsapp.R;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    String [] arr = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9","Item 10","Item 11", "Item 12", "Item 13", "Item 14", "Item 15", "Item 16", "Item 17", "Item 18", "Item 19"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        com.example.recyclerviewsapp.CustomAdapter c = new com.example.recyclerviewsapp.CustomAdapter(arr);
        recyclerView.setAdapter(c);
    }
}
// RecyclerView Docs
// -> https://developer.android.com/guide/topics/ui/layout/recyclerview?gclid=CjwKCAjw55-HBhAHEiwARMCszrdF_6HmaCLtaiif6QC-n-QJlyzx31h0DOV7nEEX9qCrvkazIeWJuhoCBYEQAvD_BwE&gclsrc=aw.ds