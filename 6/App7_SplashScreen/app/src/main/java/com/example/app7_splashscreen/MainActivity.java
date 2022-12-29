package com.example.app7_splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
            Thread time = new Thread()
            {
                @Override
                public void run() {
                    try {
                        sleep(10000); //5 sec
                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
                        Toast.makeText(MainActivity.this, "Error Invoke", Toast.LENGTH_SHORT).show();
                    }
                    finally {
                        Intent intent = new Intent(MainActivity.this,Login.class);
                        startActivity(intent);
                    }
                }
            };
            time.start();
    }
}