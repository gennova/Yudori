/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.komisi;

import com.yud.sales.Sales;
import com.yud.stb.BuktiPesanan;

/**
 *
 * @author legollas
 */
public class Komisi {

    private int id;
    private BuktiPesanan bp;
    private Sales sales;
    private double komisibp;
    private double komisia1;
    private double komisilunas;
    private double komdisitunai;
    private double rpkomisibp;
    private double rpkomisia1;
    private double rpkomisilunas;
    private double rpkomisitunai;
    private String statuskomisibp;
    private String statuskomisia1;
    private String statuskomisilunas;
    private String statuskomisitunasi;
    private String statuskomisi;
    private double totalkomisi;
    private double totaljual;
    private double totalkomisirekap;

    public Komisi() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BuktiPesanan getBp() {
        return bp;
    }

    public void setBp(BuktiPesanan bp) {
        this.bp = bp;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    public double getKomisibp() {
        return komisibp;
    }

    public void setKomisibp(double komisibp) {
        this.komisibp = komisibp;
    }

    public double getKomisia1() {
        return komisia1;
    }

    public void setKomisia1(double komisia1) {
        this.komisia1 = komisia1;
    }

    public double getKomisilunas() {
        return komisilunas;
    }

    public void setKomisilunas(double komisilunas) {
        this.komisilunas = komisilunas;
    }

    public double getKomdisitunai() {
        return komdisitunai;
    }

    public void setKomdisitunai(double komdisitunai) {
        this.komdisitunai = komdisitunai;
    }

    public double getRpkomisibp() {
        return rpkomisibp;
    }

    public void setRpkomisibp(double rpkomisibp) {
        this.rpkomisibp = rpkomisibp;
    }

    public double getRpkomisia1() {
        return rpkomisia1;
    }

    public void setRpkomisia1(double rpkomisia1) {
        this.rpkomisia1 = rpkomisia1;
    }

    public double getRpkomisilunas() {
        return rpkomisilunas;
    }

    public void setRpkomisilunas(double rpkomisilunas) {
        this.rpkomisilunas = rpkomisilunas;
    }

    public double getRpkomisitunai() {
        return rpkomisitunai;
    }

    public void setRpkomisitunai(double rpkomisitunai) {
        this.rpkomisitunai = rpkomisitunai;
    }

    public String getStatuskomisibp() {
        return statuskomisibp;
    }

    public void setStatuskomisibp(String statuskomisibp) {
        this.statuskomisibp = statuskomisibp;
    }

    public String getStatuskomisia1() {
        return statuskomisia1;
    }

    public void setStatuskomisia1(String statuskomisia1) {
        this.statuskomisia1 = statuskomisia1;
    }

    public String getStatuskomisilunas() {
        return statuskomisilunas;
    }

    public void setStatuskomisilunas(String statuskomisilunas) {
        this.statuskomisilunas = statuskomisilunas;
    }

    public String getStatuskomisitunasi() {
        return statuskomisitunasi;
    }

    public void setStatuskomisitunasi(String statuskomisitunasi) {
        this.statuskomisitunasi = statuskomisitunasi;
    }

    public String getStatuskomisi() {
        return statuskomisi;
    }

    public void setStatuskomisi(String statuskomisi) {
        this.statuskomisi = statuskomisi;
    }

    public double getTotalkomisi() {
        return totalkomisi;
    }

    public void setTotalkomisi(double totalkomisi) {
        this.totalkomisi = totalkomisi;
    }

    public double getTotaljual() {
        return totaljual;
    }

    public void setTotaljual(double totaljual) {
        this.totaljual = totaljual;
    }

    public double getTotalkomisirekap() {
        return totalkomisirekap;
    }

    public void setTotalkomisirekap(double totalkomisirekap) {
        this.totalkomisirekap = totalkomisirekap;
    }

}
