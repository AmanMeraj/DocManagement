package com.example.docmanagementapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.docmanagementapp.Model.Product;
import com.example.docmanagementapp.databinding.ProductRowBinding;
import com.example.docmanagementapp.databinding.RowAllAssetsBinding;

import java.util.ArrayList;

public class AdapterAllAssets extends RecyclerView.Adapter<AdapterAllAssets.ViewHolder>{
    public AdapterAllAssets(Context context, ArrayList<Product> data) {
        this.context = context;
        this.data = data;
    }

    Context context;
    String heading;
    private static AdapterProduct.ClickListener1 ClickListener1;
    ArrayList<Product>data;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(RowAllAssetsBinding.inflate(LayoutInflater.from(viewGroup.getContext()),
                viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
     viewHolder.binding.heading.setText(data.get(i).getHeading());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RowAllAssetsBinding binding;
        public ViewHolder(@NonNull RowAllAssetsBinding itemView) {
            super(itemView.getRoot());
            this.binding=itemView;
        }
    }
}
