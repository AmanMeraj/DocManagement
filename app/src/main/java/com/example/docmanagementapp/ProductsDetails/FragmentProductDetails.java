package com.example.docmanagementapp.ProductsDetails;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.docmanagementapp.R;
import com.example.docmanagementapp.databinding.FragmentProductDetailsBinding;

public class FragmentProductDetails extends Fragment {
    FragmentProductDetailsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentProductDetailsBinding.inflate(getLayoutInflater());
        View root=binding.getRoot();


        return root;
    }
}