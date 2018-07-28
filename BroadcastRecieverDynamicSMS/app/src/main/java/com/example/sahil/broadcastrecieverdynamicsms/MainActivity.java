package com.example.sahil.broadcastrecieverdynamicsms;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.provider.Telephony;
import android.provider.Telephony.Sms;
import android.widget.TextView;

public class MainActivity extends Activity {

    private MyReceiver mMyReciever;
    private IntentFilter mIntentFilter;
    private TextView mMessageTv;
    private TextView mPhoneTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageTv = (TextView)findViewById(R.id.message_tv);
        mPhoneTv = (TextView)findViewById(R.id.number_tv);

        mMyReciever = new MyReceiver(mMessageTv,mPhoneTv);
        mIntentFilter = new IntentFilter();
        mIntentFilter.setPriority(999);
        mIntentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(mMyReciever,mIntentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mMyReciever);
    }
}
