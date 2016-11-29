/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.kmb;

import com.init.tools.DaoFactory;
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
public class KeluarMasukBarangDaoImplemen implements KeluarMasukBarangDao {

    private Connection connection;
    private final static String sqlGetAllKMB = "select * from bkmb";
    private final static String sqlGetKMBByID = "select * from bkmb where id=?";
    private final static String sqlGetKMBByKode = "select * from bkmb where kodekmb =?";
    private final static String sqlInsertKMB = "call spInsertKMB(?,?,?,?,?,?,?,?,?)";
    private final static String sqlInsertKMBBuktiPesanan = "call sqlInsertKMBBuktiPesanan(?,?,?,?,?,?,?,?,?)";
    private final static String sqlUpdateKMB = "update bkmb set ";
    private final static String sqlDeteleKMBByID = "delete from bkmb where id=?";
    private final static String sqlDeteleKMBByKode = "delete from bkmb where kodekmb=?";

    public KeluarMasukBarangDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<KeluarMasukBarang> getALlKMB() {
        List<KeluarMasukBarang> barangs = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sqlGetAllKMB);
            rs = ps.executeQuery();
            while (rs.next()) {
                KeluarMasukBarang barang = new KeluarMasukBarang();
                barang.setId(rs.getInt("id"));
                barang.setKodeKMB(rs.getString("kodekmb"));
                barang.setNama(rs.getString("nama"));
                barang.setAlamat(rs.getString("alamat"));
                barang.setStatusbarang(rs.getString("statusbarang"));
                barang.setJumlah(rs.getInt("jumlah"));
                barang.setKeterangan(rs.getString("keterangan"));
                barang.setDetailketerangan(rs.getString("detailketerangan"));
                barang.setTanggal(rs.getString("tanggal"));
                barang.setBarang(DaoFactory.getBarangDao().getBarangByID(rs.getInt("idbarang")));
                barangs.add(barang);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KeluarMasukBarangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return barangs;
    }

    @Override
    public KeluarMasukBarang getKMBByID(int id) {
        KeluarMasukBarang barang = new KeluarMasukBarang();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sqlGetKMBByID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                barang.setId(rs.getInt("id"));
                barang.setKodeKMB(rs.getString("kodekmb"));
                barang.setNama(rs.getString("nama"));
                barang.setAlamat(rs.getString("alamat"));
                barang.setStatusbarang(rs.getString("statusbarang"));
                barang.setJumlah(rs.getInt("jumlah"));
                barang.setKodeKMB(rs.getString("keterangan"));
                barang.setDetailketerangan(rs.getString("detailketerangan"));
                barang.setTanggal(rs.getString("tanggal"));
                barang.setBarang(DaoFactory.getBarangDao().getBarangByID(rs.getInt("idbarang")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KeluarMasukBarangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return barang;
    }

    @Override
    public KeluarMasukBarang getKMBByKodeKMB(String kode) {
        KeluarMasukBarang barang = new KeluarMasukBarang();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sqlGetKMBByID);
            ps.setString(1, kode);
            rs = ps.executeQuery();
            while (rs.next()) {
                barang.setId(rs.getInt("id"));
                barang.setKodeKMB(rs.getString("kodekmb"));
                barang.setNama(rs.getString("nama"));
                barang.setAlamat(rs.getString("alamat"));
                barang.setStatusbarang(rs.getString("statusbarang"));
                barang.setJumlah(rs.getInt("jumlah"));
                barang.setKodeKMB(rs.getString("keterangan"));
                barang.setDetailketerangan(rs.getString("detailketerangan"));
                barang.setTanggal(rs.getString("tanggal"));
                barang.setBarang(DaoFactory.getBarangDao().getBarangByID(rs.getInt("idbarang")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KeluarMasukBarangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return barang;
    }

    @Override
    public void insertKMB(KeluarMasukBarang barang) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlInsertKMB);
            ps.setString(1, barang.getKodeKMB());
            ps.setString(2, barang.getNama());
            ps.setString(3, barang.getAlamat());
            ps.setString(4, barang.getKeterangan());
            ps.setString(5, barang.getDetailketerangan());
            ps.setString(6, barang.getTanggal());
            ps.setInt(7, barang.getBarang().getKodebarang());
            ps.setInt(8, barang.getJumlah());
            ps.setString(9, barang.getStatusbarang());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(KeluarMasukBarangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteKMB(KeluarMasukBarang barang) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareCall("delete from bkmb where kodekmb=?");
            statement.setString(1, barang.getKodeKMB());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(KeluarMasukBarangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data gagal dihapus karena "+ex.getMessage());
        }

    }

    @Override
    public void updateKMB(KeluarMasukBarang barang) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertKMBBuktiPesanan(KeluarMasukBarang barang) {        
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlInsertKMBBuktiPesanan);
            ps.setString(1, barang.getKodeKMB());
            ps.setString(2, barang.getNama());
            ps.setString(3, barang.getAlamat());
            ps.setString(4, barang.getKeterangan());
            ps.setString(5, barang.getDetailketerangan());
            ps.setString(6, barang.getTanggal());
            ps.setInt(7, barang.getBarang().getKodebarang());
            ps.setInt(8, barang.getJumlah());
            ps.setString(9, barang.getStatusbarang());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(KeluarMasukBarangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
