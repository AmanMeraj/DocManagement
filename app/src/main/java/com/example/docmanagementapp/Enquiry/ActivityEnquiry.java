package com.example.docmanagementapp.Enquiry;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.docmanagementapp.R;
import com.example.docmanagementapp.databinding.ActivityEnquiryBinding;

public class ActivityEnquiry extends AppCompatActivity {
ActivityEnquiryBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityEnquiryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}