package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

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

        SQLiteHelper db = new SQLiteHelper(this);


        userNAME = (EditText) findViewById(R.id.userNAME);
        userPASSWORD = (EditText) findViewById(R.id.userPASSWORD);

        btnInsert = findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String userName = userNAME.getText().toString();
                String userPassword = userPASSWORD.getText().toString();

                if(db.addUser(new UserInfo(userName, userPassword)) == true) {

                    Toast.makeText(getApplicationContext(), "User Added", Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}