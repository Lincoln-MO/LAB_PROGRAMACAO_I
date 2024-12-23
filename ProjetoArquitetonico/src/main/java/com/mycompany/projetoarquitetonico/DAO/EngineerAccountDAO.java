/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.DAO;

import com.mycompany.projetoarquitetonico.models.Account;
import com.mycompany.projetoarquitetonico.models.AdminAccount;
import com.mycompany.projetoarquitetonico.models.EngineerAccount;
import java.util.List;

import javax.persistence.*;


/**
 *
 * @author yurit
 */

@Entity(name = "engineer_account")
public class EngineerAccountDAO extends AccountDAO{
    public EngineerAccountDAO(){
        
    }
    
    
    public EngineerAccountDAO(Account account){
        this.cpf = account.getCpf();
        this.password = account.getPassword();
    }
    
    
    public EngineerAccount toEngineerAccount(){
        EngineerAccount acc = new EngineerAccount();
        acc.setName(this.name);
        acc.setCpf(this.cpf);
        acc.setPassword(this.password);
        acc.setBirthDate(this.birthDate);
        acc.setSex(this.sex);
        
        return acc;
    }
    
    public static EngineerAccountDAO findById(int id){
        return Connection.getEntityManager().find(EngineerAccountDAO.class, id);
    }
    
    
    public static void save(AdminAccount account){
        Connection.openConnection();
        Connection.beginTransaction();
        Connection.persist(new AdminAccountDAO(account));
        Connection.commitTransaction();
        Connection.closeConnection();
        System.out.println("Persist");
    }
    
    
    public static EngineerAccount find(String login, String password){       
        String sql = "SELECT account FROM engineer_account account WHERE cpf = :cpf AND password = :password";
        Query query = Connection.getEntityManager().createQuery(sql);
        query.setParameter("cpf", login);
        query.setParameter("password", password);
        
        List<EngineerAccountDAO> result = query.getResultList();

        if( !result.isEmpty() ){
            return result.get(0).toEngineerAccount();
        }else{
            return null;
        }
    }
}
