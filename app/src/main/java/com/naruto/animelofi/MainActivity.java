package com.naruto.animelofi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GoToZhongliHome (View view) {

        Intent i = new Intent(this,ZhongliHome2.class);
        startActivity(i);
    }

    public void GoToKazuhaHome (View view) {

        Intent j = new Intent(this,KazuhaHome.class);
        startActivity(j);
    }

    public void showAbout(View v) {
        Toast.makeText(getBaseContext(),"This app is currently in Beta version.\nIt plays theme music of your Favourite Characters along with their randomly generated Voice lines.",Toast.LENGTH_LONG).show();
    }

    /*
    float x1 , x2 , y1 , y2;
    pubic boolean onTouchEvent(MotionEvent touchevent) {
        switch (touchevent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = touchevent.getX();
                y1 = touchevent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchevent.getX();
                y2 = touchevent.getY();
                Toast.makeText(this, "y1 is " + y1 + "and y2 is " + y2, Toast.LENGTH_SHORT).show();

                if ( x2>x1 && y1 < 1400.0f && y2 < 1400.0f) {

                    Intent i = new Intent(this, ZhongliHome2.class);
                    startActivity(i);
                }
                else if ( x2<x1 && y1 > 1400.0f && y2 > 1400.0f) {

                    Intent j = new Intent(this, KazuhaHome.class);
                    startActivity(j);
                }
                break;
        }
        return false;
    }
     */
}