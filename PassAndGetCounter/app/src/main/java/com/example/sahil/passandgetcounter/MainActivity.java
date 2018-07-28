package com.example.sahil.passandgetcounter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView mText1;
    private int counter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText1 = (TextView) findViewById(R.id.textView);

    }

    public void Add1(View view) {
        String as = mText1.getText().toString();
        counter = Integer.parseInt(as);
        counter++;
        String c = String.valueOf(counter);
        mText1.setText(c);

    }

    public void goNext(View view) {
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        String c = mText1.getText().toString();
        intent.putExtra("count",c);
        startActivityForResult(intent,8);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 8)
        {
            if(resultCode == RESULT_OK)
            {
                String c = data.getStringExtra("count");
                mText1.setText(c);
            }
        }
    }

    public void closeApp(View view) {
        finish();
    }
}
