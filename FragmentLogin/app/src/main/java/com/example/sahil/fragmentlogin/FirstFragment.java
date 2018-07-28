package com.example.sahil.fragmentlogin;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {


    private Button mChangeBtn;
    private Button mLoginBtn;
    private EditText mUserNameEt;
    private EditText mPasswordEt;
    private TextView mConfirmTv;
    private MainActivity mMainActivity;
    private int check=0;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_first, container, false);
        mChangeBtn =(Button) view.findViewById(R.id.changecolor_btn);
        mLoginBtn = (Button) view.findViewById(R.id.login_btn);
        mUserNameEt = (EditText) view.findViewById(R.id.editText);
        mPasswordEt = (EditText) view.findViewById(R.id.editText2);
        mConfirmTv = (TextView) view.findViewById(R.id.confirm_tv);

        mChangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainActivity = (MainActivity)getActivity();
                mMainActivity.change(check,mUserNameEt.getText().toString());
            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(check == 1)
                {
                    mConfirmTv.setText("Please logout first.");
                }
                else
                {
                check =1;
                mMainActivity = (MainActivity)getActivity();
                mConfirmTv.setText("You have successfully logged in!");
                mMainActivity.login(mUserNameEt.getText().toString(),mPasswordEt.getText().toString(),check);}
            }
        });


        return view;
    }

    public void logout() {
        check = 0;
        mUserNameEt.setText("");
        mPasswordEt.setText("");
        mConfirmTv.setText("You have successfully logged out!");

    }
}
