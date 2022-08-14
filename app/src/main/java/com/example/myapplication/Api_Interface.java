package com.example.myapplication;

import android.database.Observable;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

interface apiInterface {


//    @PATCH("alerts/{alert_id}/accept")
//    Observable<Response<Void>> accept_invited_alerts(@Header("X-Api-Token") String api_token, @Path("alert_id") int alert_id);
    @Headers({

            "Accept: application/json",
            "X-RapidAPI-Key: 9932740324msh6a9ddbc8c0def5bp11f8a7jsn2006718ededf",
            "X-RapidAPI-Host: exercisedb.p.rapidapi.com"


    })
    @GET("exercises")


    public Call<List<Exercise>> getExercise ();

}