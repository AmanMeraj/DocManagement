package com.example.docmanagementapp.Home;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.docmanagementapp.Adapter.AdapterBanners;
import com.example.docmanagementapp.AddAsset.FragmentAddAsset;
import com.example.docmanagementapp.AmcProvider.ActivityAmcProvider;
import com.example.docmanagementapp.InsurenceProvider.ActivityInsurenceProvider;
import com.example.docmanagementapp.Model.Banner;
import com.example.docmanagementapp.R;
import com.example.docmanagementapp.databinding.FragmentHomeBinding;
import java.util.ArrayList;
import me.relex.circleindicator.CircleIndicator3;

public class FragmentHome extends Fragment {
    FragmentHomeBinding binding;
    AdapterBanners adapterBanners;
    ArrayList<Banner> banner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();

        banner = new ArrayList<>();
        banner.add(new Banner(R.drawable.banner27));
        banner.add(new Banner(R.drawable.banner26));

        adapterBanners = new AdapterBanners(requireActivity(), banner);
        binding.viewpager.setAdapter(adapterBanners);

        CircleIndicator3 indicator = root.findViewById(R.id.indicator);
        indicator.setViewPager(binding.viewpager);

        scrollBannerAutomatically(banner);
        binding.amcRel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(requireActivity(),ActivityAmcProvider.class);
                startActivity(i);
            }
        });
        binding.insuranceRel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(requireActivity(), ActivityInsurenceProvider.class);
                startActivity(i);
            }
        });

        return root;
    }

    private void scrollBannerAutomatically(ArrayList<Banner> data) {
        Runnable runnable = new Runnable() {
            int page = 0;

            @Override
            public void run() {
                if (adapterBanners.getItemCount() == page) {
                    page = 0;
                } else {
                    page++;
                }
                if (page < data.size()) {
                    binding.viewpager.setCurrentItem(page, true);
                }
                binding.viewpager.postDelayed(this, 2000);
            }
        };
        binding.viewpager.post(runnable);
    }
}
