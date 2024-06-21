package com.example.docmanagementapp.ProductListing;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.docmanagementapp.Adapter.AdapterListing;
import com.example.docmanagementapp.Model.Product;
import com.example.docmanagementapp.Model.ProductListing;
import com.example.docmanagementapp.ProductsDetails.FragmentProductDetails;
import com.example.docmanagementapp.R;
import com.example.docmanagementapp.databinding.FragmentProductListingBinding;

import java.util.ArrayList;

public class FragmentProductListing extends Fragment {

FragmentProductListingBinding binding;
AdapterListing adapterListing;
ArrayList<ProductListing> arrayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding=FragmentProductListingBinding.inflate(getLayoutInflater());
       View root=binding.getRoot();
       arrayList= new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ProductListing obj1= new ProductListing("Refrigerator","Simple dummy text");
            arrayList.add(obj1);
            ProductListing obj2= new ProductListing("A/C","Simple dummy");
            arrayList.add(obj2);
            ProductListing obj3= new ProductListing("Oven","Text");
            arrayList.add(obj3);

        }
        adapterListing= new AdapterListing(requireActivity(),arrayList);
        binding.rcProductListing.setAdapter(adapterListing);
        adapterListing.setOnItemClickListener1(Heading -> {
            FragmentProductDetails frag= new FragmentProductDetails();
            getParentFragmentManager().beginTransaction().replace(R.id.frame_layout,frag).addToBackStack(null).commit();
        });

        return root;
    }
}