/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.angsuran;

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
public class AngsuranDaoImplemen implements AngsuranDao {

    Connection connection;
    private static final String sqlGetAllAngsuran = "select * from angsuran";
    private static final String sqlGetAllAngsuranBP = "select * from angsuran where kodebp=?";
    private static final String sqlGetAngsuranBP = "select * from angsuran where kodebp=?";
    private static final String sqlUpdateSisaAngsuran = "call spUpdateAngsuran(?)";
    private static final String sqlInsertAngsuran = "INSERT INTO angsuran(kodeangsuran,kodebp,idpelanggan,pembayar,jumlah,penerima,tanggal,keterangan)values (?,?,?,?,?,?,?,?)";
    private static final String sqlInsertAngsuranBulanan = "INSERT INTO bantucetakand(kodebp,kodeans,tanggal,jumlah,lunas) values (?,?,?,?,?)";
    private static final String sqlGetTotalAngsuranByKodeBp = "SELECT SUM(jumlah) AS jumlahnya FROM detailangsuran WHERE nobp=? and nobp IN (SELECT kodebp FROM buktipesanan WHERE statusbp='belum')";
    private static final String sqlDeleteAngsuranByKodeAns = "call spDeleteAngsuranAwal(?)";

    public AngsuranDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Angsuran> getAllAngsuran() {
        List<Angsuran> angsurans = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sqlGetAllAngsuran);
            rs = statement.executeQuery();
            while (rs.next()) {
                Angsuran a = new Angsuran();
                a.setIdAngsuran(rs.getInt("id"));
                a.setKodeAngsuran(rs.getString("kodeangsuran"));
                a.setKodeBP(rs.getString("kodebp"));
                a.setPelanggan(DaoFactory.getPelangganDao().getPelangganByID(rs.getInt("idpelanggan")));
                a.setPembayar(rs.getString("pembayar"));
                a.setPenerima(rs.getString("penerima"));
                a.setTanggalTerima(rs.getString("tanggal"));
                a.setJumlah(rs.getInt("jumlah"));
                a.setKeterangan(rs.getString("keterangan"));
                angsurans.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AngsuranDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }

        return angsurans;
    }

    @Override
    public void insertAngsuran(Angsuran angsuran) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlInsertAngsuran);
            statement.setString(1, angsuran.getKodeAngsuran());
            statement.setString(2, angsuran.getKodeBP());
            statement.setInt(3, angsuran.getPelanggan().getIdPelanggan());
            statement.setString(4, angsuran.getPembayar());
            statement.setInt(5, angsuran.getJumlah());
            statement.setString(6, angsuran.getPenerima());
            statement.setString(7, angsuran.getTanggalTerima());
            statement.setString(8, angsuran.getKeterangan());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AngsuranDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateAngsuran(Angsuran angsuran) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAngsuran(Angsuran angsuran) {
        try {
            PreparedStatement ps;
            ps = connection.prepareStatement(sqlDeleteAngsuranByKodeAns);
            ps.setString(1, angsuran.getKodeAngsuran());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Angsuran Berhasil dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(AngsuranDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Angsuran getAngsuranByID(int kode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Angsuran getAngsuranByKodeBP(int kode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateSisaAngsuran(String kodebp) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlUpdateSisaAngsuran);
            ps.setString(1, kodebp);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AngsuranDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Angsuran> getAllAngsuranByKodeBP(String kodebp) {
        List<Angsuran> angsurans = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sqlGetAllAngsuranBP);
            statement.setString(1, kodebp);
            rs = statement.executeQuery();
            while (rs.next()) {
                Angsuran a = new Angsuran();
                a.setIdAngsuran(rs.getInt("id"));
                a.setKodeAngsuran(rs.getString("kodeangsuran"));
                a.setKodeBP(rs.getString("kodebp"));
                a.setPelanggan(DaoFactory.getPelangganDao().getPelangganByID(rs.getInt("idpelanggan")));
                a.setPembayar(rs.getString("pembayar"));
                a.setPenerima(rs.getString("penerima"));
                a.setTanggalTerima(rs.getString("tanggal"));
                a.setJumlah(rs.getInt("jumlah"));
                a.setKeterangan(rs.getString("keterangan"));
                angsurans.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AngsuranDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }

        return angsurans;
    }

    @Override
    public Angsuran getAngsuranByKodeANS(String kodeans) {
        PreparedStatement statement = null;
        Angsuran a = new Angsuran();
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement("select * from angsuran where kodeangsuran=?");
            statement.setString(1, kodeans);
            rs = statement.executeQuery();
            while (rs.next()) {
                a.setIdAngsuran(rs.getInt("id"));
                a.setKodeAngsuran(rs.getString("kodeangsuran"));
                a.setKodeBP(rs.getString("kodebp"));
                a.setPelanggan(DaoFactory.getPelangganDao().getPelangganByID(rs.getInt("idpelanggan")));
                a.setPembayar(rs.getString("pembayar"));
                a.setPenerima(rs.getString("penerima"));
                a.setTanggalTerima(rs.getString("tanggal"));
                a.setJumlah(rs.getInt("jumlah"));
                a.setKeterangan(rs.getString("keterangan"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AngsuranDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }

        return a;
    }

    @Override
    public void insertAngsuranBulananUM(Angsuran angsuran) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlInsertAngsuranBulanan);
            statement.setString(1, angsuran.getKodeBP());
            statement.setString(2, angsuran.getKodeAngsuran());
            statement.setString(3, angsuran.getTanggalTerima());
            statement.setInt(4, angsuran.getJumlah());
            statement.setString(5, "belum");
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AngsuranDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Angsuran getAngsuranByKodeBP(String kodebp) {
        PreparedStatement statement = null;
        Angsuran a = new Angsuran();
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sqlGetAngsuranBP);
            statement.setString(1, kodebp);
            rs = statement.executeQuery();
            while (rs.next()) {
                a.setIdAngsuran(rs.getInt("id"));
                a.setKodeAngsuran(rs.getString("kodeangsuran"));
                a.setKodeBP(rs.getString("kodebp"));
                a.setPelanggan(DaoFactory.getPelangganDao().getPelangganByID(rs.getInt("idpelanggan")));
                a.setPembayar(rs.getString("pembayar"));
                a.setPenerima(rs.getString("penerima"));
                a.setTanggalTerima(rs.getString("tanggal"));
                a.setJumlah(rs.getInt("jumlah"));
                a.setKeterangan(rs.getString("keterangan"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AngsuranDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }

        return a;
    }

    @Override
    public int getTotalAngsuranByKodeBp(String kode) {
        PreparedStatement statement = null;
        ResultSet rs = null;
        int total = 0;
        try {
            statement = connection.prepareStatement(sqlGetTotalAngsuranByKodeBp);
            statement.setString(1, kode);
            rs = statement.executeQuery();
            while (rs.next()) {
                total = rs.getInt("jumlahnya");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AngsuranDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

}
