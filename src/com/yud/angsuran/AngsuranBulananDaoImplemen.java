/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.angsuran;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author legollas
 */
public class AngsuranBulananDaoImplemen implements AngsuranBulananDao {

    private Connection c;
    private final static String sqlGetALlABS = "select * from bantucetakand";
    private final static String sqlInsertAngsuranBulanan = "INSERT INTO bantucetakand(kodebp,kodeans,tanggal,jumlah,angsuran1,angsuran2,angsuran3,angsuran4,angsuran5,angsuran6,angsuran7,angsuran8,angsuran9,angsuran10,lunas) "
            + "VALUES();";
    private final static String sqlGetAllRincianAngsuranByKode = "select * from detailangsuran JOIN buktipesanan ON detailangsuran.nobp = buktipesanan.kodebp WHERE buktipesanan.statusbp='belum' and detailangsuran.nobp=?";
    private final static String sqlGetAllRincianAngsuranByHarianTgl = "SELECT * FROM detailangsuran JOIN buktipesanan ON detailangsuran.nobp = buktipesanan.kodebp WHERE buktipesanan.statusbp='belum' AND detailangsuran.tgl=?";
    private final static String sqlSUMGetAllRincianAngsuranByHarianTgl = "SELECT sum(detailangsuran.jumlah) as 'jumlahnya' FROM detailangsuran JOIN buktipesanan ON detailangsuran.nobp = buktipesanan.kodebp WHERE buktipesanan.statusbp='belum' AND detailangsuran.tgl=?";
    private final static String sqlGetAllRincianAngsuranByBulananTgl = "SELECT * FROM detailangsuran JOIN buktipesanan ON detailangsuran.nobp = buktipesanan.kodebp WHERE detailangsuran.tgl between ? and ? and buktipesanan.statusbp='belum'";
    private final static String sqlSUMGetAllRincianAngsuranByBulananTgl = "SELECT sum(detailangsuran.jumlah) as 'jumlahnya' FROM detailangsuran JOIN buktipesanan ON detailangsuran.nobp = buktipesanan.kodebp WHERE detailangsuran.tgl between ? and ? and buktipesanan.statusbp='belum'";
    private final static String sqlUpdateBulanan1 = "update bantucetakand set tglangsuran1=?,angsuran1=? where kodeans=?";
    private final static String sqlUpdateBulanan2 = "update bantucetakand set tglangsuran2=?,angsuran2=? where kodeans=?";
    private final static String sqlUpdateBulanan3 = "update bantucetakand set tglangsuran3=?,angsuran3=? where kodeans=?";
    private final static String sqlUpdateBulanan4 = "update bantucetakand set tglangsuran4=?,angsuran4=? where kodeans=?";
    private final static String sqlUpdateBulanan5 = "update bantucetakand set tglangsuran5=?,angsuran5=? where kodeans=?";
    private final static String sqlUpdateBulanan6 = "update bantucetakand set tglangsuran6=?,angsuran6=? where kodeans=?";
    private final static String sqlUpdateBulanan7 = "update bantucetakand set tglangsuran7=?,angsuran7=? where kodeans=?";
    private final static String sqlUpdateBulanan8 = "update bantucetakand set tglangsuran8=?,angsuran8=? where kodeans=?";
    private final static String sqlUpdateBulanan9 = "update bantucetakand set tglangsuran9=?,angsuran9=? where kodeans=?";
    private final static String sqlUpdateBulanan10 = "update bantucetakand set tglangsuran10=?,angsuran10=? where kodeans=?";

    public AngsuranBulananDaoImplemen(Connection c) {
        this.c = c;
    }

    @Override
    public List<AngsuranBulanan> getAllAngsuranBulanan() {
        List<AngsuranBulanan> abs = new ArrayList<>();
        return abs;
    }

