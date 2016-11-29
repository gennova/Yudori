/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.user;

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
public class UserDaoImplemen implements UserDao {

    private Connection connection;
    private static final String sqlGetAllUser = "select * from user";
    private static final String sqlInsertUser = "insert into user (namauser,username,password,level) values(?,?,?,?)";
    private static final String sqlUpdateUser = "update user set namauser=?,username=?,password=?,level=? where iduser=?";
    private static final String sqlDeleteUser = "delete from user where iduser=?";
    private static final String sqlGetPasswordById = "select password from user where iduser=?";

    public UserDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<User> getALlUser() {
        List<User> users = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sqlGetAllUser);
            resultSet = statement.executeQuery();
            users = new ArrayList<>();
            while (resultSet.next()) {
                User u = new User();
                u.setIDuser(resultSet.getInt("iduser"));
                u.setNamauser(resultSet.getString("namauser"));
                u.setUsername(resultSet.getString("username"));
                u.setPassword(resultSet.getString("password"));
                u.setLevel(resultSet.getString("level"));
                users.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    @Override
    public void insertUser(User user) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareCall(sqlInsertUser);
            statement.setString(1, user.getNamauser());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getLevel());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data User Berhasil di Simpan");
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Gagal Menyimpan Data Karena : " + ex.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void updateUser(User user) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareCall(sqlUpdateUser);
            statement.setString(1, user.getNamauser());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getLevel());
            statement.setInt(5, user.getIDUser());
            statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data user gagal diupdate karena : " + ex.getMessage());
            Logger.getLogger(UserDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            JOptionPane.showMessageDialog(null, "Data user berhasil di update");
        }
    }

    @Override
    public void deleteUser(User user) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareCall(sqlDeleteUser);
            statement.setInt(1, user.getIDUser());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        }
    }

    @Override
    public String getPassword(int userid) {
        String password = "";
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareCall(sqlGetPasswordById);
            statement.setInt(1, userid);
            rs = statement.executeQuery();
            while (rs.next()) {
                password = rs.getString("password");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return password;
    }

}
