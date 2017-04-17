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
public interface AngsuranBulananDao {

    public List<AngsuranBulanan> getAllAngsuranBulanan();

    public List<AngsuranBulanan> getAllAngsuranBulananByKodeBP(String kode);

    public List<AngsuranBulanan> getAllAngsuranBulananByTglHarian(String tgl);

    public int getSUMAllAngsuranBulananByTglHarian(String tgl);

    public List<AngsuranBulanan> getAllAngsuranBulananByTglBulanan(String dateone, String datetwo);

    public int getSUMAllAngsuranBulananByTglBulanan(String dateone, String datetwo);

    public AngsuranBulanan getAngsuranBulananByID(int id);

    public AngsuranBulanan getAngsuranBulananByKodeBP(String kode);

    public AngsuranBulanan getAngsuranBulananByKodeANS(String kode);

    public void InsertAngsuranBulanan(AngsuranBulanan ab);

    public void DeleteAngsuranBulanan(AngsuranBulanan ab);

    public void UpdateAngsuranBulanan(AngsuranBulanan ab);

    public void UpdateAngsuranBulanan1(AngsuranBulanan ab);

    public void UpdateAngsuranBulanan2(AngsuranBulanan ab);

    public void UpdateAngsuranBulanan3(AngsuranBulanan ab);

    public void UpdateAngsuranBulanan4(AngsuranBulanan ab);

    public void UpdateAngsuranBulanan5(AngsuranBulanan ab);

    public void UpdateAngsuranBulanan6(AngsuranBulanan ab);

    public void UpdateAngsuranBulanan7(AngsuranBulanan ab);

    public void UpdateAngsuranBulanan8(AngsuranBulanan ab);

    public void UpdateAngsuranBulanan9(AngsuranBulanan ab);

    public void UpdateAngsuranBulanan10(AngsuranBulanan ab);

    public void resetSpaceDateAns(String kode);

    public void insertdetailangsuran(AngsuranBulanan ab);

}
