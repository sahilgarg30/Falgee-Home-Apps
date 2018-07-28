package com.example.sahil.sqlitedatabaseupdatedata;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText mPhoneEt;
    private EditText mNameEt;
    private MyHelper mMyHelper;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNameEt = (EditText)findViewById(R.id.editText);
        mPhoneEt = (EditText)findViewById(R.id.editText2);
        mMyHelper = new MyHelper(MainActivity.this,"STUDDB",null,1);
        mDb = mMyHelper.getWritableDatabase();
    }

    public void insertData(View view) {
        ContentValues cv = new ContentValues();
        cv.put("name",mNameEt.getText().toString());
        cv.put("phone",mPhoneEt.getText().toString());
        mDb.insert("studentinfo",null,cv);
        Toast.makeText(MainActivity.this, "Record successfully added!", Toast.LENGTH_SHORT).show();
        mNameEt.setText("");
        mPhoneEt.setText("");
    }
    public void goNext(View view) {
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mNameEt.setText("");
        mPhoneEt.setText("");
    }

}
