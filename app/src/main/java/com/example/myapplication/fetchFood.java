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
    String name;

    foodInfo[]  food= new foodInfo[10] ;

    public foodInfo[] fetchfood() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://calorieninjas.p.rapidapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        foodApiInterface foodApiInterface = retrofit.create(foodApiInterface.class);
        Call<Food> call = foodApiInterface.getFood();

        call.enqueue(new Callback<Food>() {
            @Override
            public void onResponse(Call<Food> call, retrofit2.Response<Food> response) {
                food= response.body().getItems();
            }

            @Override
            public void onFailure(Call<Food> call, Throwable t) {

            }
        });
        return food;
    }

    public String getName(){
        return  this.name;
    }

}
