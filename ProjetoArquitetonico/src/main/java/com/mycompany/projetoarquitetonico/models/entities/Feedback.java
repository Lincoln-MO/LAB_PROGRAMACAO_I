package com.mycompany.projetoarquitetonico.models.entities;


/**
 *
 * @author tainope
 */
public class Feedback {
    private int id;
    private String message;
    private Account author;
    private boolean isActive;
            
    
    public Feedback(){
        this.id = -1;
        this.message = "";
        this.author = null;
        this.isActive = true;
    }
    

    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    
    public String getMessage() {
        return message;
    }
    

    public void setMessage(String message) {
        this.message = message;
    }

    
    public Account getAuthor() {
        return author;
    }

    
    public void setAuthor(Account author) {
        this.author = author;
    }
    
    
    public boolean isActive(){
        return this.isActive;
    }
    
    
    public void setActive(boolean state){
        this.isActive = state;
    }
}
