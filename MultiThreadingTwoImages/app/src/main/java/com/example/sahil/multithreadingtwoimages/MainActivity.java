package com.example.sahil.multithreadingtwoimages;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ImageView mImageView2;
    private ImageView mImageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView1 = (ImageView)findViewById(R.id.imageView);
        mImageView2 = (ImageView)findViewById(R.id.imageView2);
    }

    public void getPlayers(View view) {
            MyThread myThread = new MyThread(MainActivity.this,mImageView1,mImageView2);
            myThread.execute("http://cdn02.cdn.justjared.com/wp-content/uploads/headlines/2015/06/stephen-curry-celebrates-warriors-win-with-wife-daughter.jpg",
                            "https://pbs.twimg.com/profile_images/677535789279027200/xoAivvwN_400x400.jpg");

    }

}
