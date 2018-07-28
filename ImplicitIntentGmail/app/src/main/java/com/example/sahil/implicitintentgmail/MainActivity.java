package com.example.sahil.implicitintentgmail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText mTextEt;
    private EditText mSubjectEt;
    private EditText mToEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToEt = (EditText) findViewById(R.id.to_et);
        mSubjectEt = (EditText)findViewById(R.id.subject_et);
        mTextEt = (EditText) findViewById(R.id.text_et);

    }

    public void sendMail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        String to_address = mToEt.getText().toString();
        String subject = mSubjectEt.getText().toString();
        String text = mTextEt.getText().toString();
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{to_address});
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,text);
        intent.setType("text/plain");
        startActivity(intent);
    }
}
