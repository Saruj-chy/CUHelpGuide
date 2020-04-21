package com.sd.saruj.cuhelpguide.SplashActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.sd.saruj.cuhelpguide.MainActivity;
import com.sd.saruj.cuhelpguide.R;

public class SplashScreenActivity extends AppCompatActivity {

    ProgressBar splashProgress;
    //int SPLASH_TIME = 5000; //This is 3 seconds
    int SPLASH_TIME = 500; //This is 3 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //This is additional feature, used to run a progress bar
        splashProgress = findViewById(R.id.splashProgress);
        playProgress();

        //Code to start timer and take action after the timer ends
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do any action here. Now we are moving to next page
                Intent mySuperIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mySuperIntent);

                //This 'finish()' is for exiting the app when back button pressed from Home page which is ActivityHome
                finish();

            }
        }, SPLASH_TIME);
    }

    //Method to run progress bar for 5 seconds
    private void playProgress() {
        ObjectAnimator.ofInt(splashProgress, "progress", 100)
                //.setDuration(5000)
                .setDuration(500)
                .start();
    }
}