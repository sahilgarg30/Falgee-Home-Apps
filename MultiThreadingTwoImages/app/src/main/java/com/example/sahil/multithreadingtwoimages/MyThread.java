package com.example.sahil.multithreadingtwoimages;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Sahil on 13-06-2017.
 */

public class MyThread extends AsyncTask<String,String,Bitmap[]> {

    private Context mContext;
    private ImageView mImageView1;
    private ImageView mImageView2;
    private ProgressDialog mProgressDialog;

    public MyThread(Context mContext, ImageView mImageView1, ImageView mImageView2) {
        this.mContext = mContext;
        this.mImageView1 = mImageView1;
        this.mImageView2 = mImageView2;
        this.mProgressDialog = new ProgressDialog(mContext);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgressDialog.setMessage("Loading... ");
        mProgressDialog.show();

    }

    @Override
    protected Bitmap[] doInBackground(String... params) {
        Bitmap bm[] = new Bitmap[params.length];
        URL aURL[] = new URL[params.length];
        try {
            for(int i=0;i<params.length;i++) {
                aURL[i] = new URL(params[i]);
                URLConnection conn = aURL[i].openConnection();
                conn = aURL[i].openConnection();
                conn.connect();
                InputStream is = conn.getInputStream();
                is = conn.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(is);
                bm[i] = BitmapFactory.decodeStream(bis);
                bis.close();
                is.close();
            }

        } catch (IOException e) {
            Log.e("Hub","Error getting the image from server : " + e.getMessage().toString());
        }
        return bm;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap[]) {
        super.onPostExecute(bitmap);
        mImageView1.setImageBitmap(bitmap[0]);
        mImageView2.setImageBitmap(bitmap[1]);
        mProgressDialog.dismiss();
    }
}
