/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.DAO;

import com.mycompany.projetoarquitetonico.models.ClientAccount;
import com.mycompany.projetoarquitetonico.models.Terrain;
import javax.persistence.*;

/**
 *
 * @author yurit
 */
@Entity(name = "terrain")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TerrainDAO extends GenericDAO{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ClientAccountDAO owner;
    private String name;
    private String area;
    private String location;

    public TerrainDAO(){
    }
    
    public TerrainDAO(Terrain terrain){
        this.name = terrain.getName();
        this.area = terrain.getArea();
        this.location = terrain.getLocation();
        this.owner = terrain.getOwner();
    }
    
    public static TerrainDAO findById(int id){
        return Connection.getEntityManager().find(TerrainDAO.class, id);
    }
    
    
    public static void save(TerrainDAO terrain){
        Connection.openConnection();
        Connection.beginTransaction();
        
        // makes the terrain.owner persistent 
        terrain.owner = Connection.getEntityManager().find(ClientAccountDAO.class, terrain.owner.getID());
        
        Connection.persist(terrain);
        Connection.commitTransaction();
        Connection.closeConnection();
        System.out.println("Persist");
    }

    @Override
    public Object load(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
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
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }
}
