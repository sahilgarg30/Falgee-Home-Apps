package com.example.sahil.intentservicedownloadimage;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class MyService extends IntentService {

    private int mStartId = 0;
    private String url = null;
    private String name = null;

    public MyService() {
        super("MyService");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if(mStartId == 1 || mStartId == 2) {
            Bitmap bm = null;
            try {
                URL aURL = new URL(url);
                URLConnection conn = aURL.openConnection();
                conn.connect();
                InputStream is = conn.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(is);
                bm = BitmapFactory.decodeStream(bis);
                bis.close();
                is.close();
            } catch (Exception e) {
                Log.e("Hub", "Error getting the image from server : " + e.getMessage().toString());
            }

            try {
                File f = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), name + ".jpeg");
                if (!f.exists()) {
                    f.createNewFile();
                }
                FileOutputStream fos = new FileOutputStream(f);
                bm.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                fos.flush();
                fos.close();
                Thread.sleep(3000);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mStartId = startId;
        if(mStartId == 1){
            url = intent.getStringExtra("url");
            name = intent.getStringExtra("filename");
            Toast.makeText(MyService.this, "Image "+ mStartId+ " is downloaded!", Toast.LENGTH_SHORT).show();
        }
        else if(mStartId == 2){
            url = intent.getStringExtra("url2");
            name = intent.getStringExtra("filename2");
            Toast.makeText(MyService.this, "Image "+ mStartId+ " is downloaded!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(MyService.this, "Both the images are downloaded!", Toast.LENGTH_SHORT).show();
        }

        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

