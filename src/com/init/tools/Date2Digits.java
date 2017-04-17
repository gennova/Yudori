/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.tools;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author legollas
 */
public class Date2Digits {

    private Calendar d;

    public Date2Digits(Calendar date) {
        date = d;
    }

    public String get2digitsdate() {
        Format formatter = new SimpleDateFormat("ddMMyy");
        String string = formatter.format(d);
        return string;
    }
}
