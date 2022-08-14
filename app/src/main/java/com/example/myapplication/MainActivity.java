package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Exercise> FM = new ArrayList<>();
        try {
            TimeUnit.SECONDS.sleep(3);
           FM = fetchExercises.fetchexercise();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            TimeUnit.SECONDS.sleep(3);
            Toast.makeText(MainActivity.this , FM.get(0101).getBodyPart().toString() , Toast.LENGTH_LONG).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://exercisedb.p.rapidapi.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        apiInterface apiInterface = retrofit.create(apiInterface.class);
//        Call<List<Exercise>> call = apiInterface.getExercise();
//
//        call.enqueue(new Callback<List<Exercise>>() {
//            @Override
//            public void onResponse(  Call<List<Exercise>> call, retrofit2.Response<List<Exercise>> response) {
//           Toast.makeText(MainActivity.this , response.body().get(0101).getBodyPart().toString() , Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onFailure( Call<List<Exercise>> call, Throwable t) {
//                Toast.makeText(MainActivity.this , t.toString() , Toast.LENGTH_LONG).show();
//
//            }
//        });





    }
}