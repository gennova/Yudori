/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.sales;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author legollas
 */
public class SalesTabelModel extends AbstractTableModel {

    private List<Sales> list = new ArrayList<>();

    public SalesTabelModel(List<Sales> list) {
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

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getidSales();
            case 1:
                return list.get(rowIndex).getnamaSales();
            case 2:
                return list.get(rowIndex).getAlamatSales();
            case 3:
                return list.get(rowIndex).gettelepon();
            default:
                return null;
        }
    }

    public void insert(Sales sales) {
        list.add(sales);
        fireTableDataChanged();
    }

    public void update(int row, Sales sales) {
        list.set(row, sales);
        fireTableDataChanged();
    }

    public void delete(int row) {
        list.remove(row);
        fireTableDataChanged();
    }

    public void setData(List<Sales> list) {
        this.list = list;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode Sales";
            case 1:
                return "Nama Sales";
            case 2:
                return "Alamat";
            case 3:
                return "Telepon";
            default:
                return null;
        }
    }

}
