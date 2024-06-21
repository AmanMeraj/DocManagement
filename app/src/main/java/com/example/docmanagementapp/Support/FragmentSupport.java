package com.example.docmanagementapp.Support;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.docmanagementapp.Adapter.AdapterSupport;
import com.example.docmanagementapp.Model.Support;
import com.example.docmanagementapp.R;
import com.example.docmanagementapp.databinding.FragmentSettingsBinding;
import com.example.docmanagementapp.databinding.FragmentSupportBinding;

import java.util.ArrayList;

public class FragmentSupport extends Fragment {
FragmentSupportBinding binding;
AdapterSupport adapterSupport;
ArrayList<Support>arrayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentSupportBinding.inflate(getLayoutInflater());
        View root=binding.getRoot();
        arrayList= new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Support obj1= new Support("Have any Queries ?");
            arrayList.add(obj1);
            Support obj2= new Support("Want to know about insurance ?");
            arrayList.add(obj2);
            Support obj3= new Support("Want to know about privacy policy ?");
            arrayList.add(obj3);
        }
        adapterSupport= new AdapterSupport(requireActivity(),arrayList);
        Log.d("TAG", "onCreateView: "+arrayList.size());
        binding.rcSupport.setAdapter(adapterSupport);

        return root;
    }
}