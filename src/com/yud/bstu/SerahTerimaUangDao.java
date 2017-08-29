/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.bstu;

import java.util.List;

/**
 *
 * @author legollas
 */
public interface SerahTerimaUangDao {

    public List<SerahTerimaUang> getAllBSTU();
    
    public List<SerahTerimaUang> getAllBSTUBulananTrx(String date,String date_akhir);

    public SerahTerimaUang getSerahTerimaByID(int id);

    public SerahTerimaUang getSerahTerimaByKode(String kode);

    public void insertBSTU(SerahTerimaUang stu);

    public void updateBSTU(SerahTerimaUang stu);

    public void deleteBSTU(SerahTerimaUang stu);

    public void InsertTempBSTU(SerahTerimaUang stu);
    
    public List<SerahTerimaUang> GetAllTempBSTU (); 
    
    public void truncateTempBSTU();
    
    public int getSUMTemp(String kode);
    
    public void lookBSTUDetailToTemp(String kode);
}
