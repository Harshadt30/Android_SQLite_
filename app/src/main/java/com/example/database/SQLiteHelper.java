package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SQLiteHelper extends SQLiteOpenHelper {

//    Defining table and columns
    public static final String TABLE_NAME = "user";
    public static final String id = "id";
    public static final String name = "name";
    public static final String password = "password";

    static final String DB_NAME = "demo";
    static final int DB_VERSION = 1;

    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME + "(" + id + " INTEGER PRIMARY KEY AUTOINCREMENT , " + name + " VARCHAR, " + password + " VARCHAR)";


    public SQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

//        Creating table
        db.execSQL(CREATE_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

//        Drop table if exists
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

//    Adding User into database
    public boolean addUser(UserInfo userInfo) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues userVal = new ContentValues();
        userVal.put(name, userInfo.getName());
        userVal.put(password, userInfo.getPassword());

        if(db.insert(TABLE_NAME, null ,userVal) == -1) {

            db.close();
            return false;
        }
        else {

            db.close();
            return true;
        }
    }

//    Select one row from database where id = userId
    public Cursor userRow(int userId) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM "+ TABLE_NAME + " WHERE id = "+userId, null);
        return cursor;
    }

//        delete one row from database where id = userId
    public boolean userDelete(int userId) {

        SQLiteDatabase db = this.getWritableDatabase();
        if( db.delete(TABLE_NAME, " id = "+userId, null) == 1 ) {

            return true;
        }
        else {
            return false;
        }
    }
//        Update one row from database where id = userId
    public boolean userUpdate(int userId, String userName, String userPassword) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues userUpdateVal = new ContentValues();
        userUpdateVal.put("Name", userName);
        userUpdateVal.put("Password", userPassword);
        if( db.update(TABLE_NAME, userUpdateVal, "id = "+userId, null) > 0) {
            db.close();
            return true;
        }
        else {
            db.close();
            return false;
        }
    }

//    Selecting all rows from database
    public ArrayList<UserInfo> userAllSelect () {

        ArrayList<UserInfo> users = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        while (cursor.moveToNext()) {

            int id = Integer.parseInt(cursor.getString(0));
            String name = cursor.getString(1);
            String password = cursor.getString(2);

            UserInfo userRow = new UserInfo(id, name, password);
            users.add(userRow);
        }

        return users;
    }
}
