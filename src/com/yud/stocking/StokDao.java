/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.stocking;

import java.util.List;

/**
 *
 * @author legollas
 */
public interface StokDao {

    public List<Stok> getAllStokBarang();

    public void insertStokAwalBarang();

    public void insertStokBarang();

    public void updateStokBarang();

    public void deleteStokBarang();

    public List<Stok> getLaporanPengeluanBarangByDate(String date);
    
    public List<Stok> getLaporanPengeluanBarangByDateMonth(String date,String date2);

}
