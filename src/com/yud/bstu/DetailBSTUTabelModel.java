/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.bstu;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author legollas
 */
public class DetailBSTUTabelModel extends AbstractTableModel {

    private List<SerahTerimaUang> list;

    public DetailBSTUTabelModel(List<SerahTerimaUang> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fireTableRowsDeleted(int firstRow, int lastRow) {
        super.fireTableRowsDeleted(firstRow, lastRow); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fireTableRowsUpdated(int firstRow, int lastRow) {
        super.fireTableRowsUpdated(firstRow, lastRow); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No";
            case 1:
                return "Nama";
            case 2:
                return "Uraian";
            case 3:
                return "Keterangan";
            case 4:
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
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getUraian();
            case 3:
                return list.get(rowIndex).getKeterangan();
            case 4:
                return list.get(rowIndex).getJumlah();
            default:
                return null;
        }
    }

}
