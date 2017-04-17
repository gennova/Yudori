/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.komisi;

import com.init.tools.DaoFactory;
import com.yud.stb.BuktiPesanan;
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
public class KomisiDaoImplemen implements KomisiDao {

    private Connection connection;
    private final static String sqlGetALlKomisi = "SELECT * FROM komisisales JOIN buktipesanan ON komisisales.kodebp=buktipesanan.kodebp";
    private final static String sqlGetALlKomisiByDatePesanan = "SELECT * FROM komisisales JOIN buktipesanan ON komisisales.kodebp=buktipesanan.kodebp where buktipesanan.tglpesanan=? and komisisales.statusbereskomisi='belum'";
    private final static String sqlGetALlKomisiByDatePesananRekap = "SELECT *, SUM(komisisales.komisibprupiah) AS 'totapkomisibp' FROM komisisales JOIN buktipesanan ON komisisales.kodebp=buktipesanan.kodebp WHERE buktipesanan.tglpesanan=? AND komisisales.statusbereskomisi='belum' GROUP BY buktipesanan.idsales";
    private final static String sqlGetALlKomisiByKodeBP = "SELECT * FROM komisisales JOIN buktipesanan ON komisisales.kodebp=buktipesanan.kodebp where komisisales.kodebp=? and komisisales.statusbereskomisi='belum'";
    private final static String sqlUpdateKomisByKodeBpSaja = "UPDATE komisisales SET komisibp=?,komisia1=?,komisilunas=?,komisitunai=?,komisibprupiah= (komisibp/100) * totaljual,komisia1rupiah =(komisia1/100) * totaljual,komisilunasrupiah =(komisilunas/100) * totaljual,komisitunasirupiah = (komisitunai/100) * totaljual,totalkomisi= komisibprupiah+komisia1rupiah+komisilunasrupiah+komisitunasirupiah WHERE kodebp=?;";
    private final static String sqlPostingKomisi = "update komisisales set statusbereskomisi='sudah' where kodebp=?";
    private final static String sqlGetAllKomisiA1 = "SELECT * FROM komisisales JOIN buktipesanan ON komisisales.kodebp=buktipesanan.kodebp WHERE komisisales.komisia1 IS NOT NULL AND  komisisales.komisia1>0.0 AND komisisales.statuskomisia1 IS NOT NULL AND komisisales.statusbereskomisi='belum';";
    private final static String sqlGetAllKomisiA1Rekap = "SELECT * , SUM(komisisales.komisia1rupiah) AS 'totalkomisia1' FROM komisisales JOIN buktipesanan ON komisisales.kodebp=buktipesanan.kodebp WHERE komisisales.komisia1 IS NOT NULL AND komisisales.statuskomisia1 IS NOT NULL AND  komisisales.komisia1>0.0 AND komisisales.statusbereskomisi='belum' GROUP BY komisisales.idsales";
    private final static String sqlGetAllKomisiA1RekapDate = "SELECT * , SUM(komisisales.komisia1rupiah) AS 'totalkomisia1' FROM komisisales JOIN buktipesanan ON komisisales.kodebp=buktipesanan.kodebp WHERE komisisales.komisia1 IS NOT NULL AND komisisales.statuskomisia1 IS NOT NULL AND  komisisales.komisia1>0.0 AND komisisales.statusbereskomisi='belum' and komisisales.statuskomisia1=? GROUP BY komisisales.idsales";
    private final static String sqlGetAllKomisiLunasKartu = "SELECT * FROM komisisales JOIN buktipesanan ON komisisales.kodebp=buktipesanan.kodebp WHERE komisisales.komisilunas IS NOT NULL AND  komisisales.komisilunas>0.0 AND komisisales.statuskomisilunas IS NOT NULL AND komisisales.statusbereskomisi='belum';";
    private final static String sqlGetAllKomisiLunasKartuRekap = "SELECT * , SUM(komisisales.komisilunasrupiah) AS 'totalkomisilunas' FROM komisisales JOIN buktipesanan ON komisisales.kodebp=buktipesanan.kodebp WHERE komisisales.komisilunas IS NOT NULL AND komisisales.statuskomisilunas IS NOT NULL AND  komisisales.komisilunas>0.0 AND komisisales.statusbereskomisi='belum' GROUP BY komisisales.idsales;";
    private final static String sqlGetAllKomisiTunai = "SELECT * FROM komisisales JOIN buktipesanan ON komisisales.kodebp=buktipesanan.kodebp WHERE komisisales.komisitunai IS NOT NULL AND  komisisales.komisitunai>0.0 AND komisisales.statuskomisitunasi IS NOT NULL AND komisisales.statusbereskomisi='belum';";
    private final static String sqlGetAllKomisiTunaiRekap = "SELECT * , SUM(komisisales.komisitunasirupiah) AS 'totalkomisitunai' FROM komisisales JOIN buktipesanan ON komisisales.kodebp=buktipesanan.kodebp WHERE komisisales.komisitunai IS NOT NULL AND komisisales.statuskomisitunasi IS NOT NULL AND  komisisales.komisitunai>0.0 AND komisisales.statusbereskomisi='belum' GROUP BY komisisales.idsales;";

