/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.bstu;

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
public class SerahTerimaUangDaoImplemen implements SerahTerimaUangDao {

    private Connection connection;
    private final static String sqlGetAllBSTU = "select * from bstu";
    private final static String sqlTransferDetailToTemp = "insert into tempbstu(nama,uraian,keterangan,jumlah,kodebstu) select nama,uraian,keterangan,jumlah,kodebstu from detailbstu where kodebstu=?";
    private final static String sqlGetSUmTemp = "SELECT SUM(jumlah) AS jumlahnya FROM tempbstu WHERE kodebstu=? GROUP BY kodebstu";
    private final static String sqlGetAllTempBSTU = "select * from tempbstu";
    private final static String sqlGetBSTUByID = "select * from bstu where id=?";
    private final static String sqlGetBSTUByKode = "select * from bstu where kodebstu=?";
    private final static String sqlInsertBSTU = "call spInsertBSTU(?,?,?,?,?,?,?)";
    private final static String sqlDeleteBSTU = "delete from bstu where id=?";
    private final static String sqlTruncateBSTU = "truncate tempbstu";
    private final static String sqlInsertTempBSTU = "insert into tempbstu (nama,uraian,keterangan,jumlah,kodebstu) values (?,?,?,?,?)";

    public SerahTerimaUangDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<SerahTerimaUang> getAllBSTU() {
        List<SerahTerimaUang> list = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sqlGetAllBSTU);
            rs = statement.executeQuery();
            while (rs.next()) {
                SerahTerimaUang serahTerimaUang = new SerahTerimaUang();
                serahTerimaUang.setId(rs.getInt("id"));
                serahTerimaUang.setKodeBSTU(rs.getString("kodebstu"));
                serahTerimaUang.setNama(rs.getString("nama"));
                serahTerimaUang.setUraian(rs.getString("uraian"));
                serahTerimaUang.setJumlah(rs.getInt("jumlah"));
                serahTerimaUang.setKeterangan(rs.getString("keterangan"));
                serahTerimaUang.setStatus(rs.getString("status"));
                serahTerimaUang.setJenisbstu(rs.getString("jenisbstu"));
                serahTerimaUang.setDiserahkan(rs.getString("diserahkan"));
                serahTerimaUang.setTanggal(rs.getString("tanggal"));
                list.add(serahTerimaUang);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SerahTerimaUangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public SerahTerimaUang getSerahTerimaByID(int id) {
        SerahTerimaUang serahTerimaUang = new SerahTerimaUang();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sqlGetBSTUByID);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                serahTerimaUang.setId(rs.getInt("id"));
                serahTerimaUang.setKodeBSTU(rs.getString("kodebstu"));
                serahTerimaUang.setNama(rs.getString("nama"));
                serahTerimaUang.setUraian(rs.getString("uraian"));
                serahTerimaUang.setJumlah(rs.getInt("jumlah"));
                serahTerimaUang.setKeterangan(rs.getString("keterangan"));
                serahTerimaUang.setStatus(rs.getString("status"));
                serahTerimaUang.setJenisbstu(rs.getString("jenisbstu"));
                serahTerimaUang.setDiserahkan(rs.getString("diserahkan"));
                serahTerimaUang.setTanggal(rs.getString("tanggal"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SerahTerimaUangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return serahTerimaUang;
    }

    @Override
    public SerahTerimaUang getSerahTerimaByKode(String kode) {
        SerahTerimaUang serahTerimaUang = new SerahTerimaUang();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sqlGetBSTUByKode);
            statement.setString(1, kode);
            rs = statement.executeQuery();
            while (rs.next()) {
                serahTerimaUang.setId(rs.getInt("id"));
                serahTerimaUang.setKodeBSTU(rs.getString("kodebstu"));
                serahTerimaUang.setNama(rs.getString("nama"));
                serahTerimaUang.setUraian(rs.getString("uraian"));
                serahTerimaUang.setJumlah(rs.getInt("jumlah"));
                serahTerimaUang.setKeterangan(rs.getString("keterangan"));
                serahTerimaUang.setStatus(rs.getString("status"));
                serahTerimaUang.setJenisbstu(rs.getString("jenisbstu"));
                serahTerimaUang.setDiserahkan(rs.getString("diserahkan"));
                serahTerimaUang.setTanggal(rs.getString("tanggal"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SerahTerimaUangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return serahTerimaUang;
    }

    @Override
    public void insertBSTU(SerahTerimaUang stu) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlInsertBSTU);
            statement.setString(1, stu.getKodeBSTU());
            statement.setString(2, stu.getNama());
            statement.setInt(3, stu.getJumlah());
            statement.setString(4, stu.getStatus());
            statement.setString(5, stu.getJenisbstu());
            statement.setString(6, stu.getDiserahkan());
            statement.setString(7, stu.getTanggal());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SerahTerimaUangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateBSTU(SerahTerimaUang stu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteBSTU(SerahTerimaUang stu) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlDeleteBSTU);
            statement.setInt(1, stu.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SerahTerimaUangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void InsertTempBSTU(SerahTerimaUang stu) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlInsertTempBSTU);
            statement.setString(1, stu.getNama());
            statement.setString(2, stu.getUraian());
            statement.setString(3, stu.getKeterangan());
            statement.setInt(4, stu.getJumlah());
            statement.setString(5, stu.getKodeBSTU());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SerahTerimaUangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void truncateTempBSTU() {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlTruncateBSTU);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SerahTerimaUangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<SerahTerimaUang> GetAllTempBSTU() {
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<SerahTerimaUang> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sqlGetAllTempBSTU);
            rs = statement.executeQuery();
            while (rs.next()) {
                SerahTerimaUang stu = new SerahTerimaUang();
                stu.setId(rs.getInt("id"));
                stu.setNama(rs.getString("nama"));
                stu.setUraian(rs.getString("uraian"));
                stu.setKeterangan(rs.getString("keterangan"));
                stu.setJumlah(rs.getInt("jumlah"));
                list.add(stu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SerahTerimaUangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public int getSUMTemp(String kode) {
        PreparedStatement statement = null;
        int jumlah = 0;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sqlGetSUmTemp);
            statement.setString(1, kode);
            rs = statement.executeQuery();
            while (rs.next()) {
                jumlah = rs.getInt("jumlahnya");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SerahTerimaUangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jumlah;
    }

    @Override
    public void lookBSTUDetailToTemp(String kode) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlTransferDetailToTemp);
            statement.setString(1, kode);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SerahTerimaUangDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
