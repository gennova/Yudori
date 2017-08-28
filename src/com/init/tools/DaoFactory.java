/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.tools;

import com.yud.angsuran.AngsuranBulananDao;
import com.yud.angsuran.AngsuranBulananDaoImplemen;
import com.yud.angsuran.AngsuranDao;
import com.yud.angsuran.AngsuranDaoImplemen;
import com.yud.angsuran.PelunasanDao;
import com.yud.angsuran.PelunasanDaoImplemen;
import com.yud.barang.BarangDao;
import com.yud.barang.BarangDaoImplemen;
import com.yud.bpkirim.BPKirimDao;
import com.yud.bpkirim.BpKirimDaoImplemen;
import com.yud.bstu.SerahTerimaUangDao;
import com.yud.bstu.SerahTerimaUangDaoImplemen;
import com.yud.kas.KasBesarDao;
import com.yud.kas.KasBesarDaoImplemen;
import com.yud.kas.KasDao;
import com.yud.kas.KasDaoImplemen;
import com.yud.kmb.KeluarMasukBarangDao;
import com.yud.kmb.KeluarMasukBarangDaoImplemen;
import com.yud.komisi.KomisiDao;
import com.yud.komisi.KomisiDaoImplemen;
import com.yud.pelanggan.PelangganDao;
import com.yud.pelanggan.PelangganDaoImplemen;
import com.yud.sales.SalesDao;
import com.yud.sales.SalesDaoImplemen;
import com.yud.stb.BuktiPesananDao;
import com.yud.stb.BuktiPesananDaoImplemen;
import com.yud.stb.OrderTempDao;
import com.yud.stb.OrderTempDaoImplemen;
import com.yud.stocking.StokDao;
import com.yud.stocking.StokDaoImplemen;
import com.yud.user.UserDao;
import com.yud.user.UserDaoImplemen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author legollas
 */
public class DaoFactory {

    private static Connection connection = null;
    private static final String url = "jdbc:mysql://";
    static String user = "";
    static String password = "";
    private static Statement st = null;
    private static BarangDao barangDao;
    private static UserDao userDao;
    private static SalesDao salesDao;
    private static PelangganDao pelangganDao;
    private static OrderTempDao orderTempDao;
    private static BuktiPesananDao buktiPesananDao;
    private static AngsuranDao angsuranDao;
    private static KeluarMasukBarangDao keluarMasukBarangDao;
    private static SerahTerimaUangDao serahTerimaUangDao;
    private static AngsuranBulananDao angsuranBulananDao;
    private static PelunasanDao pelunasanDao;
    private static KomisiDao komisiDao;
    private static StokDao stokDao;
    private static BPKirimDao bPKirimDao;
    private static KasDao kasDao;
    private static KasBesarDao kasBesarDao;

    public static KasBesarDao getKasBesarDao() {
        if (kasBesarDao == null) {
            kasBesarDao = new KasBesarDaoImplemen(getConnectionFix());
        }
        return kasBesarDao;
    }

    public static KasDao getKasDao() {
        if (kasDao == null) {
            kasDao = new KasDaoImplemen(getConnectionFix());
        }
        return kasDao;
    }

    public static BPKirimDao getbPKirimDao() {
        if (bPKirimDao == null) {
            bPKirimDao = new BpKirimDaoImplemen(getConnectionFix());
        }
        return bPKirimDao;
    }

    public static StokDao getStokDao() {
        if (stokDao == null) {
            stokDao = new StokDaoImplemen(getConnectionFix());
        }
        return stokDao;
    }

    public static KomisiDao getKomisiDao() {
        if (komisiDao == null) {
            komisiDao = new KomisiDaoImplemen(getConnectionFix());
        }
        return komisiDao;
    }

    public static PelunasanDao getPelunasanDao() {
        if (pelunasanDao == null) {
            pelunasanDao = new PelunasanDaoImplemen(getConnectionFix());
        }
        return pelunasanDao;
    }

    public static AngsuranBulananDao getAngsuranBulananDao() {
        if (angsuranBulananDao == null) {
            angsuranBulananDao = new AngsuranBulananDaoImplemen(getConnectionFix());
        }
        return angsuranBulananDao;
    }

    public static SerahTerimaUangDao getSerahTerimaUangDao() {
        if (serahTerimaUangDao == null) {
            serahTerimaUangDao = new SerahTerimaUangDaoImplemen(getConnectionFix());
        }
        return serahTerimaUangDao;
    }

