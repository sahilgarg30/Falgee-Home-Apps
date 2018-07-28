package com.example.sahil.passcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int counter;
    private TextView mCount;
    private Button mb1;
    private Button mb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCount = (TextView) findViewById(R.id.count_tv);
        mb1 = (Button) findViewById(R.id.button);
        mb2 = (Button) findViewById(R.id.button2);
    }

    public void add1(View view) {
        counter++;
        String as = Integer.toString(counter);
        mCount.setText(as);

    }

    public void goNext(View view) {
        Intent intent = new Intent(MainActivity.this,secondActivity.class);
        String c = mCount.getText().toString();
        intent.putExtra("number",c);
        startActivity(intent);
    }
}
