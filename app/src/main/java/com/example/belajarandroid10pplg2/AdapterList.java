package com.example.belajarandroid10pplg2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolder> {

    private List<DataModel> listSiswa;

    // constructor
    // ditambah listener
    public AdapterList(List<DataModel> listData, OnItemClickListener listener) {
        this.listSiswa = listData;
        this.listener = listener;
    }
    public interface OnItemClickListener {
        //Method
        void onItemClick(DataModel data);
    }
    //ini object listener
    OnItemClickListener listener;

    // ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama;
        TextView tvAbsen;
        TextView tvalamat;

        ImageView imgSiswa;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvnamaSiswa);
            tvAbsen = itemView.findViewById(R.id.tvnoAbsen);
            tvalamat = itemView.findViewById(R.id.tvalamat);
            imgSiswa = itemView.findViewById(R.id.imgSiswa);
        }
    }

    @NonNull
    @Override
    public AdapterList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterList.ViewHolder holder, int position) {
        String nama = listSiswa.get(position).getNama();
        String absen = listSiswa.get(position).getAbsen();
        String alamat = listSiswa.get(position).getAlamat();
        int gambar = listSiswa.get(position).getGambar();
        holder.tvNama.setText(nama);
        holder.tvAbsen.setText(absen);
        holder.tvalamat.setText(alamat);
        holder.imgSiswa.setImageResource(gambar);
        holder.itemView.setOnClickListener(v -> {
            listener.onItemClick(listSiswa.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return listSiswa.size();
    }
}
