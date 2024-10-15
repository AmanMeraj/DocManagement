package com.example.docmanagementapp.Container;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.docmanagementapp.AddAsset.FragmentAddAsset;
import com.example.docmanagementapp.Products.FragmentProducts;
import com.example.docmanagementapp.Home.FragmentHome;
import com.example.docmanagementapp.Profile.ActivityProfile;
import com.example.docmanagementapp.Profile.FragmentProfile;
import com.example.docmanagementapp.R;
import com.example.docmanagementapp.Settings.FragmentSettings;
import com.example.docmanagementapp.Support.FragmentSupport;
import com.example.docmanagementapp.databinding.ActivityBottomNavigationBinding;
import com.google.android.material.navigation.NavigationBarView;

public class ActivityContainer extends AppCompatActivity {

    ActivityBottomNavigationBinding binding; // Assuming you have this binding class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBottomNavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNav.setOnItemSelectedListener(navListener);

        // Set HomeFragment as default
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_layout, new FragmentHome())
                    .commit();
        }
        binding.plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new FragmentAddAsset()).addToBackStack(null).commit();

            }
        });
        binding.profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivityContainer.this, ActivityProfile.class);
                startActivity(i);
            }
        });
    }




    private NavigationBarView.OnItemSelectedListener navListener =
            new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.home:
                            selectedFragment = new FragmentHome();
                            break;
                        case R.id.assets:
                            selectedFragment = new FragmentProducts();
                            break;
                        case R.id.support:
                            selectedFragment = new FragmentSupport();
                            break;
                        case R.id.settings:
                            selectedFragment = new FragmentSettings();
                            break;
                        case R.id.blank:
//                            selectedFragment= new FragmentAddAsset();
                            return  false;
                    }

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame_layout, selectedFragment)
                            .addToBackStack(null)
                            .commit();

                    return true;
                }
            };



    private void updateBottomNavigationView() {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.frame_layout);
        if (currentFragment instanceof FragmentHome) {
            binding.bottomNav.setSelectedItemId(R.id.home);
        } else if (currentFragment instanceof FragmentProducts) {
            binding.bottomNav.setSelectedItemId(R.id.assets);
        } else if (currentFragment instanceof FragmentSupport) {
            binding.bottomNav.setSelectedItemId(R.id.support);
        } else if (currentFragment instanceof FragmentSettings) {
            binding.bottomNav.setSelectedItemId(R.id.settings);
        } else if (currentFragment instanceof FragmentAddAsset) {
            binding.bottomNav.setSelectedItemId(R.id.blank);
        }
    }
}