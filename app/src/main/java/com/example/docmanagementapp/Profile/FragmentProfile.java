package com.example.docmanagementapp.Profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.docmanagementapp.R;
import com.example.docmanagementapp.databinding.FragmentProductsBinding;
import com.example.docmanagementapp.databinding.FragmentProfileBinding;

public class FragmentProfile extends Fragment {
    FragmentProfileBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentProfileBinding.inflate(getLayoutInflater());
       View root= binding.getRoot();


        return root;
    }
}