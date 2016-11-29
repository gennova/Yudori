/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.bpkirim;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author legollas
 */
public class BPKirimTabelModel extends AbstractTableModel {

    private List<BPKirim> list = null;

    public BPKirimTabelModel(List<BPKirim> bPKirims) {
        this.list = bPKirims;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return list.get(rowIndex).getBarang().getNamabarang();
            case 2:
                return list.get(rowIndex).getStok();
            case 3:                
                return list.get(rowIndex).getBp().getPelanggan().getNamaPelanggan();
            case 4:
                return list.get(rowIndex).getBp().getNoFakturPesanan();
            case 5:
                return list.get(rowIndex).getStatus();
            case 6:
                return list.get(rowIndex).getBp().getKodePesanan();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case (0):
                return "No";
            case (1):
                return "Nama Barang";
            case (2):
                return "Jumlah";
            case (3):
                return "Pelanggan";
            case (4):
                return "BP";
            case (5):
                return "Track";
            case (6):
                return "Status";
            default:
                return null;
        }
    }

    @Override
    public void fireTableCellUpdated(int row, int column) {
        super.fireTableCellUpdated(row, column); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void insert(BPKirim bpkirim) {
        list.add(bpkirim);
        fireTableDataChanged();
    }

    public void update(int row, BPKirim bpkirim) {
        list.set(row, bpkirim);
        fireTableDataChanged();
    }

    public void delete(int row) {
        list.remove(row);
        fireTableDataChanged();
    }

    public void setData(List<BPKirim> list) {
        this.list = list;
        fireTableDataChanged();
    }

}
