/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.kmb;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author legollas
 */
public class KeluarMasukBarangTabelModel extends AbstractTableModel {

    private List<KeluarMasukBarang> kmb = new ArrayList<KeluarMasukBarang>();

    public KeluarMasukBarangTabelModel(List<KeluarMasukBarang> kmb) {
        this.kmb = kmb;
    }

    @Override
    public int getRowCount() {
        return kmb.size();
    }

    public void insert(KeluarMasukBarang bmkb) {
        kmb.add(bmkb);
        fireTableDataChanged();
    }

    public void update(int row, KeluarMasukBarang bmkb) {
        kmb.set(row, bmkb);
        fireTableDataChanged();
    }

    public void delete(int row) {
        kmb.remove(row);
        fireTableDataChanged();
    }

    public void setData(List<KeluarMasukBarang> list) {
        this.kmb = list;
        fireTableDataChanged();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No";
            case 1:
                return "Kode";
            case 2:
                return "Nama";
            case 3:
                return "Alamat";
            case 4:
                return "Barang";
            case 5:
                return "Jumlah";
            case 6:
                return "Keterangan";
            case 7:
                return "Status";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return kmb.get(rowIndex).getKodeKMB();
            case 2:
                return kmb.get(rowIndex).getNama();
            case 3:
                return kmb.get(rowIndex).getAlamat();
            case 4:
                return kmb.get(rowIndex).getBarang().getNamabarang();
            case 5:
                return kmb.get(rowIndex).getJumlah();
            case 6:
                return kmb.get(rowIndex).getKeterangan();
            case 7:
                return kmb.get(rowIndex).getStatusbarang();
            default:
                return null;
        }
    }

}
