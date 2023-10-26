package com.example.proklimjobenlestari.Adaptor;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proklimjobenlestari.Domain.WisataDomain;
import com.example.proklimjobenlestari.R;
import com.example.proklimjobenlestari.ShowDetailActivity;

import java.util.ArrayList;

public class WisataAdaptor extends RecyclerView.Adapter<WisataAdaptor.ViewHolder> {
    private ArrayList<WisataDomain> wisataDomains;

    public WisataAdaptor(ArrayList<WisataDomain> wisataDomains) {
        this.wisataDomains = wisataDomains;
    }

    public void setFilteredList(ArrayList<WisataDomain> filteredList) {
        this.wisataDomains = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_wisata, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        // Ambil Nilai Title dan Desc Dari Wisata Domain Untuk di impor ke Wisata Activity
        holder.title.setText(wisataDomains.get(position).getTitle());
        holder.desc.setText(wisataDomains.get(position).getDescription());

        // Ambil Nilai Drawable dari Wisata Domain untuk di impor ke Wisata Activity
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(
                wisataDomains.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

        holder.wisataLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
                intent.putExtra("object",wisataDomains.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return wisataDomains.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, desc;
        ImageView pic;
        ConstraintLayout wisataLayout;
        WebView urlVideo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            pic = itemView.findViewById(R.id.pic);
            desc = itemView.findViewById(R.id.desc);
            wisataLayout = itemView.findViewById(R.id.wisataLayout);
            urlVideo = itemView.findViewById(R.id.ytView);
        }
    }
}
