/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.komisi;

import java.util.List;

/**
 *
 * @author legollas
 */
public interface KomisiDao {

    public void insertKomisiSales(Komisi komisi);

    public List<Komisi> getAllKomisiSales();

    public List<Komisi> getAllKomisiSalesByDatePesanan(String date);

    public List<Komisi> getAllKomisiSalesByDatePesananRekap(String date);

    public List<Komisi> getAllKomisiSalesByA1();

    public List<Komisi> getAllKomisiSalesByA1Rekap();
    
    public List<Komisi> getAllKomisiSalesByA1ByDate(String date);

    public List<Komisi> getAllKomisiSalesByLUNAS();

    public List<Komisi> getAllKomisiSalesByLUNASRekap();

    public List<Komisi> getAllKomisiSalesByTUNASI();

    public List<Komisi> getAllKomisiSalesByTUNASIRekap();

    public Komisi getKomisiSalesByKodeBp(String kodebp);

    public void updateKomisiSales(Komisi komisi);

    public void updateKomisiSalesSaja(Komisi komisi);

    public void postingKomisiSales(String kodebp);

    public void postingupdatestatuskomisibp(String date,String kodebp);

    public void postingupdatestatuskomisia1(String date,String kodebp);

    public void postingupdatestatuskomisilunas(String date,String kodebp);

    public void postingupdatestatuskomisitunai(String date,String kodebp);
}
