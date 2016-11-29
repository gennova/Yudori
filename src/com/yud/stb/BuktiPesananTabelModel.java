/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.stb;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author legollas
 */
public class BuktiPesananTabelModel extends AbstractTableModel {

    private List<BuktiPesanan> list = null;

    public BuktiPesananTabelModel(List<BuktiPesanan> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    public void insert(BuktiPesanan buktipesanan) {
        list.add(buktipesanan);
        fireTableDataChanged();
    }

    public void update(int row, BuktiPesanan buktipesanan) {
        list.set(row, buktipesanan);
        fireTableDataChanged();
    }

    public void delete(int row) {
        list.remove(row);
        fireTableDataChanged();
    }

    public void setData(List<BuktiPesanan> list) {
        this.list = list;
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return list.get(rowIndex).getNoFakturPesanan();
            case 2:
                return list.get(rowIndex).getPelanggan().getKodemanualpelanggan();
            case 3:
                return list.get(rowIndex).getPelanggan().getNamaPelanggan();
            case 4:
                return list.get(rowIndex).getPelanggan().getAlamatpelanggan();
            case 5:
                return list.get(rowIndex).getPelanggan().getTelepon();
            case 6:
                return list.get(rowIndex).getJenisOrder();
            case 7:
                return list.get(rowIndex).getTglPesanan();
            case 8:
                return list.get(rowIndex).getTotal();
            case 9:
                return list.get(rowIndex).getKodePesanan();
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
                return "Kode BP Ref";
            case 2:
                return "Kode Man. Pelanggan";
            case 3:
                return "Nama";
            case 4:
                return "Alamat";
            case 5:
                return "Telpon";
            case 6:
                return "Jenis";
            case 7:
                return "Tgl. Pemesanan";
            case 8:
                return "Total";
            case 9:
                return "Kode BP";
            default:
                return null;
        }
    }

}
