/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.ui;

/**
 *
 * @author legollas
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double pokok = 2500000;
        double kesehatan = 150000;
        double transport = 200000;
        double hari =30;
        double total = (pokok+kesehatan+transport)+(hari*5000);
        double pajak = 0.01 *total;
        double totalbersih = total -pajak;
        System.out.println(totalbersih);
    }    
}
