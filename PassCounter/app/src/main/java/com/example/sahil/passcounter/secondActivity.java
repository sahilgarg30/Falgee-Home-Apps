package com.example.sahil.passcounter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class secondActivity extends Activity {

    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mText = (TextView) findViewById(R.id.textView2);
        Intent intent = getIntent();
        String c = intent.getStringExtra("number");
        mText.setText(c);

    }
}
