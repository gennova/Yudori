/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.user;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author legollas
 */
public class UserTabelModel extends AbstractTableModel {

    private List<User> list = new ArrayList<User>();

    public UserTabelModel(List<User> users) {
        this.list = users;
    }

    public void insert(User user) {
        list.add(user);
        fireTableDataChanged();
    }

    public void update(int row, User user) {
        list.set(row, user);
        fireTableDataChanged();
    }

    public void delete(int row) {
        list.remove(row);
        fireTableDataChanged();
    }

    public void setData(List<User> list) {
        this.list = list;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getIDUser();
            case 1:
                return list.get(rowIndex).getNamauser();
            case 2:
                return list.get(rowIndex).getUsername();
            case 3:
                return list.get(rowIndex).getLevel();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No";
            case 1:
                return "Nama User";
            case 2:
                return "Username";
            case 3:
                return "Level";
            default:
                return null;
        }
    }

}
