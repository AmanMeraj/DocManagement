package com.example.docmanagementapp.Signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.docmanagementapp.OTP.ActivityOtp;
import com.example.docmanagementapp.R;
import com.example.docmanagementapp.databinding.ActivitySigninBinding;

public class ActivitySignin extends AppCompatActivity {
ActivitySigninBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySigninBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivitySignin.this, ActivityOtp.class);
                startActivity(i);
            }
        });
    }
}