package com.example.sahil.bindservicedownloadimage;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

    IBinder mIBinder = new LocalBinder();
    private Bitmap image;

    public class LocalBinder extends Binder{
        public MyService getService(){
            return MyService.this;
        }
    }
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        MyTask myTask = new MyTask(mIBinder);
        String s = intent.getStringExtra("url");
        myTask.execute(s);
        Toast.makeText(MyService.this, "Image downloaded successfully!", Toast.LENGTH_SHORT).show();
        return mIBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public Bitmap returnImage(){
        return image;
    }

    public void getImage(Bitmap bitmap){
        image = bitmap;
    }
}
