/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.kmb;

import java.util.List;

/**
 *
 * @author legollas
 */
public interface KeluarMasukBarangDao {

    public List<KeluarMasukBarang> getALlKMB();

    public KeluarMasukBarang getKMBByID(int id);

    public KeluarMasukBarang getKMBByKodeKMB(String kode);

    public void insertKMB(KeluarMasukBarang barang);
    
    public void insertKMBBuktiPesanan(KeluarMasukBarang barang);

    public void deleteKMB(KeluarMasukBarang barang);

    public void updateKMB(KeluarMasukBarang barang);

}
