package co.tara.tarabari.passenger.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import co.tara.tarabari.passenger.R;

/**
 * Created by jalalnia on 5/3/2017.
 */

public class SplashActivity extends Activity {
    private final int SPLASH_DISPLAY_LENGTH = 1000;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashActivity.this,FirstActivity.class);
                startActivity(intent);
                finish();

            }
        },SPLASH_DISPLAY_LENGTH );




    }
}
