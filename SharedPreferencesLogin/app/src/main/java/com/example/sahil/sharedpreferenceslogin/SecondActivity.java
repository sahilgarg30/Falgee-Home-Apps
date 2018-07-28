package com.example.sahil.sharedpreferenceslogin;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends Activity {

    private SharedPreferences mSP;
    private int check;
    private String name;
    private TextView mNameTv;
    private SharedPreferences.Editor mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mSP = getSharedPreferences("mysp",MODE_PRIVATE);
        mEdit = mSP.edit();
        check = mSP.getInt("mycheck",0);
        name = mSP.getString("name","User");
        mNameTv = (TextView) findViewById(R.id.name_tv);
        mNameTv.setText("Welcome " + name + " .\nYou have successfully logged in! \nHave a great day!\n");
    }

    public void logoutFirst(View view) {
        check = 0;
        mEdit.putInt("mycheck",check);
        mEdit.commit();
        finish();
    }
}
