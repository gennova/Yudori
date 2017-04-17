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
public class BarangTabelModel extends AbstractTableModel {

    private List<Barang> list = new ArrayList<Barang>();

    public BarangTabelModel(List<Barang> barangs) {
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
                return "No";
            case 1:
                return "Nama Barang";
            case 2:
                return "Harga Tunai";
            case 3:
                return "Harga Drop";
            case 4:
                return "UM";
            case 5:
                return "Harga Promosi";
            case 6:
                return "Sisa 1";
            case 7:
                return "Sisa 2";
            case 8:
                return "Kode";
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
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return list.get(rowIndex).getNamabarang();
            case 2:
                return list.get(rowIndex).getHargatunai();
            case 3:
                return list.get(rowIndex).getHargadrop();
            case 4:
                return list.get(rowIndex).getUM();
            case 5:
                return list.get(rowIndex).getHargapromosi();
            case 6:
                return list.get(rowIndex).getSisa1();
            case 7:
                return list.get(rowIndex).getSisa2();
            case 8:
                return list.get(rowIndex).getIdHarga();
            default:
                return null;
        }
    }

}
