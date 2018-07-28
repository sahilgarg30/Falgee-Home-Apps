package com.example.sahil.fragmentfivefragmentshuffle;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {


    private Button mChangeBtn;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_first, container, false);
        mChangeBtn = (Button) view.findViewById(R.id.button);
        mChangeBtn.setOnClickListener(new View.OnClickListener() {
            public MainActivity mMainActivity;

            @Override
            public void onClick(View v) {
                mMainActivity = (MainActivity)getActivity();
                mMainActivity.change();
            }
        });
        return view;
    }

}
