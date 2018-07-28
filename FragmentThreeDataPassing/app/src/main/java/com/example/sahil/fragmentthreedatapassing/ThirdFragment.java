package com.example.sahil.fragmentthreedatapassing;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment {


    private TextView mNameTv;
    private TextView mPhoneTv;
    private TextView mDateTv;

    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_third, container, false);
        mNameTv = (TextView) view.findViewById(R.id.textView2);
        mPhoneTv = (TextView) view.findViewById(R.id.textView3);
        mDateTv = (TextView) view.findViewById(R.id.textView4);
        return view;
    }

    public void showdata(String s, String s1, String s2) {
        mNameTv.setText(s);
        mDateTv.setText(s2);
        mPhoneTv.setText(s1);
    }
}
