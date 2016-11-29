/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.angsuran;

import com.init.tools.DaoFactory;
import com.yud.pelanggan.Pelanggan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author legollas
 */
public class Angsuran {

    private int idAngsuran;
    private String KodeAngsuran;
    private String KodeBP;
    private Pelanggan pelanggan;
    private String Pembayar;
    private String Penerima;
    private int Jumlah;
    private String TanggalTerima;
    private String Keterangan;
    

    public int getIdAngsuran() {
        return idAngsuran;
    }

    public void setIdAngsuran(int idAngsuran) {
        this.idAngsuran = idAngsuran;
    }

    public String getKodeAngsuran() {
        return KodeAngsuran;
    }

    public void setKodeAngsuran(String KodeAngsuran) {
        this.KodeAngsuran = KodeAngsuran;
    }

    public String getKodeBP() {
        return KodeBP;
    }

    public void setKodeBP(String KodeBP) {
        this.KodeBP = KodeBP;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public String getPembayar() {
        return Pembayar;
    }

    public void setPembayar(String Pembayar) {
        this.Pembayar = Pembayar;
    }

    public String getPenerima() {
        return Penerima;
    }

    public void setPenerima(String Penerima) {
        this.Penerima = Penerima;
    }

    public int getJumlah() {
        return Jumlah;
    }

    public void setJumlah(int Jumlah) {
        this.Jumlah = Jumlah;
    }

    public String getTanggalTerima() {
        return TanggalTerima;
    }

    public void setTanggalTerima(String TanggalTerima) {
        this.TanggalTerima = TanggalTerima;
    }

    public String getKeterangan() {
        return Keterangan;
    }

    public void setKeterangan(String Keterangan) {
        this.Keterangan = Keterangan;
    }

    public boolean cekangsuran(String kodeans) {
        boolean status = false;
        PreparedStatement statement = null;
        try {
            statement = DaoFactory.getConnectionFix().prepareStatement("select kodeangsuran from angsuran where kodeangsuran=?");
            statement.setString(1, kodeans);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                status = true;
            } else {
                status = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Angsuran.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
}
