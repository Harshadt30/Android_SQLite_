package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Select extends AppCompatActivity {

    private EditText userID, userName, userPassword;
    private Button btnSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        SQLiteHelper db = new SQLiteHelper(this);

        userID = findViewById(R.id.userID);
        userName = findViewById(R.id.userNAME);
        userPassword = findViewById(R.id.userPASSWORD);

        btnSelect = findViewById(R.id.btnSelect);

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int userId = Integer.parseInt(userID.getText().toString());
                Cursor cursor = db.userRow(userId);

                if (cursor.getCount() == 0) {

                    Toast.makeText(getApplicationContext(), "No User Found", Toast.LENGTH_SHORT).show();
                }
                else {

                    while (cursor.moveToNext()) {

                        userName.setText(cursor.getString(1));
                        userPassword.setText(cursor.getString(2));
                    }

                }

            }
        });
    }
}