    public KomisiDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertKomisiSales(Komisi komisi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Komisi> getAllKomisiSales() {
        List<Komisi> Lists = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sqlGetALlKomisi);
            rs = statement.executeQuery();
            while (rs.next()) {
                Komisi k = new Komisi();
                k.setId(rs.getInt("id"));
                k.setBp(DaoFactory.getBuktiPesananDao().getBuktiPesananByKodeBP(rs.getString("kodebp")));
                k.setSales(DaoFactory.getSalesDao().getSalesByID(rs.getInt("idsales")));
                k.setKomisibp(rs.getDouble("komisibp"));
                k.setKomisia1(rs.getDouble("komisia1"));
                k.setKomisilunas(rs.getDouble("komisilunas"));
                k.setKomdisitunai(rs.getDouble("komisitunai"));
                k.setRpkomisibp(rs.getDouble("komisibprupiah"));
                k.setRpkomisia1(rs.getDouble("komisia1rupiah"));
                k.setRpkomisilunas(rs.getDouble("komisilunasrupiah"));
                k.setRpkomisitunai(rs.getDouble("komisitunasirupiah"));
                k.setStatuskomisibp(rs.getString("statuskomisibp"));
                k.setStatuskomisia1(rs.getString("statuskomisia1"));
                k.setStatuskomisilunas(rs.getString("statuskomisilunas"));
                k.setStatuskomisitunasi(rs.getString("statuskomisitunasi"));
                k.setStatuskomisi(rs.getString("statusbereskomisi"));
                k.setTotalkomisi(rs.getDouble("totalkomisi"));
                k.setTotaljual(rs.getDouble("totaljual"));
                Lists.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KomisiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Lists;
    }

    @Override
    public Komisi getKomisiSalesByKodeBp(String kodebp) {
        Komisi k = new Komisi();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sqlGetALlKomisiByKodeBP);
            statement.setString(1, kodebp);
            rs = statement.executeQuery();
            while (rs.next()) {
                k.setId(rs.getInt("id"));
                k.setBp(DaoFactory.getBuktiPesananDao().getBuktiPesananByKodeBP(rs.getString("kodebp")));
                k.setSales(DaoFactory.getSalesDao().getSalesByID(rs.getInt("idsales")));
                k.setKomisibp(rs.getDouble("komisibp"));
                k.setKomisia1(rs.getDouble("komisia1"));
                k.setKomisilunas(rs.getDouble("komisilunas"));
                k.setKomdisitunai(rs.getDouble("komisitunai"));
                k.setRpkomisibp(rs.getDouble("komisibprupiah"));
                k.setRpkomisia1(rs.getDouble("komisia1rupiah"));
                k.setRpkomisilunas(rs.getDouble("komisilunasrupiah"));
                k.setRpkomisitunai(rs.getDouble("komisitunasirupiah"));
                k.setStatuskomisibp(rs.getString("statuskomisibp"));
                k.setStatuskomisia1(rs.getString("statuskomisia1"));
                k.setStatuskomisilunas(rs.getString("statuskomisilunas"));
                k.setStatuskomisitunasi(rs.getString("statuskomisitunasi"));
                k.setStatuskomisi(rs.getString("statusbereskomisi"));
                k.setTotalkomisi(rs.getDouble("totalkomisi"));
                k.setTotaljual(rs.getDouble("totaljual"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KomisiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return k;
    }

    @Override
    public void updateKomisiSales(Komisi komisi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateKomisiSalesSaja(Komisi komisi) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlUpdateKomisByKodeBpSaja);
            statement.setDouble(1, komisi.getKomisibp());
            statement.setDouble(2, komisi.getKomisia1());
            statement.setDouble(3, komisi.getKomisilunas());
            statement.setDouble(4, komisi.getKomdisitunai());
            statement.setString(5, komisi.getBp().getKodePesanan());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Komisi berhasil disimpan");
        } catch (SQLException ex) {
            Logger.getLogger(KomisiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Kesalahan Data " + ex.getMessage());
        }

    }

    @Override
    public void postingKomisiSales(String kodebp) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlPostingKomisi);
            statement.setString(1, kodebp);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Komisi Sales Berhasil di Posting");
        } catch (SQLException ex) {
            Logger.getLogger(KomisiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error, Kesalahan Sistem/Input Data " + ex.getMessage());
        }

    }

