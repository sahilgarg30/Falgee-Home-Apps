package com.example.sahil.passandgetdata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText mNameEt;
    private EditText mPhoneEt;
    private EditText mAgeEt;
    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNameEt = (EditText) findViewById(R.id.name_et);
        mPhoneEt = (EditText) findViewById(R.id.phone_et);
        mAgeEt = (EditText) findViewById(R.id.age_et);
        mText = (TextView) findViewById(R.id.textView);

    }

    public void goNext(View view) {
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        String a = mNameEt.getText().toString();
        String b = mPhoneEt.getText().toString();
        String c = mAgeEt.getText().toString();
        intent.putExtra("name",a);
        intent.putExtra("phone",b);
        intent.putExtra("age",c);
        startActivityForResult(intent,8);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 8)
        {
            if(resultCode == RESULT_OK)
            {
                String d = data.getStringExtra("email");
                String e = data.getStringExtra("address");
                String f = data.getStringExtra("gender");
                String a = mNameEt.getText().toString();
                String b = mPhoneEt.getText().toString();
                String c = mAgeEt.getText().toString();
                mText.setText(a + " ,of age " + c + " years old, contact number "+ b + " ," + f +" has email address " + d + " and lives at " + e +".");

            }
        }
    }
}


