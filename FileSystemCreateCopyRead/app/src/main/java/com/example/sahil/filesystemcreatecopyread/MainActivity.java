package com.example.sahil.filesystemcreatecopyread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Objects;

public class MainActivity extends Activity {

    private EditText mNameEt;
    private EditText mDataEt;
    private String filename;
    private String dataname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNameEt = (EditText)findViewById(R.id.editText);
        mDataEt = (EditText)findViewById(R.id.editText2);
    }

    public void createFile(View view) {
        filename = mNameEt.getText().toString();
        dataname = mDataEt.getText().toString();
        try{
            File f = new File(getFilesDir(),mNameEt.getText().toString()+".txt");
            if(!f.exists()){
                f.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(f);
            byte[] b = mDataEt.getText().toString().getBytes();
            fos.write(b);
            fos.flush();
            fos.close();
            Toast.makeText(MainActivity.this, "File created successfully in internal storage!", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void copyFile(View view) {
        File src = new File(getFilesDir(),filename+".txt");
        if(!src.exists() || !filename.equals(mNameEt.getText().toString()))
        {
            Toast.makeText(MainActivity.this, "File does not exist in internal storage!", Toast.LENGTH_SHORT).show();
        }
        else {
            try {
                File dest = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), src.getName());
                if (!dest.exists()) {
                    dest.createNewFile();
                }
                FileInputStream fin = new FileInputStream(src);
                FileOutputStream fout = new FileOutputStream(dest);
                byte[] buf = new byte[1024];
                int len;
                while ((len = fin.read(buf)) > 0) {
                    fout.write(buf, 0, len);
                }
                fin.close();
                fout.close();
                Toast.makeText(MainActivity.this, "File copied successfully to DOWNLOADS folder!", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void readData(View view) {
        File src = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),filename+".txt");
        if(!src.exists() || !filename.equals(mNameEt.getText().toString()))
        {
            Toast.makeText(MainActivity.this, "File does not exist in external storage!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            try{
                int length = (int)src.length();
                byte[] b = new byte[length];
                FileInputStream fin = new FileInputStream(src);
                fin.read(b);
                fin.close();
                String data = new String(b);
                Toast.makeText(MainActivity.this,data, Toast.LENGTH_LONG).show();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
