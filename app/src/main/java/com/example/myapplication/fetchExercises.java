package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.Toast;

//todo Edit The Colors

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;








public class fetchExercises {
 
public Exercise fetch(){

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://exercisedb.p.rapidapi.com/exercises")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

            apiInterface apiInterface = retrofit.create(apiInterface.class);
            Call<Exercise> call = apiInterface.getExercise();

            call.enqueue(new Callback<Exercise>() {
                @Override
                public void onResponse(Call<Exercise> call, retrofit2.Response<Exercise> response) {
                    return response.body();
                }

                @Override
                public void onFailure(Call<Exercise> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
                return ;
                }
            });
    }
}



}
