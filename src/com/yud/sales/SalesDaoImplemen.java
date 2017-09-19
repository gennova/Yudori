/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.sales;

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
public class SalesDaoImplemen implements SalesDao {

    private Connection connection;
    private static final String sqlgetAllSales = "select * from sales";
    private static final String sqlgetAllSalesByID = "select * from sales where idsales=?";
    private static final String sqlgetAllSalesByName = "select * from sales where namasales=?";
    private static final String sqlInsertSales = "insert into sales (namasales,alamat,telepon) values (?,?,?)";
    private static final String sqlUpdateSales = "update sales set namasales=?,alamat=?,telepon=? where idsales=?";
    private static final String sqlDeleteSales = "delete from sales where idsales=?";

    public SalesDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Sales> getAllSales() {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<Sales> list = null;
        try {
            list = new ArrayList<Sales>();
            statement = connection.prepareCall(sqlgetAllSales);
            set = statement.executeQuery();
            while (set.next()) {
                Sales sales = new Sales();
                sales.setidSales(set.getInt("idsales"));
                sales.setnamaSales(set.getString("namasales"));
                sales.setalamatSales(set.getString("alamat"));
                sales.settelepon(set.getString("telepon"));
                list.add(sales);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalesDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void insertSales(Sales sales) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareCall(sqlInsertSales);
            statement.setString(1, sales.getnamaSales());
            statement.setString(2, sales.getAlamatSales());
            statement.setString(3, sales.gettelepon());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
        } catch (SQLException ex) {
            Logger.getLogger(SalesDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data Gagal di Simpan karena : " + ex.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(SalesDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void updateSales(Sales sales) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareCall(sqlUpdateSales);
            statement.setString(1, sales.getnamaSales());
            statement.setString(2, sales.getAlamatSales());
            statement.setString(3, sales.gettelepon());
            statement.setInt(4, sales.getidSales());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil di simpan");
        } catch (SQLException ex) {
            Logger.getLogger(SalesDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data gagal di simpan karena : " + ex.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(SalesDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void deleteSales(Sales sales) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareCall(sqlDeleteSales);
            statement.setInt(1, sales.getidSales());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan karena " + ex.getMessage());
            Logger.getLogger(SalesDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(SalesDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Sales getSalesByName(String name) {
        PreparedStatement statement = null;
        ResultSet set = null;
        Sales sales = null;
        try {
            statement = connection.prepareCall(sqlgetAllSalesByName);
            statement.setString(1, name);
            set = statement.executeQuery();
            while (set.next()) {
                sales = new Sales();
                sales.setidSales(set.getInt("idsales"));
                sales.setnamaSales(set.getString("namasales"));
                sales.setalamatSales(set.getString("alamat"));
                sales.settelepon(set.getString("telepon"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalesDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sales;

    }

    @Override
    public Sales getSalesByID(int id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        Sales sales = null;
        try {
            statement = connection.prepareCall(sqlgetAllSalesByID);
            statement.setInt(1, id);
            set = statement.executeQuery();
            while (set.next()) {
                sales = new Sales();
                sales.setidSales(set.getInt("idsales"));
                sales.setnamaSales(set.getString("namasales"));
                sales.setalamatSales(set.getString("alamat"));
                sales.settelepon(set.getString("telepon"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalesDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sales;
    }

}
