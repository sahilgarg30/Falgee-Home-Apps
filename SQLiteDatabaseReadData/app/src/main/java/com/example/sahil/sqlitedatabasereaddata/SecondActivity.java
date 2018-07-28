package com.example.sahil.sqlitedatabasereaddata;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {

    private TextView mPhoneTv;
    private TextView mNameTv;
    private MyHelper mMyHelper;
    private SQLiteDatabase mDb;
    private Button mNextBtn;
    private Button mPrevBtn;
    private Button mLastBtn;
    private Button mFirstBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mNameTv = (TextView)findViewById(R.id.name_tv);
        mPhoneTv = (TextView)findViewById(R.id.phone_tv);
        mMyHelper = new MyHelper(SecondActivity.this,"STUDDB",null,1);
        mDb = mMyHelper.getReadableDatabase();
        final Cursor c = mDb.query("studentinfo",null,null,null,null,null,null);
        if(c.moveToNext()){
            mNameTv.setText(c.getString(1));
            mPhoneTv.setText(c.getString(2));
        }
        mNextBtn = (Button)findViewById(R.id.button3);
        mPrevBtn = (Button)findViewById(R.id.button4);
        mLastBtn = (Button)findViewById(R.id.button8);
        mFirstBtn = (Button)findViewById(R.id.button7);

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.moveToNext()){
                mNameTv.setText(c.getString(1));
                mPhoneTv.setText(c.getString(2));}
                else
                {
                    Toast.makeText(SecondActivity.this, "No more records!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        mPrevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.moveToPrevious()){
                mNameTv.setText(c.getString(1));
                mPhoneTv.setText(c.getString(2));}
                else
                {
                    Toast.makeText(SecondActivity.this,"No more records!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        mFirstBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.moveToFirst()){
                    mNameTv.setText(c.getString(1));
                    mPhoneTv.setText(c.getString(2));}
                else
                {
                    Toast.makeText(SecondActivity.this,"No more records!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        mLastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(c.moveToLast()){
                    mNameTv.setText(c.getString(1));
                    mPhoneTv.setText(c.getString(2));}
                    else
                    {
                    Toast.makeText(SecondActivity.this,"No more records!", Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }

    public void goBack(View view) {
        finish();
    }
}
