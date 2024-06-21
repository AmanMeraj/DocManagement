package com.example.docmanagementapp.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.docmanagementapp.Model.Banner;
import com.example.docmanagementapp.databinding.RowBannerBinding;
import com.facebook.shimmer.Shimmer;
import com.facebook.shimmer.ShimmerDrawable;
import org.jetbrains.annotations.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class AdapterBanners extends RecyclerView.Adapter<AdapterBanners.ViewHolder> {
    private static ClickListener1 ClickListener1;
    private Context context;
    private OnBannerClick onClick;
  ArrayList<Banner> banner;
    public AdapterBanners(Context activity, ArrayList<Banner> banner) {
        this.context = activity;
        this. banner= banner;
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(RowBannerBinding.inflate(LayoutInflater.from(viewGroup.getContext()),
                viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NotNull ViewHolder holder, final int i) {

        Shimmer shimmer = new Shimmer.AlphaHighlightBuilder()// The attributes for a ShimmerDrawable is set by this builder
                .setDuration(800) // how long the shimmering animation takes to do one full sweep
                .setBaseAlpha(0.9f) //the alpha of the underlying children
                .setHighlightAlpha(0.8f) // the shimmer alpha amount
                .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
                .setAutoStart(true)
                .build();

        ShimmerDrawable shimmerDrawable = new ShimmerDrawable();
        shimmerDrawable.setShimmer(shimmer);
        //if (banner!=null) {

            Glide.with(context)
                    .load(banner.get(i).getImage())
                    .placeholder(shimmerDrawable)
                    .centerCrop()
                    .into(holder.binding.img);
            //holder.binding.jodichart.setText((CharSequence)arrayList.get(position));
      //  }





// This is the placeholder for the imageView
//        ShimmerDrawable shimmerDrawable = new ShimmerDrawable();
//        shimmerDrawable.setShimmer(shimmer);
//
//        Log.d("TAGJWD", "onBindViewHolder: "+banner.get(i).image);
//        Glide.with(context)
//                .load(banner.get(i).image)
//                .placeholder(shimmerDrawable)
//                .into(holder.binding.img);
//        holder.binding.id.setText(Integer.toString(banner.get(i).id));
//        holder.binding.shopid.setText(Integer.toString(banner.get(i).shop_id));
//        holder.binding.typeId.setText(Integer.toString(banner.get(i).type_id));
//        holder.binding.type.setText(banner.get(i).type);
//
//        String type= holder.binding.type.getText().toString();







    }

    @Override
    public int getItemCount() {
        return banner.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        RowBannerBinding binding;
        public ViewHolder(RowBannerBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;

        }
    }

    public void showMessageDialog(String title, String desc) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setTitle(title);
        builder1.setMessage(desc);
        builder1.setCancelable(false);
        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert11 = builder1.create();
        alert11.show();
    }




    public interface ClickListener1 {
        void onItemClick1(int i, int position, View v);
    }


    public void setOnItemClickListener1(ClickListener1 clickListener1) {
        ClickListener1= clickListener1;

    }

    public interface OnBannerClick {
        void onBannerItemClick(View view, int position, String related_to, int exam_id);
    }

    public void setOnClick(final OnBannerClick itemClickListener) {
        this.onClick = itemClickListener;
    }

    private String parseDate(String time) {
        String inputPattern = "HH:mm:ss";
        String outputPattern = "hh:mm a";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.getDefault());
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern, Locale.getDefault());
        Date date;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }


}
