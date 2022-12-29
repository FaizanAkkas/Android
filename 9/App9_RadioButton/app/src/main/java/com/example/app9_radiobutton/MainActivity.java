package com.example.app9_radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView output;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
       output= findViewById(R.id.result);
       imageView = findViewById(R.id.img);
    }

    public void selectcountry(View view) {

     boolean radio =((RadioButton)view).isChecked();
       switch (view.getId()) //4
       {
           case R.id.pak:
               if(radio)
               {
                   output.setText("The selct country is Pakistan");
                   output.setBackgroundColor(Color.GREEN);
                   imageView.setBackgroundResource(R.drawable.pak);
                  // Toast.makeText(this, "Pakistan", Toast.LENGTH_SHORT).show();
               }
               else
               {

               }
               break;

           case R.id.sri:
               if(radio)
               {
                   output.setText("The selct country is Srilanka");
                   output.setBackgroundColor(Color.BLUE);
                   imageView.setBackgroundResource(R.drawable.sri);
                   //Toast.makeText(this, "Srilanka", Toast.LENGTH_SHORT).show();
               }
               else
               {

               }
               break;
           case R.id.ind:
               if(radio)
               {
                   output.setText("The selct country is India");
                   output.setBackgroundColor(Color.argb(255,255,165,0));
                   imageView.setBackgroundResource(R.drawable.india);
                   //Toast.makeText(this, "India", Toast.LENGTH_SHORT).show();
               }
               else
               {

               }
               break;
           case R.id.ger:
               if(radio)
               {
                   output.setText("The selct country is Germany");
                   output.setBackgroundColor(Color.RED);
                   imageView.setBackgroundResource(R.drawable.germany);
                   //Toast.makeText(this, "Germany", Toast.LENGTH_SHORT).show();
               }
               else
               {

               }
               break;
           default:
               Toast.makeText(this, "No Nationality", Toast.LENGTH_SHORT).show();
               break;
       }

    }
}