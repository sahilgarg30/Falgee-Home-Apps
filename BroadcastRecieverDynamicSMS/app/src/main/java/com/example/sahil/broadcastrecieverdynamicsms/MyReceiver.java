package com.example.sahil.broadcastrecieverdynamicsms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    // Get the object of SmsManager
    final SmsManager sms = SmsManager.getDefault();
    private TextView mPhoneTv = null;
    private TextView mMessageTv = null;
    private String message;
    private String phoneNumber;

    public MyReceiver(){}

    public MyReceiver(TextView MessageTv, TextView PhoneTv) {
        mMessageTv = MessageTv;
        mPhoneTv = PhoneTv;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        // Retrieves a map of extended data from the intent.
        final Bundle bundle = intent.getExtras();

        try {

            if (bundle != null) {

                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for (int i = 0; i < pdusObj.length; i++) {

                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    phoneNumber = currentMessage.getDisplayOriginatingAddress();
                    message = currentMessage.getDisplayMessageBody();
                    mPhoneTv.setText(phoneNumber);
                    mMessageTv.setText(message);
                    Toast.makeText(context, "New Message Recieved!", Toast.LENGTH_SHORT).show();
                    Log.i("SmsReceiver", "senderNum: "+ phoneNumber + "; message: " + message);
                    // Show Alert
                    /*int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context,
                            "senderNum: "+ phoneNumber + ", message: " + message, duration);
                    toast.show();*/
                } // end for loop
            } // bundle is null
        } catch (Exception e) {
        Log.e("SmsReceiver", "Exception smsReceiver" +e);
    }
}

    public String getPhone(){
        return phoneNumber;
    }

    public String getMessage(){
        return message;
    }
}
