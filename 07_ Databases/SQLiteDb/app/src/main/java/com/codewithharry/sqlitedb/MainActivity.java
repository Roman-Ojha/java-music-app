package com.codewithharry.sqlitedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DbHandler handler = new DbHandler(this, "empdb", null, 1);
        // 'empdb' is the database name
        // after this it will call the constructor of hte DbHandler class

//        handler.addEmployee(new Employee(10, "Roman", 33.3));
        handler.getEmployee(3);
        handler.close();


            // You can use RoomDatabase for android as well
        // Search for the documentation
    }
}