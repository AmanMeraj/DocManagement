package com.example.docmanagementapp.AllAssets;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.docmanagementapp.Adapter.AdapterAllAssets;
import com.example.docmanagementapp.Adapter.AdapterProduct;
import com.example.docmanagementapp.Model.Product;
import com.example.docmanagementapp.R;
import com.example.docmanagementapp.databinding.FragmentAllAssetsBinding;

import java.util.ArrayList;

public class FragmentAllAssets extends Fragment {
    FragmentAllAssetsBinding binding;
    AdapterAllAssets adapterProduct;
    ArrayList<Product> arrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentAllAssetsBinding.inflate(getLayoutInflater());
        View root=binding.getRoot();
        arrayList= new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Product obj1= new Product("Master Refrigerator");
            arrayList.add(obj1);
            Product obj2= new Product("Master A/C");
            arrayList.add(obj2);
            Product obj3= new Product("Master Oven");
            arrayList.add(obj3);

        }
        adapterProduct= new AdapterAllAssets(getContext(),arrayList);
        binding.rcProducts.setAdapter(adapterProduct);

        return root;
    }
}