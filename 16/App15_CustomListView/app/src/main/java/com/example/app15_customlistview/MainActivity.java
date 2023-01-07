package com.example.app15_customlistview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
String[] title= {"Youtube","Facebook","Instagram","Linkedin","Whatsapp","Twitter"};
    String[] des= {"Youtube Description","Facebook Description" ,"Instagram Description","Linkedin Description","Whatsapp Description","Twitter Description"};
    int[] images= {R.drawable.twit,R.drawable.fb,R.drawable.insta,R.drawable.linked,R.drawable.whatsapp,R.drawable.twit};
    String[] s_owner = {"Susan Wojcicki","Mark Zuckerberg","Kevin Systrom","Ryan Roslansky","Will Cathcart","Elon Musk"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lst);
         Custom_LV custom_lv = new Custom_LV(MainActivity.this,title,des,images,s_owner);
         listView.setAdapter(custom_lv);
         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 if(i == 0)
                 {
                     AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                     alert.setTitle("Youtube");
                     alert.setIcon(R.drawable.youtube);
                     alert.setMessage("Since 2010");
                     alert.show();

                 }
                 else  if(i == 1)
                 {
                     AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                     alert.setTitle("Facebook");
                     alert.setIcon(R.drawable.fb);
                     alert.setMessage("Since 2007");
                     alert.show();


                 }
                 else  if(i == 2)
                 {
                     AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                     alert.setTitle("Instagram");
                     alert.setIcon(R.drawable.insta);
                     alert.setMessage("Since 2016");
                     alert.show();

                 }
             }
         });

    }
}