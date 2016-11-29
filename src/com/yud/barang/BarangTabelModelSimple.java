/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.barang;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author legollas
 */
public class BarangTabelModelSimple extends AbstractTableModel{

    private List<Barang> list = new ArrayList<Barang>();

    public BarangTabelModelSimple(List<Barang> barangs) {
        this.list = barangs;
    }

    public Barang get(int row) {
        return list.get(row);
    }

    public void insert(Barang Barang) {
        list.add(Barang);
        fireTableDataChanged();
    }

    public void update(int row, Barang Barang) {
        list.set(row, Barang);
        fireTableDataChanged();
    }

    public void delete(int row) {
        list.remove(row);
        fireTableDataChanged();
    }

    public void setData(List<Barang> list) {
        this.list = list;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode";
            case 1:
                return "Nama Barang";
            case 2:
                return "Harga Tunai";
            default:
                return null;
        }
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getKodebarang();
            case 1:
                return list.get(rowIndex).getNamabarang();   
            case 2:
                return list.get(rowIndex).getHargatunai();  
            default:
                return null;
        }
    }

}
