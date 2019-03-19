/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.barang;

/**
 *
 * @author legollas
 */
public class Barang {

    private int kodebarang; //1
    private String namabarang; //2
    private int idHarga; //3
    private int hargatunai; //4
    private int hargadrop; //5
    private int hargaindent; //6
    private int UM; //7
    private int Sisa; //8
    private int hargapromosi; //9
    private int sisa1; //10
    private int sisa2; //11 
    private String tglMulaiBerlaku; //12
    private String tgAkhirBerlaku; //13
    private String aktif; //14
    //---------------------------------
    //barang paket
    private String kode_satu;
    private String kode_dua;
    private String kode_tiga;
    private String kode_empat;
    private int qty_satu;
    private int qty_dua;
    private int qty_tiga;
    private int qty_empat;

    public Barang() {
    }

    public int getKodebarang() {
        return kodebarang;
    }

    public void setKodebarang(int kodebarang) {
        this.kodebarang = kodebarang;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public int getIdHarga() {
        return idHarga;
    }

    public void setIdHarga(int idHarga) {
        this.idHarga = idHarga;
    }

    public int getHargatunai() {
        return hargatunai;
    }

    public void setHargatunai(int hargatunai) {
        this.hargatunai = hargatunai;
    }

    public int getHargadrop() {
        return hargadrop;
    }

    public void setHargadrop(int hargadrop) {
        this.hargadrop = hargadrop;
    }

    public int getHargaindent() {
        return hargaindent;
    }

    public void setHargaindent(int hargaindent) {
        this.hargaindent = hargaindent;
    }

    public int getUM() {
        return UM;
    }

    public void setUM(int UM) {
        this.UM = UM;
    }

    public int getSisa() {
        return Sisa;
    }

    public void setSisa(int Sisa) {
        this.Sisa = Sisa;
    }

    public int getHargapromosi() {
        return hargapromosi;
    }

    public void setHargapromosi(int hargapromosi) {
        this.hargapromosi = hargapromosi;
    }

    public int getSisa1() {
        return sisa1;
    }

    public void setSisa1(int sisa1) {
        this.sisa1 = sisa1;
    }

    public int getSisa2() {
        return sisa2;
    }

    public void setSisa2(int sisa2) {
        this.sisa2 = sisa2;
    }

    public String getTglMulaiBerlaku() {
        return tglMulaiBerlaku;
    }

    public void setTglMulaiBerlaku(String tglMulaiBerlaku) {
        this.tglMulaiBerlaku = tglMulaiBerlaku;
    }

    public String getTgAkhirBerlaku() {
        return tgAkhirBerlaku;
    }

    public void setTgAkhirBerlaku(String tgAkhirBerlaku) {
        this.tgAkhirBerlaku = tgAkhirBerlaku;
    }

    public String getAktif() {
        return aktif;
    }

    public void setAktif(String aktif) {
        this.aktif = aktif;
    }

    /**
     * @return the kode_satu
     */
    public String getKode_satu() {
        return kode_satu;
    }

    /**
     * @param kode_satu the kode_satu to set
     */
    public void setKode_satu(String kode_satu) {
        this.kode_satu = kode_satu;
    }

    /**
     * @return the kode_dua
     */
    public String getKode_dua() {
        return kode_dua;
    }

    /**
     * @param kode_dua the kode_dua to set
     */
    public void setKode_dua(String kode_dua) {
        this.kode_dua = kode_dua;
    }

    /**
     * @return the kode_tiga
     */
    public String getKode_tiga() {
        return kode_tiga;
    }

    /**
     * @param kode_tiga the kode_tiga to set
     */
    public void setKode_tiga(String kode_tiga) {
        this.kode_tiga = kode_tiga;
    }

    /**
     * @return the kode_empat
     */
    public String getKode_empat() {
        return kode_empat;
    }

    /**
     * @param kode_empat the kode_empat to set
     */
    public void setKode_empat(String kode_empat) {
        this.kode_empat = kode_empat;
    }

    /**
     * @return the qty_satu
     */
    public int getQty_satu() {
        return qty_satu;
    }

    /**
     * @param qty_satu the qty_satu to set
     */
    public void setQty_satu(int qty_satu) {
        this.qty_satu = qty_satu;
    }

    /**
     * @return the qty_dua
     */
    public int getQty_dua() {
        return qty_dua;
    }

    /**
     * @param qty_dua the qty_dua to set
     */
    public void setQty_dua(int qty_dua) {
        this.qty_dua = qty_dua;
    }

    /**
     * @return the qty_tiga
     */
    public int getQty_tiga() {
        return qty_tiga;
    }

    /**
     * @param qty_tiga the qty_tiga to set
     */
    public void setQty_tiga(int qty_tiga) {
        this.qty_tiga = qty_tiga;
    }

    /**
     * @return the qty_empat
     */
    public int getQty_empat() {
        return qty_empat;
    }

    /**
     * @param qty_empat the qty_empat to set
     */
    public void setQty_empat(int qty_empat) {
        this.qty_empat = qty_empat;
    }
    
    

}
