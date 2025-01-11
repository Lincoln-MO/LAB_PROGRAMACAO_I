package com.mycompany.projetoarquitetonico.models.DAO;


/**
 *
 * @author yurit
 */
public class ConnectionException extends Exception{
    public ConnectionException(){}
    
    
    public ConnectionException(String message){
        super(message);
    }
}
