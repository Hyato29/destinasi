package com.example.proklimjobenlestari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;

import android.os.Bundle;
import android.widget.TextView;

import com.example.proklimjobenlestari.Adaptor.PopularAdaptor;
import com.example.proklimjobenlestari.Adaptor.RekomendasiAdaptor;
import com.example.proklimjobenlestari.Domain.PopularDomain;
import com.example.proklimjobenlestari.Domain.RekomendasiDomain;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter, adapter2;
private RecyclerView recyclerViewRekomendasiList, recyclerViewPopularList;
private TextView orderBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerViewRekomendasiList();
        recyclerViewPopularList();

        orderBtn = findViewById(R.id.orderBtn);
        orderBtn.setOnClickListener(v ->
                startActivity(new Intent(HomeActivity.this, WisataActivity.class)));

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.bottom_home){
                return true;
            }
            else if (item.getItemId() == R.id.bottom_potensi) {
                startActivity(new Intent(getApplicationContext(), WisataActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }
            else if (item.getItemId() == R.id.bottom_tiket) {
                startActivity(new Intent(getApplicationContext(), MapsActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }
            return false;
        });
    }

    private void recyclerViewRekomendasiList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewRekomendasiList = findViewById(R.id.recyclerView);
        recyclerViewRekomendasiList.setLayoutManager(linearLayoutManager);

        ArrayList<RekomendasiDomain> rekomendasi = new ArrayList<>();
        rekomendasi.add(new RekomendasiDomain("Pantai Pink","cat_2"));
        rekomendasi.add(new RekomendasiDomain("Pantai Kuta", "cat_1"));
        rekomendasi.add(new RekomendasiDomain("Senggigi", "cat_3"));
        rekomendasi.add(new RekomendasiDomain("Tanjung Aan", "cat_4"));
        adapter = new RekomendasiAdaptor(rekomendasi);
        recyclerViewRekomendasiList.setAdapter(adapter);
    }

    private void recyclerViewPopularList(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView3);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<PopularDomain> popularList = new ArrayList<>();
        popularList.add(new PopularDomain("Pantai Kuta",  "pop_1kuta"));
        popularList.add(new PopularDomain("Pantai Pink", "pop_2pink"));
        popularList.add(new PopularDomain("Pantai Senggigi", "pop_3senggigi"));

        adapter2 = new PopularAdaptor(popularList);
        recyclerViewPopularList.setAdapter(adapter2);
    }
}