/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.tools;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




/**
 *
 * @author legollas
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException{
        // TODO code application logic heresout 
        //System.out.println(DaoFactory.getIDUrutPesanan());
        //new PrintReport("./report/BPesanan.jasper","kodeBPParams","BP0204160003");       
        /*
            String data[] = new String[4];
            data[0]="tendy";
            data[1]="novitha";
            data[2]="ami";
            data[3]="winda";
            JSONArray array = new JSONArray();
            array.add(data);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("namasiswa", array);
            FileWriter fileWriter = new FileWriter("datasiswa.json");
            fileWriter.write(jSONObject.toString());
            fileWriter.flush();
            fileWriter.close(); 
        
*/
        //KoneksiKu kk = new KoneksiKu();
        Koneksi kk = new Koneksi();
        kk.bukaKoneksi();
        Connection c = kk.getKoneksi();
        System.out.println(c.getCatalog());
        PreparedStatement ps = c.prepareStatement("select * from loginlist");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            System.out.println(rs.getString("pass"));
        }
    }
}