    @Override
    public List<Komisi> getAllKomisiSalesByDatePesanan(String date) {
        List<Komisi> Lists = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sqlGetALlKomisiByDatePesanan);
            statement.setString(1, date);
            rs = statement.executeQuery();
            while (rs.next()) {
                Komisi k = new Komisi();
                k.setId(rs.getInt("id"));
                k.setBp(DaoFactory.getBuktiPesananDao().getBuktiPesananByKodeBP(rs.getString("kodebp")));
                k.setSales(DaoFactory.getSalesDao().getSalesByID(rs.getInt("idsales")));
                k.setKomisibp(rs.getDouble("komisibp"));
                k.setKomisia1(rs.getDouble("komisia1"));
                k.setKomisilunas(rs.getDouble("komisilunas"));
                k.setKomdisitunai(rs.getDouble("komisitunai"));
                k.setRpkomisibp(rs.getDouble("komisibprupiah"));
                k.setRpkomisia1(rs.getDouble("komisia1rupiah"));
                k.setRpkomisilunas(rs.getDouble("komisilunasrupiah"));
                k.setRpkomisitunai(rs.getDouble("komisitunasirupiah"));
                k.setStatuskomisibp(rs.getString("statuskomisibp"));
                k.setStatuskomisia1(rs.getString("statuskomisia1"));
                k.setStatuskomisilunas(rs.getString("statuskomisilunas"));
                k.setStatuskomisitunasi(rs.getString("statuskomisitunasi"));
                k.setStatuskomisi(rs.getString("statusbereskomisi"));
                k.setTotalkomisi(rs.getDouble("totalkomisi"));
                k.setTotaljual(rs.getDouble("totaljual"));
                Lists.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KomisiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Lists;
    }

