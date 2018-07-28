package com.example.sahil.fragmentthreedatapassing;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {


    private Button mShowBtn;
    private Button mChangeBtn;
    private MainActivity mMainActivity;
    private EditText mDateEt;
    private EditText mNameEt;
    private EditText mPhoneEt;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_first, container, false);
        mChangeBtn = (Button) view.findViewById(R.id.button2);
        mShowBtn = (Button) view.findViewById(R.id.button);
        mNameEt = (EditText) view.findViewById(R.id.editText);
        mPhoneEt = (EditText) view.findViewById(R.id.editText2);
        mDateEt = (EditText) view.findViewById(R.id.editText3);

        mChangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainActivity = (MainActivity)getActivity();
                mMainActivity.change();
            }
        });

        mShowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainActivity = (MainActivity)getActivity();
                mMainActivity.show(mNameEt.getText().toString(),mPhoneEt.getText().toString(),mDateEt.getText().toString());
            }
        });
        return view;
    }

}
