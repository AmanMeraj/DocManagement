package com.example.docmanagementapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.docmanagementapp.Model.ProductListing;
import com.example.docmanagementapp.databinding.ProductRowBinding;
import com.example.docmanagementapp.databinding.RowProductListingBinding;

import java.util.ArrayList;

public class AdapterListing extends RecyclerView.Adapter<AdapterListing.ViewHolder>{
    public AdapterListing(Context context, ArrayList<ProductListing> data) {
        this.context = context;
        this.data = data;
    }

    Context context;
    String heading;
    private static AdapterProduct.ClickListener1 ClickListener1;
    ArrayList<ProductListing> data;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(RowProductListingBinding.inflate(LayoutInflater.from(viewGroup.getContext()),
                viewGroup, false));    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
     viewHolder.binding.heading.setText(data.get(i).getHeading());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                heading=data.get(i).getHeading();
                ClickListener1.onItemClick1(heading);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        RowProductListingBinding binding;
        public ViewHolder(@NonNull RowProductListingBinding itemView) {
            super(itemView.getRoot());
                this.binding=itemView;
        }
    }
    public interface ClickListener1 {
        void onItemClick1(String Heading);
    }

    public void setOnItemClickListener1(AdapterProduct.ClickListener1 clickListener1) {
        ClickListener1= clickListener1;

    }
}
