package com.example.sahil.fragmenthome;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    private ThirdFragment mThirdFrag;
    private SecondFragment mSecFrag;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private static final String TAG = "MainActivityFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"onCreate");
        setContentView(R.layout.activity_main);
        mSecFrag = new SecondFragment();
        mThirdFrag = new ThirdFragment();
        mFragmentManager = getFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.myframe,mSecFrag);
        mFragmentTransaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"onRestart");
    }

    public void change() {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        if(mSecFrag.isResumed())
            mFragmentTransaction.replace(R.id.myframe,mThirdFrag);
        else
            mFragmentTransaction.replace(R.id.myframe,mSecFrag);
        mFragmentTransaction.commit();
    }
}
