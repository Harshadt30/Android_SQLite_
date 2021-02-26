package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

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

        userList = findViewById(R.id.userListView);

        ArrayList<String> user = new ArrayList<>();
        user.add("User1");
        user.add("User2");
        user.add("User3");
        user.add("User4");
        user.add("User5");

        ArrayAdapter userArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, user);
        userList.setAdapter(userArrayAdapter);
    }
}