package com.example.listviewandrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

// here we are extending from the 'ArrayAdapter'
public class RomanAdapter extends ArrayAdapter<String> {
    // here after taking the built in Adapter we are trying to make change in that adapter
    private String[] arr;
    private Context context;
    public RomanAdapter(@NonNull Context context, int resource, @NonNull String[] arr) {
        super(context, resource, arr);
        this.context=context;
        // here now in the constructor we are setting the array
        this.arr=arr;
    }

    // now we have to override the getItem and getView
    @Nullable
    @Override
    public String getItem(int position) {
        // here position will give us the position of the array data
        return arr[position];
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView=LayoutInflater.from(getContext()).inflate(R.layout.my_roman_layout,parent,false);
        // here from we are Inflating the layout that we made in the 'my_roman_layout'
        TextView t= convertView.findViewById(R.id.textView);
        // here we are getting the textview of the list where all the value will goes
        t.setText(getItem(position));
        // before returning the view, add Click Listener
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You Clicked on: "+position, Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
