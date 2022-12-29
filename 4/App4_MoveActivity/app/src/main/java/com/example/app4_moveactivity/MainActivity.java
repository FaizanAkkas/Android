package com.example.app4_moveactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.textname);
        password = findViewById(R.id.textpassword);
    }

    public void btnlogin(View view) {
     String un =  username.getText().toString();
     String pass = password.getText().toString();
     if(un.equals("admin") && pass.equals("admin"))
     {
       //  Toast.makeText(getApplicationContext(),"Valid Login",Toast.LENGTH_LONG).show();
         Intent intent = new Intent(MainActivity.this,WelcomeActivity.class);
         startActivity(intent);
     }
    else
     {
         Toast.makeText(this, "Invalid Login", Toast.LENGTH_LONG).show();

     }
    }
}