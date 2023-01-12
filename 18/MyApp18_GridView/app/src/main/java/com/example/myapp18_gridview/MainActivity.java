package com.example.myapp18_gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    int[] assets = {

            R.drawable.ic_baseline_insert_emoticon_24,
            R.drawable.ic_baseline_laptop_24,
            R.drawable.ic_baseline_laptop_chromebook_24,
            R.drawable.ic_baseline_laptop_windows_24,
            R.drawable.ic_baseline_headphones_24,
            R.drawable.ic_baseline_insert_emoticon_24,
            R.drawable.ic_baseline_laptop_24,
            R.drawable.ic_baseline_laptop_chromebook_24
    };
    String[] titles = {"Emoji Icon","Laptop","Chromebook","Windows","Headphones","Emoji Icon","Laptop","Chromebook"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gv);
        GV_Custom gv_custom = new GV_Custom(MainActivity.this,assets,titles);
        gridView.setAdapter(gv_custom);
    }
}