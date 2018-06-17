package com.ajit123jain.pregbuddy.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.ajit123jain.pregbuddy.R;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class FcmInstanceIDService extends FirebaseInstanceIdService{
    @Override
    public void onTokenRefresh() {
        String recent_token = FirebaseInstanceId.getInstance().getToken();
        SharedPreferences sharedPreferences= getApplicationContext().getSharedPreferences(getString(R.string.FCM_PREF), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Log.d("Token1",recent_token);
        editor.putString(getString(R.string.FCM_TOKEN),recent_token);
        editor.commit();

    }
}
