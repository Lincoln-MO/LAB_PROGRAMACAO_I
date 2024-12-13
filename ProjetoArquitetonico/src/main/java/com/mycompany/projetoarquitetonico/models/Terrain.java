/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.models;

/**
 *
 * @author tainope
 */
public class Terrain {
    protected String name;
    protected String owner_id; // change with hibernate
    protected float area;
    protected String address;
    
    
    public Terrain(){
        this.name = "";
        //this.owner_id = "";
        this.area = 0.0f;
        this.address = "";
    }
    
    public Terrain(String name, Float area, String address){
        this.name = name;
        this.area = area;
        this.address = address;
    }
}
