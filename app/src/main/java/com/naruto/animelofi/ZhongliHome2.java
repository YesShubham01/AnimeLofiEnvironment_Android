package com.naruto.animelofi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.VideoView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ZhongliHome2 extends AppCompatActivity {
    MediaPlayer voiceline;
    MediaPlayer music;
    public void pause(View view) {
        music.pause();
    }
    public void play(View view) {
        music.start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhongli_home2);

        //Toast here V
        Toast.makeText(getBaseContext(),"This app is currently in Beta version, Kindly use only with HeadPhones.",Toast.LENGTH_LONG).show();
        // music here V
        music = MediaPlayer.create(getApplicationContext(), R.raw.zhonglithelisner);
        music.start();
        music.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });


        // voice lines here V
        callZhongli(true);
        Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                callZhongli(false);
                adjustmusic();
            }
        };

        t.schedule(tt,40000 , 40000);

        // background video here V
        final VideoView videoView = (VideoView) findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.zhongling);
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


    // a function to adjust bg music and voiceline
    public void adjustmusic() {
        if (voiceline.isPlaying()) {
            music.setVolume(0.5f,0.5f);
        }
        else {
            music.setVolume(1.0f,1.0f);
        }
    }

    // a function to call zhongli voice lines
    public void callZhongli ( boolean yn ) {
        if ( yn ) {
            playZhongliVoiceline(0);
        }
        else {
            final int random = new Random().nextInt(4);
            playZhongliVoiceline(random);
        }
    }

    // aa function to play random voice line , random number input --> from 0 to 3

    public void playZhongliVoiceline ( int counter) {

        if ( counter == 0 ) {
            voiceline = MediaPlayer.create(getApplicationContext(), R.raw.zhongli_name);
            voiceline.start();
            adjustmusic();
        }
        if ( counter == 1) {
            voiceline = MediaPlayer.create(getApplicationContext(), R.raw.zhongli_osmanthus);
            voiceline.start();
            adjustmusic();
        }
        if ( counter == 2) {
            voiceline = MediaPlayer.create(getApplicationContext(), R.raw.zhongli_final_day);
            voiceline.start();
            adjustmusic();
        }
        if ( counter == 3) {
            voiceline = MediaPlayer.create(getApplicationContext(), R.raw.zhongli_traveller);
            voiceline.start();
            adjustmusic();
        }


    }


}