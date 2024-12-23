/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.DAO;

import com.mycompany.projetoarquitetonico.models.Account;
import com.mycompany.projetoarquitetonico.models.AdminAccount;
import java.util.List;

import javax.persistence.*;


/**
 *
 * @author yurit
 */

@Entity(name = "admin_account")
public class AdminAccountDAO extends AccountDAO{
    public AdminAccountDAO(){
        
    }
    
    
    public AdminAccountDAO(Account account){
        this.cpf = account.getCpf();
        this.password = account.getPassword();
    }
    
    
    public AdminAccount toAdminAccount(){
        AdminAccount acc = new AdminAccount();
        acc.setName(this.name);
        acc.setCpf(this.cpf);
        acc.setPassword(this.password);
        acc.setBirthDate(this.birthDate);
        acc.setSex(this.sex);
        
        return acc;
    }
    
    
    public static void save(AdminAccount account){
        Connection.openConnection();
        Connection.beginTransaction();
        Connection.persist(new AdminAccountDAO(account));
        Connection.commitTransaction();
        Connection.closeConnection();
        System.out.println("Persist");
    }
    
    
    public static AdminAccount find(String login, String password){       
        String sql = "SELECT account FROM admin_account account WHERE cpf = :cpf AND password = :password";
        Query query = Connection.getEntityManager().createQuery(sql);
        query.setParameter("cpf", login);
        query.setParameter("password", password);
        
        List<AdminAccountDAO> result = query.getResultList();;

        if( !result.isEmpty() ){
            return result.get(0).toAdminAccount();
        }else{
            return null;
        }
    }
}
