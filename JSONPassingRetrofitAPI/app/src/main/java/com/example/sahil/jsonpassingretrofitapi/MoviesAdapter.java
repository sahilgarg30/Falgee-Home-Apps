package com.example.sahil.jsonpassingretrofitapi;

import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sahil on 16-06-2017.
 */

public class MoviesAdapter extends BaseAdapter {
    private ArrayList<Result> mArraylst;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public MoviesAdapter(ArrayList<Result> mArraylst, Context mContext) {
        this.mArraylst = mArraylst;
        this.mContext = mContext;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mArraylst.size();
    }

    @Override
    public Object getItem(int position) {
        return mArraylst.get(position);
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
        TextView mTitleTv = (TextView) convertView.findViewById(R.id.title_tv);
        TextView mReleaseDateTv = (TextView) convertView.findViewById(R.id.releasedate_tv);
        TextView mOverviewTv = (TextView) convertView.findViewById(R.id.overview_tv);
        TextView mRatingTv = (TextView) convertView.findViewById(R.id.rating_tv);
        mTitleTv.setText(mArraylst.get(position).getTitle());
        mReleaseDateTv.setText(mArraylst.get(position).getReleaseDate());
        mOverviewTv.setText(mArraylst.get(position).getOverview());
        mRatingTv.setText(mArraylst.get(position).getVoteAverage().toString());
        return convertView;
    }
}
