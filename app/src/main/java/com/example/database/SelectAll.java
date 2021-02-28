package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class SelectAll extends AppCompatActivity {

    private ListView userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_all);
        SQLiteDatabase demoDB = openOrCreateDatabase("demo", MODE_PRIVATE, null);

        userList = findViewById(R.id.userListView);

        ArrayList<String> user = new ArrayList<>();
        Cursor userRaw = demoDB.rawQuery("SELECT * FROM user ", null);
        if (userRaw.moveToFirst()) {

            user.add(userRaw.getString(0));
        }

        ArrayAdapter userArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, user);
        userList.setAdapter(userArrayAdapter);
    }
}