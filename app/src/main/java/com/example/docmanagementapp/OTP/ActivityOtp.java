package com.example.docmanagementapp.OTP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.docmanagementapp.Container.ActivityContainer;
import com.example.docmanagementapp.databinding.ActivityOtpBinding;

public class ActivityOtp extends AppCompatActivity {
ActivityOtpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivityOtp.this, ActivityContainer.class);
                startActivity(i);
            }
        });
    }
}