package com.example.docmanagementapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.docmanagementapp.Enquiry.ActivityEnquiry;
import com.example.docmanagementapp.Model.Amc;
import com.example.docmanagementapp.databinding.RowAmcBinding;
import com.example.docmanagementapp.databinding.RowBannerBinding;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class AdapterAmc extends RecyclerView.Adapter<AdapterAmc.ViewHolder>{
    public AdapterAmc(ArrayList<Amc> data, Context context) {
        this.data = data;
        this.context = context;
    }

    ArrayList<Amc> data;
    Context context;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(RowAmcBinding.inflate(LayoutInflater.from(viewGroup.getContext()),
                viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.binding.heading.setText(data.get(i).getHeading());
        viewHolder.binding.subHeading.setText(data.get(i).getSubheading());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context, ActivityEnquiry.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        RowAmcBinding binding;
        public ViewHolder(@NonNull RowAmcBinding itemView) {
            super(itemView.getRoot());
            this.binding=itemView;
        }
    }
}
