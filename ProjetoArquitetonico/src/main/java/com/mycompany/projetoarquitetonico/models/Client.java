/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.models;

/**
 *
 * @author linco
 */

public class Client extends Account{
    public Client(){
        super();
    }
    
    public Client(String name, String cpf, String birthDate, String sex, String password, String accessLevel){
        super(name, cpf, birthDate, sex, password, accessLevel);
    }
}
