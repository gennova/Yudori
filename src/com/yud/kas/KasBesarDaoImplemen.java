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
public class KasBesarDaoImplemen implements KasBesarDao {

    private Connection connection;
    private final String sqlInsertKas = "call spInsertKasBesar(?,?)";
    private final String sqlInsertKasTemp = "call spInsertKasBesarTemp(?,?,?,?,?,?,?)";
    private final String sqlGetAllKas = "select * from kas_besar";
    private final String sqlGetAllKasBesarDetailByDate = "SELECT *, @k:=IF(jeniskas='Keluar',total,0) AS Kredit,@d:=IF(jeniskas='Masuk',total,0) AS Debet , @s:=@s+@d-@k AS Saldo FROM kas_besar_detail_temp where tanggal=?";
    private final String sqlGetAllKasBesarDetailByDateBulanan = "SELECT *, @k:=IF(jeniskas='Keluar',total,0) AS Kredit,@d:=IF(jeniskas='Masuk',total,0) AS Debet , @s:=@s+@d-@k AS Saldo FROM kas_besar_detail_temp where tanggal between ? and ? order by tanggal asc,id asc";
    private final String sqlGetAllKasDetailTemp = "select * from kas_besar_detail_temp";
    private final String sqlInsertDetailToTemp = "insert into kas_besar_detail_temp select id,kodekas,kodekasmanual,tanggal,total,jeniskas,uraian,kodeakun from kas_besar_detail where kodekas=?";
    private final String sqlCetakLaporanKasBesarHarianTemp = "call spCetakLaporanKasBesar(?)";
    private final String sqlCetakLaporanKasBesarBulananTemp = "call spCetakLaporanKasBesarBulanan2(?,?)";

    public KasBesarDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<KasBesar> getALlKasBesar() {
        List<KasBesar> kases = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareCall(sqlGetAllKas);
            rs = statement.executeQuery();
            while (rs.next()) {
                KasBesar k = new KasBesar();
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
    public List<KasBesar> getALlKasBesarByDate(String date) {        
        List<KasBesar> kases = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            this.rekap_kas_besar_to_temp_harian(date); // load dulu ke temp detail kas besar
            statement = connection.prepareStatement("select @s:=0");
            statement.executeQuery();
            statement = connection.prepareCall(sqlGetAllKasBesarDetailByDate);
            statement.setString(1, date);
            rs = statement.executeQuery();
            while (rs.next()) {
                KasBesar k = new KasBesar();
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
    public List<KasBesar> getALlKasBesarByDateBulanan(String date, String date_akhir) {
        List<KasBesar> kases = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            this.rekap_kas_besar_to_temp_bulanan(date, date_akhir);
            statement = connection.prepareStatement("select @s:=0");
            statement.executeQuery();
            statement = connection.prepareCall(sqlGetAllKasBesarDetailByDateBulanan);
            statement.setString(1, date);
            statement.setString(2, date_akhir);
            rs = statement.executeQuery();
            while (rs.next()) {
                KasBesar k = new KasBesar();
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
    public List<KasBesar> getALlKasBesarTemp() {
        List<KasBesar> kases = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareCall(sqlGetAllKasDetailTemp);
            rs = statement.executeQuery();
            while (rs.next()) {
                KasBesar k = new KasBesar();
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
    public KasBesar getKasBesarByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KasBesar getKasBesarByKodeKas(String kode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KasBesar getKasBesarByKodeKasManual(String kode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<KasBesar> getLaporanKasBesar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertKasBesar(KasBesar kas) {
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
    public void deleteKasBesar(KasBesar kas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateKasBesar(KasBesar kas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertKasBesarTemp(KasBesar kas) {
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

    @Override
    public void truncateKasTemp() {
        try {
            PreparedStatement statement = connection.prepareStatement("truncate kas_besar_detail_temp");
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KasDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void rekap_kas_besar_to_temp_harian(String date) {
        try {
            PreparedStatement ps = connection.prepareStatement(sqlCetakLaporanKasBesarHarianTemp);
            ps.setString(1, date);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KasBesarDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void rekap_kas_besar_to_temp_bulanan(String date, String date_akhir) {
        try {
            PreparedStatement ps = connection.prepareStatement(sqlCetakLaporanKasBesarBulananTemp);
            ps.setString(1, date);
            ps.setString(2, date_akhir);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KasBesarDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
