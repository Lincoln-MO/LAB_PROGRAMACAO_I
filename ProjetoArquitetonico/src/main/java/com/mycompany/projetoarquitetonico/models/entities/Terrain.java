package com.mycompany.projetoarquitetonico.models.entities;


/**
 *
 * @author tainope
 */
public class Terrain {
    private int id;
    private Account owner;
    private String name;
    private String area;
    private String location;
    
    
    public Terrain(){
        this.id = -1;
        this.name = "";
        this.owner = null;
        this.area = "";
        this.location = "";
    }

    
    public int getId() {
        return id;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    
    public Account getOwner() {
        return owner;
    }

    
    public void setOwner(Account owner) {
        this.owner = owner;
    }

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }
    

    public String getArea() {
        return area;
    }

    
    public void setArea(String area) {
        this.area = area;
    }

    
    public String getLocation() {
        return location;
    }

    
    public void setLocation(String location) {
        this.location = location;
    }
}
