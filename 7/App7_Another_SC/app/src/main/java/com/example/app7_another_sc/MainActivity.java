package com.example.app7_another_sc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Animation t_anim,b_anim;
    ImageView img;
    TextView logo,slogan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

      t_anim = AnimationUtils.loadAnimation(MainActivity.this,R.anim.top_animation);
      b_anim = AnimationUtils.loadAnimation(MainActivity.this,R.anim.bottom_animation);

      //-----------------------------------findview by id
       img =findViewById(R.id.imageView);
       logo=findViewById(R.id.logotext);
       slogan=findViewById(R.id.slogantext);
       img.setAnimation(t_anim);
       logo.setAnimation(b_anim);
        slogan.setAnimation(b_anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(MainActivity.this,LoginPage.class);
                startActivity(intent);
            }
        },5000);

    }
}