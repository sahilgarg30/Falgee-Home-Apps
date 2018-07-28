package com.example.sahil.passandgetdata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends Activity {

    private EditText mGenderEt;
    private EditText mAddEt;
    private EditText mEmailEt;
    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mEmailEt = (EditText) findViewById(R.id.email_et);
        mAddEt = (EditText) findViewById(R.id.add_et);
        mGenderEt = (EditText) findViewById(R.id.gender_et);
        mText = (TextView) findViewById(R.id.textView3);

    }


    public void goBack(View view) {
        Intent intent = new Intent();
        String d = mEmailEt.getText().toString();
        String e = mAddEt.getText().toString();
        String f = mGenderEt.getText().toString();
        intent.putExtra("email",d);
        intent.putExtra("address",e);
        intent.putExtra("gender",f);
        setResult(RESULT_OK,intent);
        finish();
    }

    public void showData(View view) {
            String a = getIntent().getStringExtra("name");
            String b = getIntent().getStringExtra("phone");
            String c = getIntent().getStringExtra("age");
            mText.setText(a + " ,of age " + c + " has contact number " + b + ".");
    }
}
