package com.example.sahil.fragmentthreedatapassing;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity {

    private SecondFragment mSecFrag;
    private ThirdFragment mThirdFrag;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSecFrag = new SecondFragment();
        mThirdFrag = new ThirdFragment();
        mFragmentManager = getFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.myframe,mSecFrag);
        mFragmentTransaction.commit();

    }

    public void change() {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        if(mSecFrag.isResumed())
            mFragmentTransaction.replace(R.id.myframe,mThirdFrag);
        else
            mFragmentTransaction.replace(R.id.myframe,mSecFrag);
        mFragmentTransaction.commit();
    }

    public void show(String s, String s1, String s2) {
        if(mSecFrag.isResumed())
            mSecFrag.showdata(s,s1,s2);
        else
            mThirdFrag.showdata(s,s1,s2);
    }
}
