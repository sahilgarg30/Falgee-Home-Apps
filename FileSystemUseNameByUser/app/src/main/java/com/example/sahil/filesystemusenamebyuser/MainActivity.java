package com.example.sahil.filesystemusenamebyuser;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends Activity {

    private EditText mDataEt;
    private EditText mNameEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNameEt = (EditText)findViewById(R.id.editText);
        mDataEt = (EditText)findViewById(R.id.editText2);
    }

    public void createFile(View view) {
        try {
            File f = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),mNameEt.getText().toString()+".txt");
            if(!f.exists())
            {
                f.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(f);
            byte[] b  = mDataEt.getText().toString().getBytes();
            fos.write(b);
            fos.flush();
            fos.close();
            Toast.makeText(MainActivity.this, "File is successfully created!", Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            e.printStackTrace();
        }
        mNameEt.setText("");
        mDataEt.setText("");

    }
}
