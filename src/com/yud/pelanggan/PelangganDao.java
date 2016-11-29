/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.pelanggan;

import java.util.List;

/**
 *
 * @author legollas
 */
public interface PelangganDao {

    public List<Pelanggan> getAllPelanggan();
    
    public Pelanggan getPelangganByID(int id);
    
    public Pelanggan getPelangganByName(String Name);

    public void insertPelanggan(Pelanggan pelanggan);

    public void updatePelanggan(Pelanggan pelanggan);

    public void deletePelanggan(Pelanggan pelanggan);
}
