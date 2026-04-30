package com.example.belajarandroid10pplg2;

public class DataModel {
    String nama;
    String absen;
    String alamat;
    int gambar;
    String detail;

    public DataModel(String nama, String absen, String alamat, int gambar, String detail) {
        this.nama = nama;
        this.absen = absen;
        this.alamat = alamat;
        this.gambar = gambar;
        this.detail = detail;
    }

    public String getNama() {
        return nama;
    }

    public String getAbsen() {
        return absen;
    }

    public String getAlamat() {
        return alamat;
    }
    public int getGambar() { return gambar;}
    public String getDetail(){return detail;}
}
