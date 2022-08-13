package com.example.apitest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface apiInterface {
    @GET("nutrition?query="+ Food.getName())
    @Headers({
            "Accept: application/json",



    })



    public Call<Food> getFood ();

}
