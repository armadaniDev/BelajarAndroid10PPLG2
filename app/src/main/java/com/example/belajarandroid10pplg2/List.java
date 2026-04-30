package com.example.belajarandroid10pplg2;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class List extends AppCompatActivity {

    RecyclerView RvListSiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RvListSiswa = (RecyclerView) findViewById(R.id.RvListSiswa);
        //membuat array list mengguanakan dat model
        ArrayList<DataModel> listData = new ArrayList<>();

        listData.add(new DataModel("Albay","1","Jati",R.drawable.user_laki,"Ini detail lengkap profil Albay")) ;
        listData.add(new DataModel("Abdillah","2","Ngembal",R.drawable.user_laki,"Ini detail lengkap profil Abdillah"));
        listData.add(new DataModel("Zizo","3","Mayong",R.drawable.user_laki,"Ini detail lengkap profil Zizo"));
        listData.add(new DataModel("Rahman","4","Damaran",R.drawable.user_laki,"Ini detail lengkap profil Rahman"));
        listData.add(new DataModel("Arhaqi","5","Kuningan",R.drawable.user_laki,"Ini detail lengkap profil Haqi"));
        listData.add(new DataModel("Bhisma","6","Jakarta",R.drawable.user_laki,"Ini detail lengkap profil Bhisma"));
        listData.add(new DataModel("Daniswara","7","Gebog",R.drawable.user_women,"Ini detail lengkap profil Danis"));
        listData.add(new DataModel("Diwa","8","Blora",R.drawable.user_laki,"Ini detail lengkap profil Diwa"));
        listData.add(new DataModel("Devo","9","Kaliputu",R.drawable.user_laki,"Ini detail lengkap profil Devo"));
        listData.add(new DataModel("Dzaki","10","Ploso",R.drawable.user_laki,"Ini detail lengkapprofil Dzaki"));

        AdapterList adapter = new AdapterList(listData, data -> {
            android.widget.Toast.makeText(
                    List.this,
                    "Hallo " + data.getNama(),
                    android.widget.Toast.LENGTH_SHORT
            ).show();
            Intent in = new Intent(List.this, DetailList.class);
            in.putExtra("nama", data.getNama());
            in.putExtra("alamat", data.getAlamat());
            in.putExtra("detail", data.getDetail());
            in.putExtra("gambar", data.getGambar());
            startActivity(in);
        });
        RvListSiswa.setLayoutManager(new LinearLayoutManager(this));
        RvListSiswa.setAdapter(adapter);
    }
}