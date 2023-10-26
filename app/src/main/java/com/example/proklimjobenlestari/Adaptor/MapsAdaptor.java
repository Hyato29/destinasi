package com.example.proklimjobenlestari.Adaptor;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proklimjobenlestari.Domain.MapsDomain;
import com.example.proklimjobenlestari.R;
import com.example.proklimjobenlestari.ShowDetailMaps;

import java.util.ArrayList;

public class MapsAdaptor extends RecyclerView.Adapter<MapsAdaptor.ViewHolder> {
    private ArrayList<MapsDomain> mapsDomains;

    public MapsAdaptor(ArrayList<MapsDomain> mapsDomains) {
        this.mapsDomains = mapsDomains;
    }

    public void setFilteredList(ArrayList<MapsDomain> filteredList) {
        this.mapsDomains = filteredList;
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

        holder.title.setText(mapsDomains.get(position).getTitle());
        holder.desc.setText(mapsDomains.get(position).getDescription());

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(
                mapsDomains.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

        holder.mapsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailMaps.class);
                intent.putExtra("object",mapsDomains.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mapsDomains.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, desc;
        ImageView pic;
        ConstraintLayout mapsLayout;
        FrameLayout map;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            pic = itemView.findViewById(R.id.pic);
            desc = itemView.findViewById(R.id.desc);
            mapsLayout = itemView.findViewById(R.id.wisataLayout);
        }
    }
}
