/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.pelanggan;

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
public class Pelanggan {

    private int idPelanggan;
    private String kodemanualpelanggan;
    private String namaPelanggan;
    private String alamatpelanggan;
    private String telepon;

    public Pelanggan() {
    }

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getAlamatpelanggan() {
        return alamatpelanggan;
    }

    public void setAlamatpelanggan(String alamatpelanggan) {
        this.alamatpelanggan = alamatpelanggan;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public boolean cekpelanggan(int idpelanggan) {
        boolean status = false;
        PreparedStatement statement = null;
        try {
            statement = DaoFactory.getConnectionFix().prepareStatement("select idpelanggan from pelanggan where idpelanggan=?");
            statement.setInt(1, idpelanggan);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                status = true;
            } else {
                status = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public String getKodemanualpelanggan() {
        return kodemanualpelanggan;
    }

    public void setKodemanualpelanggan(String kodemanualpelanggan) {
        this.kodemanualpelanggan = kodemanualpelanggan;
    }

}
