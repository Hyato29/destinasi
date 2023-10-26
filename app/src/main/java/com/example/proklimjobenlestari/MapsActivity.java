package com.example.proklimjobenlestari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.proklimjobenlestari.Adaptor.MapsAdaptor;
import com.example.proklimjobenlestari.Domain.MapsDomain;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends AppCompatActivity {
    private MapsAdaptor adapter2;
    private RecyclerView recyclerViewWisataList;
    private ArrayList<MapsDomain> mapsList;
    private SearchView searchView;

    private MapsDomain object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

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
                startActivity(new Intent(getApplicationContext(), WisataActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            } else if (item.getItemId() == R.id.bottom_tiket) {
                return true;
            }
            return false;
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewWisataList = findViewById(R.id.recyclerView2);
        recyclerViewWisataList.setLayoutManager(linearLayoutManager);

        mapsList = new ArrayList<>();
        mapsList.add(new MapsDomain("Pantai Kuta", "pop_1kuta",
                "Pesona Pantai \n yang Eksotis", -8.894096, 116.282199));

        mapsList.add(new MapsDomain("Pantai Pink", "pop_2pink",
                "Keajaiban Pantai \n Berpasir Merah", -8.855356, 116.562248));

        mapsList.add(new MapsDomain("Pantai Senggigi", "pop_3senggigi",
                "Keindahan \n Pantai dan Sunset", -8.478610, 116.037674));

        mapsList.add(new MapsDomain("Pantai Tanjung Aan", "pop_4tanjungaan",
                "Keindahan Pasir \n Putih dan Air Jernih", -8.909400, 116.320636));

        mapsList.add(new MapsDomain("Pantai Kura-Kura", "pop_5kurakura",
                "Pantai dan Batu dengan \n Rupa Kura-Kura", -8.920679, 116.445625));


        adapter2 = new MapsAdaptor(mapsList);
        recyclerViewWisataList.setAdapter(adapter2);

    }

    private void filterList(String text) {
        List<MapsDomain> filteredList = new ArrayList<>();
        for (MapsDomain wisataDomain : mapsList) {
            if (wisataDomain.getTitle().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(wisataDomain);
            }
        }
        if (filteredList.isEmpty()) {
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        } else {
            adapter2.setFilteredList((ArrayList<MapsDomain>) filteredList);
        }
    }


}
