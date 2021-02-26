package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends AppCompatActivity {

    private EditText userID, userName, userPassword;
    private Button btnSelect, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        SQLiteDatabase demoDB = openOrCreateDatabase("demo", MODE_PRIVATE, null);

        userID = findViewById(R.id.userID);
        userName = findViewById(R.id.userNAME);
        userPassword = findViewById(R.id.userPASSWORD);

        btnSelect = findViewById(R.id.btnSelect);
        btnDelete = findViewById(R.id.btnDelete);

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int userId = Integer.parseInt(userID.getText().toString());
                Cursor userRaw = demoDB.rawQuery("SELECT * FROM user WHERE id = "+userId, null);
                if (userRaw.moveToFirst()) {

                    userName.setText(userRaw.getString(1));
                    userPassword.setText(userRaw.getString(2));

                }
                else {

                    Toast.makeText(getApplicationContext(), "No User Found", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userId = Integer.parseInt(userID.getText().toString());
                if(demoDB.delete("user", "id = "+userId, null) > 0) {

                    userID.setText("");
                    userName.setText("");
                    userPassword.setText("");
                    Toast.makeText(getApplicationContext(), "User deleted", Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}