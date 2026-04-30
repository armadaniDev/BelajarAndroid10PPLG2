package com.example.belajarandroid10pplg2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailListGame extends AppCompatActivity {

    ImageView imgGameDetail;
    TextView tvNamaGame;
    TextView tvDeveloper;
    TextView tvTipe;
    TextView tvRating;
    TextView tvVersi;
    TextView tvDeskripiSinkat;
    TextView tvDeskripsi;
    TextView tvRank;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_list_game);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        int gambar = getIntent().getIntExtra("gambar",0);
        String namaGame = getIntent().getStringExtra("namaGame");
        String developer = getIntent().getStringExtra("Developer");
        String tipe = getIntent().getStringExtra("tipe");
        String rating = getIntent().getStringExtra("rating");
        String versi = getIntent().getStringExtra("versi");
        String deskripisiSinkat = getIntent().getStringExtra("deskripsiSingkat");
        String Deskripsi = getIntent().getStringExtra("detailGame");
        String rank = getIntent().getStringExtra("rank");

        imgGameDetail = findViewById(R.id.imgGameDetail);
        tvNamaGame = findViewById(R.id.tvNamaGame);
        tvDeveloper = findViewById(R.id.tvDeveloper);
        tvTipe= findViewById(R.id.tvTipe);
        tvRating = findViewById(R.id.tvRating);
        tvVersi = findViewById(R.id.tvVersi);
        tvDeskripiSinkat = findViewById(R.id.tvDeskripsiSingkat);
        tvDeskripsi = findViewById(R.id.tvDeskripsi);
        tvRank = findViewById(R.id.tvRank);

        imgGameDetail.setImageResource(gambar);
        tvNamaGame.setText(namaGame);
        tvDeveloper.setText(developer);
        tvTipe.setText(tipe);
        tvRating.setText(rating);
        tvVersi.setText(versi);
        tvDeskripiSinkat.setText(deskripisiSinkat);
        tvDeskripsi.setText(Deskripsi);
        tvRank.setText(rank);
    }
}