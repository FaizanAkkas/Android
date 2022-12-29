package com.example.app6_movedata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DataMove extends AppCompatActivity {
TextView t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_move);
        t1=findViewById(R.id.output_to);
        t2=findViewById(R.id.output_from);
        t3=findViewById(R.id.output_message);


        //------------------------------ settext
        t1.setText(getIntent().getExtras().getString("key_to"));
        t2.setText(getIntent().getExtras().getString("key_from"));
        t3.setText(getIntent().getExtras().getString("key_msg"));
    }
}