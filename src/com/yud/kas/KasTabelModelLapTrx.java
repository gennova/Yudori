/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.kas;

import com.init.tools.DaoFactory;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author legollas
 */
public class KasTabelModelLapTrx extends AbstractTableModel {

    private List<Kas> listeds = new ArrayList<>();

    public KasTabelModelLapTrx(List<Kas> listeds) {
        this.listeds = listeds;
    }

    @Override
    public int getRowCount() {
        return listeds.size();
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
                return listeds.get(rowIndex).getKodeKas();
            case 2:
                return listeds.get(rowIndex).getTanggal();
            case 3:
                return listeds.get(rowIndex).getUraian();
            case 4:
                int value = listeds.get(rowIndex).getDebet();
                if (value == 0) {
                    return "-";
                } else {
                    return DaoFactory.getFormatRupiahIndonesiaInt(listeds.get(rowIndex).getDebet());
                }
            case 5:
                int valuek = listeds.get(rowIndex).getKredit();
                if (valuek == 0) {
                    return "-";
                } else {
                    return DaoFactory.getFormatRupiahIndonesiaInt(listeds.get(rowIndex).getKredit());
                }
            case 6:
                int values = listeds.get(rowIndex).getSaldo();
                if (values == 0) {
                    return "-";
                } else {
                    return DaoFactory.getFormatRupiahIndonesiaInt(listeds.get(rowIndex).getSaldo());
                }
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
                return "Tanggal";
            case 3:
                return "Uraian";
            case 4:
                return "Debit";
            case 5:
                return "Kredit";
            case 6:
                return "Saldo";
            default:
                return null;
        }
    }

}
