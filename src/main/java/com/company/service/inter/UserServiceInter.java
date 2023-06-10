/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.service.inter;

/**
 *
 * @author FX506ICB
 */

import com.company.entity.Authority;
import com.company.entity.User;

import java.util.List;

public interface UserServiceInter {
    //public List<User>getAll(String name,String surname,Integer nationality_id);
    //public User findByEmailAndPassword(String email,String password);
    public List<User> getAll(String name, String surname, Integer nationalityId);
    public User getById(int id);
    public boolean addUser(User u);
    public boolean updateUser(User u);
    public boolean removeUser(int id);
    public List<Authority> authorities(Integer id);
    public User findByEmail(String email);


}