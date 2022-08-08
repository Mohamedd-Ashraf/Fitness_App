package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;


import com.example.myapplication.databinding.ActivityBmiResultBinding;

public class BMI_Result extends AppCompatActivity {
    ActivityBmiResultBinding binding;

    String mBMI="26";
    float intBMI=26;
    String height;
    String weight;
    String age , gender;
    float intHeight , intWeight, intAge , intGender;
    RelativeLayout mBackground;
    Intent intent ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBmiResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mBackground = findViewById(R.id.content_layout) ;
        intent = getIntent();
        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");
        age = intent.getStringExtra("age");
        gender = intent.getStringExtra("gender");

        intWeight = Float.parseFloat(weight);
        intHeight = Float.parseFloat(height);

        intHeight=intHeight/100;
        mBMI =  Float.toString(intBMI);


        getSupportActionBar().hide();


        if (intBMI >16){
            binding.bmiCategory.setText("Serve Thiness");
            mBackground.setBackgroundColor(Color.RED);
            binding.imageView.setImageResource(R.drawable.ic_baseline_highlight_off_24);
        }
        else   if (intBMI <16.9&& intBMI>16){
            binding.bmiCategory.setText("Moderate Thiness");
            mBackground.setBackgroundColor(Color.YELLOW);
            binding.imageView.setImageResource(R.drawable.ic_baseline_info_24);
        }
        else   if (intBMI <25&& intBMI>18.4){
            binding.bmiCategory.setText("Normal");
//            mBackground.setBackgroundColor(Color.YELLOW);
            binding.imageView.setImageResource(R.drawable.ic_baseline_check_circle_outline_24);
        }
        else   if (intBMI <29.4&& intBMI>25){
            binding.bmiCategory.setText("Over Weight");
            mBackground.setBackgroundColor(Color.YELLOW);
            binding.imageView.setImageResource(R.drawable.ic_baseline_info_24);
        }

        else  {
            binding.bmiCategory.setText("obese Class");
            mBackground.setBackgroundColor(Color.YELLOW);
            binding.imageView.setImageResource(R.drawable.ic_baseline_info_24);
        }

        binding.genderDisplay.setText(gender);
        binding.bmiDisplay.setText(mBMI);

        binding.reCalculateBmi.setOnClickListener(view -> {
            startActivity(new Intent(this, MainActivity.class));
        });


    }
}