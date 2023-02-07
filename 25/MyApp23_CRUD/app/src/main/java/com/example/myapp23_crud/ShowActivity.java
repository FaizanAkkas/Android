package com.example.myapp23_crud;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

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

        ViewData();
       listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
               AlertDialog.Builder alert= new AlertDialog.Builder(ShowActivity.this);
               alert.setTitle("Choose Any Action");
               alert.setMessage("Do you want to Update/Delete?");
               //--------------------------------------------------------------Update
               alert.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {

                       Intent intent = new Intent(ShowActivity.this,MainActivity.class);
                       intent.putExtra("Key_sid",((TextView) view.findViewById(R.id.output_id)).getText().toString());
                       intent.putExtra("Key_sname",((TextView) view.findViewById(R.id.output_name)).getText().toString());
                       intent.putExtra("Key_semail",((TextView) view.findViewById(R.id.output_email)).getText().toString());
                       intent.putExtra("Key_sbc",((TextView) view.findViewById(R.id.output_bc)).getText().toString());
                       startActivity(intent);
                       Toast.makeText(ShowActivity.this, "Update record", Toast.LENGTH_SHORT).show();
                   }
               });
               //--------------------------------------------------------------Delete
               alert.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                     //String studentid= ((TextView) view.findViewById(R.id.output_id)).getText().toString();
                       int stdid=Integer.parseInt (((TextView) view.findViewById(R.id.output_id)).getText().toString());
                       db_helper.Delete_Record(stdid);
                       ViewData();
                       Toast.makeText(ShowActivity.this, "Record Deleted", Toast.LENGTH_SHORT).show();
                   }
               });
               alert.show();
               return true;
           }
       });
    }
    public  void  ViewData()
    {
        ArrayList<HashMap<String,String>>  userlist= db_helper.Get_Record();
        ListAdapter adapter =  new SimpleAdapter(this,userlist,R.layout.row_list,
                new String[]{"id_std","name_std","email_std","bc_std"},
                new int[] {R.id.output_id,R.id.output_name,R.id.output_email,R.id.output_bc});
        listView.setAdapter(adapter);
    }
}