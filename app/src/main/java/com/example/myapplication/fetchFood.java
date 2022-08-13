package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.Toast;

//todo Edit The Colors

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class fetchFood {
   string name;

   

 public String fetch(string name) {
    this.name = name;
     Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://calorieninjas.p.rapidapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

            foodApiInterface foodApiInterface = retrofit.create(foodApiInterface.class);
            Call<Food> call = foodApiInterface.getFood();

            call.enqueue(new Callback<Food>() {
                @Override
                public void onResponse(Call<Food> call, retrofit2.Response<Food> response) {
                    return response.body();
                }

                @Override
                public void onFailure(Call<Food> call, Throwable t) {
                  Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
                }
            });

    }

    public String getName(){
        return  this.name;
    }
     
}