    @Override
    public List<Komisi> getAllKomisiSalesByA1() {
        List<Komisi> Lists = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sqlGetAllKomisiA1);
            rs = statement.executeQuery();
            while (rs.next()) {
                Komisi k = new Komisi();
                k.setId(rs.getInt("id"));
                k.setBp(DaoFactory.getBuktiPesananDao().getBuktiPesananByKodeBP(rs.getString("kodebp")));
                k.setSales(DaoFactory.getSalesDao().getSalesByID(rs.getInt("idsales")));
                k.setKomisibp(rs.getDouble("komisibp"));
                k.setKomisia1(rs.getDouble("komisia1"));
                k.setKomisilunas(rs.getDouble("komisilunas"));
                k.setKomdisitunai(rs.getDouble("komisitunai"));
                k.setRpkomisibp(rs.getDouble("komisibprupiah"));
                k.setRpkomisia1(rs.getDouble("komisia1rupiah"));
                k.setRpkomisilunas(rs.getDouble("komisilunasrupiah"));
                k.setRpkomisitunai(rs.getDouble("komisitunasirupiah"));
                k.setStatuskomisibp(rs.getString("statuskomisibp"));
                k.setStatuskomisia1(rs.getString("statuskomisia1"));
                k.setStatuskomisilunas(rs.getString("statuskomisilunas"));
                k.setStatuskomisitunasi(rs.getString("statuskomisitunasi"));
                k.setStatuskomisi(rs.getString("statusbereskomisi"));
                k.setTotalkomisi(rs.getDouble("totalkomisi"));
                k.setTotaljual(rs.getDouble("totaljual"));
                Lists.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KomisiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Lists;
    }

    @Override
    public List<Komisi> getAllKomisiSalesByLUNAS() {
        List<Komisi> Lists = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sqlGetAllKomisiLunasKartu);
            rs = statement.executeQuery();
            while (rs.next()) {
                Komisi k = new Komisi();
                k.setId(rs.getInt("id"));
                k.setBp(DaoFactory.getBuktiPesananDao().getBuktiPesananByKodeBP(rs.getString("kodebp")));
                k.setSales(DaoFactory.getSalesDao().getSalesByID(rs.getInt("idsales")));
                k.setKomisibp(rs.getDouble("komisibp"));
                k.setKomisia1(rs.getDouble("komisia1"));
                k.setKomisilunas(rs.getDouble("komisilunas"));
                k.setKomdisitunai(rs.getDouble("komisitunai"));
                k.setRpkomisibp(rs.getDouble("komisibprupiah"));
                k.setRpkomisia1(rs.getDouble("komisia1rupiah"));
                k.setRpkomisilunas(rs.getDouble("komisilunasrupiah"));
                k.setRpkomisitunai(rs.getDouble("komisitunasirupiah"));
                k.setStatuskomisibp(rs.getString("statuskomisibp"));
                k.setStatuskomisia1(rs.getString("statuskomisia1"));
                k.setStatuskomisilunas(rs.getString("statuskomisilunas"));
                k.setStatuskomisitunasi(rs.getString("statuskomisitunasi"));
                k.setStatuskomisi(rs.getString("statusbereskomisi"));
                k.setTotalkomisi(rs.getDouble("totalkomisi"));
                k.setTotaljual(rs.getDouble("totaljual"));
                Lists.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KomisiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Lists;
    }

    @Override
    public List<Komisi> getAllKomisiSalesByTUNASI() {
        List<Komisi> Lists = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sqlGetAllKomisiTunai);
            rs = statement.executeQuery();
            while (rs.next()) {
                Komisi k = new Komisi();
                k.setId(rs.getInt("id"));
                k.setBp(DaoFactory.getBuktiPesananDao().getBuktiPesananByKodeBP(rs.getString("kodebp")));
                k.setSales(DaoFactory.getSalesDao().getSalesByID(rs.getInt("idsales")));
                k.setKomisibp(rs.getDouble("komisibp"));
                k.setKomisia1(rs.getDouble("komisia1"));
                k.setKomisilunas(rs.getDouble("komisilunas"));
                k.setKomdisitunai(rs.getDouble("komisitunai"));
                k.setRpkomisibp(rs.getDouble("komisibprupiah"));
                k.setRpkomisia1(rs.getDouble("komisia1rupiah"));
                k.setRpkomisilunas(rs.getDouble("komisilunasrupiah"));
                k.setRpkomisitunai(rs.getDouble("komisitunasirupiah"));
                k.setStatuskomisibp(rs.getString("statuskomisibp"));
                k.setStatuskomisia1(rs.getString("statuskomisia1"));
                k.setStatuskomisilunas(rs.getString("statuskomisilunas"));
                k.setStatuskomisitunasi(rs.getString("statuskomisitunasi"));
                k.setStatuskomisi(rs.getString("statusbereskomisi"));
                k.setTotalkomisi(rs.getDouble("totalkomisi"));
                k.setTotaljual(rs.getDouble("totaljual"));
                Lists.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KomisiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Lists;
    }

