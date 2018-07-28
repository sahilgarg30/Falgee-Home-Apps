package com.example.sahil.listviewandadapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sahil on 12-06-2017.
 */

public class MyAnimalAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Animal> mAnimalList;
    private LayoutInflater mLayoutInflater;

    public MyAnimalAdapter(Context mContext, ArrayList<Animal> mAnimalList) {
        this.mContext = mContext;
        this.mAnimalList = mAnimalList;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }

    public void setmAnimalList(ArrayList<Animal> mAnimalList) {
        this.mAnimalList = mAnimalList;
    }

    @Override
    public int getCount() {
        return mAnimalList.size();
    }

    @Override
    public Object getItem(int position) {
        return mAnimalList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.item_layout,parent,false);
        }
        TextView animalTv = (TextView) convertView.findViewById(R.id.textView);
        animalTv.setText(mAnimalList.get(position).getname());
        TextView animalScNameTv = (TextView) convertView.findViewById(R.id.textView2);
        animalScNameTv.setText(mAnimalList.get(position).getScName());
        Log.i("MyAnimalAdapter","Item - " + position);
        return convertView;
    }
}
