package com.example.sahil.fragmentcount;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity {

    private SecondFragment mSecFrag;
    private ThirdFragment mThirdFrag;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private FirstFragment mFirstFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSecFrag = new SecondFragment();
        mThirdFrag = new ThirdFragment();
        mFragmentManager = getFragmentManager();
        mFirstFrag = (FirstFragment) mFragmentManager.findFragmentById(R.id.fragment);
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.myframe,mSecFrag);
        mFragmentTransaction.commit();
    }

    public void change(String s) {
        Bundle bundle = new Bundle();
        bundle.putString("mycount",s);
        mFragmentTransaction = mFragmentManager.beginTransaction();
        if(mSecFrag.isResumed()){
            mThirdFrag.setArguments(bundle);
            mFragmentTransaction.replace(R.id.myframe,mThirdFrag);
        }

        else{
            mSecFrag.setArguments(bundle);
            mFragmentTransaction.replace(R.id.myframe,mSecFrag);
        }

        mFragmentTransaction.commit();
    }

    public void show(String s) {
        if(mSecFrag.isResumed())
            mSecFrag.showdata(s);
        else
            mThirdFrag.showdata(s);
    }

    public void sendcount(String s) {
        mFirstFrag.senddata(s);
    }
}
