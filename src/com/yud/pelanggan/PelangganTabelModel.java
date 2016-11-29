/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.pelanggan;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author legollas
 */
public class PelangganTabelModel extends AbstractTableModel {

    private List<Pelanggan> list = null;

    public PelangganTabelModel(List<Pelanggan> pelanggans) {
        this.list = pelanggans;
    }

    public void insert(Pelanggan pelanggan) {
        list.add(pelanggan);
        fireTableDataChanged();
    }

    public void update(int row, Pelanggan pelanggan) {
        list.set(row, pelanggan);
        fireTableDataChanged();
    }

    public void delete(int row) {
        list.remove(row);
        fireTableDataChanged();
    }

    public void setData(List<Pelanggan> list) {
        this.list = list;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getIdPelanggan();
            case 1:
                return list.get(rowIndex).getKodemanualpelanggan();
            case 2:
                return list.get(rowIndex).getNamaPelanggan();
            case 3:
                return list.get(rowIndex).getAlamatpelanggan();
            case 4:
                return list.get(rowIndex).getTelepon();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode";
            case 1:
                return "Ref. Pelanggan";
            case 2:
                return "Nama Pelanggan";
            case 3:
                return "Alamat Pelanggan";
            case 4:
                return "Telepon";
            default:
                return null;
        }
    }
}
