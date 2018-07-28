package com.example.sahil.contentresolver;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText mNameEt;
    private EditText mPhoneEt;
    private ContentResolver cr;
    private Uri uri;
    private Cursor c;
    private Button mNextBtn;
    private Button mPrevBtn;
    private Button mDeleteBtn;
    private Button mUpdateBtn;
    private Button mInsertBtn;
    private int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameEt = (EditText)findViewById(R.id.editText);
        mPhoneEt = (EditText)findViewById(R.id.editText2);
        mNextBtn = (Button)findViewById(R.id.button);
        mPrevBtn = (Button)findViewById(R.id.button2);
        mDeleteBtn = (Button)findViewById(R.id.button3);
        mInsertBtn = (Button)findViewById(R.id.button4);
        mUpdateBtn = (Button)findViewById(R.id.button5);


        cr = getContentResolver();
        uri = Uri.parse("content://com.sahilgarg.contentprovider");
        c = cr.query(uri,null,null,null,null);

        if(c.moveToNext()){
            mNameEt.setText(c.getString(1));
            mPhoneEt.setText(c.getString(2));}
        else
        {
            mDeleteBtn.setVisibility(View.INVISIBLE);
            mUpdateBtn.setVisibility(View.INVISIBLE);
            mNextBtn.setVisibility(View.INVISIBLE);
            mPrevBtn.setVisibility(View.INVISIBLE);
            counter=1;
            mNameEt.setText("");
            mPhoneEt.setText("");
            Toast.makeText(this, "No records available.\nPlease add some records!", Toast.LENGTH_LONG).show();
        }

    }

    public void goNext(View view) {
            if(c.moveToNext()){
                mNameEt.setText(c.getString(1));
                mPhoneEt.setText(c.getString(2));
            }else {
                c.moveToPrevious();
                Toast.makeText(this, "No more records!", Toast.LENGTH_SHORT).show();
            }
    }

    public void goPrevious(View view) {
            if(c.moveToPrevious()){
                mNameEt.setText(c.getString(1));
                mPhoneEt.setText(c.getString(2));
            }else{
                c.moveToNext();
                Toast.makeText(this, "No more records!", Toast.LENGTH_SHORT).show();
            }
    }

    public void deleteData(View view) {
        int id1 = Integer.parseInt(c.getString(0));
        cr.delete(uri,"_id = " + c.getString(0),null);
        c = cr.query(uri,null,null,null,null);
        Toast.makeText(MainActivity.this, "Record successfully deleted!", Toast.LENGTH_SHORT).show();
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
            mNextBtn.setVisibility(View.INVISIBLE);
            mPrevBtn.setVisibility(View.INVISIBLE);
            counter=1;
            mNameEt.setText("");
            mPhoneEt.setText("");
            Toast.makeText(MainActivity.this, "No records available.\nPlease add more to view and make changes!", Toast.LENGTH_LONG).show();
        }
    }

    public void insertData(View view) {
        if(counter==0){
            mNameEt.setText("");
            mPhoneEt.setText("");
            Toast.makeText(this, "Enter the new record and press this button again to insert it!", Toast.LENGTH_SHORT).show();
            counter = 1;
        }else {
            ContentValues cv = new ContentValues();
            cv.put("name", mNameEt.getText().toString());
            cv.put("phone", mPhoneEt.getText().toString());
            cr.insert(uri, cv);
            Toast.makeText(this, "Record successfully inserted!", Toast.LENGTH_SHORT).show();
            counter=0;
            c = cr.query(uri,null,null,null,null);
            c.moveToLast();
            mNameEt.setText(c.getString(1));
            mPhoneEt.setText(c.getString(2));
            if(c.getString(0).equals("1")){
                mDeleteBtn.setVisibility(View.VISIBLE);
                mUpdateBtn.setVisibility(View.VISIBLE);
                mNextBtn.setVisibility(View.VISIBLE);
                mPrevBtn.setVisibility(View.VISIBLE);
            }
        }
    }

    public void updateData(View view) {
        ContentValues cv = new ContentValues();
        cv.put("name",mNameEt.getText().toString());
        cv.put("phone",mPhoneEt.getText().toString());
        cr.update(uri,cv,"_id = " + c.getString(0),null);
        int id1 = Integer.parseInt(c.getString(0));
        Toast.makeText(this, "Record successfully updated!", Toast.LENGTH_SHORT).show();
        c = cr.query(uri,null,null,null,null);
        c.moveToNext();
        while(Integer.parseInt(c.getString(0))<id1)
        {
            c.moveToNext();
        }
        mNameEt.setText(c.getString(1));
        mPhoneEt.setText(c.getString(2));
    }
}
