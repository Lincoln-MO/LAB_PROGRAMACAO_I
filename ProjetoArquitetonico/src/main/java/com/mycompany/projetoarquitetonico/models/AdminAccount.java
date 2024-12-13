/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.models;

import com.sun.jdi.connect.spi.Connection;

/**
 *
 * @author tainope
 */
public class AdminAccount extends Account{
    public AdminAccount(){
        super();
    }
    
    public AdminAccount(String name, String cpf, String birthDate, String sex, String password, String accessLevel){
        super(name, cpf, birthDate, sex, password, accessLevel);
    }
    
    public void save(){
        
    }
}
