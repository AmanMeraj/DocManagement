package com.example.docmanagementapp.AddAssetDetail;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.docmanagementapp.AllAssets.FragmentAllAssets;
import com.example.docmanagementapp.R;
import com.example.docmanagementapp.databinding.FragmentAddAssetDetailBinding;

public class FragmentAddAssetDetail extends Fragment {

  FragmentAddAssetDetailBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentAddAssetDetailBinding.inflate(getLayoutInflater());
        View root= binding.getRoot();
        binding.submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentAllAssets frag= new FragmentAllAssets();
                getParentFragmentManager().beginTransaction().replace(R.id.frame_layout,frag).addToBackStack(null).commit();
            }
        });


        return root;
    }
}