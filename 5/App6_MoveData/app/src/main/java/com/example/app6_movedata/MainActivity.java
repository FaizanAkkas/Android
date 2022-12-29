package com.example.app6_movedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edit_to,edit_from,edit_message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_to = findViewById(R.id.txt_to);
        edit_from = findViewById(R.id.txt_from);
        edit_message = findViewById(R.id.txt_msg);
    }

    public void btnsubmit(View view) {
        Intent intent = new Intent(MainActivity.this,DataMove.class);
        intent.putExtra("key_to",edit_to.getText().toString());
        intent.putExtra("key_from",edit_from.getText().toString());
        intent.putExtra("key_msg",edit_message.getText().toString());
startActivity(intent);


    }
}