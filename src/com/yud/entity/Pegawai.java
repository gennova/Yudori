/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.entity;

/**
 *
 * @author legollas
 */
public class Pegawai {
    private int kodepegawai;
    private String namapegawai;
    private String alamatpegawai;
    private String jk;
    private String username;
    private String password;

    public Pegawai() {
    }

    public int getKodepegawai() {
        return kodepegawai;
    }

    public void setKodepegawai(int kodepegawai) {
        this.kodepegawai = kodepegawai;
    }

    public String getNamapegawai() {
        return namapegawai;
    }

    public void setNamapegawai(String namapegawai) {
        this.namapegawai = namapegawai;
    }

    public String getAlamatpegawai() {
        return alamatpegawai;
    }

    public void setAlamatpegawai(String alamatpegawai) {
        this.alamatpegawai = alamatpegawai;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
