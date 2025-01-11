package com.mycompany.projetoarquitetonico.models.DAO;


/**
 *
 * @author yurit
 */
public class HostNotFoundException extends Exception{
    public HostNotFoundException(){}
    
    
    public HostNotFoundException(String message){
        super(message);
    }
}
