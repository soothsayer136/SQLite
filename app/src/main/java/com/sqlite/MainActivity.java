package com.sqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import myhelper.Myhelper;

public class MainActivity extends AppCompatActivity {
    private EditText edWord, edMeaning;
    private Button btnAddWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edWord = findViewById(R.id.edWord);
        edMeaning = findViewById(R.id.edMeaning);
        btnAddWord = findViewById(R.id.btnAddWord);

        final Myhelper myHelper = new Myhelper(this);
        final SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();

        btnAddWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long id = myHelper.InsertData(edWord.getText().toString(), edMeaning.getText().toString(), sqLiteDatabase);
                if (id > 0) {
                    Toast.makeText(MainActivity.this, "Sucessful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
