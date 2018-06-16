package com.ajit123jain.pregbuddy.network;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded    // annotation that used with POST type request
    @POST("register/json") // specify the sub url for our base url
    Call<JsonObject> login(
            @Field("email") String user_email,
            @Field("password") String user_pass);

    @FormUrlEncoded    // annotation that used with POST type request
    @POST("login/json") // specify the sub url for our base url
    Call<JsonObject> register(
            @Field("username") String user_email,
            @Field("password") String user_pass);

}

