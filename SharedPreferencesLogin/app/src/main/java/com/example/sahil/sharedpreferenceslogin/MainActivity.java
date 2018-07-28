package com.example.sahil.sharedpreferenceslogin;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView mConfirmTv;
    private EditText mUsernameEt;
    private EditText mPasswordEt;
    private SharedPreferences mSP;
    private SharedPreferences.Editor mEdit;
    private int check;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUsernameEt = (EditText)findViewById(R.id.name_et);
        mPasswordEt = (EditText)findViewById(R.id.password_et);
        mConfirmTv = (TextView)findViewById(R.id.confirm_tv);
        mSP = getSharedPreferences("mysp",MODE_PRIVATE);
        mEdit = mSP.edit();
        check = mSP.getInt("mycheck",0);
        if(check == 1)
        {
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        check = mSP.getInt("mycheck",0);
        if(check == 1)
            finish();
        else
        { mConfirmTv.setText("You have successfully logged out!");
          mPasswordEt.setText("");
          mUsernameEt.setText("");
        }
    }

    public void loginSecond(View view) {
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        check = 1;
        mEdit.putInt("mycheck",check);
        mEdit.putString("name",mUsernameEt.getText().toString());
        mEdit.commit();
        startActivity(intent);
    }
}
