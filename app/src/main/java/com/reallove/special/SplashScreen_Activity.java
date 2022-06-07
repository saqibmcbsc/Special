package com.reallove.special;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreen_Activity extends AppCompatActivity {

    TextView logo,sublogo;
    Animation top,bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        logo = findViewById(R.id.logo);
        sublogo = findViewById(R.id.sublogo);

        top = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.main_logo_animation);
        bottom = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sub_logo_animation);

        logo.setAnimation(top);
        sublogo.setAnimation(bottom);

      new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
              startActivity(new Intent(getApplicationContext(),Login_Activity.class));
              finish();

          }
      }, 2000);
    }
}