package com.example.sahil.intentservicedownloadimage;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = (EditText)findViewById(R.id.editText);
    }

    public void downloadImage(View view) {

        Intent intent = new Intent(MainActivity.this,MyService.class);
        String s = "http://orig04.deviantart.net/9e8c/f/2013/059/8/e/derrick_rose_poster_edit_by_gaxelstudios-d5whx8i.jpg";
        intent.putExtra("url",s);
        if(mEditText.getText().toString().equals(""))
            intent.putExtra("filename","drose");
        else
            intent.putExtra("filename",mEditText.getText().toString());

        String s1 = "http://photos.imageevent.com/afap/sports/basketball/nbastars//Derrick%20Rose%20-%20Dunk.jpg";
        intent.putExtra("url2",s1);
        if(mEditText.getText().toString().equals(""))
            intent.putExtra("filename2","bigdrose");
        else
            intent.putExtra("filename2",mEditText.getText().toString());

        startService(intent);
        mEditText.setText("");
    }
}
