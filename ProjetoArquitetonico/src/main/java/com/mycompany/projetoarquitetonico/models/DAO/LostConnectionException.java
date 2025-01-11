package com.mycompany.projetoarquitetonico.models.DAO;


/**
 *
 * @author yurit
 */
public class LostConnectionException extends Exception{
    public LostConnectionException(){}
    

    public LostConnectionException(String message){
        super(message);
    }
}
