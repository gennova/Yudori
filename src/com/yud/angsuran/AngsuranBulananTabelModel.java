/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.angsuran;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author legollas
 */
public class AngsuranBulananTabelModel extends AbstractTableModel {

    private List<AngsuranBulanan> list = new ArrayList<AngsuranBulanan>();

    public AngsuranBulananTabelModel(List<AngsuranBulanan> abs) {
        this.list = abs;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    public void insert(AngsuranBulanan Angsuran) {
        list.add(Angsuran);
        fireTableDataChanged();
    }

    public void update(int row, AngsuranBulanan Angsuran) {
        list.set(row, Angsuran);
        fireTableDataChanged();
    }

    public void delete(int row) {
        list.remove(row);
        fireTableDataChanged();
    }

    public void setData(List<AngsuranBulanan> angsurans) {
        this.list = angsurans;
        fireTableDataChanged();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int column) {

        switch (column) {
            case 0:
                return "No";
            case 1:
                return "Kode BP";
            case 2:
                return "Kode Ans";
            case 3:
                return "Tanggal";
            case 4:
                return "ANS";
            case 5:
                return "Jumlah";
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
                return list.get(rowIndex).getKodebp();
            case 2:
                return list.get(rowIndex).getKodeans();
            case 3:
                return list.get(rowIndex).getTanggal();
            case 4:
                return list.get(rowIndex).getAngsuranke();
            case 5:
                return list.get(rowIndex).getJumlah();
            default:
                return null;
        }
    }

}
