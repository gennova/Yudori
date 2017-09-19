/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.barang;

import java.util.List;

/**
 *
 * @author legollas
 */
public interface BarangDao {
    public List<Barang> getAllBarang();
    
    public Barang getBarangByID(int id);
    
    public Barang getBarangByName(String kode);

    public void insertBarang(Barang barang);
    
    public void updateNamaBarang(Barang barang);

    public void deleteBarang(Barang barang);       
    
    public void updateHargaBarang(Barang barang);
}
