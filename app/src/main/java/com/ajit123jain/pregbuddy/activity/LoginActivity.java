package com.ajit123jain.pregbuddy.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ajit123jain.pregbuddy.AlertDialogManager;
import com.ajit123jain.pregbuddy.R;
import com.ajit123jain.pregbuddy.model.LoginResponse;
import com.ajit123jain.pregbuddy.network.ApiClient;
import com.ajit123jain.pregbuddy.network.ApiInterface;
import com.ajit123jain.pregbuddy.utils.SharedPreferenceHelper;
import com.google.gson.Gson;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText txtUsername, txtPassword;
    Button btnLogin,btnRegister;
    AlertDialogManager alert = new AlertDialogManager();
    SharedPreferenceHelper session;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        session = new SharedPreferenceHelper(getApplicationContext());
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        Toast.makeText(getApplicationContext(), "User LoginActivity Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();
        // LoginActivity button click event
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();
                // Check if username, password is filled
                if (username.trim().length() > 0 && password.trim().length() > 0) {
                    login(username.trim(), password.trim());
                } else {
                    Toast.makeText(getApplicationContext(),"Please write Username and password",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RegisterationActivity.class));
                finish();
            }
        });
    }
    //login user and sed to the main Activity
    private void login(final String username, String password) {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        HashMap<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        Log.d("Username:"+username,"Password:"+password);
        params.put("apikey",getResources().getString(R.string.apikey));
        apiService.login(params).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                 if (response.body().getApimessage().equals("OK")){
                     session.createLoginSession(username,username);
                     Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                     finish();
                 }
                 else {
                    Toast.makeText(getApplicationContext(),response.body().getApimessage(),Toast.LENGTH_LONG).show();
                 }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.e("Result",t.getMessage());
                Log.e("Result",t.toString());
                Toast.makeText(getApplicationContext(),"please connect to the internet",Toast.LENGTH_LONG).show();

            }
        });
    }

}
