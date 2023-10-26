package com.example.proklimjobenlestari.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proklimjobenlestari.Domain.RekomendasiDomain;
import com.example.proklimjobenlestari.R;

import java.util.ArrayList;

public class RekomendasiAdaptor extends RecyclerView.Adapter<RekomendasiAdaptor.ViewHolder>{
ArrayList<RekomendasiDomain> rekomendasiDomains;

    public RekomendasiAdaptor(ArrayList<RekomendasiDomain> rekomendasiDomains) {
        this.rekomendasiDomains = rekomendasiDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_rekomendasi,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.rekomendasiName.setText(rekomendasiDomains.get(position).getTitle());
        String picUrl = "";
        switch (position) {
            case 0: {
                picUrl = "cat_1";
                holder.homeLayout.setBackground(ContextCompat.getDrawable(
                        holder.itemView.getContext(), R.drawable.cat_background1));
                break;
            }
            case 1: {
                picUrl = "cat_2";
                holder.homeLayout.setBackground(ContextCompat.getDrawable(
                        holder.itemView.getContext(), R.drawable.cat_background2));
                break;
            }
            case 2: {
                picUrl = "cat_3";
                holder.homeLayout.setBackground(ContextCompat.getDrawable(
                        holder.itemView.getContext(), R.drawable.cat_background3));
                break;
            }
            case 3: {
                picUrl = "cat_4";
                holder.homeLayout.setBackground(ContextCompat.getDrawable(
                        holder.itemView.getContext(), R.drawable.cat_background4));
                break;
            }
        }
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(
                picUrl, "drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.rekomendasiPic);
    }

    @Override
    public int getItemCount() {
        return rekomendasiDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
        TextView rekomendasiName;
        ImageView rekomendasiPic;
        ConstraintLayout homeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rekomendasiName = itemView.findViewById(R.id.rekomendasiName);
            rekomendasiPic = itemView.findViewById(R.id.rekomendasiPic);
            homeLayout = itemView.findViewById(R.id.homeLayout);
        }

    }
}
