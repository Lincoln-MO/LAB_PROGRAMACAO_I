/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.models;

import com.mycompany.projetoarquitetonico.DAO.AdminAccountDAO;
import com.sun.jdi.connect.spi.Connection;
import javax.persistence.Entity;

/**
 *
 * @author tainope
 */

public class AdminAccount extends Account{
    public AdminAccount(){
        super();
    }
    
    public AdminAccount(String name, String cpf, String birthDate, String sex, String password){
        super(name, cpf, birthDate, sex, password);
    }
    public static void save(AdminAccount account){
        AdminAccountDAO.save(account);
    }
}
