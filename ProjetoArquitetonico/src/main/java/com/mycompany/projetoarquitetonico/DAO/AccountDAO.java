package com.mycompany.projetoarquitetonico.DAO;

import com.mycompany.projetoarquitetonico.models.Account;
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
    protected String name;
    protected String cpf;
    protected String password = "";
    protected String birthDate;
    protected String sex;
    
    
    public AccountDAO(){
        this.name = "";
        this.cpf = "";
        this.birthDate = "";
        this.sex = "";
        this.password = "";
    }
    
    public AccountDAO(Account account){
        this.name = account.getName();
        this.cpf = account.getCpf();
        this.birthDate = account.getBirthDate();
        this.sex = account.getSex();
        this.password = account.getPassword();
    }
    
    // GenericDAO interface implementation

    
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
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public void save() {
        
    }
    
    public int getID(){
        return this.id;
    }
}
