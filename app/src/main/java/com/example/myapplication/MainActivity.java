package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

//todo Edit The Colors

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static void setTimeout(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://exercisedb.p.rapidapi.com/exercises/exercise/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

                    apiInterface apiInterface = retrofit.create(apiInterface.class);
                    Call<Exercise> call = apiInterface.getExercise();

                    call.enqueue(new Callback<Exercise>() {
                        @Override
                        public void onResponse(Call<Exercise> call, retrofit2.Response<Exercise> response) {
                Toast.makeText(MainActivity.this, response.body().getBodyPart() , Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(Call<Exercise> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
                        }
                    });










        Intent intent = new Intent(this,BMI_Page.class);
        startActivity(intent);


    }

}