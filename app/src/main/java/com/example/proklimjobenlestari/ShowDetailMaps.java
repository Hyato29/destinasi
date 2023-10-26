package com.example.proklimjobenlestari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.proklimjobenlestari.Domain.MapsDomain;
import com.example.proklimjobenlestari.Domain.WisataDomain;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ShowDetailMaps extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap googleMap;
    FrameLayout map;

    private MapsDomain object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail_maps);

        getBundle();

        map = findViewById(R.id.mapsWisata);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapsWisata);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        this.googleMap = googleMap;
        String title = object.getTitle();
        double latitude = object.getLatitude();
        double longitude = object.getLongitude();

        LatLng mapIndonesia = new LatLng(latitude, longitude);
        this.googleMap.addMarker(new MarkerOptions().position(mapIndonesia).title(title));
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(mapIndonesia));
    }

    private void getBundle() {
        object = (MapsDomain) getIntent().getSerializableExtra("object");
    }
}