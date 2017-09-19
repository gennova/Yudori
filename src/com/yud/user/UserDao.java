/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.user;

import java.util.List;

/**
 *
 * @author legollas
 */
public interface UserDao {

    public List<User> getALlUser();

    public void insertUser(User user);

    public void updateUser(User user);

    public void deleteUser(User user);
    
    public String getPassword(int userid);
}
