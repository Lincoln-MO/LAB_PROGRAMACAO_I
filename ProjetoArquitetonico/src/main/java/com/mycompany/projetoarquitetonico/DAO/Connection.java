package com.mycompany.projetoarquitetonico.DAO;


import javax.persistence.*;


/**
 *
 * @author yurit
 */
public class Connection {
    private static int x;
    private static EntityManagerFactory factory;
    private static EntityManager manager;
    
    
    public static void openConnection(){
        factory = Persistence.createEntityManagerFactory("trabalho_final_lps");
        createManager();
    }
    
    
    private static void createManager(){
        manager = factory.createEntityManager();
    }
    
    
    public static void closeConnection(){
        factory.close();
    }
    
    
    public static void beginTransaction(){
        System.out.println("begin");
        createManager();
        manager.getTransaction().begin();
    }
    
    
    public static void persist(Object obj){
        System.out.println("persist");
        manager.persist(obj);
    }
    
    
    public static void merge(Object obj){
        System.out.println("merge");
        manager.merge(obj);
    }
    
    
    public static void commitTransaction(){
        System.out.println("commit");
        manager.getTransaction().commit();
        manager.close();
    }
    
    
    public static EntityManager getEntityManager(){
        return manager;
    }
}
