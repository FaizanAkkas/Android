package com.example.myapp23_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText_id,editText_un,editText_email,editText_bc;
    Button button_insert,button_view;
    DB_Helper db_helper;
    public  static  final  String DATABASE_NAME = "Info.db";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_id = findViewById(R.id.txt_id);
        editText_un = findViewById(R.id.txt_un);
        editText_email = findViewById(R.id.txt_email);
        editText_bc = findViewById(R.id.txt_batchcode);
        button_insert = findViewById(R.id.btn_insert);
        button_view = findViewById(R.id.btn_view);
        db_helper = new DB_Helper(MainActivity.this);

        Intent intent = getIntent();
        if (intent != null)
        {   editText_id.setText(intent.getStringExtra("Key_sid"));
            editText_un.setText(intent.getStringExtra("Key_sname"));
            editText_email.setText(intent.getStringExtra("Key_semail"));
            editText_bc.setText(intent.getStringExtra("Key_sbc"));
        }


        //------------------------------------------------insertion operation
        button_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              boolean check=  db_helper.Insert_Record(editText_un.getText().toString(),editText_email.getText().toString(),editText_bc.getText().toString());
            if(check)
            {
                Toast.makeText(MainActivity.this, "Record Inserted", Toast.LENGTH_SHORT).show();

            }
            else
            {
                Toast.makeText(MainActivity.this, "Record not Inserted", Toast.LENGTH_SHORT).show();

            }
            }
        });
        button_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShowActivity.class);
                startActivity(intent);
            }
        });
    }
}