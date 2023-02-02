package com.example.myapp23_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ShowActivity extends AppCompatActivity {
 ListView listView;
 DB_Helper db_helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        listView = findViewById(R.id.lst);
        db_helper = new DB_Helper(ShowActivity.this); // db_helper class constructor call here

       ArrayList<HashMap<String,String>>  userlist= db_helper.Get_Record();
        ListAdapter adapter =  new SimpleAdapter(this,userlist,R.layout.row_list,
                                                 new String[]{"id_std","name_std","email_std","bc_std"},
                                                new int[] {R.id.output_id,R.id.output_name,R.id.output_email,R.id.output_bc});
       listView.setAdapter(adapter);
    }
}