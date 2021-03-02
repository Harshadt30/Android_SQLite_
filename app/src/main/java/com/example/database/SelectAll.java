package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectAll extends AppCompatActivity {

    SQLiteHelper db;
    ListView userList;
    ArrayList<UserInfo> users;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_all);

        db = new SQLiteHelper(this);

        userList = findViewById(R.id.userListView);

        users = new ArrayList<>();
        users = db.userAllSelect();

        myAdapter = new MyAdapter(this, users);
        userList.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }
}