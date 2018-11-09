package com.crmonline.appcrm;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

    }
    private void mostrarLogin() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashScreenActivity.this,
                        MainActivity.class);
                startActivity(intent);

            }
        }, 2000);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mostrarLogin();
    }
}