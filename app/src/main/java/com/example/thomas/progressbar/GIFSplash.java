package com.example.thomas.progressbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class GIFSplash extends AppCompatActivity {

    @Override // Following code snippets took inspiration from an EDMT Dev YouTube Tutorial, "Android Studio Tutorial - GIF Splash Screen"
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gifsplash);
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(5000); // Divide by 1000 to get the number of seconds, in this case 5000 is 5 seconds introductory splash screen
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(GIFSplash.this, ProgressBars.class); // Shows that the GIF activity is the launcher activity and then starts the Progress Bars activity upon the completion of the indent timer
                    startActivity(intent); // Launches activity
                }
            }
        };
        timer.start();
    }


    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }
}


