package com.delivery.chaze.chazedelivery.Retrofit;

import com.delivery.chaze.chazedelivery.models.User;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    //@Headers("Content-Type: application/json")
    @FormUrlEncoded
    @POST("/check/")
    Call<Void> verify_user(@Field("phone_no") String phone_no,
                           @Field("password") String password);
}
