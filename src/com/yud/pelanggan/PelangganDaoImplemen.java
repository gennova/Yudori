/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.pelanggan;

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
public class PelangganDaoImplemen implements PelangganDao {

    private Connection connection;
    private static final String sqlGetAllPelanggan = "select * from pelanggan";
    private static final String sqlGetAllPelangganByID = "select * from pelanggan where idpelanggan=?";
    private static final String sqlGetAllPelangganByName = "select * from pelanggan where namapelanggan=?";
    private static final String sqlInsertPelanggan = "insert into pelanggan(mankodepelanggan,namapelanggan,alamat,telepon) values(?,?,?,?)";
    private static final String sqlUpdatePelanggan = "update pelanggan set mankodepelanggan=?,namapelanggan=?,alamat=?,telepon=? where idpelanggan=?";
    private static final String sqlDeletePelanggan = "delete from pelanggan where idpelanggan=?";

    public PelangganDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Pelanggan> getAllPelanggan() {
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Pelanggan> pelanggans = null;
        try {
            pelanggans = new ArrayList<Pelanggan>();
            statement = connection.prepareCall(sqlGetAllPelanggan);
            rs = statement.executeQuery();
            while (rs.next()) {
                Pelanggan pelanggan = new Pelanggan();
                pelanggan.setIdPelanggan(rs.getInt("idpelanggan"));
                pelanggan.setKodemanualpelanggan(rs.getString("mankodepelanggan"));
                pelanggan.setNamaPelanggan(rs.getString("namapelanggan"));
                pelanggan.setAlamatpelanggan(rs.getString("alamat"));
                pelanggan.setTelepon(rs.getString("telepon"));
                pelanggans.add(pelanggan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PelangganDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(PelangganDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pelanggans;
    }

    @Override
    public void insertPelanggan(Pelanggan pelanggan) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareCall(sqlInsertPelanggan);
            statement.setString(1, pelanggan.getKodemanualpelanggan());
            statement.setString(2, pelanggan.getNamaPelanggan());
            statement.setString(3, pelanggan.getAlamatpelanggan());
            statement.setString(4, pelanggan.getTelepon());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
        } catch (SQLException ex) {
            Logger.getLogger(PelangganDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(PelangganDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void updatePelanggan(Pelanggan pelanggan) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareCall(sqlUpdatePelanggan);
            statement.setString(1, pelanggan.getKodemanualpelanggan());
            statement.setString(2, pelanggan.getNamaPelanggan());
            statement.setString(3, pelanggan.getAlamatpelanggan());
            statement.setString(4, pelanggan.getTelepon());
            statement.setInt(5, pelanggan.getIdPelanggan());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil di simpan");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan karena : " + ex.getMessage());
            Logger.getLogger(PelangganDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(PelangganDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void deletePelanggan(Pelanggan pelanggan) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareCall(sqlDeletePelanggan);
            statement.setInt(1, pelanggan.getIdPelanggan());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan karena : " + ex.getMessage());
            Logger.getLogger(PelangganDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(PelangganDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Pelanggan getPelangganByID(int id) {
        PreparedStatement statement = null;
        ResultSet rs = null;
        Pelanggan pelanggans = null;
        try {            
            statement = connection.prepareCall(sqlGetAllPelangganByID);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                pelanggans = new Pelanggan();
                pelanggans.setIdPelanggan(rs.getInt("idpelanggan"));
                pelanggans.setKodemanualpelanggan(rs.getString("mankodepelanggan"));
                pelanggans.setNamaPelanggan(rs.getString("namapelanggan"));
                pelanggans.setAlamatpelanggan(rs.getString("alamat"));
                pelanggans.setTelepon(rs.getString("telepon"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PelangganDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(PelangganDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pelanggans;
    }

    @Override
    public Pelanggan getPelangganByName(String Name) {
        PreparedStatement statement = null;
        ResultSet rs = null;
        Pelanggan pelanggans = null;
        try {            
            statement = connection.prepareCall(sqlGetAllPelangganByName);
            statement.setString(1, Name);
            rs = statement.executeQuery();
            while (rs.next()) {
                pelanggans = new Pelanggan();
                pelanggans.setIdPelanggan(rs.getInt("idpelanggan"));
                pelanggans.setKodemanualpelanggan(rs.getString("mankodepelanggan"));
                System.out.println("pelanggasnssss "+rs.getString("mankodepelanggan"));
                pelanggans.setNamaPelanggan(rs.getString("namapelanggan"));
                pelanggans.setAlamatpelanggan(rs.getString("alamat"));
                pelanggans.setTelepon(rs.getString("telepon"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PelangganDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(PelangganDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pelanggans;
    }

}
