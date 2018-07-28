package com.example.sahil.bindservicedownloadimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Sahil on 21-06-2017.
 */

public class MyTask extends AsyncTask<String,String,Bitmap> {

    private final MyService mMyService;
    Bitmap bm = null;

    public MyTask(IBinder IBinder) {
        mMyService = ((MyService.LocalBinder)IBinder).getService();
    }

    @Override
    protected Bitmap doInBackground(String... params) {
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
        mMyService.getImage(bm);
        return bm;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
    }

}
