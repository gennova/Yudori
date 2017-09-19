/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.komisi;

import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author legollas
 */
public class KomisiTabelModelSalesA1Rekap extends AbstractTableModel {

    private List<Komisi> Lists;

    public KomisiTabelModelSalesA1Rekap(List<Komisi> Lists) {
        this.Lists = Lists;
    }

    @Override
    public int getRowCount() {
        return Lists.size();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No";
            case 1:
                return "Nama Sales";
            case 2:
                return "Tanggal Pesanan";
            case 3:
                return "Total";
            case 4:
                return "Komisi %";
            case 5:
                return "Komisi Rp";
            default:
                return null;
        }
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return Lists.get(rowIndex).getBp().getSales().getnamaSales();
            case 2:
                return Lists.get(rowIndex).getBp().getTglPesanan();
            case 3:
                return Lists.get(rowIndex).getBp().getTotal();
            case 4:
                return Lists.get(rowIndex).getKomisia1();
            case 5:
                return Lists.get(rowIndex).getTotalkomisirekap();
            default:
                return null;
        }
    }

    @Override
    public void fireTableCellUpdated(int row, int column) {
        super.fireTableCellUpdated(row, column); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fireTableChanged(TableModelEvent e) {
        super.fireTableChanged(e); //To change body of generated methods, choose Tools | Templates.
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
    public void fireTableRowsInserted(int firstRow, int lastRow) {
        super.fireTableRowsInserted(firstRow, lastRow); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fireTableRowsUpdated(int firstRow, int lastRow) {
        super.fireTableRowsUpdated(firstRow, lastRow); //To change body of generated methods, choose Tools | Templates.
    }

}
