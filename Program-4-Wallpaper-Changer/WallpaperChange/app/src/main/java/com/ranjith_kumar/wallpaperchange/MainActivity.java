package com.ranjith_kumar.wallpaperchange;


import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Timer myTimer;
    Button button;
    WallpaperManager wpm;
    Drawable drawable;
    int prev = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        myTimer = new Timer();
        wpm = WallpaperManager.getInstance(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWallpaper();
            }
        });
    }
    private void setWallpaper() {
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(prev == 1)
                {
                    drawable = getResources().getDrawable(R.drawable.one);
                    prev = 2;
                }
                else if(prev == 2)
                {
                    drawable = getResources().getDrawable(R.drawable.two);
                    prev = 3;
                }
                else if(prev == 3)
                {
                    drawable = getResources().getDrawable(R.drawable.three);
                    prev = 4;
                }
                else if(prev == 4)
                {
                    drawable = getResources().getDrawable(R.drawable.four);
                    prev = 5;
                }
                else if(prev == 5)
                {
                    drawable = getResources().getDrawable(R.drawable.five);
                    prev = 1;
                }
                Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
                try {
                    wpm.setBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        },0,30000);
    }
}