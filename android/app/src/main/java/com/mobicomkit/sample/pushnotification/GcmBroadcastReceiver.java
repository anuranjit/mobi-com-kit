package com.mobicomkit.sample.pushnotification;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.mobicomkit.api.notification.MobiComPushReceiver;

public class GcmBroadcastReceiver extends BroadcastReceiver {


    private static final String TAG = "GcmBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "Received notification: " + intent.getExtras().toString());
        setResultCode(Activity.RESULT_OK);
        if (MobiComPushReceiver.isMobiComPushNotification(context, intent)) {
            Log.i(TAG, "Yes it is a MT notification....");
            MobiComPushReceiver.processMessageAsync(context, intent);
            return;
        }
    }

}