package com.example.sahil.fragmentlogin;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Button;

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

    public void change(int check, String s) {
        Bundle bundle = new Bundle();
        bundle.putInt("mycheck",check);
        bundle.putString("name",s);
        mFragmentTransaction = mFragmentManager.beginTransaction();
        if(mSecFrag.isResumed())
        {   mThirdFrag.setArguments(bundle);
            mFragmentTransaction.replace(R.id.myframe,mThirdFrag);
        }
        else
        {   mSecFrag.setArguments(bundle);
            mFragmentTransaction.replace(R.id.myframe,mSecFrag);
        }

        mFragmentTransaction.commit();

    }

    public void login(String s, String s1,int check) {
        if(mSecFrag.isResumed())
            mSecFrag.login(s,s1,check);
        else
            mThirdFrag.login(s,s1,check);

    }

    public void logout() {
        mFirstFrag.logout();
    }
}