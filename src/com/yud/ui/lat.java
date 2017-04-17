/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.ui;

import com.init.tools.Date2Digits;
import com.init.tools.PrintReport;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Properties;
import javax.annotation.Resource;
import sun.util.BuddhistCalendar;

/**
 *
 * @author legollas
 */
public class lat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new PrintReport("./report/bkmb.jasper", "kodefaktur", "KM0504160002");
    }

}
