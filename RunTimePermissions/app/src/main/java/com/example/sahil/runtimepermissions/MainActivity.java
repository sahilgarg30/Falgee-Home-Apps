package com.example.sahil.runtimepermissions;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addPermissions(View view) {
        if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CAMERA,Manifest.permission.CALL_PHONE},88);
        }
        else
        {
            Toast.makeText(MainActivity.this, "All permissions granted!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 88){
            if(grantResults.length > 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED && grantResults[1]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(MainActivity.this, "Both permissions granted!", Toast.LENGTH_SHORT).show();
            }
            else if(grantResults.length > 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(MainActivity.this, "Only camera permission granted!", Toast.LENGTH_SHORT).show();
            }
            else if(grantResults.length > 0 && grantResults[1]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(MainActivity.this, "Only calling phone permission granted!", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(MainActivity.this, "No permission granted!", Toast.LENGTH_SHORT).show();
        }
    }
}
