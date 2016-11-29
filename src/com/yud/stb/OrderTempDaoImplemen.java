/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.stb;

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
public class OrderTempDaoImplemen implements OrderTempDao {

    private Connection connection;
    private static final String sqlGetAllOrderTemp = "select * from ordertemp";
    private static final String sqlInsertDetailToTempOrder = "insert into ordertemp(kodebarang,namabarang,unit,harga,total,idpesanan,kodebp) select kodebarang,namabarang,unit,harga,total,idpesanan,kodebp from detailpesanan where kodebp=?";
    private static final String sqlInsertOrderTemo = "INSERT INTO ordertemp(kodebarang,namabarang,unit,harga,kodebp) values(?,?,?,?,?)";
    private static final String sqltruncateOrderTemp = "truncate ordertemp";
    private static final String sqlGetAllSumOrder = "select sum(harga) as total from ordertemp where idpesanan=?";

    public OrderTempDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<OrderTemp> getAllOrderTemo() {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<OrderTemp> list = null;
        try {
            statement = connection.prepareStatement(sqlGetAllOrderTemp);
            resultSet = statement.executeQuery();
            list = new ArrayList<OrderTemp>();
            while (resultSet.next()) {
                OrderTemp orderTemp = new OrderTemp();
                orderTemp.setIdOrder(resultSet.getInt("idorder"));
                orderTemp.setKodeBarang(resultSet.getInt("kodebarang"));
                orderTemp.setNamaBarang(resultSet.getString("namabarang"));
                orderTemp.setUnit(resultSet.getInt("unit"));
                orderTemp.setHarga(resultSet.getInt("harga"));
                orderTemp.setKodepesanan(resultSet.getString("idpesanan"));
                list.add(orderTemp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderTempDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void insertordertemp(OrderTemp ordertemp) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlInsertOrderTemo);
            statement.setInt(1, ordertemp.getKodeBarang());
            statement.setString(2, ordertemp.getNamaBarang());
            statement.setInt(3, ordertemp.getUnit());
            statement.setInt(4, ordertemp.getHarga());
            statement.setString(5, ordertemp.getKodepesanan());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderTempDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateordertemp(OrderTemp ordertemp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteordertemp(OrderTemp ordertemp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void truncateordertemp() {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqltruncateOrderTemp);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderTempDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public int getSumOrder(String kodepesanan) {
        PreparedStatement statement = null;
        ResultSet rs = null;
        int total = 0;
        try {
            statement = connection.prepareStatement(sqlGetAllSumOrder);
            statement.setString(1, kodepesanan);
            rs = statement.executeQuery();
            if (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderTempDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    @Override
    public void insertDetailToTemp(String kodebp) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlInsertDetailToTempOrder);
            statement.setString(1, kodebp);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderTempDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
