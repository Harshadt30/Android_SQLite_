package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectAll extends AppCompatActivity {

    private ListView userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_all);

        SQLiteHelper db = new SQLiteHelper(this);

        userList = findViewById(R.id.userListView);

        ArrayList<String> user = new ArrayList<>();
        Cursor userRaw = db.userAllSelect();
        if(userRaw.getCount() > 0) {

            while (userRaw.moveToNext()) {

                user.add(userRaw.getString(1));
                db.close();
            }
        }
        else {
            Toast.makeText(getApplicationContext(), "No data found", Toast.LENGTH_SHORT).show();
        }

        ArrayAdapter userArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, user);
        userList.setAdapter(userArrayAdapter);
    }
}