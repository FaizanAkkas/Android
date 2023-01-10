package com.example.myapp16_cardview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CV_Page2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv_page2);
    }

    public void btnburger(View view) {
        Toast.makeText(this, "550 Rs", Toast.LENGTH_SHORT).show();
    }
}