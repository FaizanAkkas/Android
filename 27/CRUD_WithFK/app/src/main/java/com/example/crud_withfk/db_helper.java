package com.example.crud_withfk;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class db_helper extends SQLiteOpenHelper {
    public static final String DATABAE_NAME = "Organization.db";
    //-----------------------------------------------------Table 1
    public static  final String TABLE_NAME1 = "DeptTable";
    public  static  final String D_1 = "D_Id";
    public  static  final String D_2 = "D_Name";
    //-----------------------------------------------------Table 2
    public static  final String TABLE_NAME2 = "EmpTable";
    public  static  final String E_1 = "E_Id";
    public  static  final String E_2 = "E_Name";
    public  static  final String E_3 = "E_Salary";
    public  static  final String E_4 = "D_Id_FK";


    public db_helper(@Nullable Context context) {
        super(context, DATABAE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //================TABLE 1 Department
        sqLiteDatabase.execSQL("create table " + TABLE_NAME1 + "(D_Id integer PRIMARY KEY AUTOINCREMENT,D_Name TEXT)");
        //================TABLE 2 Employee
        sqLiteDatabase.execSQL("create table EmpTable (E_Id integer PRIMARY KEY AUTOINCREMENT,E_Name TEXT,E_Salary TEXT,D_Id_FK integer, FOREIGN KEY (D_Id_FK) REFERENCES "+TABLE_NAME1+"("+D_1+"))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);
        onCreate(sqLiteDatabase);
    }
//----------------------------------------------------Department Insert
    public  boolean insertrecord(String dname )
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(D_2,dname);
        long success =sqLiteDatabase.insert(TABLE_NAME1,null,contentValues);
        if(success == -1)
        {
            return false;

        }
        else
        {
            return true;

        }
    }
    //========================================== view department data
    @SuppressLint("Range")
    public ArrayList<HashMap<String,String>> show_record(){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String,String>> userlist = new ArrayList<>();
        String query = "SELECT D_Id,D_Name FROM "+ TABLE_NAME1;
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext())
        {
            HashMap<String,String> user = new HashMap<>();
            user.put("DId",cursor.getString(cursor.getColumnIndex(D_1)));
            user.put("DName",cursor.getString(cursor.getColumnIndex(D_2)));


            userlist.add(user);
        }
        return  userlist;
    }

    //----------------------------------------------------------------------------------------Employee Insert
    public  boolean empinsert(String ename, String esal,String dif_fk)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(E_2,ename);
        contentValues.put(E_3,esal);
        contentValues.put(E_4,dif_fk);
        long success =sqLiteDatabase.insert(TABLE_NAME2,null,contentValues);
        if(success == -1)
        {
            return false;

        }
        else
        {
            return true;

        }
    }

    @SuppressLint("Range")
    public ArrayList<HashMap<String,String>> showEmp_record(){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String,String>> userlist = new ArrayList<>();
        String query = "SELECT E_Id,E_Name,E_Salary,D_Id_FK FROM "+ TABLE_NAME2;
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext())
        {
            HashMap<String,String> user = new HashMap<>();
            user.put("EId",cursor.getString(cursor.getColumnIndex(E_1)));
            user.put("EName",cursor.getString(cursor.getColumnIndex(E_2)));
            user.put("ESalary",cursor.getString(cursor.getColumnIndex(E_3)));
            user.put("EDept",cursor.getString(cursor.getColumnIndex(E_4)));

            userlist.add(user);
        }
        return  userlist;
    }

    public  ArrayList<String>  fillspinner()
    {


        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<String> data = new ArrayList<>();
        String query = "SELECT * FROM DeptTable";
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext())
        {
            String dname=cursor.getString(1);

            data.add(dname);

        }
       return  data;

    }
}
