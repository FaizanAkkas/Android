package com.example.app15_customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
String[] title= {"Youtube","Facebook","Instagram","Linkedin","Whatsapp","Twitter"};
    String[] des= {"Youtube Description","Facebook Description" ,"Instagram Description","Linkedin Description","Whatsapp Description","Twitter Description"};
    int[] images= {R.drawable.youtube,R.drawable.fb,R.drawable.insta,R.drawable.linked,R.drawable.whatsapp,R.drawable.twit};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lst);
         Custom_LV custom_lv = new Custom_LV(MainActivity.this,title,des,images);
         listView.setAdapter(custom_lv);

    }
}