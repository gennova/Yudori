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
public class KomisiTabelModelSalesA1 extends AbstractTableModel {

    private List<Komisi> Lists;

    public KomisiTabelModelSalesA1(List<Komisi> Lists) {
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
                return "Kode BP";
            case 2:
                return "Nama Sales";
            case 3:
                return "Tanggal Pesanan";
            case 4:
                return "Total";
            case 5:
                return "Komisi %";
            case 6:
                return "Komisi Rp";
            case 7:
                return "Posting";
            default:
                return null;
        }
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return Lists.get(rowIndex).getBp().getKodePesanan();
            case 2:
                return Lists.get(rowIndex).getBp().getSales().getnamaSales();
            case 3:
                return Lists.get(rowIndex).getBp().getTglPesanan();
            case 4:
                return Lists.get(rowIndex).getBp().getTotal();
            case 5:
                return Lists.get(rowIndex).getKomisia1();
            case 6:
                return Lists.get(rowIndex).getRpkomisia1();
            case 7:
                return Lists.get(rowIndex).getStatuskomisia1();
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
