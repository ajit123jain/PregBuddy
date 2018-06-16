package com.ajit123jain.pregbuddy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ajit123jain.pregbuddy.AlertDialogManager;
import com.ajit123jain.pregbuddy.R;
import com.ajit123jain.pregbuddy.utils.SharedPreferenceHelper;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PushNotifications.start(getApplicationContext(), "YOUR_INSTANCE_ID");
        PushNotifications.subscribe("hello");
    }*/
    // Alert Dialog Manager
    AlertDialogManager alert = new AlertDialogManager();

    // Session Manager Class
    SharedPreferenceHelper session;

    // Button Logout
    Button btnLogout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        session = new SharedPreferenceHelper(getApplicationContext());
        btnLogout = (Button) findViewById(R.id.btnLogout);
        Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();
        /**
         * Call this function whenever you want to check user login
         * This will redirect user to LoginActivity is he is not
         * logged in
         * */
        session.checkLogin();
        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                session.logoutUser();
            }
        });
    }

}

