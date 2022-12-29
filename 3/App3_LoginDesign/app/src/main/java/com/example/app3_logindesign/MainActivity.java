package com.example.app3_logindesign;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText username,userpass;
    TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       username = findViewById(R.id.txtname);
       userpass=findViewById(R.id.txtpwd);
       output= findViewById(R.id.result);
    }

    public void btnlogin(View view) {
        String un = username.getText().toString();
        String password =userpass.getText().toString();
        if (un.equals("admin") && password.equals("aptech"))
        {
            output.setText("Valid result");
            output.setTextColor(Color.GREEN);
        }
        else
        {
            output.setText("Invalid result");
            output.setTextColor(Color.argb(255,255,0,0));
        }



    }
}