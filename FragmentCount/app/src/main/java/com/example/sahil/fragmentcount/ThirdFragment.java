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
public class ThirdFragment extends Fragment {


    private TextView mCountTv;
    private Button mSendBtn;
    private MainActivity mMainActivity;

    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        mCountTv = (TextView) view.findViewById(R.id.textView2);
        mSendBtn = (Button) view.findViewById(R.id.count_thirdfrag_btn);

        mSendBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mMainActivity = (MainActivity) getActivity();
                int count = Integer.parseInt(mCountTv.getText().toString());
                count++;
                mCountTv.setText(String.valueOf(count));
                mMainActivity.sendcount(String.valueOf(count));
            }
        });


        Bundle bundle = getArguments();
        if(bundle != null) {
            String str = bundle.getString("mycount");
            mCountTv.setText(str);
        }

        return view;
    }

    public void showdata(String s) {
        mCountTv.setText(s);
    }
}
