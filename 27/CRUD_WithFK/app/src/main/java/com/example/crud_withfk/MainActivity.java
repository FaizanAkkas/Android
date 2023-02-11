package com.example.crud_withfk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    db_helper mydb ;
    EditText d_name;
    Button btninsert,addemp;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new db_helper(this);
        d_name = findViewById(R.id.editText1);
        lv = findViewById(R.id.lst);
        btninsert= findViewById(R.id.btn_insert);
        addemp= findViewById(R.id.btn_addemp);
        View_DData();
        btninsert.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 boolean success = mydb.insertrecord(d_name.getText().toString());
                 if (success) {
                     Toast.makeText(MainActivity.this, "Record Inserted", Toast.LENGTH_SHORT).show();
                     View_DData();
                     d_name.setText("");
                 } else {
                     Toast.makeText(MainActivity.this, "Record Not Inserted", Toast.LENGTH_SHORT).show();
                 }
             }
         });
        addemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,EmployeeActivity.class);
                startActivity(intent);
            }
        });

    }
    public  void  View_DData()
    {
        ArrayList<HashMap<String, String>> userList = mydb.show_record();

        ListAdapter adapter = new SimpleAdapter(MainActivity.this,
                userList,
                R.layout.list_row,new String[]{"DId","DName"},
                new int[]{R.id.lst_id,R.id.lst_name});
        lv.setAdapter(adapter);


    }
}