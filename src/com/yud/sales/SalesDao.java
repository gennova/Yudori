/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.sales;

import java.util.List;

/**
 *
 * @author legollas
 */
public interface SalesDao {

    public List<Sales> getAllSales();
    
    public Sales getSalesByID(int id);
    
    public Sales getSalesByName(String name);
    
    public void insertSales(Sales sales);
    
    public void updateSales(Sales sales);
    
    public void deleteSales(Sales sales);
}
