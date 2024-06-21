package com.example.docmanagementapp.Products;

import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.docmanagementapp.Adapter.AdapterProduct;
import com.example.docmanagementapp.Model.Product;
import com.example.docmanagementapp.ProductListing.FragmentProductListing;
import com.example.docmanagementapp.R;
import com.example.docmanagementapp.databinding.FragmentProductsBinding;

import java.util.ArrayList;

public class FragmentProducts extends Fragment {
    FragmentProductsBinding binding;
    AdapterProduct adapterProduct;
    ArrayList<Product>arrayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentProductsBinding.inflate(getLayoutInflater());
        View root= binding.getRoot();
        arrayList= new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Product obj1= new Product("Master Refrigerator");
            arrayList.add(obj1);
            Product obj2= new Product("Master A/C");
            arrayList.add(obj2);
            Product obj3= new Product("Master Oven");
            arrayList.add(obj3);

        }
        adapterProduct= new AdapterProduct(getContext(),arrayList);
        binding.rcProducts.setAdapter(adapterProduct);
        adapterProduct.setOnItemClickListener1(Heading -> {
            FragmentProductListing frag= new FragmentProductListing();
            getParentFragmentManager().beginTransaction().replace(R.id.frame_layout,frag).addToBackStack(null).commit();
        });

        return root;
    }
}