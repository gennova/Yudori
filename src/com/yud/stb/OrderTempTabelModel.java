/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.stb;

import java.util.List;
import javax.management.loading.PrivateClassLoader;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author legollas
 */
public class OrderTempTabelModel extends AbstractTableModel {

    private List<OrderTemp> list = null;

    public OrderTempTabelModel(List<OrderTemp> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    public void insert(OrderTemp orderTemp) {
        list.add(orderTemp);
        fireTableDataChanged();
    }

    public void update(int row, OrderTemp orderTemp) {
        list.set(row, orderTemp);
        fireTableDataChanged();
    }

    public void delete(int row) {
        list.remove(row);
        fireTableDataChanged();
    }

    public void setData(List<OrderTemp> list) {
        this.list = list;
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getIdOrder();
            case 1:
                return list.get(rowIndex).getNamaBarang();
            case 2:
                return list.get(rowIndex).getUnit();
            case 3:
                return list.get(rowIndex).getHarga();
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
                return "Nama Barang";
            case 2:
                return "Unit";
            case 3:
                return "Harga";
            default:
                return null;
        }
    }
}
