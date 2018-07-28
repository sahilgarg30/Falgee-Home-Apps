package com.example.sahil.servicedownloadimage;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Sahil on 19-06-2017.
 */

public class MyTask extends AsyncTask<String,String,Bitmap> {
    private Context mContext;
    private ImageView mImageView;
    private String filename;

    public MyTask(Context mContext, ImageView mImageView) {
        this.mContext = mContext;
        this.mImageView = mImageView;
    }

    public MyTask() {
        mContext = null;
        mImageView = null;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap bm = null;

        if(mContext==null)
        filename = params[1];

        try {
            URL aURL = new URL(params[0]);
            URLConnection conn = aURL.openConnection();
            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();
        } catch (Exception e) {
            Log.e("Hub","Error getting the image from server : " + e.getMessage().toString());
        }
        return bm;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if(mContext == null) {
            try {
                File f = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), filename+".jpeg");
                if (!f.exists()) {
                    f.createNewFile();
                }
                FileOutputStream fos = new FileOutputStream(f);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                fos.flush();
                fos.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(mImageView != null)
        mImageView.setImageBitmap(bitmap);

    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }
}
