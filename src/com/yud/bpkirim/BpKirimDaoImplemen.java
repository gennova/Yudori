/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.bpkirim;

import com.init.tools.DaoFactory;
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
public class BpKirimDaoImplemen implements BPKirimDao {

    private final Connection connection;
    private static final String sqlGetALlBPKirim = "SELECT buktipesanan.idpelanggan,detailpesanan.namabarang,detailpesanan.unit,buktipesanan.namapelanggan,buktipesanan.idpesananfaktur,buktipesanan.statuskirim,buktipesanan.kodebp FROM buktipesanan JOIN detailpesanan ON buktipesanan.kodebp=detailpesanan.kodebp WHERE buktipesanan.statuskirim='belum' and statusbp='belum' GROUP BY buktipesanan.kodebp ";

    public BpKirimDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<BPKirim> getAllBPKirim() {
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<BPKirim> kirims = null;
        try {
            kirims = new ArrayList<BPKirim>();
            statement = connection.prepareCall(sqlGetALlBPKirim);
            rs = statement.executeQuery();
            while (rs.next()) {
                BPKirim bpk = new BPKirim();
                bpk.setBp(DaoFactory.getBuktiPesananDao().getBuktiPesananByKodeBP(rs.getString("kodebp")));
                bpk.setBarang(DaoFactory.getBarangDao().getBarangByName(rs.getString("namabarang")));
                bpk.setStok(rs.getInt("unit"));
                bpk.setStatus(rs.getString("statuskirim"));
                bpk.setPelanggan(DaoFactory.getPelangganDao().getPelangganByID(rs.getInt("idpelanggan")));
                kirims.add(bpk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BpKirimDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kirims;
    }

    @Override
    public List<BPKirim> getAllBPKirimByKodeBP(String kodeBP) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BPKirim> getBPKirimByKodeBp(String kodeBP) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertBPKirim(BPKirim bPKirim) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateBPKirim(BPKirim bPKirim) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteBPKirim(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteBPKirimByKodeBP(String kode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
