package com.mycompany.projetoarquitetonico.models.DAO;


import javax.persistence.*;


/**
 *
 * @author yurit
 */
public class Connection {
    private static int x;
    private static EntityManagerFactory factory;
    private static EntityManager manager;
    
    
    public static void openConnection() throws ConnectionException{
        try{
            factory = Persistence.createEntityManagerFactory("trabalho_final_lps");
            createManager();
        }catch(Exception e){
            throw new ConnectionException("Could not open connection.");
        }
        
    }
    
    
    private static void createManager() throws ConnectionException{
        try{
            manager = factory.createEntityManager();
        }catch (Exception e){
            throw new ConnectionException("Could not create entity manager.");
        }
    }
    
    
    public static void closeConnection() throws ConnectionException{
        try{
            factory.close();
        }catch (Exception e){
            throw new ConnectionException("Could not close connection.");
        }
    }
    
    
    public static void beginTransaction() throws ConnectionException{
        try{
            createManager();
            manager.getTransaction().begin();
        }catch (Exception e){
            throw new ConnectionException();
        }
    }
    
    
    public static void persist(Object obj) throws ConnectionException{
        try{
            manager.persist(obj);
        }catch (Exception e){
            throw new ConnectionException("Could not persist object");
        }
    }
    
    
    public static void merge(Object obj) throws ConnectionException{
        try{
            manager.merge(obj);
        }catch (Exception e){
            throw new ConnectionException("Could not merge object");
        }
    }
    
    
    public static void commitTransaction() throws ConnectionException{
        try{
            manager.getTransaction().commit();
            manager.close();
        }catch (Exception e){
            throw new ConnectionException("Could not commit transaction");
        }
    }
    
    
    public static EntityManager getEntityManager()throws ConnectionException{
        return manager;
    }
}
