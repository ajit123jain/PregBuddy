package com.ajit123jain.pregbuddy.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ajit123jain.pregbuddy.R;
import com.ajit123jain.pregbuddy.network.MySingleton;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class BroadCastActivity extends AppCompatActivity {

    String APP_SERVER_URL = "http://192.168.1.4/fcmtest/fcm_insert.php";
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra("level",0);
            TextView textView = findViewById(R.id.level);
            ProgressBar progressBar = findViewById(R.id.progress);
            progressBar.setProgress(level);
            textView.setText(level+"");

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast);
       // registerReceiver(broadcastReceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        final Button token2 = findViewById(R.id.token);
        token2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences= getApplicationContext().getSharedPreferences(getString(R.string.FCM_PREF), Context.MODE_PRIVATE);
                final String token = sharedPreferences.getString(getString(R.string.FCM_TOKEN),"");
                Log.d("Token",token);
                StringRequest request = new StringRequest(Request.Method.POST, APP_SERVER_URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Response",response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params = new HashMap<>();
                        params.put("fcm_token",token);
                        return params;
                    }
                };
                MySingleton.getmInstance(BroadCastActivity.this).addToRequestQueue(request);
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
      //  unregisterReceiver(broadcastReceiver);
    }
}
