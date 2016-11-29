/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.stocking;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author legollas
 */
public class StokTabelModel2 extends AbstractTableModel {

    private List<Stok> lists;

    public StokTabelModel2(List<Stok> lists) {
        this.lists = lists;
    }

    @Override
    public int getRowCount() {
        return lists.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            default:
                return null;
            case 0:
                return "No.";
            case 1:
                return "Nama Barang";
            case 2:
                return "Jumlah/Stok";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            default:
                return null;
            case 0:
                return lists.get(rowIndex).getId();
            case 1:
                return lists.get(rowIndex).getBarang().getNamabarang();
            case 2:
                return lists.get(rowIndex).getJumlah();
        }
    }

}
