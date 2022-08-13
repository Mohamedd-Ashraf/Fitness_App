package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

    interface apiInterface {

    @Headers({

            "Accept: application/json",
            "X-RapidAPI-Key: 9932740324msh6a9ddbc8c0def5bp11f8a7jsn2006718ededf",
            "X-RapidAPI-Host: exercisedb.p.rapidapi.com"


    })
        @GET("1315")


    public Call<Exercise> getExercise ();

}