    @Override
    public List<Komisi> getAllKomisiSalesByDatePesananRekap(String date) {
        List<Komisi> Lists = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sqlGetALlKomisiByDatePesananRekap);
            statement.setString(1, date);
            rs = statement.executeQuery();
            while (rs.next()) {
                Komisi k = new Komisi();
                k.setId(rs.getInt("id"));
                k.setBp(DaoFactory.getBuktiPesananDao().getBuktiPesananByKodeBP(rs.getString("kodebp")));
                k.setSales(DaoFactory.getSalesDao().getSalesByID(rs.getInt("idsales")));
                k.setKomisibp(rs.getDouble("komisibp"));
                k.setKomisia1(rs.getDouble("komisia1"));
                k.setKomisilunas(rs.getDouble("komisilunas"));
                k.setKomdisitunai(rs.getDouble("komisitunai"));
                k.setRpkomisibp(rs.getDouble("komisibprupiah"));
                k.setRpkomisia1(rs.getDouble("komisia1rupiah"));
                k.setRpkomisilunas(rs.getDouble("komisilunasrupiah"));
                k.setRpkomisitunai(rs.getDouble("komisitunasirupiah"));
                k.setStatuskomisibp(rs.getString("statuskomisibp"));
                k.setStatuskomisia1(rs.getString("statuskomisia1"));
                k.setStatuskomisilunas(rs.getString("statuskomisilunas"));
                k.setStatuskomisitunasi(rs.getString("statuskomisitunasi"));
                k.setStatuskomisi(rs.getString("statusbereskomisi"));
                k.setTotalkomisi(rs.getDouble("totalkomisi"));
                k.setTotaljual(rs.getDouble("totaljual"));
                k.setTotalkomisirekap(rs.getDouble("totapkomisibp"));
                Lists.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KomisiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Lists;
    }

    @Override
    public List<Komisi> getAllKomisiSalesByA1Rekap() {
        List<Komisi> Lists = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sqlGetAllKomisiA1Rekap);
            rs = statement.executeQuery();
            while (rs.next()) {
                Komisi k = new Komisi();
                k.setId(rs.getInt("id"));
                k.setBp(DaoFactory.getBuktiPesananDao().getBuktiPesananByKodeBP(rs.getString("kodebp")));
                k.setSales(DaoFactory.getSalesDao().getSalesByID(rs.getInt("idsales")));
                k.setKomisibp(rs.getDouble("komisibp"));
                k.setKomisia1(rs.getDouble("komisia1"));
                k.setKomisilunas(rs.getDouble("komisilunas"));
                k.setKomdisitunai(rs.getDouble("komisitunai"));
                k.setRpkomisibp(rs.getDouble("komisibprupiah"));
                k.setRpkomisia1(rs.getDouble("komisia1rupiah"));
                k.setRpkomisilunas(rs.getDouble("komisilunasrupiah"));
                k.setRpkomisitunai(rs.getDouble("komisitunasirupiah"));
                k.setStatuskomisibp(rs.getString("statuskomisibp"));
                k.setStatuskomisia1(rs.getString("statuskomisia1"));
                k.setStatuskomisilunas(rs.getString("statuskomisilunas"));
                k.setStatuskomisitunasi(rs.getString("statuskomisitunasi"));
                k.setStatuskomisi(rs.getString("statusbereskomisi"));
                k.setTotalkomisi(rs.getDouble("totalkomisi"));
                k.setTotaljual(rs.getDouble("totaljual"));
                k.setTotalkomisirekap(rs.getDouble("totalkomisia1"));
                Lists.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KomisiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Lists;
    }

