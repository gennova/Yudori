/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.stocking;

import com.init.tools.DaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author legollas
 */
public class StokDaoImplemen implements StokDao {

    private Connection connection;
    private final static String sqlGetAllStokBarang = "SELECT id,idbarang,SUM(stok) AS jumlahnya,tanggal,keterangan,kategori,trace from stokbarang group by idbarang";
    private final static String sqlGetAllStokBarangKeluarByDate = "SELECT id,idbarang,SUM(stok) AS jumlahnya,tanggal,keterangan,kategori,trace FROM stokbarang WHERE stok<0 and tanggal=? GROUP BY idbarang,tanggal ORDER BY tanggal ASC ";
    private final static String sqlGetAllStokBarangKeluarByDateMonth = "SELECT id,idbarang,SUM(stok) AS jumlahnya,tanggal,keterangan,kategori,trace FROM stokbarang WHERE stok<0 and tanggal between ? and ? GROUP BY idbarang ORDER BY tanggal ASC ";
    public Connection getConnection() {
        return connection;
    }

    public StokDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    

    @Override
    public List<Stok> getAllStokBarang() {
        List<Stok> stoks = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sqlGetAllStokBarang);
            rs = statement.executeQuery();
            while (rs.next()) {
                Stok stok = new Stok();
                stok.setId(rs.getInt("id"));
                stok.setBarang(DaoFactory.getBarangDao().getBarangByID(rs.getInt("idbarang")));
                stok.setJumlah(rs.getInt("jumlahnya"));
                stok.setKeterangan(rs.getString("keterangan"));
                stoks.add(stok);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StokDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }

        return stoks;
    }

    @Override
    public void insertStokAwalBarang() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertStokBarang() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateStokBarang() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteStokBarang() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Stok> getLaporanPengeluanBarangByDate(String date) {
        List<Stok> stoks = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sqlGetAllStokBarangKeluarByDate);
            statement.setString(1, date);
            rs = statement.executeQuery();
            while (rs.next()) {
                Stok stok = new Stok();
                stok.setId(rs.getInt("idbarang"));
                stok.setBarang(DaoFactory.getBarangDao().getBarangByID(rs.getInt("idbarang")));
                stok.setJumlah(rs.getInt("jumlahnya"));
                stoks.add(stok);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StokDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }

        return stoks;
    }

    @Override
    public List<Stok> getLaporanPengeluanBarangByDateMonth(String date, String date2) {
        List<Stok> stoks = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sqlGetAllStokBarangKeluarByDateMonth);
            statement.setString(1, date);
            statement.setString(2, date2);
            rs = statement.executeQuery();
            while (rs.next()) {
                Stok stok = new Stok();
                stok.setId(rs.getInt("idbarang"));
                stok.setBarang(DaoFactory.getBarangDao().getBarangByID(rs.getInt("idbarang")));
                stok.setJumlah(rs.getInt("jumlahnya"));
                stoks.add(stok);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StokDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }

        return stoks;
    }

}
