package com.doxa.belajarapibasic;

/**
 * Created by doxa on 10/02/18.
 */

public class MakananModel {
    private String namaMakanan;
    private String harga;
    private String stok;
    private String sisa;
    private String owner;

    public MakananModel(String namaMakanan, String harga, String stok, String sisa, String owner) {
        this.namaMakanan = namaMakanan;
        this.harga = harga;
        this.stok = stok;
        this.sisa = sisa;
        this.owner = owner;
    }

    public MakananModel() {
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getNamaMakanan() {
        return namaMakanan;
    }

    public void setNamaMakanan(String namaMakanan) {
        this.namaMakanan = namaMakanan;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }

    public String getSisa() {
        return sisa;
    }

    public void setSisa(String sisa) {
        this.sisa = sisa;
    }
}
