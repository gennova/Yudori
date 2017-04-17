/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.bstu;

import com.init.tools.DaoFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author legollas
 */
public class SerahTerimaUang {

    private int id;
    private String kodeBSTU;
    private String nama;
    private String uraian;
    private int jumlah;
    private String keterangan;
    private String status;
    private String jenisbstu;
    private String diserahkan;
    private String tanggal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKodeBSTU() {
        return kodeBSTU;
    }

    public void setKodeBSTU(String kodeBSTU) {
        this.kodeBSTU = kodeBSTU;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getUraian() {
        return uraian;
    }

    public void setUraian(String uraian) {
        this.uraian = uraian;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJenisbstu() {
        return jenisbstu;
    }

    public void setJenisbstu(String jenisbstu) {
        this.jenisbstu = jenisbstu;
    }

    public String getDiserahkan() {
        return diserahkan;
    }

    public void setDiserahkan(String diserahkan) {
        this.diserahkan = diserahkan;
    }

    public boolean cekstu(String kode) {
        boolean status = false;
        PreparedStatement statement = null;
        try {
            statement = DaoFactory.getConnectionFix().prepareStatement("select kodebstu from bstu where kodebstu=?");
            statement.setString(1, kode);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                status = true;
            } else {
                status = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SerahTerimaUang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
