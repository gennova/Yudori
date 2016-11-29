/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.user;

/**
 *
 * @author legollas
 */
public class User {

    private int IDuser;
    private String Namauser;
    private String Username;
    private String Password;
    private String level;

    public User() {

    }

    public void setIDuser(int IDuser) {
        this.IDuser = IDuser;
    }

    public int getIDUser() {
        return IDuser;
    }

    public int getUser() {
        return IDuser;
    }

    public void setNamauser(String Namauser) {
        this.Namauser = Namauser;
    }

    public String getNamauser() {
        return Namauser;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

}
