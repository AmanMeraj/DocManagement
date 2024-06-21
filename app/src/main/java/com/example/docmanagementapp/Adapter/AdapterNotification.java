package com.example.docmanagementapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.docmanagementapp.Model.Amc;
import com.example.docmanagementapp.databinding.RowAmcBinding;
import com.example.docmanagementapp.databinding.RowNotificationBinding;

import java.util.ArrayList;

public class AdapterNotification extends RecyclerView.Adapter<AdapterNotification.ViewHolder>{
    public AdapterNotification(ArrayList<Amc> data, Context context) {
        this.data = data;
        this.context = context;
    }

    ArrayList<Amc> data;
    Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(RowNotificationBinding.inflate(LayoutInflater.from(viewGroup.getContext()),
                viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.binding.heading.setText(data.get(i).getHeading());
        viewHolder.binding.subHeading.setText(data.get(i).getSubheading());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        RowNotificationBinding binding;
        public ViewHolder(@NonNull RowNotificationBinding itemView) {
            super(itemView.getRoot());
            this.binding=itemView;
        }
    }
}
