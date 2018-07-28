package com.example.sahil.fragmentcount;


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
public class FirstFragment extends Fragment {


    private Button mChangeBtn;
    private MainActivity mMainActivity;
    private Button mAddBtn;
    private int count;
    private TextView mCountTv;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        mChangeBtn = (Button) view.findViewById(R.id.button2);
        mAddBtn = (Button) view.findViewById(R.id.button3);
        mCountTv = (TextView) view.findViewById(R.id.textView);

        mChangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainActivity = (MainActivity) getActivity();
                mMainActivity.change(mCountTv.getText().toString());

            }
        });

        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                mCountTv.setText(String.valueOf(count));
                mMainActivity = (MainActivity) getActivity();
                mMainActivity.show(mCountTv.getText().toString());
            }
        });

        return view;
    }

    public void senddata(String s) {
        mCountTv.setText(s);
        count = Integer.parseInt(s);
    }

}
