package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase demoDB = openOrCreateDatabase("demo", MODE_PRIVATE, null);
        demoDB.execSQL("CREATE TABLE IF NOT EXISTS user (id INT, name VARCHAR, password VACHAR)");
        demoDB.close();
    }

    public void btnInsert(View view) {

        Intent insertIntent = new Intent(MainActivity.this, Insert.class);
        startActivity(insertIntent);
    }

    public void btnSelect(View view) {

        Intent selectIntent = new Intent(MainActivity.this, Select.class);
        startActivity(selectIntent);
    }

    public void btnUpdate(View view) {

        Intent updateIntent = new Intent(MainActivity.this, Update.class);
        startActivity(updateIntent);
    }

    public void btnDelete(View view) {

        Intent deleteIntent = new Intent(MainActivity.this, Delete.class);
        startActivity(deleteIntent);
    }

    public void btnSelectAll(View view) {

        Intent selectAllIntent = new Intent(MainActivity.this, SelectAll.class);
        startActivity(selectAllIntent);
    }
}