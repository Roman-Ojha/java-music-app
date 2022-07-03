package com.codewithharry.Mplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PlaySong extends AppCompatActivity {

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
        updateSeek.interrupt();
    }


    int position;
    int iconRotate;
    boolean rotatePlay=true;
    TextView textView,totalTime,completeTime;
    ImageView play, previous, next,musicIconPlay;
    ArrayList<File> songs;
    MediaPlayer mediaPlayer;
    String textContent;
    SeekBar seekBar;
    Thread updateSeek;



    // this will update the seekbar
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);
        textView = findViewById(R.id.textView);
        play = findViewById(R.id.play);
        previous = findViewById(R.id.previous);
        next = findViewById(R.id.next);
        seekBar = findViewById(R.id.seekBar);
        musicIconPlay=findViewById(R.id.imageView2);
        totalTime=findViewById(R.id.totalTime);
        completeTime=findViewById(R.id.completeTime);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        // here we are getting the object
        songs = (ArrayList) bundle.getParcelableArrayList("songList");
        // typecasting to (ArrayList)
        textContent = intent.getStringExtra("currentSong");
        textView.setText(textContent);
        textView.setSelected(true);
        position = intent.getIntExtra("position", 0);
        Uri uri = Uri.parse(songs.get(position).toString());
        mediaPlayer = MediaPlayer.create(this, uri);
        mediaPlayer.start();
        seekBar.setMax(mediaPlayer.getDuration());
        float totalduration=(float)mediaPlayer.getDuration()/1000/60;
        float getSecond=((totalduration-(int)totalduration)*100);
        totalTime.setText((int)totalduration+":"+(int)getSecond);
        completeTime.setText(mediaPlayer.getCurrentPosition()+":"+mediaPlayer.getCurrentPosition());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });



        updateSeek = new Thread(){
            @Override
            public void run() {
                int currentPosition = 0;
                int sleepMs=50;
                try{
                     iconRotate=0;
                    while(currentPosition<mediaPlayer.getDuration()){
                        currentPosition = mediaPlayer.getCurrentPosition();
                        seekBar.setProgress(currentPosition);
                        if(rotatePlay)
                        {
                            if(iconRotate<=360)
                            {
                                musicIconPlay.setRotation(iconRotate++);
                            }
                            else {
                                musicIconPlay.setRotation(0);
                                iconRotate = 0;
                            }
                        }
                        else{
                            musicIconPlay.setRotation(iconRotate);
                        }

                        sleep(sleepMs);
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        updateSeek.start();

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    play.setImageResource(R.drawable.play);
                    mediaPlayer.pause();
                    rotatePlay=false;
                }
                else{
                    play.setImageResource(R.drawable.pause);
                    mediaPlayer.start();
                    rotatePlay=true;
                }

            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer.release();
                if(position!=0){
                    position = position - 1;
                }
                else{
                    position = songs.size() - 1;
                }
                // start the song again according to the position
                Uri uri = Uri.parse(songs.get(position).toString());
                mediaPlayer = MediaPlayer.create(getApplicationContext(), uri);
                mediaPlayer.start();
                play.setImageResource(R.drawable.pause);
                seekBar.setMax(mediaPlayer.getDuration());
                textContent = songs.get(position).getName().toString();
                textView.setText(textContent);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer.release();
                if(position!=songs.size()-1){
                    position = position + 1;
                }
                else{
                    position = 0;
                }
                // start the song again according to the position
                Uri uri = Uri.parse(songs.get(position).toString());
                mediaPlayer = MediaPlayer.create(getApplicationContext(), uri);
                mediaPlayer.start();
                play.setImageResource(R.drawable.pause);
                seekBar.setMax(mediaPlayer.getDuration());
                textContent = songs.get(position).getName().toString();
                textView.setText(textContent);
            }
        });








    }
}