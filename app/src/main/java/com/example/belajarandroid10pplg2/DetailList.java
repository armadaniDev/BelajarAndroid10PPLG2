package com.example.belajarandroid10pplg2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.TaskExecutor;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailList extends AppCompatActivity {

    TextView txtNama;
    TextView txtDetail;
    TextView txtAlamat;

    ImageView imgProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        String nama = getIntent().getStringExtra("nama");
        String alamat = getIntent().getStringExtra("alamat");
        String detail = getIntent().getStringExtra("detail");
        int gambar = getIntent().getIntExtra("gambar", 0);

        txtNama = findViewById(R.id.txtNama);
        txtAlamat = findViewById(R.id.txtAlamat);
        txtDetail = findViewById(R.id.txtDetail);
        imgProfile = findViewById(R.id.imgProfile);

        txtNama.setText(nama);
        txtAlamat.setText(alamat);
        txtDetail.setText(detail);
        imgProfile.setImageResource(gambar);
    }
}