    @Override
    public List<Komisi> getAllKomisiSalesByLUNASRekap() {
        List<Komisi> Lists = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sqlGetAllKomisiLunasKartuRekap);
            rs = statement.executeQuery();
            while (rs.next()) {
                Komisi k = new Komisi();
                k.setId(rs.getInt("id"));
                k.setBp(DaoFactory.getBuktiPesananDao().getBuktiPesananByKodeBP(rs.getString("kodebp")));
                k.setSales(DaoFactory.getSalesDao().getSalesByID(rs.getInt("idsales")));
                k.setKomisibp(rs.getDouble("komisibp"));
                k.setKomisia1(rs.getDouble("komisia1"));
                k.setKomisilunas(rs.getDouble("komisilunas"));
                k.setKomdisitunai(rs.getDouble("komisitunai"));
                k.setRpkomisibp(rs.getDouble("komisibprupiah"));
                k.setRpkomisia1(rs.getDouble("komisia1rupiah"));
                k.setRpkomisilunas(rs.getDouble("komisilunasrupiah"));
                k.setRpkomisitunai(rs.getDouble("komisitunasirupiah"));
                k.setStatuskomisibp(rs.getString("statuskomisibp"));
                k.setStatuskomisia1(rs.getString("statuskomisia1"));
                k.setStatuskomisilunas(rs.getString("statuskomisilunas"));
                k.setStatuskomisitunasi(rs.getString("statuskomisitunasi"));
                k.setStatuskomisi(rs.getString("statusbereskomisi"));
                k.setTotalkomisi(rs.getDouble("totalkomisi"));
                k.setTotaljual(rs.getDouble("totaljual"));
                k.setTotalkomisirekap(rs.getDouble("totalkomisilunas"));
                Lists.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KomisiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Lists;
    }

    @Override
    public List<Komisi> getAllKomisiSalesByTUNASIRekap() {
        List<Komisi> Lists = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sqlGetAllKomisiTunaiRekap);
            rs = statement.executeQuery();
            while (rs.next()) {
                Komisi k = new Komisi();
                k.setId(rs.getInt("id"));
                k.setBp(DaoFactory.getBuktiPesananDao().getBuktiPesananByKodeBP(rs.getString("kodebp")));
                k.setSales(DaoFactory.getSalesDao().getSalesByID(rs.getInt("idsales")));
                k.setKomisibp(rs.getDouble("komisibp"));
                k.setKomisia1(rs.getDouble("komisia1"));
                k.setKomisilunas(rs.getDouble("komisilunas"));
                k.setKomdisitunai(rs.getDouble("komisitunai"));
                k.setRpkomisibp(rs.getDouble("komisibprupiah"));
                k.setRpkomisia1(rs.getDouble("komisia1rupiah"));
                k.setRpkomisilunas(rs.getDouble("komisilunasrupiah"));
                k.setRpkomisitunai(rs.getDouble("komisitunasirupiah"));
                k.setStatuskomisibp(rs.getString("statuskomisibp"));
                k.setStatuskomisia1(rs.getString("statuskomisia1"));
                k.setStatuskomisilunas(rs.getString("statuskomisilunas"));
                k.setStatuskomisitunasi(rs.getString("statuskomisitunasi"));
                k.setStatuskomisi(rs.getString("statusbereskomisi"));
                k.setTotalkomisi(rs.getDouble("totalkomisi"));
                k.setTotaljual(rs.getDouble("totaljual"));
                k.setTotalkomisirekap(rs.getDouble("totalkomisitunai"));
                Lists.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KomisiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Lists;
    }

