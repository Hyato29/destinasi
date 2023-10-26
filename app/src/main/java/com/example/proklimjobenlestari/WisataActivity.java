package com.example.proklimjobenlestari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.proklimjobenlestari.Adaptor.WisataAdaptor;
import com.example.proklimjobenlestari.Domain.WisataDomain;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class WisataActivity extends AppCompatActivity {
    private WisataAdaptor adapter2;
    private RecyclerView recyclerViewWisataList;
    private ArrayList<WisataDomain> wisataList;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata);

        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_potensi);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_home) {
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.bottom_potensi) {
                return true;
            } else if (item.getItemId() == R.id.bottom_tiket) {
                startActivity(new Intent(getApplicationContext(), MapsActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }
            return false;
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewWisataList = findViewById(R.id.recyclerView2);
        recyclerViewWisataList.setLayoutManager(linearLayoutManager);

        wisataList = new ArrayList<>();
        wisataList.add(new WisataDomain("Pantai Kuta", "pop_1kuta", "Pesona Pantai \n yang Eksotis",
                getString(R.string.descKuta), "Parkiran yang luas, Penginapan, Jetski dan Watersport lainnya, Bukit Mandalika, Snorkling, dan Menyakiskan Ritual Bau Nyale.", "18 Km dari Bandara Internasional Lombok",
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/no5dtX9ZQik\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"));
        wisataList.add(new WisataDomain("Pantai Pink", "pop_2pink", "Keajaiban Pantai \n Berpasir Merah",
                getString(R.string.descPink),"Snorkeling, Berenang, Hunting Foto, Bakar Ikan, dan Camping.", "56 Km dari Bandara Internasional Lombok",
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/cYPkoWyOz94?start=8\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe><iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/cYPkoWyOz94?start=8\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"));
        wisataList.add(new WisataDomain("Pantai Senggigi", "pop_3senggigi", "Keindahan \n Pantai dan Sunset",
                getString(R.string.descSenggigi), "Bersantai di tepi Pantai, Berswa Foto, Berselancar, dan Snorkeling.", "51 Km dari Bandara Internasional Lombok",
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/8y3Dr5iEEHc?start=25\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"));
        wisataList.add(new WisataDomain("Pantai Tanjung Aan", "pop_4tanjungaan", "Keindahan Pasir \n Putih dan Air Jernih",
                getString(R.string.descTanjungAan), "Berenang, Snorkeling, Berselancar, Mendaki Bukit, dan Melihat Sunset", "22 Km dari Bandara Internasional Lombok",
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/9f8UdBeBAH4?start=114\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"));
        wisataList.add(new WisataDomain("Pantai Kura-Kura", "pop_5kurakura", "Pantai dan Batu dengan \n Rupa Kura-Kura",
                getString(R.string.descKuraKura),"Swafoto, Camping, Selancar, dan Berenang.", "52 Km dari Bandara Internasional Lombok",
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/69cVxlIjLtg?start=114\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"));

        adapter2 = new WisataAdaptor(wisataList);
        recyclerViewWisataList.setAdapter(adapter2);
    }

    private void filterList(String text) {
        List<WisataDomain> filteredList = new ArrayList<>();
        for (WisataDomain wisataDomain : wisataList) {
            if (wisataDomain.getTitle().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(wisataDomain);
            }
        }
        if (filteredList.isEmpty()) {
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        } else {
            adapter2.setFilteredList((ArrayList<WisataDomain>) filteredList);
        }
    }
}
