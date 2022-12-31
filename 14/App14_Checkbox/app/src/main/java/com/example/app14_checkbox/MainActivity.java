package com.example.app14_checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> arrayList = new ArrayList<>();
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.result);
    }
    public void selectionitem(View view) {
        boolean check_chk = ((CheckBox)view).isChecked();
        switch (view.getId())
        {
            case R.id.kit:
                if(check_chk)
                {
                    arrayList.add("I like kitkat version");
                }
                else
                {
                    arrayList.remove("I like kitkat version");
                }
                break;
            case R.id.oreo:
                if(check_chk)
                {
                    arrayList.add("I like Oreo version");
                }
                else
                {
                    arrayList.remove("I like Oreo version");
                }
                break;
            case R.id.marsh:
                if(check_chk)
                {
                    arrayList.add("I like Marshmellow version");
                }
                else
                {
                    arrayList.remove("I like Marshmellow version");
                }
                break;
            case R.id.lolli:
                if(check_chk)
                {
                    arrayList.add("I like Lollipop version");
                }
                else
                {
                    arrayList.remove("I like Lollipop version");
                }
                break;
            case R.id.nou:
                if(check_chk)
                {
                    arrayList.add("I like Nouget version");
                }
                else
                {
                    arrayList.remove("I like Nouget version");
                }
                break;
        }

    }
    public void btnfinalclick(View view) {

        String f_s="";
        for ( String item:arrayList) {
         f_s = f_s+item+"\n";
        }
        textView.setText(f_s);
    }


}