    public static KeluarMasukBarangDao getKeluarMasukBarangDao() {
        if (keluarMasukBarangDao == null) {
            keluarMasukBarangDao = new KeluarMasukBarangDaoImplemen(getConnectionFix());
        }
        return keluarMasukBarangDao;
    }

    public static AngsuranDao getAngsuranDao() {
        if (angsuranDao == null) {
            angsuranDao = new AngsuranDaoImplemen(getConnectionFix());
        }
        return angsuranDao;
    }

    public static BuktiPesananDao getBuktiPesananDao() {
        if (buktiPesananDao == null) {
            buktiPesananDao = new BuktiPesananDaoImplemen(getConnectionFix());
        }
        return buktiPesananDao;
    }

    public static OrderTempDao getOrderTempDao() {
        if (orderTempDao == null) {
            orderTempDao = new OrderTempDaoImplemen(getConnectionFix());
        }
        return orderTempDao;
    }

    public static PelangganDao getPelangganDao() {
        if (pelangganDao == null) {
            pelangganDao = new PelangganDaoImplemen(getConnectionFix());
        }
        return pelangganDao;
    }

    public static SalesDao getSalesDao() {
        if (salesDao == null) {
            salesDao = new SalesDaoImplemen(getConnectionFix());
        }
        return salesDao;
    }

