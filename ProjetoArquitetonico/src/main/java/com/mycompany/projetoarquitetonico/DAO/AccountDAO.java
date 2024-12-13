package com.mycompany.projetoarquitetonico.DAO;

import javax.persistence.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yurit
 */
@Entity(name = "generic_account")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AccountDAO extends GenericDAO{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;
    protected String login;
    protected String password;
    
    
    public AccountDAO(){
        this.login = "";
        this.password = "";
    }
    
    // GenericDAO interface implementation
    
    @Override
    public void save(){
        System.out.println("Saving Account...");
        Connection.beginTransaction();
        Connection.persist(this);
        Connection.commitTransaction();
    }

    
    public AccountDAO load(Object obj){
        System.out.println("Loading account...");
        return null;
    }
    
    public void update(Object obj){}
    
    public void delete(Object obj){}
    
    public Object findAll(){
        System.out.println("Finding all accounts...");
        return null;
    }
    
    
    public void find(String login, String password, String accessLevel){
        System.out.println("Finding account. Login: " + login + "; Passw: " + password
        + "Access lvl: " + accessLevel);
    }
    
    public void setLogin(String login){
        this.login = login;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
}
