/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.kas;

import java.util.List;

/**
 *
 * @author legollas
 */
public interface KasDao {
    public List<Kas> getALlKas();
    
    public List<Kas> getALlKasTemp();

    public Kas getKasByID(int id);

    public Kas getKasByKodeKas(String kode);
    
    public Kas getKasByKodeKasManual(String kode);

    public void insertKas(Kas kas);
    
    public void deleteKas(Kas kas);

    public void updateKas(Kas kas);
    
    public void insertKasTemp(Kas kas);
    
    public void insertDetailToTemp(String kode);
    
    public void truncateKasTemp();
}
