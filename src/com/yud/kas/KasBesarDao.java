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
public interface KasBesarDao {

    public List<KasBesar> getALlKasBesar();
    
    public List<KasBesar> getALlKasBesarByDate(String date);
    
    public List<KasBesar> getALlKasBesarByDateBulanan(String date,String date_akhir);
    
    public void rekap_kas_besar_to_temp_harian(String date);
    
    public void rekap_kas_besar_to_temp_bulanan(String date, String date_akhir);

    public List<KasBesar> getALlKasBesarTemp();

    public KasBesar getKasBesarByID(int id);

    public KasBesar getKasBesarByKodeKas(String kode);

    public KasBesar getKasBesarByKodeKasManual(String kode);

    public List<KasBesar> getLaporanKasBesar();

    public void insertKasBesar(KasBesar kas);

    public void deleteKasBesar(KasBesar kas);

    public void updateKasBesar(KasBesar kas);

    public void insertKasBesarTemp(KasBesar kas);

    public void insertDetailToTemp(String kode);

    public void truncateKasTemp();
}