    @Override
    public AngsuranBulanan getAngsuranBulananByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AngsuranBulanan getAngsuranBulananByKodeBP(String kode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AngsuranBulanan getAngsuranBulananByKodeANS(String kode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void InsertAngsuranBulanan(AngsuranBulanan ab) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DeleteAngsuranBulanan(AngsuranBulanan ab) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void UpdateAngsuranBulanan(AngsuranBulanan ab) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void UpdateAngsuranBulanan1(AngsuranBulanan ab) {
        PreparedStatement statement = null;
        try {
            statement = c.prepareStatement(sqlUpdateBulanan1);
            statement.setString(1, ab.getTgl1());
            statement.setString(2, ab.getAngsuran1());
            statement.setString(3, ab.getKodeans());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AngsuranBulananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void UpdateAngsuranBulanan2(AngsuranBulanan ab) {
        PreparedStatement statement = null;
        try {
            statement = c.prepareStatement(sqlUpdateBulanan2);
            statement.setString(1, ab.getTgl2());
            statement.setString(2, ab.getAngsuran2());
            statement.setString(3, ab.getKodeans());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AngsuranBulananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void UpdateAngsuranBulanan3(AngsuranBulanan ab) {
        PreparedStatement statement = null;
        try {
            statement = c.prepareStatement(sqlUpdateBulanan3);
            statement.setString(1, ab.getTgl3());
            statement.setString(2, ab.getAngsuran3());
            statement.setString(3, ab.getKodeans());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AngsuranBulananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void UpdateAngsuranBulanan4(AngsuranBulanan ab) {
        PreparedStatement statement = null;
        try {
            statement = c.prepareStatement(sqlUpdateBulanan4);
            statement.setString(1, ab.getTgl4());
            statement.setString(2, ab.getAngsuran4());
            statement.setString(3, ab.getKodeans());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AngsuranBulananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void UpdateAngsuranBulanan5(AngsuranBulanan ab) {
        PreparedStatement statement = null;
        try {
            statement = c.prepareStatement(sqlUpdateBulanan5);
            statement.setString(1, ab.getTgl5());
            statement.setString(2, ab.getAngsuran5());
            statement.setString(3, ab.getKodeans());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AngsuranBulananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void UpdateAngsuranBulanan6(AngsuranBulanan ab) {
        PreparedStatement statement = null;
        try {
            statement = c.prepareStatement(sqlUpdateBulanan6);
            statement.setString(1, ab.getTgl6());
            statement.setString(2, ab.getAngsuran6());
            statement.setString(3, ab.getKodeans());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AngsuranBulananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void UpdateAngsuranBulanan7(AngsuranBulanan ab) {
        PreparedStatement statement = null;
        try {
            statement = c.prepareStatement(sqlUpdateBulanan7);
            statement.setString(1, ab.getTgl7());
            statement.setString(2, ab.getAngsuran7());
            statement.setString(3, ab.getKodeans());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AngsuranBulananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void UpdateAngsuranBulanan8(AngsuranBulanan ab) {
        PreparedStatement statement = null;
        try {
            statement = c.prepareStatement(sqlUpdateBulanan8);
            statement.setString(1, ab.getTgl8());
            statement.setString(2, ab.getAngsuran8());
            statement.setString(3, ab.getKodeans());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AngsuranBulananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void UpdateAngsuranBulanan9(AngsuranBulanan ab) {
        PreparedStatement statement = null;
        try {
            statement = c.prepareStatement(sqlUpdateBulanan9);
            statement.setString(1, ab.getTgl9());
            statement.setString(2, ab.getAngsuran9());
            statement.setString(3, ab.getKodeans());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AngsuranBulananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void UpdateAngsuranBulanan10(AngsuranBulanan ab) {
        PreparedStatement statement = null;
        try {
            statement = c.prepareStatement(sqlUpdateBulanan10);
            statement.setString(1, ab.getTgl10());
            statement.setString(2, ab.getAngsuran10());
            statement.setString(3, ab.getKodeans());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AngsuranBulananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void resetSpaceDateAns(String kode) {
        PreparedStatement ps = null;
        String a = "UPDATE bantucetakand SET angsuran1='     ',angsuran2='     ',angsuran3='     ',angsuran4='     ',angsuran5='     ',angsuran6='     ',angsuran7='     ',angsuran8='     ',angsuran9='     ',angsuran10='     ',tglangsuran1='     ',tglangsuran2='     ',tglangsuran3='     ',tglangsuran4='     ',tglangsuran5='     ',tglangsuran6='     ',tglangsuran7='     ',tglangsuran8='     ',tglangsuran9='     ',tglangsuran10='     ' where kodebp=?";
        try {
            ps = c.prepareStatement(a);
            ps.setString(1, kode);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AngsuranBulananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insertdetailangsuran(AngsuranBulanan ab) {
        PreparedStatement statement = null;
        try {
            statement = c.prepareStatement("insert into detailangsuran (noans,nobp,tgl,angsuranke,jumlah) values(?,?,?,?,?)");
            statement.setString(1, ab.getKodeans());
            statement.setString(2, ab.getKodebp());
            statement.setString(3, ab.getTanggal());
            statement.setString(4, ab.getAngsuranke());
            statement.setInt(5, ab.getJumlah());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AngsuranBulananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Kesalahan Data karena "+ex.getMessage());
        }
    }

    @Override
    public List<AngsuranBulanan> getAllAngsuranBulananByKodeBP(String kode) {
        List<AngsuranBulanan> list = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        int jumlah = 0;
        try {
            statement = c.prepareStatement(sqlGetAllRincianAngsuranByKode);
            statement.setString(1, kode);
            rs = statement.executeQuery();
            while (rs.next()) {
                AngsuranBulanan ab = new AngsuranBulanan();
                ab.setKodeans(rs.getString("noans"));
                ab.setKodebp(rs.getString("nobp"));
                ab.setTanggal(rs.getString("tgl"));
                ab.setAngsuranke(rs.getString("angsuranke"));
                ab.setJumlah(rs.getInt("jumlah"));
                list.add(ab);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AngsuranBulananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<AngsuranBulanan> getAllAngsuranBulananByTglHarian(String tgl) {
        List<AngsuranBulanan> list = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = c.prepareStatement(sqlGetAllRincianAngsuranByHarianTgl);
            statement.setString(1, tgl);
            rs = statement.executeQuery();
            while (rs.next()) {
                AngsuranBulanan ab = new AngsuranBulanan();
                ab.setKodeans(rs.getString("noans"));
                ab.setKodebp(rs.getString("nobp"));
                ab.setTanggal(rs.getString("tgl"));
                ab.setAngsuranke(rs.getString("angsuranke"));
                ab.setJumlah(rs.getInt("jumlah"));
                list.add(ab);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AngsuranBulananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<AngsuranBulanan> getAllAngsuranBulananByTglBulanan(String dateone, String datetwo) {
        List<AngsuranBulanan> list = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = c.prepareStatement(sqlGetAllRincianAngsuranByBulananTgl);
            statement.setString(1, dateone);
            statement.setString(2, datetwo);
            rs = statement.executeQuery();
            while (rs.next()) {
                AngsuranBulanan ab = new AngsuranBulanan();
                ab.setKodeans(rs.getString("noans"));
                ab.setKodebp(rs.getString("nobp"));
                ab.setTanggal(rs.getString("tgl"));
                ab.setAngsuranke(rs.getString("angsuranke"));
                ab.setJumlah(rs.getInt("jumlah"));
                list.add(ab);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AngsuranBulananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public int getSUMAllAngsuranBulananByTglHarian(String tgl) {
        PreparedStatement statement = null;
        ResultSet rs = null;
        int jumlah = 0;
        try {
            statement = c.prepareStatement(sqlSUMGetAllRincianAngsuranByHarianTgl);
            statement.setString(1, tgl);
            rs = statement.executeQuery();
            while (rs.next()) {                
                jumlah = rs.getInt("jumlahnya");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AngsuranBulananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jumlah;
    }

    @Override
    public int getSUMAllAngsuranBulananByTglBulanan(String dateone, String datetwo) {
        PreparedStatement statement = null;
        ResultSet rs = null;
        int jumlah = 0;
        try {
            statement = c.prepareStatement(sqlSUMGetAllRincianAngsuranByBulananTgl);
            statement.setString(1, dateone);
            statement.setString(2, datetwo);
            rs = statement.executeQuery();
            while (rs.next()) {                
                jumlah = rs.getInt("jumlahnya");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AngsuranBulananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Kesalahan data "+ex.getMessage());
        }
        return jumlah;
    }
}
