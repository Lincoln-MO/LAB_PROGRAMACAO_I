/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.models;

/**
 *
 * @author tainope
 */
public class Engineer extends Account {
    public Engineer(){
        super();
    }
    
    public Engineer(String name, String cpf, String birthDate, String sex, String password, String accessLevel){
        super(name, cpf, birthDate, sex, password, accessLevel);
    }
}
