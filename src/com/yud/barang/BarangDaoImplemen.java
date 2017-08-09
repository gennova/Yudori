/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.barang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author legollas
 */
public class BarangDaoImplemen implements BarangDao {

    private Connection connection = null;
    private static final String sqlGelALlBarang = "SELECT * FROM barang JOIN hargabarang ON barang.idbarang = hargabarang.idbarang WHERE CURDATE()<=tglberlakuakhir AND hargabarang.aktif='Y' ORDER BY barang.idbarang ASC";
    private static final String sqlGelBarangByID = "SELECT * FROM barang JOIN hargabarang ON barang.idbarang = hargabarang.idbarang WHERE CURDATE()<=tglberlakuakhir AND hargabarang.aktif='Y' and barang.idbarang=? ORDER BY barang.idbarang ASC";
    private static final String sqlGelBarangByName = "SELECT * FROM barang JOIN hargabarang ON barang.idbarang = hargabarang.idbarang WHERE CURDATE()<=tglberlakuakhir AND hargabarang.aktif='Y' and barang.namabarang=? ORDER BY barang.idbarang ASC";
    private static final String sqlInsertBarang = "call spInsertBarang(?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String sqlDeleteBarang = "delete from barang where idbarang=?";
    private static final String sqlUpdateNamaBarang = "update barang set namabarang=? where idbarang=?";
    private static final String sqlUpdateHargaBarang = "call spInsertHargaBarang(?,?,?,?,?,?,?,?,?,?,?,?)";

    public BarangDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Barang> getAllBarang() {
        List<Barang> gs = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareCall(sqlGelALlBarang);
            rs = statement.executeQuery();
            while (rs.next()) {
                Barang g = new Barang();
                g.setKodebarang(rs.getInt("idbarang")); //1
                g.setNamabarang(rs.getString("namabarang")); //2
                g.setIdHarga(rs.getInt("idharga")); //3
                g.setHargatunai(rs.getInt("hargatunai")); //4
                g.setHargadrop(rs.getInt("hargadrop")); //5
                g.setHargaindent(rs.getInt("hargaindent")); //6
                g.setUM(rs.getInt("UM")); //7
                g.setSisa(rs.getInt("sisa")); //8
                g.setHargapromosi(rs.getInt("hargapromositunai")); //9
                g.setSisa1(rs.getInt("sisa1")); //10
                g.setSisa2(rs.getInt("sisa2")); //11
                g.setTglMulaiBerlaku(rs.getString("tglberlakumulai")); //12
                g.setTgAkhirBerlaku(rs.getString("tglberlakuakhir")); //13
                g.setAktif(rs.getString("aktif")); //14
                gs.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BarangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gs;
    }

    @Override
    public void insertBarang(Barang barang) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareCall(sqlInsertBarang);
            statement.setString(1, barang.getNamabarang());//1
            statement.setInt(2, barang.getHargatunai());//2
            statement.setInt(3, barang.getHargadrop());//3
            statement.setInt(4, barang.getHargaindent());//4
            statement.setInt(5, barang.getUM()); //5
            statement.setInt(6, barang.getSisa()); //6
            statement.setInt(7, barang.getHargapromosi()); //7
            statement.setInt(8, barang.getSisa1());//8
            statement.setInt(9, barang.getSisa2());//9
            statement.setString(10, barang.getTglMulaiBerlaku());//10
            statement.setString(11, barang.getTgAkhirBerlaku());//11
            statement.setString(12, barang.getAktif());//12
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Barang Berhasil di Simpan");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Barang Gagal di Simpan karena " + ex.getMessage());
            Logger.getLogger(BarangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteBarang(Barang barang) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareCall(sqlDeleteBarang);
            statement.setInt(1, barang.getKodebarang());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Barang Berhasil Dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(BarangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Barang getBarangByID(int id) {
        Barang g = new Barang();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareCall(sqlGelBarangByID);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                g.setKodebarang(rs.getInt("idbarang")); //1
                g.setNamabarang(rs.getString("namabarang")); //2
                g.setIdHarga(rs.getInt("idharga")); //3
                g.setHargatunai(rs.getInt("hargatunai")); //4
                g.setHargadrop(rs.getInt("hargadrop")); //5
                g.setHargaindent(rs.getInt("hargaindent")); //6
                g.setUM(rs.getInt("UM")); //7
                g.setHargapromosi(rs.getInt("hargapromositunai")); //8
                g.setSisa(rs.getInt("sisa")); //9
                g.setSisa1(rs.getInt("sisa1")); //10
                g.setSisa2(rs.getInt("sisa2")); //11
                g.setTglMulaiBerlaku(rs.getString("tglberlakumulai")); //12
                g.setTgAkhirBerlaku(rs.getString("tglberlakuakhir")); //13
                g.setAktif(rs.getString("aktif")); //14
            }
        } catch (SQLException ex) {
            Logger.getLogger(BarangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return g;
    }

    @Override
    public Barang getBarangByName(String kode) {
        Barang g = new Barang();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareCall(sqlGelBarangByName);
            statement.setString(1, kode);
            rs = statement.executeQuery();
            while (rs.next()) {
                g.setKodebarang(rs.getInt("idbarang")); //1
                g.setNamabarang(rs.getString("namabarang")); //2
                g.setIdHarga(rs.getInt("idharga")); //3
                g.setHargatunai(rs.getInt("hargatunai")); //4
                g.setHargadrop(rs.getInt("hargadrop")); //5
                g.setHargaindent(rs.getInt("hargaindent")); //6
                g.setUM(rs.getInt("UM")); //7
                g.setHargapromosi(rs.getInt("hargapromositunai")); //8
                g.setSisa(rs.getInt("sisa")); //9
                g.setSisa1(rs.getInt("sisa1")); //10
                g.setSisa2(rs.getInt("sisa2")); //11
                g.setTglMulaiBerlaku(rs.getString("tglberlakumulai")); //12
                g.setTgAkhirBerlaku(rs.getString("tglberlakuakhir")); //13
                g.setAktif(rs.getString("aktif")); //14
            }
        } catch (SQLException ex) {
            Logger.getLogger(BarangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return g;
    }

    @Override
    public void updateNamaBarang(Barang barang) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlUpdateNamaBarang);
            statement.setString(1, barang.getNamabarang());
            statement.setInt(2, barang.getKodebarang());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Nama Barang Berhasil Dirubah");
        } catch (SQLException ex) {
            Logger.getLogger(BarangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateHargaBarang(Barang barang) {
        PreparedStatement statement =null;
        try {
            statement = connection.prepareStatement(sqlUpdateHargaBarang);
            statement.setString(1, barang.getNamabarang());
            statement.setInt(2, barang.getHargatunai());
            statement.setInt(3, barang.getHargadrop());
            statement.setInt(4, barang.getUM());
            statement.setInt(5, barang.getHargapromosi());
            statement.setInt(6, barang.getHargaindent());
            statement.setInt(7, barang.getSisa1());
            statement.setInt(8, barang.getSisa2());
            statement.setInt(9, barang.getIdHarga());
            statement.setString(10, barang.getTglMulaiBerlaku());
            statement.setString(11, barang.getTgAkhirBerlaku());
            statement.setInt(12, barang.getKodebarang());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Harga Barang Berhasil Diperbaharui.");
        } catch (SQLException ex) {
            Logger.getLogger(BarangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data Harga Barang Gagal Diperbaharui.");
        }
    }
}
