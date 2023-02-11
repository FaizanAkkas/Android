package com.example.crud_withfk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class EmployeeActivity extends AppCompatActivity {
    db_helper mydb ;
    EditText e_name,e_salary;
    Spinner spinner;
    Button btninsert;
    ListView elv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        mydb = new db_helper(this);

        e_name = findViewById(R.id.editText1);
        e_salary = findViewById(R.id.editText2);
        spinner = findViewById(R.id.spin);
        elv = findViewById(R.id.elst);
      ArrayList<String> data =   mydb.fillspinner();
        ArrayAdapter arrayAdapter = new ArrayAdapter(EmployeeActivity.this,R.layout.support_simple_spinner_dropdown_item,data);
        spinner.setAdapter(arrayAdapter);

         btninsert = findViewById(R.id.btn_insert);
        View_EData();
         btninsert.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 boolean success = mydb.empinsert(e_name.getText().toString(),e_salary.getText().toString(), spinner.getSelectedItem().toString());
                 if (success) {
                     Toast.makeText(EmployeeActivity.this, "Record Inserted", Toast.LENGTH_SHORT).show();
                     View_EData();
                     e_name.setText("");
                     e_salary.setText("");
                 } else {
                     Toast.makeText(EmployeeActivity.this, "Record Not Inserted", Toast.LENGTH_SHORT).show();
                 }
             }
         });
    }
    public  void  View_EData()
    {
        ArrayList<HashMap<String, String>> userList = mydb.showEmp_record();

        ListAdapter adapter = new SimpleAdapter(EmployeeActivity.this,
                userList,
                R.layout.e_list_row,new String[]{"EId","EName","ESalary","EDept"},
                new int[]{R.id.lst_eid,R.id.lst_ename,R.id.lst_esal,R.id.lst_edept});
        elv.setAdapter(adapter);


    }








}