    @Override
    public void postingupdatestatuskomisibp(String date,String kodebp) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("update komisisales set statuskomisibp=? WHERE komisisales.komisibp IS NOT NULL AND  komisisales.komisibp>0.0 AND komisisales.statusbereskomisi='belum' AND kodebp=?");
            statement.setString(1, date);
            statement.setString(2, kodebp);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Komisi BP Harian Berhasil di Posting");
        } catch (SQLException ex) {
            Logger.getLogger(KomisiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error, kesalahan data " + ex.getMessage());
        }
    }

    @Override
    public void postingupdatestatuskomisia1(String date,String kodebp) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("update komisisales set statuskomisia1=? WHERE komisisales.komisia1 IS NOT NULL AND  komisisales.komisia1>0.0 AND komisisales.statusbereskomisi='belum' AND kodebp=?;");
            statement.setString(1, date);
            statement.setString(2, kodebp);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Komisi A1 Berhasil di Posting");
        } catch (SQLException ex) {
            Logger.getLogger(KomisiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error, kesalahan data " + ex.getMessage());
        }
    }

    @Override
    public void postingupdatestatuskomisilunas(String date,String kodebp) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("update komisisales set statuskomisilunas=? WHERE komisisales.komisilunas IS NOT NULL AND  komisisales.komisilunas>0.0 AND komisisales.statusbereskomisi='belum' AND kodebp=?");
            statement.setString(1, date);
            statement.setString(2, kodebp);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Komisi Pelunasan Kartu Berhasil di Posting");
        } catch (SQLException ex) {
            Logger.getLogger(KomisiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error, kesalahan data " + ex.getMessage());
        }
    }

    @Override
    public void postingupdatestatuskomisitunai(String date,String kodebp) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("update komisisales set statuskomisitunasi=? WHERE komisisales.komisitunai IS NOT NULL AND  komisisales.komisitunai>0.0 AND komisisales.statusbereskomisi='belum' AND kodebp=?");
            statement.setString(1, date);
            statement.setString(2, kodebp);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Komisi Tunai Berhasil di Posting");
        } catch (SQLException ex) {
            Logger.getLogger(KomisiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error, kesalahan data " + ex.getMessage());
        }
    }

    @Override
    public List<Komisi> getAllKomisiSalesByA1ByDate(String date) {
        List<Komisi> Lists = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sqlGetAllKomisiA1RekapDate);
            statement.setString(1, date);
            rs = statement.executeQuery();
            while (rs.next()) {
                Komisi k = new Komisi();
                k.setId(rs.getInt("id"));
                k.setBp(DaoFactory.getBuktiPesananDao().getBuktiPesananByKodeBP(rs.getString("kodebp")));
                k.setSales(DaoFactory.getSalesDao().getSalesByID(rs.getInt("idsales")));
                k.setKomisibp(rs.getDouble("komisibp"));
                k.setKomisia1(rs.getDouble("komisia1"));
                k.setKomisilunas(rs.getDouble("komisilunas"));
                k.setKomdisitunai(rs.getDouble("komisitunai"));
                k.setRpkomisibp(rs.getDouble("komisibprupiah"));
                k.setRpkomisia1(rs.getDouble("komisia1rupiah"));
                k.setRpkomisilunas(rs.getDouble("komisilunasrupiah"));
                k.setRpkomisitunai(rs.getDouble("komisitunasirupiah"));
                k.setStatuskomisibp(rs.getString("statuskomisibp"));
                k.setStatuskomisia1(rs.getString("statuskomisia1"));
                k.setStatuskomisilunas(rs.getString("statuskomisilunas"));
                k.setStatuskomisitunasi(rs.getString("statuskomisitunasi"));
                k.setStatuskomisi(rs.getString("statusbereskomisi"));
                k.setTotalkomisi(rs.getDouble("totalkomisi"));
                k.setTotaljual(rs.getDouble("totaljual"));
                k.setTotalkomisirekap(rs.getDouble("totalkomisia1"));
                Lists.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KomisiDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Lists;
    }

}
