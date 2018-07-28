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
public class SecondFragment extends Fragment {


    private TextView mCountTv;
    private Button mCountBtn;

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_second, container, false);
        mCountTv = (TextView) view.findViewById(R.id.textView2);
        mCountBtn = (Button) view.findViewById(R.id.count_secfrag_btn);

        mCountBtn.setOnClickListener(new View.OnClickListener() {
            public MainActivity mMainActivity;

            @Override
            public void onClick(View v) {
                mMainActivity = (MainActivity)getActivity() ;
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
