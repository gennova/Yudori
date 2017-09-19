/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.stb;

import java.util.List;

/**
 *
 * @author legollas
 */
public interface OrderTempDao {

    public List<OrderTemp> getAllOrderTemo();

    public void insertordertemp(OrderTemp ordertemp);
    
    public void insertDetailToTemp(String kodebp);

    public void updateordertemp(OrderTemp ordertemp);

    public void deleteordertemp(OrderTemp ordertemp);

    public void truncateordertemp();

    public int getSumOrder(String kodepesanan);
}
