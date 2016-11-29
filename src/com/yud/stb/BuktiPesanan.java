/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.stb;

import com.init.tools.DaoFactory;
import com.yud.pelanggan.Pelanggan;
import com.yud.sales.Sales;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author legollas
 */
public class BuktiPesanan {

    private int id;
    private Pelanggan pelanggan;
    private Sales sales;
    private String KodePesanan;
    private String NoFakturPesanan;
    private int komisiSales;
    private String TglPesanan;
    private String TglPenagihan;
    private String TglPengiriman;
    private String jenisPesanan;
    private String JenisOrder;
    private int total;
    private int UM;
    private int angsuran;
    private int sisa;
    private int sisa2;
    private String statusBP;
    private int HargaTunai;
    private String StatusKirimBarang;

    public BuktiPesanan() {
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    public int getKomisiSales() {
        return komisiSales;
    }

    public void setKomisiSales(int komisiSales) {
        this.komisiSales = komisiSales;
    }

    public String getTglPesanan() {
        return TglPesanan;
    }

    public void setTglPesanan(String TglPesanan) {
        this.TglPesanan = TglPesanan;
    }

    public String getTglPenagihan() {
        return TglPenagihan;
    }

    public void setTglPenagihan(String TglPenagihan) {
        this.TglPenagihan = TglPenagihan;
    }

    public String getTglPengiriman() {
        return TglPengiriman;
    }

    public void setTglPengiriman(String TglPengiriman) {
        this.TglPengiriman = TglPengiriman;
    }

    public String getJenisPesanan() {
        return jenisPesanan;
    }

    public void setJenisPesanan(String jenisPesanan) {
        this.jenisPesanan = jenisPesanan;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getUM() {
        return UM;
    }

    public void setUM(int UM) {
        this.UM = UM;
    }

    public int getSisa() {
        return sisa;
    }

    public void setSisa(int sisa) {
        this.sisa = sisa;
    }

    public String getKodePesanan() {
        return KodePesanan;
    }

    public void setKodePesanan(String KodePesanan) {
        this.KodePesanan = KodePesanan;
    }

    public String getNoFakturPesanan() {
        return NoFakturPesanan;
    }

    public void setNoFakturPesanan(String NoFakturPesanan) {
        this.NoFakturPesanan = NoFakturPesanan;
    }

    public String getJenisOrder() {
        return JenisOrder;
    }

    public void setJenisOrder(String JenisOrder) {
        this.JenisOrder = JenisOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSisa2() {
        return sisa2;
    }

    public void setSisa2(int sisa2) {
        this.sisa2 = sisa2;
    }

    public boolean cekbp(String kodebp) {
        boolean status = false;
        PreparedStatement statement = null;
        try {
            statement = DaoFactory.getConnectionFix().prepareStatement("select kodebp from buktipesanan where kodebp=?");
            statement.setString(1, kodebp);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                status = true;
            } else {
                status = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuktiPesanan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public String getStatusBP() {
        return statusBP;
    }

    public void setStatusBP(String statusBP) {
        this.statusBP = statusBP;
    }

    public int getAngsuran() {
        return angsuran;
    }

    public void setAngsuran(int angsuran) {
        this.angsuran = angsuran;
    }

    public int getHargaTunai() {
        return HargaTunai;
    }

    public void setHargaTunai(int HargaTunai) {
        this.HargaTunai = HargaTunai;
    }

    public String getStatusKirimBarang() {
        return StatusKirimBarang;
    }

    public void setStatusKirimBarang(String StatusKirimBarang) {
        this.StatusKirimBarang = StatusKirimBarang;
    }

}
