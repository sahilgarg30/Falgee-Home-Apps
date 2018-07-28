package com.example.sahil.servicedownloadimage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ImageView mImageView;
    private EditText mEditText;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView)findViewById(R.id.imageView);
        mEditText = (EditText)findViewById(R.id.editText);
    }

    public void downloadImage(View view) {
        intent = new Intent(MainActivity.this,MyService.class);
        String s = "http://www.3sayi.com/wp-content/uploads/2011/04/Derrick-Rose-MVP-Jersey-Widescreen-Wallpaper-200x200.jpg";
        intent.putExtra("url",s);
        intent.putExtra("filename",mEditText.getText().toString());
        startService(intent);
        mEditText.setText("");
    }

    public void viewImage(View view) {
        String s = "http://www.3sayi.com/wp-content/uploads/2011/04/Derrick-Rose-MVP-Jersey-Widescreen-Wallpaper-200x200.jpg";
        MyTask myTask = new MyTask(MainActivity.this,mImageView);
        myTask.execute(s);
    }

    public void downloadLargeImage(View view) {
        intent = new Intent(MainActivity.this,MyService.class);
        String s = "http://photos.imageevent.com/afap/sports/basketball/nbastars//Derrick%20Rose%20-%20Dunk.jpg";
        intent.putExtra("url",s);
        if(mEditText.getText().toString().equals(""))
            intent.putExtra("filename","bigdrose");
        else
        intent.putExtra("filename",mEditText.getText().toString());
        startService(intent);
        mEditText.setText("");
    }
}
