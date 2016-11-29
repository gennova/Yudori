/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.kmb;

import com.init.tools.DaoFactory;
import com.yud.barang.Barang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author legollas
 */
public class KeluarMasukBarang {

    private int id;
    private String kodeKMB;
    private String nama;
    private String alamat;
    private String tanggal;
    private String keterangan;
    private Barang barang;
    private int jumlah;
    private String detailketerangan;
    private String statusbarang;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKodeKMB() {
        return kodeKMB;
    }

    public void setKodeKMB(String kodeKMB) {
        this.kodeKMB = kodeKMB;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getDetailketerangan() {
        return detailketerangan;
    }

    public void setDetailketerangan(String detailketerangan) {
        this.detailketerangan = detailketerangan;
    }

    public String getStatusbarang() {
        return statusbarang;
    }

    public void setStatusbarang(String statusbarang) {
        this.statusbarang = statusbarang;
    }

    public boolean cekkmb(String kode) {
        boolean status = false;
        PreparedStatement statement = null;
        try {
            statement = DaoFactory.getConnectionFix().prepareStatement("select kodekmb from bkmb where kodekmb=?");
            statement.setString(1, kode);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                status = true;
            } else {
                status = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KeluarMasukBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

}
