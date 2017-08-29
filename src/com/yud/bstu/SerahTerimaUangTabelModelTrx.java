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
public class SerahTerimaUangTabelModelTrx extends AbstractTableModel {

    private List<SerahTerimaUang> List;

    public SerahTerimaUangTabelModelTrx(List<SerahTerimaUang> List) {
        this.List = List;
    }

    @Override
    public int getRowCount() {
        return List.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged(); //To change body of generated methods, choose Tools | Templates.
    }

    public void insert(SerahTerimaUang stu) {
        List.add(stu);
        fireTableDataChanged();
    }

    public void update(int row, SerahTerimaUang stu) {
        List.set(row, stu);
        fireTableDataChanged();
    }

    public void delete(int row) {
        List.remove(row);
        fireTableDataChanged();
    }

    public void setData(List<SerahTerimaUang> list) {
        this.List = list;
        fireTableDataChanged();
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
                return "Masuk";
            case 4:
                return "Keluar";
            case 5:
                return "Saldo";
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
                return List.get(rowIndex).getNama();
            case 2:
                return List.get(rowIndex).getUraian();
            case 3:
                return List.get(rowIndex).getDebit();
            case 4:
                return List.get(rowIndex).getKredit();
            case 5:
                return List.get(rowIndex).getSaldo();
            default:
                return null;
        }
    }

}
