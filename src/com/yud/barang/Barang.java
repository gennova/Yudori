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

}
