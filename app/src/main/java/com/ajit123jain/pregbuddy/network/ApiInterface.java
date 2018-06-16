package com.ajit123jain.pregbuddy.network;

import com.ajit123jain.pregbuddy.model.LoginResponse;
import com.ajit123jain.pregbuddy.model.RegisterResponse;
import com.google.gson.JsonObject;


import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface ApiInterface {
    //Post Request for registering user
    @FormUrlEncoded
    @POST("register/json")
    Call<RegisterResponse> register(
            @Field("email") String user_email,
            @Field("password") String user_pass,
            @Field("apikey") String apikey);

    // Login via get request
    @GET("login/json")
    Call<LoginResponse> login(@QueryMap Map<String,String> params);

}

