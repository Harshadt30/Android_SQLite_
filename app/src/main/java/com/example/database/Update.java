package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {

    private EditText userID, userName, userPassword;
    private Button btnSelect, btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        SQLiteHelper db = new SQLiteHelper(this);

        userID = findViewById(R.id.userID);
        userName = findViewById(R.id.userNAME);
        userPassword = findViewById(R.id.userPASSWORD);

        btnSelect = findViewById(R.id.btnSelect);
        btnUpdate = findViewById(R.id.btnUpdate);

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int userId = Integer.parseInt(userID.getText().toString());
                Cursor userRaw = db.userRow(userId);

                if (userRaw.getCount() > 0) {

                    while (userRaw.moveToNext()) {

                        userName.setText(userRaw.getString(1));
                        userPassword.setText(userRaw.getString(2));
                    }

                }
                else {

                    Toast.makeText(getApplicationContext(), "No User Found", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int userId = Integer.parseInt(userID.getText().toString());
                ContentValues updateVal = new ContentValues();

                if(db.userUpdate(userId, userName.getText().toString(), userPassword.getText().toString())) {

                    Toast.makeText(getApplicationContext(), "User Updated", Toast.LENGTH_SHORT).show();
                }
                else  {

                    Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}