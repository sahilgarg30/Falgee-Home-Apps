package com.example.sahil.broadcastrecieverstaticphone;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        String incomingnumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
        Notification.Builder mBuilder = new Notification.Builder(context);
        mBuilder.setContentTitle("Incoming Phone call!");
        mBuilder.setContentText(incomingnumber + " is calling.");
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        NotificationManager manager = (NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
        manager.notify(5,mBuilder.build());
    }
}
