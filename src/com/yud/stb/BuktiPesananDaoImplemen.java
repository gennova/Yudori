/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.stb;

import com.init.tools.DaoFactory;
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
public class BuktiPesananDaoImplemen implements BuktiPesananDao {

    Connection connection;
    private  final String sqlInsertBuktiPesanan = "call spInsertPesanan(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    private  final String sqlUpdateBuktiPesanan = "call spUpdatePesanan(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    private  final String sqlTransferDetailBpToTemp = "insert into ordertemp(kodebarang,namabarang,unit,harga,total,idpesanan,kodebp) select kodebarang,namabarang,unit,harga,total,idpesanan,kodebp from detailpesanan where kodebp=?";
    private  final String sqlGetAllBPesanan = "select * from buktipesanan where statusbp='belum'";
    private  final String sqlGetAllBPesananbelumkirim = "SELECT detailpesanan.namabarang,detailpesanan.unit,buktipesanan.namapelanggan,buktipesanan.idpesananfaktur,buktipesanan.statuskirim,buktipesanan.kodebp FROM buktipesanan JOIN detailpesanan ON buktipesanan.kodebp=detailpesanan.kodebp WHERE buktipesanan.statuskirim='belum' GROUP BY buktipesanan.kodebp ";
    private  final String sqlGetAllPesananBelumLunas = "select * from buktipesanan where statusbp='belum'";
    private  final String sqlGetAllBPesananLunas = "select * from buktipesanan where statusbp='LUNAS'";
    private  final String sqlGetAllBPesananByDate = "select * from buktipesanan where tglpesanan=? and statusbp='belum'";
    private  final String sqlGetAllBPesananByDateDropA1 = "select * from buktipesanan where tglpesanan=? and jenisorder='DROP A1' and statusbp='belum'";
    private  final String sqlGetAllBPesananByDateTunai = "select * from buktipesanan where tglpesanan=? and jenisorder='TUNAI' and statusbp='belum'";
    private  final String sqlGetAllBPesananByDateIndent = "select * from buktipesanan where tglpesanan=? and jenisorder='INDENT' and statusbp='belum'";
    private  final String sqlGetAllBPesananBySales = "select * from buktipesanan where idsales=? and statusbp='belum'";
    private  final String sqlGetAllBPesananBySalesBelumKomisi = "SELECT * FROM buktipesanan WHERE idsales=? and statusbp='belum' AND kodebp IN (SELECT kodebp FROM komisisales WHERE statusbereskomisi='belum') ";
    private  final String sqlGetAllBPesananBySalesSudahKomisi = "SELECT * FROM buktipesanan WHERE idsales=? and statusbp='belum' AND kodebp IN (SELECT kodebp FROM komisisales WHERE statusbereskomisi='sudah') ";
    private  final String sqlGetAllBPesananByDateBulanan = "select * from buktipesanan where tglpesanan between ? and ? and statusbp='belum'";
    private  final String sqlGetBPesananByID = "select * from buktipesanan where idpesanan=? and statusbp='belum'";
    private  final String sqlGetBPesananByKodeBP = "select * from buktipesanan where kodebp=? and statusbp='belum'";
    private  final String sqlDeleteBP = "call spDeleteBp(?)";

    public BuktiPesananDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<BuktiPesanan> getAllBuktiPesanan() {
        List<BuktiPesanan> bps = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlGetAllBPesanan);
            rs = ps.executeQuery();
            while (rs.next()) {
                BuktiPesanan bp = new BuktiPesanan();
                bp.setId(rs.getInt("idpesanan"));
                bp.setKodePesanan(rs.getString("kodebp"));
                bp.setNoFakturPesanan(rs.getString("idpesananfaktur"));
                bp.setPelanggan(DaoFactory.getPelangganDao().getPelangganByID(rs.getInt("idpelanggan")));
                bp.setSales(DaoFactory.getSalesDao().getSalesByID(rs.getInt("idsales")));
                bp.setKomisiSales(rs.getInt("komisisales"));
                bp.setJenisOrder(rs.getString("jenisorder"));
                bp.setTglPesanan(rs.getString("tglpesanan"));
                bp.setTglPenagihan(rs.getString("tglpenagihan"));
                bp.setTglPengiriman(rs.getString("tglpengiriman"));
                bp.setTotal(rs.getInt("total"));
                bp.setUM(rs.getInt("UM"));
                bp.setAngsuran(rs.getInt("angsuran"));
                bp.setSisa(rs.getInt("sisa"));
                bp.setSisa2(rs.getInt("sisaberjalan"));
                bp.setStatusBP(rs.getString("statusbp"));
                bp.setHargaTunai(rs.getInt("hargatunai"));
                bp.setStatusKirimBarang(rs.getString("statuskirim"));
                bps.add(bp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuktiPesananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro / Kesalahan Data" + ex.getMessage());
        }
        return bps;
    }

    @Override
    public void InsertBuktiPesanan(BuktiPesanan bp) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareCall(sqlInsertBuktiPesanan);
            statement.setString(1, bp.getKodePesanan());
            statement.setString(2, bp.getNoFakturPesanan());
            statement.setString(3, bp.getPelanggan().getKodemanualpelanggan());
            statement.setString(4, bp.getPelanggan().getNamaPelanggan());
            statement.setString(5, bp.getPelanggan().getAlamatpelanggan());
            statement.setString(6, bp.getPelanggan().getTelepon());
            statement.setInt(7, bp.getSales().getidSales());
            statement.setInt(8, bp.getKomisiSales());
            statement.setString(9, bp.getJenisOrder());
            statement.setString(10, bp.getTglPesanan());
            statement.setString(11, bp.getTglPenagihan());
            statement.setString(12, bp.getTglPengiriman());
            statement.setInt(13, bp.getAngsuran());
            statement.setInt(14, bp.getTotal());
            statement.setInt(15, bp.getUM());
            statement.setInt(16, bp.getSisa());
            statement.setInt(17, bp.getHargaTunai());
            statement.setString(18, bp.getStatusKirimBarang());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Bukti Pesanan Berhasil Disimpan");
        } catch (SQLException ex) {
            Logger.getLogger(BuktiPesananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro / Kesalahan Data" + ex.getMessage());
        }
    }

