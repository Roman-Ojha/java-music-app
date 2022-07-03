package com.codewithharry.Mplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // we also have to get the Storage permission from the use so we will going to access that as well
    // to give the user option to chose whether they want to give a permission or not
    // for that we will going to use Dexter Library
    // so we have to add it in the dependencies
    // search for the dexter android in browser
    /*
        and Include the library in your build.gradle
            dependencies{
                implementation 'com.karumi:dexter:6.2.3'
            }

            -> https://github.com/Karumi/Dexter
           -> so first go the the 'Gradle Scripts' and after that
           -> and then in 'buld.gradle(Module:iSangeet.app' we have to include the dependencies
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ListView listView;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        Dexter.withContext(this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        // if the permission is granted then this method will apply

                        ArrayList<File> mySongs = fetchSongs(Environment.getExternalStorageDirectory());
                        // here we are putting all the songs inside this array list
                        String [] items = new String[mySongs.size()];
                        // for showing the name of the song

                        for(int i=0;i<mySongs.size();i++){
                            items[i] = mySongs.get(i).getName().replace(".mp3", "");
                            // replacing '.mp3' with " "
                        }

                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, items);
                        listView.setAdapter(adapter);
                        // now this will show all the song that are available in the storage in the Listview

                        // now we have to implement when the user will select or click the item then perform some action
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent intent = new Intent(MainActivity.this, PlaySong.class);
                                //using Intent to pass the song to the another activity
                                String currentSong = listView.getItemAtPosition(position).toString();
                                intent.putExtra("songList", mySongs);
                                // sending array list
                                intent.putExtra("currentSong", currentSong);
                                // sending current playing song
                                intent.putExtra("position", position);
                                // and the position of the song
                                startActivity(intent);
                            }
                        });


                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                        // now after if user will deny the permission and we wan to again give the permission to the user then this has to be done
                    }
                })
                .check();
    }


    // Here this function will return the files arraylist
    public ArrayList<File> fetchSongs(File file){
            ArrayList arrayList = new ArrayList();
            // in this arraylist all the song available in the directory will come
            File [] songs = file.listFiles();
            // this will list all the file

        // implementing the reading files in recursive way
            if(songs !=null){
                // if the song is null
                for(File myFile: songs){
                    if(!myFile.isHidden() && myFile.isDirectory()){
                        // if it is directory or not hidden
                        arrayList.addAll(fetchSongs(myFile));
                        // fetching all the song from the file
                    }
                    else{
                        if(myFile.getName().endsWith(".mp3") && !myFile.getName().startsWith(".")){
                            // and here those file which ends with '.mp3' but not start with '.'
                            // means all the '.' file are those file which are used by the other application
                            arrayList.add(myFile);
                            // adding file to the array
                        }
                    }
                }
            }
            return arrayList;
    }
    // we also have to add:
    //  android.defaultConfig.vectorDrawables.useSupportLibrary = true
    // build.gradle

    // we also have to use
    // android:requestLegacyExternalStorage="true"
    // for access legacy storage

    // we can also include:
    // android:marqueeRepeatLimit="marquee_forever"
    // in xml to marquee the song title
}