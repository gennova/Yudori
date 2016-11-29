/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.angsuran;

import java.util.List;

/**
 *
 * @author legollas
 */
public interface AngsuranDao {

    public List<Angsuran> getAllAngsuran();
    
    public List<Angsuran> getAllAngsuranByKodeBP(String kodebp);
    
    public Angsuran getAngsuranByKodeBP(String kodebp);

    public void insertAngsuran(Angsuran angsuran);
    
    public void insertAngsuranBulananUM(Angsuran angsuran);

    public void updateAngsuran(Angsuran angsuran);
    
    public void updateSisaAngsuran(String kodebp);

    public void deleteAngsuran(Angsuran angsuran);

    public Angsuran getAngsuranByID(int kode);

    public Angsuran getAngsuranByKodeBP(int kode);    
    
    public int getTotalAngsuranByKodeBp(String kode);
    
}
