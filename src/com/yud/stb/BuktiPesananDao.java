/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.stb;

import java.util.List;

/**
 *
 * @author legollas
 */
public interface BuktiPesananDao {

    public List<BuktiPesanan> getAllBuktiPesanan();
    
    public List<BuktiPesanan> getAllBuktiPesananBelumTerkirim();
    
    public List<BuktiPesanan> getAllBuktiPesananBelumLunas();
    
    public List<BuktiPesanan> getAllBuktiPesananLunas();
    
    public List<BuktiPesanan> getAllBuktiPesananByDate(String date);
    
    public List<BuktiPesanan> getAllBuktiPesananByDateDROPA1(String date);
    
    public List<BuktiPesanan> getAllBuktiPesananByDateTUNAI(String date);
    
    public List<BuktiPesanan> getAllBuktiPesananByDateINDENT(String date);
    
    public List<BuktiPesanan> getAllBuktiPesananByBulanan(String dateone,String datetwo);
    
    public List<BuktiPesanan> getAllBuktiPesananBySales(int idsales);
    
    public List<BuktiPesanan> getAllBuktiPesananBySalesBelumKomisi(int idsales);
    
    public List<BuktiPesanan> getAllBuktiPesananBySalesSudahKomisi(int idsales);
    
    public BuktiPesanan getBuktiPesananByID(int id);
    
    public BuktiPesanan getBuktiPesananByKodeBP(String kode);

    public void InsertBuktiPesanan(BuktiPesanan bp);

    public void UpdateBuktiPesanan(BuktiPesanan bp);

    public void DeleteBuktiPesanan(BuktiPesanan bp);
    
    public void getTempDetailPesanan(String kode);
    
}
