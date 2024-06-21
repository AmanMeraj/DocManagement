package com.example.docmanagementapp.Settings;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.docmanagementapp.Adapter.AdapterNotification;
import com.example.docmanagementapp.AmcProvider.ActivityAmcProvider;
import com.example.docmanagementapp.Notification.ActivityNotification;
import com.example.docmanagementapp.R;
import com.example.docmanagementapp.databinding.FragmentSettingsBinding;

public class FragmentSettings extends Fragment {
FragmentSettingsBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentSettingsBinding.inflate(getLayoutInflater());
        View root=binding.getRoot();

        binding.relativeNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(requireActivity(), ActivityNotification.class);
                startActivity(i);

            }
        });
        return  root;
    }
}