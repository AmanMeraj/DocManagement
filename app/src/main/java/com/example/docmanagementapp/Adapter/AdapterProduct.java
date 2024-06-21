package com.example.docmanagementapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import com.example.docmanagementapp.Model.Product;
import com.example.docmanagementapp.ProductListing.FragmentProductListing;
import com.example.docmanagementapp.R;
import com.example.docmanagementapp.databinding.ProductRowBinding;

import java.util.ArrayList;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder>{

    public AdapterProduct(Context context, ArrayList<Product> data) {
        this.context = context;
        this.data = data;
    }

    Context context;
    String heading;
    private static ClickListener1 ClickListener1;
    ArrayList<Product>data;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(ProductRowBinding.inflate(LayoutInflater.from(viewGroup.getContext()),
                viewGroup, false));
    }

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

    public class ViewHolder extends RecyclerView.ViewHolder {
        ProductRowBinding binding;
        public ViewHolder(@NonNull ProductRowBinding itemView) {
            super(itemView.getRoot());
            this.binding=itemView;
        }
    }
    public interface ClickListener1 {
        void onItemClick1(String Heading);
    }

    public void setOnItemClickListener1(ClickListener1 clickListener1) {
        ClickListener1= clickListener1;

    }
}
