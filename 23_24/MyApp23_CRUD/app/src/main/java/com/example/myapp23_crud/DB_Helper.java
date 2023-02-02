package com.example.myapp23_crud;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.tv.TableRequest;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

import kotlin.Suppress;

public class DB_Helper extends SQLiteOpenHelper {
    public  static  final  String DATABASE_NAME = "Info.db";
    public  static  final  String TABLE_NAME = "Student_Table";
    public  static  final  String Col_1 = "Std_ID";
    public  static  final  String Col_2 = "Std_Name";
    public  static  final  String Col_3 = "Std_Email";
    public  static  final  String Col_4 = "Std_BatchCode";
    public DB_Helper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + " (Std_ID INTEGER PRIMARY KEY AUTOINCREMENT,Std_Name TEXT,Std_Email TEXT,Std_BatchCode TEXT ) ");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop Table IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public  boolean Insert_Record(String name,String email,String bc)
    {
        SQLiteDatabase sql_obj = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Std_Name",name);
        cv.put(Col_3,email);
        cv.put(Col_4,bc);
       long success= sql_obj.insert(TABLE_NAME,null,cv);
        if(success == -1)
        {
            return  false;
        }
        else
        {
            return true;
        }
    }
    //-------------------------------------------------------
    @SuppressLint("Range")
    public ArrayList<HashMap<String,String>> Get_Record()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String,String>> userlist = new ArrayList<>();
        String query = "Select Std_ID,Std_Name,Std_Email,Std_BatchCode FROM "+TABLE_NAME;
        Cursor cursor =db.rawQuery(query,null);
        while (cursor.moveToNext())
        {
            HashMap<String,String> user = new HashMap<>();
            user.put("id_std",cursor.getString(cursor.getColumnIndex(Col_1)));
            user.put("name_std",cursor.getString(cursor.getColumnIndex(Col_2)));
            user.put("email_std",cursor.getString(cursor.getColumnIndex(Col_3)));
            user.put("bc_std",cursor.getString(cursor.getColumnIndex(Col_4)));
            userlist.add(user);

        }
        return  userlist;
    }

}
