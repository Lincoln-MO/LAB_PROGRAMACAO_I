/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.DAO;

import javax.persistence.*;


/**
 *
 * @author yurit
 */

@Entity(name = "admin_account")
public class AdminAccountDAO extends AccountDAO{
    protected String testValue;
    
    
    
    public AdminAccountDAO(){
        
    }
    
    
    public boolean find(){
        String sql = "SELECT login FROM admin_account WHERE login = :login AND password = :password";
        Query query = entityManager.createQuery(sql);
                
    }
}
