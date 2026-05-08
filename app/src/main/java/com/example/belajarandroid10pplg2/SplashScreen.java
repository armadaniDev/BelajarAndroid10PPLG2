package com.example.belajarandroid10pplg2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);

        logo = findViewById(R.id.logoSplash);

        Animation fade = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        logo.startAnimation(fade);

        sharedPreferences = getSharedPreferences("Datauser", MODE_PRIVATE);
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            String username = sharedPreferences.getString("username", "");

            if (!username.isEmpty()) {
                // sudah login
                startActivity(new Intent(SplashScreen.this, ListGame.class));
            } else {
                // belum login
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
            }
            finish();
        }, 2500);
    }
}