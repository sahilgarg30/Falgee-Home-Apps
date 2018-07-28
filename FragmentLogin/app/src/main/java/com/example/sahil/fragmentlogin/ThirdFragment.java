package com.example.sahil.fragmentlogin;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment {

    private TextView mLoginTv;
    private Button mLogoutBtn;
    private MainActivity mMainActivity;
    private int check;

    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        mLoginTv = (TextView) view.findViewById(R.id.login_tv);
        mLogoutBtn = (Button) view.findViewById(R.id.logout_btn);
        Bundle bundle = getArguments();
        if(bundle != null) {
            check = bundle.getInt("mycheck");
            String name = bundle.getString("name");
            if (check == 1) {
                mLogoutBtn.setVisibility(View.VISIBLE);
                mLoginTv.setVisibility(View.VISIBLE);
                mLoginTv.setText("Welcome " + name + ".\nHave a great day ahead!");
            }
        }



        mLogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainActivity = (MainActivity) getActivity();
                mLogoutBtn.setVisibility(View.INVISIBLE);
                mLoginTv.setVisibility(View.INVISIBLE);
                mMainActivity.logout();
            }
        });

        return view;
    }
    public void login(String s, String s1,int checker) {
        check = checker;
        if (check == 1) {
            mLoginTv.setVisibility(View.VISIBLE);
            mLoginTv.setText("Welcome " + s + ".\nHave a great day ahead!");
            mLogoutBtn.setVisibility(View.VISIBLE);
        }
    }


}

