package com.foodApp.stopwastingfood;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    //Define Columns Names and TableName AFTER DataBase Creation

    private  static final String DBNAME = "DatabaseHelper";
    private  static final String TABLE_NAME  = "UsersTable";
    private  static final String DBVERSION  = "1";
    //Columns Names
    private  static final String KEY_ID = "ID";
    private  static final String KEY_NAME = "Name";
    private  static final String KEY_EMAIL = "Email";
    private  static final String KEY_PASSWORD = "Password";

    private static final String CREATE_USER_TABLE="CREATE TABLE " + TABLE_NAME  + "("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_NAME +"TEXT,"
            + KEY_EMAIL +"TEXT UNIQUE,"
            +KEY_PASSWORD +"TEXT" +");";

    public DatabaseHelper(Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" drop table if exists UserTable");
        onCreate(db);
    }
    public boolean addData(User user){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValue=new ContentValues();
        contentValue.put(KEY_NAME, user.getUserName());
        contentValue.put(KEY_EMAIL, user.getUserEmail());
        contentValue.put(KEY_PASSWORD, user.getUserPassword());
        long result = db.insert(TABLE_NAME, null, contentValue);
        //As if data inserted incorrectly it will return -1/false
        if (result == 1)

            return true;

        else

            return false;
    }
    //Return all data from database
    public Cursor getData(String email){
        SQLiteDatabase db=this.getReadableDatabase();
        String selectQuery= "select * from " +TABLE_NAME  ;
        Cursor data= db.rawQuery(selectQuery, null);
        //db.close();
        Log.d(DBNAME, "Fetching user from Sqlite: " + data.toString());

        return data;
    }
}
