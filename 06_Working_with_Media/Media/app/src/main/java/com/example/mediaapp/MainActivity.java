package com.example.mediaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button play;
    private Button pause;
    private SeekBar seekBar;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play=findViewById(R.id.play);
        pause=findViewById(R.id.pause);
        seekBar=findViewById(R.id.seekBar);
        // MediaPlayer using local source -----------------------------------------------------
//        mediaPlayer=MediaPlayer.create(this,R.raw.on);
//        // here we are setting the Max value of seekBar the exact length of the music
//        seekBar.setMax(mediaPlayer.getDuration());
//        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                if(fromUser){
//                    // here when the user is playing with the seekBar only at that time we want to fire this function
//                    mediaPlayer.seekTo(progress);
//                }
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
//        play.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // when we will going to click the play button then it will going to start playing music
//                mediaPlayer.start();
//            }
//        });
//        pause.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mediaPlayer.pause();
//            }
//        });



            // ===================================================================================================================================
        // MediaPlayer using Remote source ----------------------------------------------
        // you can also be able to play the music form url:
            // search 'Index of Sound Fx or music'
        mediaPlayer = new MediaPlayer();
        try {
            // you also need to require a permission of the internet so you have put permission int the 'AndroidManifest.xml' like:
            // ->  <uses-permission android:name="android.permission.Internet"/>
            // if you want to allow the data from the http, insecure site then you also have to use this in the 'AndroidManifest.xml'
            // -> android:usesCleartextTraffic="true"
            //
            mediaPlayer.setDataSource("https://paglasongs.com/files/download/id/2094");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // to prepared for the media player
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Toast.makeText(MainActivity.this, "Ready to Play", Toast.LENGTH_SHORT).show();
                mp.start();
                // here we are setting the Max value of seekBar the exact length of the music
                seekBar.setMax(mediaPlayer.getDuration());
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if(fromUser){
                            // here when the user is playing with the seekBar only at that time we want to fire this function
                            mediaPlayer.seekTo(progress);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

            }
        });
        // Here Run mediaPlayer.prepareAsync() method to start preparing the mediaPlayer.
        mediaPlayer.prepareAsync();
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // when we will going to click the play button then it will going to start playing music
                mediaPlayer.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });
            // ======================================================================================================================================================

    }
    // to use the media in the android studio we have to put the music in the path:
        //-> first we have to create a new folder in res
        // -> new/Android Resource Directory

    // if you want to add the font in the android studio then you have to download the font first and after that you have to put the file in the path:
    // first you have to make a new res directory and name of directory is 'font' and type also 'font'
    // Now you can chose font-family

}

// MediaPlayer Docs
// -> https://developer.android.com/reference/android/media/MediaPlayer