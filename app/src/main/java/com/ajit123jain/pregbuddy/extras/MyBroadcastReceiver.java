package com.ajit123jain.pregbuddy.extras;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.util.Log;

public class MyBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "MyBroadCastReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        StringBuilder s = new StringBuilder("");
        s.append("Action :"+intent.getAction());
        s.append("Uri :"+intent.toUri(Intent.URI_INTENT_SCHEME));
        Log.e(TAG,s.toString());
    }
}