    @Override
    public void UpdateBuktiPesanan(BuktiPesanan bp) {
        JOptionPane.showMessageDialog(null, "Mulai Update "+bp.getKodePesanan());
        PreparedStatement statement = null;
        try {
            statement = connection.prepareCall(sqlUpdateBuktiPesanan);
            statement.setString(1, bp.getKodePesanan());
            statement.setString(2, bp.getNoFakturPesanan());
            statement.setString(3, bp.getPelanggan().getKodemanualpelanggan());
            statement.setString(4, bp.getPelanggan().getNamaPelanggan());
            statement.setString(5, bp.getPelanggan().getAlamatpelanggan());
            statement.setString(6, bp.getPelanggan().getTelepon());
            statement.setInt(7, bp.getSales().getidSales());
            statement.setInt(8, bp.getKomisiSales());
            statement.setString(9, bp.getJenisOrder());
            statement.setString(10, bp.getTglPesanan());
            statement.setString(11, bp.getTglPenagihan());
            statement.setString(12, bp.getTglPengiriman());
            statement.setInt(13, bp.getAngsuran());
            statement.setInt(14, bp.getTotal());
            statement.setInt(15, bp.getUM());
            statement.setInt(16, bp.getSisa());
            statement.setInt(17, bp.getHargaTunai());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Bukti Pesanan Berhasil Diupdate");
        } catch (SQLException ex) {
            Logger.getLogger(BuktiPesananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro / Kesalahan Data" + ex.getMessage());
        }
    }

    @Override
    public void DeleteBuktiPesanan(BuktiPesanan bp) {
        PreparedStatement statement=null;
        try {
            statement = connection.prepareStatement(sqlDeleteBP);
            statement.setString(1, bp.getKodePesanan());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(BuktiPesananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus" + ex.getMessage());
        }
        
    }

    @Override
    public BuktiPesanan getBuktiPesananByID(int id) {
        BuktiPesanan bp = new BuktiPesanan();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlGetBPesananByID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {

                bp.setId(rs.getInt("idpesanan"));
                bp.setKodePesanan(rs.getString("kodebp"));
                bp.setNoFakturPesanan(rs.getString("idpesananfaktur"));
                bp.setPelanggan(DaoFactory.getPelangganDao().getPelangganByID(rs.getInt("idpelanggan")));
                bp.setSales(DaoFactory.getSalesDao().getSalesByID(rs.getInt("idsales")));
                bp.setKomisiSales(rs.getInt("komisisales"));
                bp.setJenisOrder(rs.getString("jenisorder"));
                bp.setTglPesanan(rs.getString("tglpesanan"));
                bp.setTglPenagihan(rs.getString("tglpenagihan"));
                bp.setTglPengiriman(rs.getString("tglpengiriman"));
                bp.setTotal(rs.getInt("total"));
                bp.setUM(rs.getInt("UM"));
                bp.setAngsuran(rs.getInt("angsuran"));
                bp.setSisa(rs.getInt("sisa"));
                bp.setSisa2(rs.getInt("sisaberjalan"));
                bp.setStatusBP(rs.getString("statusbp"));
                bp.setHargaTunai(rs.getInt("hargatunai"));
                bp.setStatusKirimBarang(rs.getString("statuskirim"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuktiPesananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro / Kesalahan Data" + ex.getMessage());
        }
        return bp;
    }

    @Override
    public BuktiPesanan getBuktiPesananByKodeBP(String kode) {
        BuktiPesanan bp = new BuktiPesanan();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlGetBPesananByKodeBP);
            ps.setString(1, kode);
            rs = ps.executeQuery();
            while (rs.next()) {
                bp.setId(rs.getInt("idpesanan"));
                bp.setKodePesanan(rs.getString("kodebp"));
                bp.setNoFakturPesanan(rs.getString("idpesananfaktur"));
                bp.setPelanggan(DaoFactory.getPelangganDao().getPelangganByID(rs.getInt("idpelanggan")));
                bp.setSales(DaoFactory.getSalesDao().getSalesByID(rs.getInt("idsales")));
                bp.setKomisiSales(rs.getInt("komisisales"));
                bp.setJenisOrder(rs.getString("jenisorder"));
                bp.setTglPesanan(rs.getString("tglpesanan"));
                bp.setTglPenagihan(rs.getString("tglpenagihan"));
                bp.setTglPengiriman(rs.getString("tglpengiriman"));
                bp.setTotal(rs.getInt("total"));
                bp.setUM(rs.getInt("UM"));
                bp.setAngsuran(rs.getInt("angsuran"));
                bp.setSisa(rs.getInt("sisa"));
                bp.setSisa2(rs.getInt("sisaberjalan"));
                bp.setStatusBP(rs.getString("statusbp"));
                bp.setHargaTunai(rs.getInt("hargatunai"));
                bp.setStatusKirimBarang(rs.getString("statuskirim"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuktiPesananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro / Kesalahan Data" + ex.getMessage());
        }
        return bp;
    }

    @Override
    public void getTempDetailPesanan(String kode) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlTransferDetailBpToTemp);
            statement.setString(1, kode);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BuktiPesananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro / Kesalahan Data" + ex.getMessage());
        }

    }

    @Override
    public List<BuktiPesanan> getAllBuktiPesananByDate(String date) {
        List<BuktiPesanan> bps = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlGetAllBPesananByDate);
            ps.setString(1, date);
            rs = ps.executeQuery();            
            while (rs.next()) {
                BuktiPesanan bp = new BuktiPesanan();
                bp.setId(rs.getInt("idpesanan"));
                bp.setKodePesanan(rs.getString("kodebp"));
                bp.setNoFakturPesanan(rs.getString("idpesananfaktur"));
                bp.setPelanggan(DaoFactory.getPelangganDao().getPelangganByID(rs.getInt("idpelanggan")));
                bp.setSales(DaoFactory.getSalesDao().getSalesByID(rs.getInt("idsales")));
                bp.setKomisiSales(rs.getInt("komisisales"));
                bp.setJenisOrder(rs.getString("jenisorder"));
                bp.setTglPesanan(rs.getString("tglpesanan"));
                bp.setTglPenagihan(rs.getString("tglpenagihan"));
                bp.setTglPengiriman(rs.getString("tglpengiriman"));
                bp.setTotal(rs.getInt("total"));
                bp.setUM(rs.getInt("UM"));
                bp.setAngsuran(rs.getInt("angsuran"));
                bp.setSisa(rs.getInt("sisa"));
                bp.setSisa2(rs.getInt("sisaberjalan"));
                bp.setStatusBP(rs.getString("statusbp"));
                bp.setHargaTunai(rs.getInt("hargatunai"));
                bp.setStatusKirimBarang(rs.getString("statuskirim"));
                bps.add(bp);
            }
            if (rs.first()==false) {
                JOptionPane.showMessageDialog(null, "Tidak ada ditemukan pada data tanggal ini.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuktiPesananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro / Kesalahan Data" + ex.getMessage());
        }
        return bps;
    }

    @Override
    public List<BuktiPesanan> getAllBuktiPesananByBulanan(String dateone, String datetwo) {
        List<BuktiPesanan> bps = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlGetAllBPesananByDateBulanan);
            ps.setString(1, dateone);
            ps.setString(2, datetwo);
            rs = ps.executeQuery();            
            while (rs.next()) {
                BuktiPesanan bp = new BuktiPesanan();
                bp.setId(rs.getInt("idpesanan"));
                bp.setKodePesanan(rs.getString("kodebp"));
                bp.setNoFakturPesanan(rs.getString("idpesananfaktur"));
                bp.setPelanggan(DaoFactory.getPelangganDao().getPelangganByID(rs.getInt("idpelanggan")));
                bp.setSales(DaoFactory.getSalesDao().getSalesByID(rs.getInt("idsales")));
                bp.setKomisiSales(rs.getInt("komisisales"));
                bp.setJenisOrder(rs.getString("jenisorder"));
                bp.setTglPesanan(rs.getString("tglpesanan"));
                bp.setTglPenagihan(rs.getString("tglpenagihan"));
                bp.setTglPengiriman(rs.getString("tglpengiriman"));
                bp.setTotal(rs.getInt("total"));
                bp.setUM(rs.getInt("UM"));
                bp.setAngsuran(rs.getInt("angsuran"));
                bp.setSisa(rs.getInt("sisa"));
                bp.setSisa2(rs.getInt("sisaberjalan"));
                bp.setStatusBP(rs.getString("statusbp"));
                bp.setHargaTunai(rs.getInt("hargatunai"));
                bp.setStatusKirimBarang(rs.getString("statuskirim"));
                bps.add(bp);
            }
            if (rs.first()==false) {
                JOptionPane.showMessageDialog(null, "Tidak ada ditemukan pada data tanggal ini.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuktiPesananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro / Kesalahan Data" + ex.getMessage());
        }
        return bps;
    }

