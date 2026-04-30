package com.example.belajarandroid10pplg2;

public class DataGame {
    String namaGame;
    String pembuat;
    String tipe;
    String rating;
    int gambar;
    String detailGame;
    String versi;
    String deskripsiSinkat;
    String rank;

    public DataGame(String namaGame, String pembuat, String tipe, String rating, int gambar, String detailGame, String versi, String deskripsiSinkat, String rank) {
        this.namaGame = namaGame;
        this.pembuat = pembuat;
        this.tipe = tipe;
        this.rating = rating;
        this.gambar = gambar;
        this.detailGame = detailGame;
        this.versi = versi;
        this.deskripsiSinkat = deskripsiSinkat;
        this.rank = rank;
    }

    public String getNamaGame() {
        return namaGame;
    }

    public String getPembuat() {
        return pembuat;
    }

    public String getTipe() {
        return tipe;
    }

    public String getRating() {
        return rating;
    }

    public int getGambar() {
        return gambar;
    }

    public String getDetailGame() {
        return detailGame;
    }
    public String getVersi() {
        return versi;
    }
    public String getDeskripsiSinkat() {
        return deskripsiSinkat;
    }
    public String getRank() {
        return rank;
    }
}
