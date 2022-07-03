package com.codewithharry.sqlitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHandler extends SQLiteOpenHelper {
    // here we are extending from the SQLiteOpenHelper Database
    // SQLiteOpenHelper is the baseclass
    public DbHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE myemployee (sno INTEGER PRIMARY KEY, name TEXT, increment TEXT)";
        // Here we are making a text type or to say Schema
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop = String.valueOf("DROP TABLE IF EXISTS");
        db.execSQL(drop, new String[]{"myemployee"});
        // here 'myemployee' is the name of the table
        onCreate(db);
        //creating database
    }

    public void addEmployee(Employee emp){
        SQLiteDatabase db = this.getWritableDatabase();
        // making a writable version of database
        ContentValues values = new ContentValues();
        values.put("name", emp.getName());
        // putting value to the database
        // .put(<key>,<value>)
        values.put("increment", emp.getIncrement());
        long k = db.insert("myemployee", null, values);
        Log.d("mytag", Long.toString(k));
        db.close();
    }

    public void getEmployee(int sno){
        SQLiteDatabase db = this.getReadableDatabase();
        // making the readable version of database to read data
        Cursor cursor = db.query("myemployee", new String[]{"sno", "name", "increment"},
                "sno=?", new String[]{String.valueOf(sno)}, null, null, null);
        if(cursor != null && cursor.moveToFirst()){
            Log.d("mytag name", cursor.getString(1));
            Log.d("mytag increment", cursor.getString(2));
        }
        else{
            Log.d("mytag", "Some error occurred");
        }
    }
}
