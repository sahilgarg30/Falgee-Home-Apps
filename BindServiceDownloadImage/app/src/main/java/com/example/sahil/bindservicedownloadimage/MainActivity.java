package com.example.sahil.bindservicedownloadimage;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ServiceConnection mServiceConnection;
    private MyService mMyService;
    private boolean isServiceConnected;
    private ImageView mImageView;
    private Button mViewImage_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView)findViewById(R.id.imageView);
        mViewImage_Btn = (Button)findViewById(R.id.button2);

        mServiceConnection = new ServiceConnection() {

            @Override
            public void onServiceConnected(ComponentName name, IBinder iBinder) {
                mMyService = ((MyService.LocalBinder)iBinder).getService();
                isServiceConnected = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
    }

    public void downloadImage(View view) {
        Intent intent = new Intent(MainActivity.this,MyService.class);
        String s = "http://www.logoeps.com/wp-content/uploads/2013/03/jordan-air-vector-logo-200x200.png";
        String s1 = "http://epicasports.com/wp-content/uploads/2012/01/Derrick-Rose-200x200.jpg";
        intent.putExtra("url",s1);
        bindService(intent,mServiceConnection,BIND_AUTO_CREATE);

    }

    public void viewImage(View view) {
        if(isServiceConnected){
            mImageView.setImageBitmap(mMyService.returnImage());
        }
        else{
            Toast.makeText(MainActivity.this, "Image not downloaded!", Toast.LENGTH_SHORT).show();
        }
    }

    public void disconnectService(View view) {
        if(isServiceConnected){
            unbindService(mServiceConnection);
            isServiceConnected = false;
            Toast.makeText(MainActivity.this, "Service disconnected successfully!", Toast.LENGTH_SHORT).show();
            mImageView.setImageBitmap(null);
        }
        else {
            Toast.makeText(MainActivity.this, "Service already disconnected.", Toast.LENGTH_SHORT).show();
        }
    }
}
