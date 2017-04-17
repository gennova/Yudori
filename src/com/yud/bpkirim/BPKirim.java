/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.bpkirim;

import com.yud.barang.Barang;
import com.yud.pelanggan.Pelanggan;
import com.yud.stb.BuktiPesanan;

/**
 *
 * @author legollas
 */
public class BPKirim {

    private int id;
    private String idKirim;
    private BuktiPesanan bp;
    private Barang barang;
    private int stok;
    private String status;
    private Pelanggan pelanggan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdKirim() {
        return idKirim;
    }

    public void setIdKirim(String idKirim) {
        this.idKirim = idKirim;
    }

    public BuktiPesanan getBp() {
        return bp;
    }

    public void setBp(BuktiPesanan bp) {
        this.bp = bp;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

}
