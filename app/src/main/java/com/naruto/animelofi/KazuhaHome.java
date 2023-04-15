package com.naruto.animelofi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import android.widget.VideoView;

import java.time.Clock;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class KazuhaHome extends AppCompatActivity {

    MediaPlayer music;
    MediaPlayer voiceline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kazuha_home);

        Toast.makeText(getBaseContext(),"This app is currently in Beta version, Kindly use only with HeadPhones.",Toast.LENGTH_LONG).show();

        // theme music
        music = MediaPlayer.create(getApplicationContext(), R.raw.kazuhamusic);
        music.start();
        music.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });

        //voiceline
        callKazuha(true);
        Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
               callKazuha(false);
            }
        };

        t.schedule(tt,50000 , 50000);

        //background video
        final VideoView videoView = (VideoView) findViewById(R.id.videoView2);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.kazuhavideo);
        videoView.start();



        videoView.setOnPreparedListener (new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
    }



    @Override
    public void onBackPressed() {


        super.onBackPressed();
        music.release();
        voiceline.release();
        finish();


    }


    // a function to generate random number and call kazuha voice lines
    public void callKazuha ( boolean yn ) {
        if ( yn ) {
            playKazuhaVoiceline(0);
        }
        else {
            final int random = new Random().nextInt(3);
            playKazuhaVoiceline(random);
        }
    }


    // aa function to play random voice line , random number input --> from 0 to 3
    public void playKazuhaVoiceline ( int counter) {

        if ( counter == 0 ) {
            voiceline = MediaPlayer.create(getApplicationContext(), R.raw.hello_kazuha);
            voiceline.start();
        }
        if ( counter == 1) {
            voiceline = MediaPlayer.create(getApplicationContext(), R.raw.kazuha_home);
            voiceline.start();
        }
        if ( counter == 2) {
            voiceline = MediaPlayer.create(getApplicationContext(), R.raw.kazuha_mapleleaves);
            voiceline.start();
        }


    }


}