package com.ajit123jain.pregbuddy.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ajit123jain.pregbuddy.R;
import com.ajit123jain.pregbuddy.network.ApiClient;
import com.ajit123jain.pregbuddy.network.ApiInterface;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.pusher.pushnotifications.api.RegisterResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterationActivity extends AppCompatActivity {
   // SignUpResponse signUpResponsesData;
    EditText email, password, name;
    Button signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        // init the EditText and Button
        name = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        signUp = (Button) findViewById(R.id.signUp);
        // implement setOnClickListener event on sign up Button
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // validate the fields and call sign method to implement the api
                if (validate(name) && validate(email) && validate(password)) {
                    signUp();
                }
            }
        });
    }

    private boolean validate(EditText editText) {
        // check the lenght of the enter data in EditText and give error if its empty
        if (editText.getText().toString().trim().length() > 0) {
            return true; // returs true if field is not empty
        }
        editText.setError("Please Fill This");
        editText.requestFocus();
        return false;
    }

    private void signUp() {
        // display a progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(RegisterationActivity.this);
        progressDialog.setCancelable(false); // set cancelable to false
        progressDialog.setMessage("Please Wait"); // set message
        progressDialog.show(); // show progress dialog

        // Api is a class in which we define a method getClient() that returns the API Interface class object
        // registration is a POST request type method in which we are sending our field's data
       /* Api.getClient().registration(name.getText().toString().trim(),
                email.getText().toString().trim(),
                password.getText().toString().trim(),
                "email", new Callback<SignUpResponse>() {*/
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        apiService.register(email.getText().toString().trim(),
                password.getText().toString().trim(),getResources().getString(R.string.apikey)).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                Log.d("Response",new Gson().toJson(response.body()));
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

            }
        });

    }
}
