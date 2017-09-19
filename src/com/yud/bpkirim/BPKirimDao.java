/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.bpkirim;

import java.util.List;

/**
 *
 * @author legollas
 */
public interface BPKirimDao {

    public List<BPKirim> getAllBPKirim();

    public List<BPKirim> getAllBPKirimByKodeBP(String kodeBP);

    public List<BPKirim> getBPKirimByKodeBp(String kodeBP);

    public void insertBPKirim(BPKirim bPKirim);

    public void updateBPKirim(BPKirim bPKirim);

    public void deleteBPKirim(String id);

    public void deleteBPKirimByKodeBP(String kode);
}
