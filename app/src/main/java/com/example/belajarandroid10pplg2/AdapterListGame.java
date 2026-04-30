package com.example.belajarandroid10pplg2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class AdapterListGame extends RecyclerView.Adapter<AdapterListGame.ViewHolder> {
    //mmenyimpan data game
    private List<DataGame> listGame;

    // constructor
    // ditambah listener
    // menambah data list game dan klik
    public AdapterListGame(List<DataGame> listGame, AdapterListGame.OnItemClickListener listener) {
        this.listGame = listGame;
        this.listener = listener;
    }
    public interface OnItemClickListener {
        //Method
        // saat data di klik, dta game dikirim
        void onItemClick(DataGame dataGame);
    }
    //ini object listener
    AdapterListGame.OnItemClickListener listener;

    // ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaGame;
        TextView tvPembuat;
        TextView tvTipe;
        TextView tvRating;
        ImageView imgGame;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaGame = itemView.findViewById(R.id.tvNamaGame);
            tvPembuat = itemView.findViewById(R.id.tvPembuat);
            tvTipe = itemView.findViewById(R.id.tvTipe);
            imgGame = itemView.findViewById(R.id.imgGame);
            tvRating = itemView.findViewById(R.id.tvRating);
        }
    }

    @NonNull
    @Override
    public AdapterListGame.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_layout_game, parent, false);
        return new AdapterListGame.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListGame.ViewHolder holder, int pos) {
        String namaGame = listGame.get(pos).getNamaGame();
        String pembuat = listGame.get(pos).getPembuat();
        String tipe = listGame.get(pos).getTipe();
        String rating = listGame.get(pos).getRating();
        int gambar = listGame.get(pos).getGambar();
        holder.tvNamaGame.setText(namaGame);
        holder.tvPembuat.setText(pembuat);
        holder.tvTipe.setText(tipe);
        holder.tvRating.setText(rating);
        holder.imgGame.setImageResource(gambar);
        holder.itemView.setOnClickListener(v -> {
            listener.onItemClick(listGame.get(pos));
        });
    }

    @Override
    public int getItemCount() {
        return listGame.size();
    }
}
