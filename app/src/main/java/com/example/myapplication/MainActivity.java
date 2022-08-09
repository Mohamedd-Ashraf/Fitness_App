package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;

//todo Edit The Colors

import com.example.myapplication.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    int intialWeight = 50;
    int intialِAge= 20;
    int intialHeight = 170;
    boolean everyThingIsRigyt = true;
    String currentHeaight = "170";
    String currentWeight = "50";
    String typeOfUser = "0";
    String currentAge= "20";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        binding.calculateBmi.setOnClickListener(view -> {
            calculateBmi();
        });
        binding.male.setOnClickListener(view -> {
            binding.male.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.card_back_plus_minus));
            binding.female.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.card_back));
            typeOfUser = "Male";

        });
        binding.female.setOnClickListener(view -> {
            binding.female.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.card_back_plus_minus));
            binding.male.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.card_back));
            typeOfUser = "Female";

        });
        binding.seekbar.setMax(280);
        binding.seekbar.setProgress(170);
        binding.seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                intialHeight = i;
                currentHeaight = String.valueOf(intialHeight);
                binding.currentHeight.setText(currentHeaight);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
        binding.incrementAge.setOnClickListener(view -> {
            intialِAge = intialِAge+1;
            currentAge= String.valueOf(intialِAge);
            binding.currentAge.setText(currentAge);
        });
        binding.decrementAge.setOnClickListener(view -> {
            intialِAge = intialِAge-1;
            currentAge= String.valueOf(intialِAge);
            binding.currentAge.setText(currentAge);
        });
        binding.incrementWeight.setOnClickListener(view -> {
            intialWeight = intialWeight+1;
            currentWeight= String.valueOf(intialWeight);
            binding.currentWeight.setText(currentWeight);
        });
        binding.decrementWeight.setOnClickListener(view -> {
            intialWeight = intialWeight-1;
            currentWeight= String.valueOf(intialWeight);
            binding.currentWeight.setText(currentWeight);
        });
    }

    private void calculateBmi() {
        if(typeOfUser.equals("0")){
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            everyThingIsRigyt = false;
        }
        if (intialHeight <= 0 || currentHeaight.equals("0")){
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            everyThingIsRigyt = false;
        }
        if  (intialWeight<=0|| currentWeight.equals("0")){
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            everyThingIsRigyt = false;
        }
        if (currentAge.equals("0")||intialِAge<=0){
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            everyThingIsRigyt = false;
        }
        if (everyThingIsRigyt){
            Intent intent = new Intent(this,BMI_Result.class);
            intent.putExtra("gender", typeOfUser);
            intent.putExtra("height",currentHeaight );
            intent.putExtra("weight", currentWeight);
            intent.putExtra("age", currentAge);

            startActivity(intent);

        }
        else {
            everyThingIsRigyt = true;
        }

    }
}