/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.kas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author legollas
 */
public class KasTabelModelAll extends AbstractTableModel {

    private List<Kas> listeds = new ArrayList<>();

    public KasTabelModelAll(List<Kas> listeds) {
        this.listeds = listeds;
    }

    @Override
    public int getRowCount() {
        return listeds.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return listeds.get(rowIndex).getKodeKas();
            case 2:
                return listeds.get(rowIndex).getKodeManKas();
            case 3:
                return listeds.get(rowIndex).getTanggal();
            case 4:
                return listeds.get(rowIndex).getSaldo();
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
                return "Kode";
            case 2:
                return "Referensi";
            case 3:
                return "Tanggal";
            case 4:
                return "Total";
            default:
                return null;
        }
    }

}
