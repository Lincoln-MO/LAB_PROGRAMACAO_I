/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.DAO;

import com.mycompany.projetoarquitetonico.models.Account;
import com.mycompany.projetoarquitetonico.models.AdminAccount;
import com.mycompany.projetoarquitetonico.models.ClientAccount;
import com.mycompany.projetoarquitetonico.models.EngineerAccount;
import com.mycompany.projetoarquitetonico.models.Terrain;
import java.util.List;

import javax.persistence.*;


/**
 *
 * @author yurit
 */

@Entity(name = "client_account")
public class ClientAccountDAO extends AccountDAO{
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TerrainDAO> terrains;
    
    public ClientAccountDAO(){
        
    }
    
    
    public ClientAccountDAO(Account account){
        this.name = account.getName();
        this.cpf = account.getCpf();
        this.birthDate = account.getBirthDate();
        this.password = account.getPassword();
        this.sex = account.getSex();
    }
    
    
    public ClientAccount toClientAccount(){
        ClientAccount acc = new ClientAccount();
        acc.setName(this.name);
        acc.setCpf(this.cpf);
        acc.setPassword(this.password);
        acc.setBirthDate(this.birthDate);
        acc.setSex(this.sex);
        
        return acc;
    }
    
    
    public static void save(ClientAccount account){
        Connection.openConnection();
        Connection.beginTransaction();
        Connection.persist(new ClientAccountDAO(account));
        Connection.commitTransaction();
        Connection.closeConnection();
        System.out.println("Persist");
    }
    
    
    public static ClientAccount find(String login, String password){       
        String sql = "SELECT account FROM client_account account WHERE cpf = :cpf AND password = :password";
        Query query = Connection.getEntityManager().createQuery(sql);
        query.setParameter("cpf", login);
        query.setParameter("password", password);
        
        List<ClientAccountDAO> result = query.getResultList();

        if( !result.isEmpty() ){
            return result.get(0).toClientAccount();
        }else{
            return null;
        }
    }
    
    
    public static ClientAccountDAO findByCPF(String cpf){
        String sql = "SELECT account FROM client_account account WHERE cpf = :cpf";
        Query query = Connection.getEntityManager().createQuery(sql);
        query.setParameter("cpf", cpf);
        
        List<ClientAccountDAO> result = query.getResultList();

        if( !result.isEmpty() ){
            return result.get(0);
        }else{
            return null;
        }
    }
}
