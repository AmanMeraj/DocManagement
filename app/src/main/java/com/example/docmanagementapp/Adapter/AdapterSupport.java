package com.example.docmanagementapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.docmanagementapp.Model.Support;
import com.example.docmanagementapp.databinding.ProductRowBinding;
import com.example.docmanagementapp.databinding.RowSupportBinding;

import java.util.ArrayList;

public class AdapterSupport extends RecyclerView.Adapter<AdapterSupport.ViewHolder>{
    public AdapterSupport(Context context, ArrayList<Support> data) {
        this.context = context;
        this.data = data;
    }

    Context context;
    ArrayList<Support>data;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(RowSupportBinding.inflate(LayoutInflater.from(viewGroup.getContext()),
                viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
     viewHolder.binding.question.setText(data.get(i).getHeading());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RowSupportBinding binding;
        public ViewHolder(@NonNull RowSupportBinding itemView) {
            super(itemView.getRoot());
            this.binding=itemView;
        }
    }
}
