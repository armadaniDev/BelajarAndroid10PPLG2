package com.example.belajarandroid10pplg2;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListGame extends AppCompatActivity {

    RecyclerView RvListGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.list_game);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RvListGame = (RecyclerView) findViewById(R.id.RvListGame);
        //membuat array list mengguanakan dat model
        ArrayList<DataGame> listDataGame = new ArrayList<>();

        listDataGame.add(new DataGame("Mobile Legends","Moonton","Moba","4",R.drawable.ml, "Game moba terbaik di dunia","1.8","Moba paling ramah","#1 di PlayStore"));
        listDataGame.add(new DataGame("Honor of Kings","Level Infinite","Moba","4",R.drawable.hok, "Game moba terbaik di china","Patch 2026","Moba Terbaik","#4  di PlayStore"));
        listDataGame.add(new DataGame("Clash of Clans","Supercell","Strategy","4",R.drawable.coc, "Game strategy terbaik","Th 16","Strategy dan membagun","#5 di PlayStore"));
        listDataGame.add(new DataGame("Pokemon Unite","The Pokemon Company","Moba","5",R.drawable.pokemon, "Game moba terbaik di dunia yeyyyy","Patch 2026","Moba mantapp","#2 di PlayStore"));
        listDataGame.add(new DataGame("Pubg","Level Infinite","Battle Royale","3",R.drawable.pubg, "Game battle royale dengan 100 pemain","30.4","Battle Royale Strategy","#7 di PlayStore"));
        listDataGame.add(new DataGame("Free Fire","Garena","Battle Royale","4",R.drawable.ff, "Game Auto aim","OB Update 2026","Battle Royale Auto Aim","#9 di PlayStore"));
        listDataGame.add(new DataGame("Minecraft","Mojang","Open World","5",R.drawable.mc, "Game Open World terbagus","1.21.8","Game Survival","#3 di PlayStore"));
        listDataGame.add(new DataGame("Roblox","Roblox Corporation","Multiplayer","5",R.drawable.rblox, "Game dengan experience yang beragam","Live Update","Multiplayer Mantapp","#6 di PlayStore"));
        listDataGame.add(new DataGame("Genshin Impact","Cognosphere Pte.Ltd.","RPG","4",R.drawable.genshin, "Game Hama","4.5","Rpg Game Grinding","#10 di PlayStore"));
        listDataGame.add(new DataGame("Blood Strike","NetEase Game","Battle Royale","4",R.drawable.bs, "Game FPS paling mantap","Patch Global 2026","Fps Battle Royale Game Cepat","#9 di PlayStore"));

        AdapterListGame adapter = new AdapterListGame(listDataGame, dataGame -> {
            android.widget.Toast.makeText(
                    ListGame.this,
                    "Welcome to " + dataGame.getNamaGame(),
                    android.widget.Toast.LENGTH_SHORT
            ).show();
            Intent in = new Intent(ListGame.this, DetailListGame.class);
            in.putExtra("namaGame", dataGame.getNamaGame());
            in.putExtra("Developer", dataGame.getPembuat());
            in.putExtra("tipe", dataGame.getTipe());
            in.putExtra("rating", dataGame.getRating());
            in.putExtra("gambar", dataGame.getGambar());
            in.putExtra("detailGame", dataGame.getDetailGame());
            in.putExtra("versi", dataGame.getVersi());
            in.putExtra("deskripsiSingkat", dataGame.getDeskripsiSinkat());
            in.putExtra("rank", dataGame.getRank());
            startActivity(in);
        });
        RvListGame.setLayoutManager(new LinearLayoutManager(this));
        RvListGame.setAdapter(adapter);
    }
}