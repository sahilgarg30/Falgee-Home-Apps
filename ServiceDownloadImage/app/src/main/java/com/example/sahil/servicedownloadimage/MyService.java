package com.example.sahil.servicedownloadimage;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String s = intent.getStringExtra("url");
        String name = intent.getStringExtra("filename");
        if(s!=null){
        MyTask myTask = new MyTask();
        if(name.equals(""))
            myTask.execute(s,"drose");
        else
            myTask.execute(s,name);
        Toast.makeText(MyService.this,"Image downloaded!", Toast.LENGTH_SHORT).show();
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
