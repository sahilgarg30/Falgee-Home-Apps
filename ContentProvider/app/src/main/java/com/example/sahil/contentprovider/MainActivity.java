package com.example.sahil.contentprovider;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private MyHelper mMyHelper;
    private SQLiteDatabase mDB;
    private EditText mPhoneEt;
    private EditText mNameEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNameEt = (EditText)findViewById(R.id.editText);
        mPhoneEt = (EditText)findViewById(R.id.editText2);

        mMyHelper = new MyHelper(MainActivity.this,"STUDDB",null,1);
        mDB = mMyHelper.getWritableDatabase();
    }

    public void readData(View view) {
        Cursor c = mDB.query("studentinfo",null,null,null,null,null,null);
        while(c.moveToNext()){
            Toast.makeText(MainActivity.this, c.getString(0) + " " + c.getString(1) + " " + c.getString(2), Toast.LENGTH_SHORT).show();
        }
    }

    public void insertData(View view) {
        ContentValues cv = new ContentValues();
        cv.put("name",mNameEt.getText().toString());
        cv.put("phone",mPhoneEt.getText().toString());
        mDB.insert("studentinfo",null,cv);
        mNameEt.setText("");
        mPhoneEt.setText("");
    }
}
