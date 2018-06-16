package com.ajit123jain.pregbuddy.network;

import com.google.gson.JsonObject;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface ApiInterface {
    @FormUrlEncoded    // annotation that used with POST type request
    @POST("register/json") // specify the sub url for our base url
    Call<JsonObject> login(
            @Field("email") String user_email,
            @Field("password") String user_pass,
            @Field("apikey") String apikey);

    // annotation that used with POST type request
    @GET("login/json") // specify the sub url for our base url
    Call<JsonObject> register(@QueryMap Map<String,String> params);

}

