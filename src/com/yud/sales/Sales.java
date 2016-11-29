/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.sales;

/**
 *
 * @author legollas
 */
public class Sales {

    private int idSales;
    private String namaSales;
    private String alamatSales;
    private String telepon;

    public Sales() {
    }

    public void setidSales(int idSales) {
        this.idSales = idSales;
    }

    public int getidSales() {
        return idSales;
    }

    public void setnamaSales(String namaSales) {
        this.namaSales = namaSales;
    }

    public String getnamaSales() {
        return namaSales;
    }

    public void setalamatSales(String alamatSales) {
        this.alamatSales = alamatSales;
    }

    public String getAlamatSales() {
        return alamatSales;
    }

    public void settelepon(String telp) {
        this.telepon = telp;
    }

    public String gettelepon() {
        return telepon;
    }
}
