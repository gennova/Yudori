/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.angsuran;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author legollas
 */
public class AngsuranTabelModel extends AbstractTableModel {

    List<Angsuran> angsurans = new ArrayList<>();

    public AngsuranTabelModel(List<Angsuran> angsurans) {
        this.angsurans = angsurans;
    }

    @Override
    public int getRowCount() {
        return angsurans.size();
    }
    
    public Angsuran get(int row) {
        return angsurans.get(row);
    }

    public void insert(Angsuran Angsuran) {
        angsurans.add(Angsuran);
        fireTableDataChanged();
    }

    public void update(int row, Angsuran Angsuran) {
        angsurans.set(row, Angsuran);
        fireTableDataChanged();
    }

    public void delete(int row) {
        angsurans.remove(row);
        fireTableDataChanged();
    }

    public void setData(List<Angsuran> angsurans) {
        this.angsurans = angsurans;
        fireTableDataChanged();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No";
            case 1:
                return "Kode ANS";
            case 2:
                return "Kode BP";
            case 3:
                return "Nama";
            case 4:
                return "Jumlah";
            case 5:
                return "Penerima";
            case 6:
                return "Tanggal";
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
                return angsurans.get(rowIndex).getKodeAngsuran();
            case 2:
                return angsurans.get(rowIndex).getKodeBP();
            case 3:
                return angsurans.get(rowIndex).getPembayar();
            case 4:
                return angsurans.get(rowIndex).getJumlah();
            case 5:
                return angsurans.get(rowIndex).getPenerima();
            case 6:
                return angsurans.get(rowIndex).getTanggalTerima();
            default:
                return null;
        }
    }

}
