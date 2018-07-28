package com.example.sahil.sqlitedatabaseupdatedata;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.id;

public class SecondActivity extends Activity {

    private MyHelper mMyHelper;
    private SQLiteDatabase mDb;
    private Button mNextBtn;
    private Button mPrevBtn;
    private EditText mNameEt;
    private EditText mPhoneEt;
    private Button mDeleteBtn;
    private Button mUpdateBtn;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mNameEt = (EditText)findViewById(R.id.name_et);
        mPhoneEt = (EditText)findViewById(R.id.phone_et);

        mNextBtn = (Button)findViewById(R.id.button3);
        mPrevBtn = (Button)findViewById(R.id.button4);
        mDeleteBtn = (Button)findViewById(R.id.button8);
        mUpdateBtn = (Button)findViewById(R.id.button7);

        mMyHelper = new MyHelper(SecondActivity.this,"STUDDB",null,1);
        mDb = mMyHelper.getReadableDatabase();
        c = mDb.query("studentinfo",null,null,null,null,null,null);

        if(c.moveToNext()){
        mNameEt.setText(c.getString(1));
        mPhoneEt.setText(c.getString(2));}
        else
        {
            mDeleteBtn.setVisibility(View.INVISIBLE);
            mUpdateBtn.setVisibility(View.INVISIBLE);
            mNameEt.setVisibility(View.INVISIBLE);
            mPhoneEt.setVisibility(View.INVISIBLE);
            mNextBtn.setVisibility(View.INVISIBLE);
            mPrevBtn.setVisibility(View.INVISIBLE);
            Toast.makeText(SecondActivity.this, "No records available.\nPlease add more to view and make changes!", Toast.LENGTH_LONG).show();
        }

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.moveToNext()){
                    mNameEt.setText(c.getString(1));
                    mPhoneEt.setText(c.getString(2));}
                else
                {   c.moveToPrevious();
                    Toast.makeText(SecondActivity.this, "No more records!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        mPrevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.moveToPrevious()){
                    mNameEt.setText(c.getString(1));
                    mPhoneEt.setText(c.getString(2));}
                else
                {   c.moveToNext();
                    Toast.makeText(SecondActivity.this,"No more records!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        mUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv = new ContentValues();
                cv.put("name",mNameEt.getText().toString());
                cv.put("phone",mPhoneEt.getText().toString());
                mDb.update("studentinfo",cv,"_id = " + c.getString(0),null);
                int id1 = Integer.parseInt(c.getString(0));
                Toast.makeText(SecondActivity.this, "Record successfully updated!", Toast.LENGTH_SHORT).show();
                c = mDb.query("studentinfo",null,null,null,null,null,null);
                c.moveToNext();
                while(Integer.parseInt(c.getString(0))<id1)
                {
                    c.moveToNext();
                }
                mNameEt.setText(c.getString(1));
                mPhoneEt.setText(c.getString(2));
                }

});

        mDeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id1 = Integer.parseInt(c.getString(0));
                mDb.delete("studentinfo","_id = " + c.getString(0),null);
                c = mDb.query("studentinfo",null,null,null,null,null,null);
                Toast.makeText(SecondActivity.this, "Record successfully deleted!", Toast.LENGTH_SHORT).show();
                if(c.moveToNext()) {
                    while ((Integer.parseInt(c.getString(0))) < id1 - 1) {
                        c.moveToNext();
                    }
                    mNameEt.setText(c.getString(1));
                    mPhoneEt.setText(c.getString(2));
                }
                else
                {
                    mDeleteBtn.setVisibility(View.INVISIBLE);
                    mUpdateBtn.setVisibility(View.INVISIBLE);
                    mNameEt.setVisibility(View.INVISIBLE);
                    mPhoneEt.setVisibility(View.INVISIBLE);
                    mNextBtn.setVisibility(View.INVISIBLE);
                    mPrevBtn.setVisibility(View.INVISIBLE);
                    Toast.makeText(SecondActivity.this, "No records available.\nPlease add more to view and make changes!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void goBack(View view) {
        finish();
    }
}

