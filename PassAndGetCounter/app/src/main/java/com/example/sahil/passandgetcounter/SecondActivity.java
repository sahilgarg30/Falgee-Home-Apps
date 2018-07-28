package com.example.sahil.passandgetcounter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends Activity {

    private TextView mText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mText2 = (TextView) findViewById(R.id.textView2);

    }

    @Override
    protected void onStart() {
        super.onStart();
        String c = getIntent().getStringExtra("count");
        mText2.setText(c);

    }

    public void Add1(View view) {
        String c = mText2.getText().toString();
        int counter = Integer.parseInt(c);
        counter++;
        c = String.valueOf(counter);
        mText2.setText(c);

    }

    public void goBack(View view) {
        Intent intent = new Intent();
        String c = mText2.getText().toString();
        intent.putExtra("count",c);
        setResult(RESULT_OK,intent);
        finish();
    }
}