    @Override
    public List<BuktiPesanan> getAllBuktiPesananBySales(int idsales) {
        List<BuktiPesanan> bps = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlGetAllBPesananBySales);
            ps.setInt(1, idsales);
            rs = ps.executeQuery();            
            while (rs.next()) {
                BuktiPesanan bp = new BuktiPesanan();
                bp.setId(rs.getInt("idpesanan"));
                bp.setKodePesanan(rs.getString("kodebp"));
                bp.setNoFakturPesanan(rs.getString("idpesananfaktur"));
                bp.setPelanggan(DaoFactory.getPelangganDao().getPelangganByID(rs.getInt("idpelanggan")));
                bp.setSales(DaoFactory.getSalesDao().getSalesByID(rs.getInt("idsales")));
                bp.setKomisiSales(rs.getInt("komisisales"));
                bp.setJenisOrder(rs.getString("jenisorder"));
                bp.setTglPesanan(rs.getString("tglpesanan"));
                bp.setTglPenagihan(rs.getString("tglpenagihan"));
                bp.setTglPengiriman(rs.getString("tglpengiriman"));
                bp.setTotal(rs.getInt("total"));
                bp.setUM(rs.getInt("UM"));
                bp.setAngsuran(rs.getInt("angsuran"));
                bp.setSisa(rs.getInt("sisa"));
                bp.setSisa2(rs.getInt("sisaberjalan"));
                bp.setStatusBP(rs.getString("statusbp"));
                bp.setHargaTunai(rs.getInt("hargatunai"));
                bp.setStatusKirimBarang(rs.getString("statuskirim"));
                bps.add(bp);
            }
            if (rs.first()==false) {
                JOptionPane.showMessageDialog(null, "Tidak ada ditemukan data.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuktiPesananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro / Kesalahan Data" + ex.getMessage());
        }
        return bps;
    }

    @Override
    public List<BuktiPesanan> getAllBuktiPesananLunas() {
        List<BuktiPesanan> bps = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlGetAllBPesananLunas);
            rs = ps.executeQuery();
            while (rs.next()) {
                BuktiPesanan bp = new BuktiPesanan();
                bp.setId(rs.getInt("idpesanan"));
                bp.setKodePesanan(rs.getString("kodebp"));
                bp.setNoFakturPesanan(rs.getString("idpesananfaktur"));
                bp.setPelanggan(DaoFactory.getPelangganDao().getPelangganByID(rs.getInt("idpelanggan")));
                bp.setSales(DaoFactory.getSalesDao().getSalesByID(rs.getInt("idsales")));
                bp.setKomisiSales(rs.getInt("komisisales"));
                bp.setJenisOrder(rs.getString("jenisorder"));
                bp.setTglPesanan(rs.getString("tglpesanan"));
                bp.setTglPenagihan(rs.getString("tglpenagihan"));
                bp.setTglPengiriman(rs.getString("tglpengiriman"));
                bp.setTotal(rs.getInt("total"));
                bp.setUM(rs.getInt("UM"));
                bp.setAngsuran(rs.getInt("angsuran"));
                bp.setSisa(rs.getInt("sisa"));
                bp.setSisa2(rs.getInt("sisaberjalan"));
                bp.setStatusBP(rs.getString("statusbp"));
                bp.setHargaTunai(rs.getInt("hargatunai"));
                bp.setStatusKirimBarang(rs.getString("statuskirim"));
                bps.add(bp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuktiPesananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro / Kesalahan Data" + ex.getMessage());
        }
        return bps;
    }

    @Override
    public List<BuktiPesanan> getAllBuktiPesananBySalesBelumKomisi(int idsales) {
        List<BuktiPesanan> bps = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlGetAllBPesananBySalesBelumKomisi);
            ps.setInt(1, idsales);
            rs = ps.executeQuery();            
            while (rs.next()) {
                BuktiPesanan bp = new BuktiPesanan();
                bp.setId(rs.getInt("idpesanan"));
                bp.setKodePesanan(rs.getString("kodebp"));
                bp.setNoFakturPesanan(rs.getString("idpesananfaktur"));
                bp.setPelanggan(DaoFactory.getPelangganDao().getPelangganByID(rs.getInt("idpelanggan")));
                bp.setSales(DaoFactory.getSalesDao().getSalesByID(rs.getInt("idsales")));
                bp.setKomisiSales(rs.getInt("komisisales"));
                bp.setJenisOrder(rs.getString("jenisorder"));
                bp.setTglPesanan(rs.getString("tglpesanan"));
                bp.setTglPenagihan(rs.getString("tglpenagihan"));
                bp.setTglPengiriman(rs.getString("tglpengiriman"));
                bp.setTotal(rs.getInt("total"));
                bp.setUM(rs.getInt("UM"));
                bp.setAngsuran(rs.getInt("angsuran"));
                bp.setSisa(rs.getInt("sisa"));
                bp.setSisa2(rs.getInt("sisaberjalan"));
                bp.setStatusBP(rs.getString("statusbp"));
                bp.setHargaTunai(rs.getInt("hargatunai"));
                bp.setStatusKirimBarang(rs.getString("statuskirim"));
                bps.add(bp);
            }
            if (rs.first()==false) {
                JOptionPane.showMessageDialog(null, "Tidak ada ditemukan data.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuktiPesananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro / Kesalahan Data" + ex.getMessage());
        }
        return bps;
    }

    @Override
    public List<BuktiPesanan> getAllBuktiPesananBySalesSudahKomisi(int idsales) {
        List<BuktiPesanan> bps = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlGetAllBPesananBySalesSudahKomisi);
            ps.setInt(1, idsales);
            rs = ps.executeQuery();            
            while (rs.next()) {
                BuktiPesanan bp = new BuktiPesanan();
                bp.setId(rs.getInt("idpesanan"));
                bp.setKodePesanan(rs.getString("kodebp"));
                bp.setNoFakturPesanan(rs.getString("idpesananfaktur"));
                bp.setPelanggan(DaoFactory.getPelangganDao().getPelangganByID(rs.getInt("idpelanggan")));
                bp.setSales(DaoFactory.getSalesDao().getSalesByID(rs.getInt("idsales")));
                bp.setKomisiSales(rs.getInt("komisisales"));
                bp.setJenisOrder(rs.getString("jenisorder"));
                bp.setTglPesanan(rs.getString("tglpesanan"));
                bp.setTglPenagihan(rs.getString("tglpenagihan"));
                bp.setTglPengiriman(rs.getString("tglpengiriman"));
                bp.setTotal(rs.getInt("total"));
                bp.setUM(rs.getInt("UM"));
                bp.setAngsuran(rs.getInt("angsuran"));
                bp.setSisa(rs.getInt("sisa"));
                bp.setSisa2(rs.getInt("sisaberjalan"));
                bp.setStatusBP(rs.getString("statusbp"));
                bp.setHargaTunai(rs.getInt("hargatunai"));
                bp.setStatusKirimBarang(rs.getString("statuskirim"));
                bps.add(bp);
            }
            if (rs.first()==false) {
                JOptionPane.showMessageDialog(null, "Tidak ada ditemukan data.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuktiPesananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro / Kesalahan Data" + ex.getMessage());
        }
        return bps;
    }

    @Override
    public List<BuktiPesanan> getAllBuktiPesananByDateDROPA1(String date) {
        List<BuktiPesanan> bps = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlGetAllBPesananByDateDropA1);
            ps.setString(1, date);
            rs = ps.executeQuery();            
            while (rs.next()) {
                BuktiPesanan bp = new BuktiPesanan();
                bp.setId(rs.getInt("idpesanan"));
                bp.setKodePesanan(rs.getString("kodebp"));
                bp.setNoFakturPesanan(rs.getString("idpesananfaktur"));
                bp.setPelanggan(DaoFactory.getPelangganDao().getPelangganByID(rs.getInt("idpelanggan")));
                bp.setSales(DaoFactory.getSalesDao().getSalesByID(rs.getInt("idsales")));
                bp.setKomisiSales(rs.getInt("komisisales"));
                bp.setJenisOrder(rs.getString("jenisorder"));
                bp.setTglPesanan(rs.getString("tglpesanan"));
                bp.setTglPenagihan(rs.getString("tglpenagihan"));
                bp.setTglPengiriman(rs.getString("tglpengiriman"));
                bp.setTotal(rs.getInt("total"));
                bp.setUM(rs.getInt("UM"));
                bp.setAngsuran(rs.getInt("angsuran"));
                bp.setSisa(rs.getInt("sisa"));
                bp.setSisa2(rs.getInt("sisaberjalan"));
                bp.setStatusBP(rs.getString("statusbp"));
                bp.setHargaTunai(rs.getInt("hargatunai"));
                bp.setStatusKirimBarang(rs.getString("statuskirim"));
                bps.add(bp);
            }
            if (rs.first()==false) {
                JOptionPane.showMessageDialog(null, "Tidak ada ditemukan pada data tanggal ini.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuktiPesananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro / Kesalahan Data" + ex.getMessage());
        }
        return bps;
    }

    @Override
    public List<BuktiPesanan> getAllBuktiPesananByDateTUNAI(String date) {
        List<BuktiPesanan> bps = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlGetAllBPesananByDateTunai);
            ps.setString(1, date);
            rs = ps.executeQuery();            
            while (rs.next()) {
                BuktiPesanan bp = new BuktiPesanan();
                bp.setId(rs.getInt("idpesanan"));
                bp.setKodePesanan(rs.getString("kodebp"));
                bp.setNoFakturPesanan(rs.getString("idpesananfaktur"));
                bp.setPelanggan(DaoFactory.getPelangganDao().getPelangganByID(rs.getInt("idpelanggan")));
                bp.setSales(DaoFactory.getSalesDao().getSalesByID(rs.getInt("idsales")));
                bp.setKomisiSales(rs.getInt("komisisales"));
                bp.setJenisOrder(rs.getString("jenisorder"));
                bp.setTglPesanan(rs.getString("tglpesanan"));
                bp.setTglPenagihan(rs.getString("tglpenagihan"));
                bp.setTglPengiriman(rs.getString("tglpengiriman"));
                bp.setTotal(rs.getInt("total"));
                bp.setUM(rs.getInt("UM"));
                bp.setAngsuran(rs.getInt("angsuran"));
                bp.setSisa(rs.getInt("sisa"));
                bp.setSisa2(rs.getInt("sisaberjalan"));
                bp.setStatusBP(rs.getString("statusbp"));
                bp.setHargaTunai(rs.getInt("hargatunai"));
                bp.setStatusKirimBarang(rs.getString("statuskirim"));
                bps.add(bp);
            }
            if (rs.first()==false) {
                JOptionPane.showMessageDialog(null, "Tidak ada ditemukan pada data tanggal ini.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuktiPesananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro / Kesalahan Data" + ex.getMessage());
        }
        return bps;
    }

    @Override
    public List<BuktiPesanan> getAllBuktiPesananByDateINDENT(String date) {
        List<BuktiPesanan> bps = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlGetAllBPesananByDateIndent);
            ps.setString(1, date);
            rs = ps.executeQuery();            
            while (rs.next()) {
                BuktiPesanan bp = new BuktiPesanan();
                bp.setId(rs.getInt("idpesanan"));
                bp.setKodePesanan(rs.getString("kodebp"));
                bp.setNoFakturPesanan(rs.getString("idpesananfaktur"));
                bp.setPelanggan(DaoFactory.getPelangganDao().getPelangganByID(rs.getInt("idpelanggan")));
                bp.setSales(DaoFactory.getSalesDao().getSalesByID(rs.getInt("idsales")));
                bp.setKomisiSales(rs.getInt("komisisales"));
                bp.setJenisOrder(rs.getString("jenisorder"));
                bp.setTglPesanan(rs.getString("tglpesanan"));
                bp.setTglPenagihan(rs.getString("tglpenagihan"));
                bp.setTglPengiriman(rs.getString("tglpengiriman"));
                bp.setTotal(rs.getInt("total"));
                bp.setUM(rs.getInt("UM"));
                bp.setAngsuran(rs.getInt("angsuran"));
                bp.setSisa(rs.getInt("sisa"));
                bp.setSisa2(rs.getInt("sisaberjalan"));
                bp.setStatusBP(rs.getString("statusbp"));
                bp.setHargaTunai(rs.getInt("hargatunai"));
                bp.setStatusKirimBarang(rs.getString("statuskirim"));
                bps.add(bp);
            }
            if (rs.first()==false) {
                JOptionPane.showMessageDialog(null, "Tidak ada ditemukan pada data tanggal ini.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuktiPesananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro / Kesalahan Data" + ex.getMessage());
        }
        return bps;
    }

    @Override
    public List<BuktiPesanan> getAllBuktiPesananBelumLunas() {
        List<BuktiPesanan> bps = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlGetAllPesananBelumLunas);
            rs = ps.executeQuery();
            while (rs.next()) {
                BuktiPesanan bp = new BuktiPesanan();
                bp.setId(rs.getInt("idpesanan"));
                bp.setKodePesanan(rs.getString("kodebp"));
                bp.setNoFakturPesanan(rs.getString("idpesananfaktur"));
                bp.setPelanggan(DaoFactory.getPelangganDao().getPelangganByID(rs.getInt("idpelanggan")));
                bp.setSales(DaoFactory.getSalesDao().getSalesByID(rs.getInt("idsales")));
                bp.setKomisiSales(rs.getInt("komisisales"));
                bp.setJenisOrder(rs.getString("jenisorder"));
                bp.setTglPesanan(rs.getString("tglpesanan"));
                bp.setTglPenagihan(rs.getString("tglpenagihan"));
                bp.setTglPengiriman(rs.getString("tglpengiriman"));
                bp.setTotal(rs.getInt("total"));
                bp.setUM(rs.getInt("UM"));
                bp.setAngsuran(rs.getInt("angsuran"));
                bp.setSisa(rs.getInt("sisa"));
                bp.setSisa2(rs.getInt("sisaberjalan"));
                bp.setStatusBP(rs.getString("statusbp"));
                bp.setHargaTunai(rs.getInt("hargatunai"));
                bp.setStatusKirimBarang(rs.getString("statuskirim"));
                bps.add(bp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuktiPesananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro / Kesalahan Data" + ex.getMessage());
        }
        return bps;
    }

    @Override
    public List<BuktiPesanan> getAllBuktiPesananBelumTerkirim() {
        List<BuktiPesanan> bps = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlGetAllBPesananbelumkirim);
            rs = ps.executeQuery();
            while (rs.next()) {
                BuktiPesanan bp = new BuktiPesanan();
                bp.setId(rs.getInt("idpesanan"));
                bp.setKodePesanan(rs.getString("kodebp"));
                bp.setNoFakturPesanan(rs.getString("idpesananfaktur"));
                bp.setPelanggan(DaoFactory.getPelangganDao().getPelangganByID(rs.getInt("idpelanggan")));
                bp.setSales(DaoFactory.getSalesDao().getSalesByID(rs.getInt("idsales")));
                bp.setKomisiSales(rs.getInt("komisisales"));
                bp.setJenisOrder(rs.getString("jenisorder"));
                bp.setTglPesanan(rs.getString("tglpesanan"));
                bp.setTglPenagihan(rs.getString("tglpenagihan"));
                bp.setTglPengiriman(rs.getString("tglpengiriman"));
                bp.setTotal(rs.getInt("total"));
                bp.setUM(rs.getInt("UM"));
                bp.setAngsuran(rs.getInt("angsuran"));
                bp.setSisa(rs.getInt("sisa"));
                bp.setSisa2(rs.getInt("sisaberjalan"));
                bp.setStatusBP(rs.getString("statusbp"));
                bp.setHargaTunai(rs.getInt("hargatunai"));
                bp.setStatusKirimBarang(rs.getString("statuskirim"));
                bps.add(bp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuktiPesananDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro / Kesalahan Data" + ex.getMessage());
        }
        return bps;
    }
}
