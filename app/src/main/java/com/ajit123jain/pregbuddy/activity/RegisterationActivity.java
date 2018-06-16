package com.ajit123jain.pregbuddy.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ajit123jain.pregbuddy.R;
import com.ajit123jain.pregbuddy.model.RegisterResponse;
import com.ajit123jain.pregbuddy.network.ApiClient;
import com.ajit123jain.pregbuddy.network.ApiInterface;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterationActivity extends AppCompatActivity {
    EditText email, password, name;
    Button signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        name = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        signUp = (Button) findViewById(R.id.signUp);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // validate the fields and call sign method to implement the api
                if (validate(email) && validate(password)) {
                    signUp();
                }
            }
        });
    }

    private boolean validate(EditText editText) {
        if (editText.getText().toString().trim().length() > 0) {
            return true;
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
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        apiService.register(email.getText().toString().trim(),
                password.getText().toString().trim(),getResources().getString(R.string.apikey)).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                Log.d("Response",new Gson().toJson(response.body()));
                if(response.body().getApimessage().equals("OK")){
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(),response.body().getApimessage(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Please Connect to the internet",Toast.LENGTH_LONG).show();
            }
        });

    }
}
