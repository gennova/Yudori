/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.kas;

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
public class KasDaoImplemen implements KasDao {

    private Connection connection;
    private static final String sqlInsertKas = "call spInsertKas(?,?)";
    private static final String sqlInsertKasTemp = "call spInsertKasTemp(?,?,?,?,?,?,?)";
    private static final String sqlGetAllKas = "select * from kas";
    private static final String sqlGetAllKasDetailByDate = "SELECT *, @k:=IF(jeniskas='Keluar',total,0) AS Kredit,@d:=IF(jeniskas='Masuk',total,0) AS Debet , @s:=@s+@d-@k AS Saldo FROM kasdetail where tanggal=?";
    private static final String sqlGetAllKasDetailByDateBulanan = "SELECT *, @k:=IF(jeniskas='Keluar',total,0) AS Kredit,@d:=IF(jeniskas='Masuk',total,0) AS Debet , @s:=@s+@d-@k AS Saldo FROM kasdetail where tanggal between ? and ?";
    private static final String sqlGetAllKasDetailTemp = "select * from kasdetail_temp";
    private static final String sqlInsertDetailToTemp = "insert into kasdetail_temp select * from kasdetail where kodekas=?";

    public KasDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Kas> getALlKas() {
        List<Kas> kases = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareCall(sqlGetAllKas);
            rs = statement.executeQuery();
            while (rs.next()) {
                Kas k = new Kas();
                k.setIdKas(rs.getInt("id")); //1
                k.setKodeKas(rs.getString("kodekas")); //2
                k.setKodeManKas(rs.getString("kodekasmanual")); //3
                k.setTanggal(rs.getString("tanggal")); //4
                k.setSaldo(rs.getInt("total")); //5
                kases.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KasDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(kases.size());
        return kases;
    }

    @Override
    public List<Kas> getALlKasByDate(String date) {
        List<Kas> kases = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement("select @s:=0");
            statement.executeQuery();
            statement = connection.prepareCall(sqlGetAllKasDetailByDate);
            statement.setString(1, date);
            rs = statement.executeQuery();
            while (rs.next()) {
                Kas k = new Kas();
                k.setIdKas(rs.getInt("id")); //1
                k.setKodeKas(rs.getString("kodekas")); //2
                k.setKodeManKas(rs.getString("kodekasmanual")); //3
                k.setTanggal(rs.getString("tanggal")); //4
                k.setUraian(rs.getString("uraian")); //5
                k.setJenisKas(rs.getString("jeniskas")); //6
                k.setSaldo(rs.getInt("Saldo")); //7   // saldo trx
                k.setKredit(rs.getInt("Kredit")); // 8
                k.setDebet(rs.getInt("Debet")); // 8
                k.setKodeakun(rs.getString("kodeakun")); //8
                kases.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KasDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kases;
    }

    @Override
    public List<Kas> getALlKasByDateBulanan(String date, String date_akhir) {
        List<Kas> kases = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement("select @s:=0");
            statement.executeQuery();
            statement = connection.prepareCall(sqlGetAllKasDetailByDateBulanan);
            statement.setString(1, date);
            statement.setString(2, date_akhir);
            rs = statement.executeQuery();
            while (rs.next()) {
                Kas k = new Kas();
                k.setIdKas(rs.getInt("id")); //1
                k.setKodeKas(rs.getString("kodekas")); //2
                k.setKodeManKas(rs.getString("kodekasmanual")); //3
                k.setTanggal(rs.getString("tanggal")); //4
                k.setUraian(rs.getString("uraian")); //5
                k.setJenisKas(rs.getString("jeniskas")); //6
                k.setSaldo(rs.getInt("Saldo")); //7   // saldo trx
                k.setKredit(rs.getInt("Kredit")); // 8
                k.setDebet(rs.getInt("Debet")); // 8
                k.setKodeakun(rs.getString("kodeakun")); //8
                kases.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KasDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kases;
    }    
    

    @Override
    public Kas getKasByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Kas getKasByKodeKas(String kode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Kas getKasByKodeKasManual(String kode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertKas(Kas kas) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlInsertKas);
            statement.setString(1, kas.getKodeKas()); //1
            statement.setString(2, kas.getKodeManKas()); //2
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Kas Operasional Berhasil Disimpan");
        } catch (SQLException ex) {
            Logger.getLogger(KasDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteKas(Kas kas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateKas(Kas kas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertKasTemp(Kas kas) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlInsertKasTemp);
            statement.setString(1, kas.getKodeKas());
            statement.setString(2, kas.getKodeManKas());
            statement.setString(3, kas.getTanggal());
            statement.setInt(4, kas.getSaldo());
            statement.setString(5, kas.getJenisKas());
            statement.setString(6, kas.getUraian());
            statement.setString(7, kas.getKodeakun());
            statement.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Data Kas Operasional Berhasil Disimpan");
        } catch (SQLException ex) {
            Logger.getLogger(KasDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void truncateKasTemp() {
        try {
            PreparedStatement statement = connection.prepareStatement("truncate kasdetail_temp");
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KasDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Kas> getALlKasTemp() {
        List<Kas> kases = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareCall(sqlGetAllKasDetailTemp);
            rs = statement.executeQuery();
            while (rs.next()) {
                Kas k = new Kas();
                k.setIdKas(rs.getInt("id")); //1
                k.setKodeKas(rs.getString("kodekas")); //2
                k.setKodeManKas(rs.getString("kodekasmanual")); //3
                k.setTanggal(rs.getString("tanggal")); //4
                k.setUraian(rs.getString("uraian")); //5
                k.setJenisKas(rs.getString("jeniskas")); //6
                k.setSaldo(rs.getInt("total")); //7
                k.setKodeakun(rs.getString("kodeakun")); //8
                kases.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KasDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kases;
    }

    @Override
    public void insertDetailToTemp(String kode) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlInsertDetailToTemp);
            ps.setString(1, kode);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KasDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
