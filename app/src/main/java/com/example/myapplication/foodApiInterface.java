package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;




import com.example.myapplication.Food;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface foodApiInterface {
    String query = "nutrition?query=";
    String food ="tomato";

    @Headers({
            "Accept: application/json",
            "X-RapidAPI-Key: 9932740324msh6a9ddbc8c0def5bp11f8a7jsn2006718ededf",
            "X-RapidAPI-Host: calorieninjas.p.rapidapi.com",



    })
    @GET("nutrition?query=tomato")


    public Call<Food> getFood ();

}