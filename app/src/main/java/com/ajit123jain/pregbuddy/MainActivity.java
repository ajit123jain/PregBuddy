package com.ajit123jain.pregbuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pusher.pushnotifications.PushNotifications;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PushNotifications.start(getApplicationContext(), "YOUR_INSTANCE_ID");
        PushNotifications.subscribe("hello");
    }
}
