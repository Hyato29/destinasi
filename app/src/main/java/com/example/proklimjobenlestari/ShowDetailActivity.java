package com.example.proklimjobenlestari;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proklimjobenlestari.Domain.WisataDomain;

import me.biubiubiu.justifytext.library.JustifyTextView;

public class ShowDetailActivity extends AppCompatActivity {
private TextView titleDetail, fasilitas, jarak;
private JustifyTextView descDetail;
private ImageView picDetail;
private WebView urlDetail;
private WisataDomain object;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        initView();
        getBundle();
        getVideo();
    }

    private void getVideo(){
        String urlVideo = object.getUrlVideo();
        urlDetail.loadData(urlVideo, "text/html", "utf-8");
        urlDetail.getSettings().setJavaScriptEnabled(true);
        urlDetail.setWebChromeClient(new WebChromeClient());
    }

    private void getBundle() {
        object = (WisataDomain) getIntent().getSerializableExtra("object");

        int drawableResourceId = this.getResources().getIdentifier(object.getPic(),
                "drawable", this.getPackageName());

        picDetail.setImageResource(drawableResourceId);

        titleDetail.setText(object.getTitle());
        descDetail.setText(object.getDetailDescription());
        fasilitas.setText(object.getFasilitas());
        jarak.setText(object.getJarak());
    }

    private void initView() {
        titleDetail = findViewById(R.id.titleDetail);
        picDetail = findViewById(R.id.picDetail);
        urlDetail = findViewById(R.id.ytView);
        descDetail = findViewById(R.id.descDetail);
        fasilitas = findViewById(R.id.fasilitas);
        jarak = findViewById(R.id.jarak);
    }
}