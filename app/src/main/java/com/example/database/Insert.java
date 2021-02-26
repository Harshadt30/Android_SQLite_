package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Insert extends AppCompatActivity {

    EditText userID, userNAME, userPASSWORD;
    Button btnInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) throws SQLiteException {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        SQLiteDatabase demoDB = openOrCreateDatabase("demo", MODE_PRIVATE, null);

        userID = (EditText) findViewById(R.id.userID);
        userNAME = (EditText) findViewById(R.id.userNAME);
        userPASSWORD = (EditText) findViewById(R.id.userPASSWORD);

        btnInsert = findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int userId = Integer.parseInt(userID.getText().toString());
                String userName = userNAME.getText().toString();
                String userPassword = userPASSWORD.getText().toString();
                ContentValues user = new ContentValues();
                user.put("id", userId);
                user.put("name", userName);
                user.put("password", userPassword);

//                demoDB.execSQL("INSERT INTO user VALUES('"+userId+"', '"+userName+"', '"+userPassword+"')", null);
                if(demoDB.insert("user", null, user) > 0){

                    Toast.makeText(getApplicationContext(), "User Added", Toast.LENGTH_SHORT).show();
                }
                demoDB.close();

            }
        });
    }
}