/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KoneksiKu {

    String url;
    String user;
    String password;
    private Connection koneksi = null;
    private Statement st = null;

    public KoneksiKu() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Driver ditemukan");
            // TODO code application logic here
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KoneksiKu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            try {
                File file = new File("resource.xml");
                Properties properties;
                try (FileInputStream fileInput = new FileInputStream(file)) {
                    properties = new Properties();
                    properties.loadFromXML(fileInput);
                }
                //115.178.239.150
                String db = "ypiisema_supervisi";
                String host = "ypiisemarang.sch.id";
                String username = "ypiisema_spv";
                String passwordnya = "supervisi";
                user = username;
                password = passwordnya;
                url = "jdbc:mysql://"+host+":3306/"+db+"";
            } catch (FileNotFoundException e) {
            } catch (IOException e) {
            }

            koneksi = DriverManager.getConnection(url, user, password);

//            System.out.println("Koneksi OK");
            st = koneksi.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(KoneksiKu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Connection bukaKoneksi() throws SQLException {
        koneksi = DriverManager.getConnection(url, user, password);
        return koneksi;
    }

    public Connection getKoneksi() {
        return koneksi;
    }

    public void setKoneksi(Connection koneksi) {
        this.koneksi = koneksi;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public void tutupKoneksi() throws SQLException {
        if (koneksi != null) {
            koneksi.close();
        }
    }

    public int updateData(String sql) throws SQLException {
        int i = 0;
        i = st.executeUpdate(sql);
        return i;
    }

    public ResultSet lihatData(String sql) throws SQLException {
        ResultSet rs = null;
        rs = st.executeQuery(sql);
        return rs;

    }

    public void executeData(String sql) throws SQLException {
        st.execute(sql);
    }
}
