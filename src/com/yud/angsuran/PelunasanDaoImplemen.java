/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.angsuran;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author legollas
 */
public class PelunasanDaoImplemen implements PelunasanDao {

    private Connection connection;
    private final static String sqlInsertPelunasan = "call spInsertPelunasan(?,?,?)";

    public PelunasanDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertPelunasan(Pelunasan pelunasan) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlInsertPelunasan);
            statement.setString(1, pelunasan.getKodebp());
            statement.setString(2, pelunasan.getTanggal());
            statement.setString(3, pelunasan.getKeterangan());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (SQLException ex) {
            Logger.getLogger(PelunasanDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Tidak ada data BP atau Kesalahan Data " + ex.getMessage());
        }

    }

}
