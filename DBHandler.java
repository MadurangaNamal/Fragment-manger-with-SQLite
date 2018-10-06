package com.example.user.app15;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 8/20/2018.
 */

public class DBHandler extends SQLiteOpenHelper{
    public DBHandler(Context context) {
        super(context,"STUDENTDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE STUDENTS "+"(SID INTEGER PRIMARY KEY,NAME TEXT,AGE INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS STUDENTS");
        onCreate(db);

    }

    public void  addStudent(Student student){

        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("SID",student.getSid());
        values.put("NAME",student.getName());
        values.put("AGE",student.getAge());

        db.insert("STUDENTS",null,values);

    }

    public List<Student> getAllStudents(){

        ArrayList<Student> list = new ArrayList<>();
        SQLiteDatabase db=this.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM STUDENTS",null);

        if(c.moveToFirst()){
            do{
                Student s = new Student(Integer.parseInt(c.getString(0)), c.getString(1), Integer.parseInt(c.getString(2)));
                list.add(s);
            }
            while(c.moveToNext());
        }
        return list;
    }
    public int updateStudents(Student student){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NAME", student.getName());
        values.put("AGE", student.getAge());

        return db.update("STUDENTS", values, "SID = ?",
                new String[]{String.valueOf(student.getSid())});
    }

    public void deleteStudents(int sid){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("STUDENTS", "SID = ?",
                new String[]{String.valueOf(sid)});
    }
}
