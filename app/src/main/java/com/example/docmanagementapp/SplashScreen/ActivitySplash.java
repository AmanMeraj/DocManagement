package com.example.docmanagementapp.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.docmanagementapp.Signin.ActivitySignin;
import com.example.docmanagementapp.databinding.ActivitySplashBinding;

public class ActivitySplash extends AppCompatActivity {
ActivitySplashBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(ActivitySplash.this, ActivitySignin.class);
            startActivity(intent);
            finish(); // Close the splash screen activity
        }, 3000);
    }
}