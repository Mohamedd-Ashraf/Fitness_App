package com.example.myapplication;


import android.widget.Toast;

//todo Edit The Colors

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;








public class fetchExercises {
    static List<Exercise>   exercise= new ArrayList() ;
    public static List<Exercise> fetchexercise() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://exercisedb.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface apiInterface = retrofit.create(apiInterface.class);
        Call<List<Exercise>> call = apiInterface.getExercise();

        call.enqueue(new Callback<List<Exercise>>() {
            @Override
            public void onResponse(Call<List<Exercise>> call, retrofit2.Response<List<Exercise>> response) {

                List<Exercise>   mm = response.body();

            exercise = mm;
            }

            @Override
            public void onFailure(Call<List<Exercise>> call, Throwable t) {
                exercise = null;
            }
        });
        try {
            TimeUnit.SECONDS.sleep(3);
            return exercise;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
return exercise;
    }}




