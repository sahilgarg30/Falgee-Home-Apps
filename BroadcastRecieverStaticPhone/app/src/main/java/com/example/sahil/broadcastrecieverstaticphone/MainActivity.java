package com.example.sahil.broadcastrecieverstaticphone;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startBroadcast(View view) {
        Toast.makeText(MainActivity.this, "You will now be notified for all calls!", Toast.LENGTH_SHORT).show();
    }
}