    public static UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImplemen(getConnectionFix());
        }
        return userDao;
    }

    public static BarangDao getBarangDao() {
        if (barangDao == null) {
            barangDao = new BarangDaoImplemen(getConnectionFix());
        }
        return barangDao;
    }

    public static Connection getConnectionFix() {
        if (connection == null) {
            Koneksi k = new Koneksi();
            try {
                connection = k.bukaKoneksi();
            } catch (SQLException ex) {
                Logger.getLogger(DaoFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }

    public static String getIDUrutPesanan() {
        String kode = "";
        String formatlalu = "";
        String formatlalutanggal = null;
        String formatsekarang = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        PreparedStatement prep2 = null;
        Calendar c = Calendar.getInstance();
        Format formatter = new SimpleDateFormat("ddMMyy");
        String stringdate = formatter.format(c.getTime());
        try {
            prep2 = getConnectionFix().prepareStatement(("SELECT nourutpesanan as kode FROM urutpesnan ORDER BY idurut DESC LIMIT 1"));
            rs = prep2.executeQuery();
            while (rs.next()) {
                formatlalu = rs.getString("kode");
            }
            formatsekarang = "BP" + stringdate;
            if ("".equals(formatlalu)) {
                formatlalu = "BP" + stringdate + "0001";
                kode = formatlalu;
            }
            formatlalutanggal = formatlalu.substring(0, 8);
            System.out.println("Lalu " + formatlalu);
            System.out.println("Lalu Ringkas " + formatlalutanggal);
            System.out.println("Skrng " + formatsekarang);
            //JOptionPane.showMessageDialog(null, formatlalu);
            prep = getConnectionFix().prepareStatement(("SELECT RIGHT(nourutpesanan,4) AS kode FROM urutpesnan ORDER BY idurut DESC LIMIT 1"));
            rs = prep.executeQuery();
            while (rs.next()) {
                if (rs.first() == false) {
                    kode = "BP" + stringdate + "0001";
                } else {
                    rs.last();
                    if (formatlalutanggal.equalsIgnoreCase(formatsekarang)) {
                        int autoid = rs.getInt(1) + 1;
                        String nomor = String.valueOf(autoid);
                        int nolong = nomor.length();
                        for (int i = 0; i < 4 - nolong; i++) {
                            nomor = "0" + nomor;
                        }
                        kode = "BP" + stringdate + nomor;
                    } else {
                        kode = "BP" + stringdate + "0001";
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kode;
    }

    public static String getIDUrutAngsuran() {
        String kode = "";
        String formatlalu = "";
        String formatlalutanggal = null;
        String formatsekarang = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        PreparedStatement prep2 = null;
        Calendar c = Calendar.getInstance();
        Format formatter = new SimpleDateFormat("ddMMyy");
        String stringdate = formatter.format(c.getTime());
        try {
            prep2 = getConnectionFix().prepareStatement(("SELECT nourutangsuran as kode FROM urutangsuran ORDER BY idurut DESC LIMIT 1"));
            rs = prep2.executeQuery();
            while (rs.next()) {
                formatlalu = rs.getString("kode");
            }
            formatsekarang = "KA" + stringdate;
            if ("".equals(formatlalu)) {
                formatlalu = "KA" + stringdate + "0001";
                kode = formatlalu;
            }
            formatlalutanggal = formatlalu.substring(0, 8);
            System.out.println("Lalu " + formatlalu);
            System.out.println("Lalu Ringkas " + formatlalutanggal);
            System.out.println("Skrng " + formatsekarang);
            //JOptionPane.showMessageDialog(null, formatlalu);
            prep = getConnectionFix().prepareStatement(("SELECT RIGHT(nourutangsuran,4) AS kode FROM urutangsuran ORDER BY idurut DESC LIMIT 1"));
            rs = prep.executeQuery();
            while (rs.next()) {
                if (rs.first() == false) {
                    kode = "KA" + stringdate + "0001";
                } else {
                    rs.last();
                    if (formatlalutanggal.equalsIgnoreCase(formatsekarang)) {
                        int autoid = rs.getInt(1) + 1;
                        String nomor = String.valueOf(autoid);
                        int nolong = nomor.length();
                        for (int i = 0; i < 4 - nolong; i++) {
                            nomor = "0" + nomor;
                        }
                        kode = "KA" + stringdate + nomor;
                    } else {
                        kode = "KA" + stringdate + "0001";
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kode;
    }

    public static String getIDUrutBKM() {
        String kode = "";
        String formatlalu = "";
        String formatlalutanggal = null;
        String formatsekarang = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        PreparedStatement prep2 = null;
        Calendar c = Calendar.getInstance();
        Format formatter = new SimpleDateFormat("ddMMyy");
        String stringdate = formatter.format(c.getTime());
        try {
            prep2 = getConnectionFix().prepareStatement(("SELECT nourutbkm as kode FROM urutbkm ORDER BY idurut DESC LIMIT 1"));
            rs = prep2.executeQuery();
            while (rs.next()) {
                formatlalu = rs.getString("kode");
            }
            formatsekarang = "KM" + stringdate;
            if ("".equals(formatlalu)) {
                formatlalu = "KM" + stringdate + "0001";
                kode = formatlalu;
            }
            formatlalutanggal = formatlalu.substring(0, 8);
            System.out.println("Lalu " + formatlalu);
            System.out.println("Lalu Ringkas " + formatlalutanggal);
            System.out.println("Skrng " + formatsekarang);
            //JOptionPane.showMessageDialog(null, formatlalu);
            prep = getConnectionFix().prepareStatement(("SELECT RIGHT(nourutbkm,4) AS kode FROM urutbkm ORDER BY idurut DESC LIMIT 1"));
            rs = prep.executeQuery();
            while (rs.next()) {
                if (rs.first() == false) {
                    kode = "KM" + stringdate + "0001";
                } else {
                    rs.last();
                    if (formatlalutanggal.equalsIgnoreCase(formatsekarang)) {
                        int autoid = rs.getInt(1) + 1;
                        String nomor = String.valueOf(autoid);
                        int nolong = nomor.length();
                        for (int i = 0; i < 4 - nolong; i++) {
                            nomor = "0" + nomor;
                        }
                        kode = "KM" + stringdate + nomor;
                    } else {
                        kode = "KM" + stringdate + "0001";
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kode;
    }

    public static String getIDUrutBSTU() {
        String kode = "";
        String formatlalu = "";
        String formatlalutanggal = null;
        String formatsekarang = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        PreparedStatement prep2 = null;
        Calendar c = Calendar.getInstance();
        Format formatter = new SimpleDateFormat("ddMMyy");
        String stringdate = formatter.format(c.getTime());
        try {
            prep2 = getConnectionFix().prepareStatement(("SELECT nourutbstu as kode FROM urutbstu ORDER BY idurut DESC LIMIT 1"));
            rs = prep2.executeQuery();
            while (rs.next()) {
                formatlalu = rs.getString("kode");
            }
            formatsekarang = "TU" + stringdate;
            if ("".equals(formatlalu)) {
                formatlalu = "TU" + stringdate + "0001";
                kode = formatlalu;
            }
            formatlalutanggal = formatlalu.substring(0, 8);
            System.out.println("Lalu " + formatlalu);
            System.out.println("Lalu Ringkas " + formatlalutanggal);
            System.out.println("Skrng " + formatsekarang);
            //JOptionPane.showMessageDialog(null, formatlalu);
            prep = getConnectionFix().prepareStatement(("SELECT RIGHT(nourutbstu,4) AS kode FROM urutbstu ORDER BY idurut DESC LIMIT 1"));
            rs = prep.executeQuery();
            while (rs.next()) {
                if (rs.first() == false) {
                    kode = "TU" + stringdate + "0001";
                } else {
                    rs.last();
                    if (formatlalutanggal.equalsIgnoreCase(formatsekarang)) {
                        int autoid = rs.getInt(1) + 1;
                        System.out.println("nomorrr" + autoid);
                        String nomor = String.valueOf(autoid);
                        int nolong = nomor.length();
                        for (int i = 0; i < 4 - nolong; i++) {
                            nomor = "0" + nomor;
                        }
                        kode = "TU" + stringdate + nomor;
                    } else {
                        kode = "TU" + stringdate + "0001";
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kode;
    }

    public static void insertUrutPesanan(String kodepesanan) throws SQLException {
        PreparedStatement statement = null;
        statement = connection.prepareStatement("insert into urutpesnan(nourutpesanan) values(?)");
        statement.setString(1, kodepesanan);
        statement.executeUpdate();
    }

    public static void insertUrutAngsuran(String kodeangsuran) throws SQLException {
        PreparedStatement statement = null;
        statement = connection.prepareStatement("insert into urutangsuran(nourutangsuran) values(?)");
        statement.setString(1, kodeangsuran);
        statement.executeUpdate();
    }

    public static void insertUrutBKM(String kodebkm) throws SQLException {
        PreparedStatement statement = null;
        statement = connection.prepareStatement("insert into urutbkm(nourutbkm) values(?)");
        statement.setString(1, kodebkm);
        statement.executeUpdate();
    }

    public static void insertUrutBSTU(String kodebstu) throws SQLException {
        PreparedStatement statement = null;
        statement = connection.prepareStatement("insert into urutbstu(nourutbstu) values(?)");
        statement.setString(1, kodebstu);
        statement.executeUpdate();
    }

    public static void insertUrutKASOperasional(String kodekas) throws SQLException {
        PreparedStatement statement = null;
        statement = connection.prepareStatement("insert into urutkas(nourutkas) values(?)");
        statement.setString(1, kodekas);
        statement.executeUpdate();
    }

    public static void insertUrutKASBesar(String kodekas) throws SQLException {
        PreparedStatement statement = null;
        statement = connection.prepareStatement("insert into urutkasbesar(nourutkas) values(?)");
        statement.setString(1, kodekas);
        statement.executeUpdate();
    }

    public static String getIDUrutKasBesar() {
        String kode = "";
        String formatlalu = "";
        String formatlalutanggal = null;
        String formatsekarang = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        PreparedStatement prep2 = null;
        Calendar c = Calendar.getInstance();
        Format formatter = new SimpleDateFormat("ddMMyy");
        String stringdate = formatter.format(c.getTime());
        try {
            prep2 = getConnectionFix().prepareStatement(("SELECT nourutkas as kode FROM urutkasbesar ORDER BY idurut DESC LIMIT 1"));
            rs = prep2.executeQuery();
            while (rs.next()) {
                formatlalu = rs.getString("kode");
            }
            formatsekarang = "KB" + stringdate;
            if ("".equals(formatlalu)) {
                formatlalu = "KB" + stringdate + "0001";
                kode = formatlalu;
            }
            formatlalutanggal = formatlalu.substring(0, 8);
            System.out.println("Lalu " + formatlalu);
            System.out.println("Lalu Ringkas " + formatlalutanggal);
            System.out.println("Skrng " + formatsekarang);
            //JOptionPane.showMessageDialog(null, formatlalu);
            prep = getConnectionFix().prepareStatement(("SELECT RIGHT(nourutkas,4) AS kode FROM urutkasbesar ORDER BY idurut DESC LIMIT 1"));
            rs = prep.executeQuery();
            while (rs.next()) {
                if (rs.first() == false) {
                    kode = "KB" + stringdate + "0001";
                } else {
                    rs.last();
                    if (formatlalutanggal.equalsIgnoreCase(formatsekarang)) {
                        int autoid = rs.getInt(1) + 1;
                        String nomor = String.valueOf(autoid);
                        int nolong = nomor.length();
                        for (int i = 0; i < 4 - nolong; i++) {
                            nomor = "0" + nomor;
                        }
                        kode = "KB" + stringdate + nomor;
                    } else {
                        kode = "KB" + stringdate + "0001";
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kode;
    }

    public static String getIDUrutKasOperasional() {
        String kode = "";
        String formatlalu = "";
        String formatlalutanggal = null;
        String formatsekarang = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        PreparedStatement prep2 = null;
        Calendar c = Calendar.getInstance();
        Format formatter = new SimpleDateFormat("ddMMyy");
        String stringdate = formatter.format(c.getTime());
        try {
            prep2 = getConnectionFix().prepareStatement(("SELECT nourutkas as kode FROM urutkas ORDER BY idurut DESC LIMIT 1"));
            rs = prep2.executeQuery();
            while (rs.next()) {
                formatlalu = rs.getString("kode");
            }
            formatsekarang = "KO" + stringdate;
            if ("".equals(formatlalu)) {
                formatlalu = "KO" + stringdate + "0001";
                kode = formatlalu;
            }
            formatlalutanggal = formatlalu.substring(0, 8);
            System.out.println("Lalu " + formatlalu);
            System.out.println("Lalu Ringkas " + formatlalutanggal);
            System.out.println("Skrng " + formatsekarang);
            //JOptionPane.showMessageDialog(null, formatlalu);
            prep = getConnectionFix().prepareStatement(("SELECT RIGHT(nourutkas,4) AS kode FROM urutkas ORDER BY idurut DESC LIMIT 1"));
            rs = prep.executeQuery();
            while (rs.next()) {
                if (rs.first() == false) {
                    kode = "KO" + stringdate + "0001";
                } else {
                    rs.last();
                    if (formatlalutanggal.equalsIgnoreCase(formatsekarang)) {
                        int autoid = rs.getInt(1) + 1;
                        String nomor = String.valueOf(autoid);
                        int nolong = nomor.length();
                        for (int i = 0; i < 4 - nolong; i++) {
                            nomor = "0" + nomor;
                        }
                        kode = "KO" + stringdate + nomor;
                    } else {
                        kode = "KO" + stringdate + "0001";
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kode;
    }

    public static String getIDUrutKasBesar2() {
        String kode = "";
        String formatlalu = "";
        String formatlalutanggal = null;
        String formatsekarang = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        PreparedStatement prep2 = null;
        Calendar c = Calendar.getInstance();
        Format formatter = new SimpleDateFormat("ddMMyy");
        String stringdate = formatter.format(c.getTime());
        try {
            prep2 = getConnectionFix().prepareStatement(("SELECT nourutkas as kode FROM urutkasbesar ORDER BY idurut DESC LIMIT 1"));
            rs = prep2.executeQuery();
            while (rs.next()) {
                formatlalu = rs.getString("kode");
            }
            formatsekarang = "KB" + stringdate;
            if ("".equals(formatlalu)) {
                formatlalu = "KB" + stringdate + "0001";
                kode = formatlalu;
            }
            formatlalutanggal = formatlalu.substring(0, 8);
            System.out.println("Lalu " + formatlalu);
            System.out.println("Lalu Ringkas " + formatlalutanggal);
            System.out.println("Skrng " + formatsekarang);
            //JOptionPane.showMessageDialog(null, formatlalu);
            prep = getConnectionFix().prepareStatement(("SELECT RIGHT(nourutkas,4) AS kode FROM urutkasbesar ORDER BY idurut DESC LIMIT 1"));
            rs = prep.executeQuery();
            while (rs.next()) {
                if (rs.first() == false) {
                    kode = "KB" + stringdate + "0001";
                } else {
                    rs.last();
                    if (formatlalutanggal.equalsIgnoreCase(formatsekarang)) {
                        int autoid = rs.getInt(1) + 1;
                        String nomor = String.valueOf(autoid);
                        int nolong = nomor.length();
                        for (int i = 0; i < 4 - nolong; i++) {
                            nomor = "0" + nomor;
                        }
                        kode = "KB" + stringdate + nomor;
                    } else {
                        kode = "KB" + stringdate + "0001";
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kode;
    }
    
    public static String getFormatRupiahIndonesiaInt(int harga) {
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        kursIndonesia.applyPattern("Rp #,##0");
        return kursIndonesia.format(harga);
    }
}
