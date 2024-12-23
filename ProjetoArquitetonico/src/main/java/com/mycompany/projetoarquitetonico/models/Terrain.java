/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.models;

import com.mycompany.projetoarquitetonico.DAO.ClientAccountDAO;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 *
 * @author tainope
 */
public class Terrain {
    private ClientAccountDAO owner;
    private String name;
    private String area;
    private String location;
    
    
    public Terrain(){
        this.name = "";
        this.owner = null;
        this.area = "";
        this.location = "";
    }
    
    public Terrain(String name, String area, String address){
        this.name = name;
        this.area = area;
        this.location = address;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the owner
     */
    public ClientAccountDAO getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(ClientAccountDAO owner) {
        this.owner = owner;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the address
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param address the address to set
     */
    public void setLocation(String address) {
        this.location = address;
    }
}
