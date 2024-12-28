/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Query;


/**
 *
 * @author yurit
 */
@Entity(name = "project")
public class ProjectDAO extends GenericDAO{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String startDate;
    @ManyToOne
    private AccountDAO responsible;
    @OneToOne
    private TerrainDAO terrain;
    private String expenseTableString;

    
    public static void save(ProjectDAO proj){
        Connection.openConnection();
        Connection.beginTransaction();
        
        // makes the project.terrain persistent 
        proj.setTerrain(Connection.getEntityManager().find(TerrainDAO.class, proj.getTerrain().getId()));
        
        Connection.persist(proj);
        Connection.commitTransaction();
        Connection.closeConnection();
        System.out.println("Persist");
    }
    
    
    public static List<ProjectDAO> findAllByTerrain(TerrainDAO terrain){
        String sql = "SELECT project FROM project project WHERE "+
            "(terrain_id = :id)";

        Query query = Connection.getEntityManager().createQuery(sql);
        query.setParameter("id", terrain.getID());
        
        return query.getResultList();
    }
    
    
    public static List<ProjectDAO> findAllByUser(AccountDAO account){
        List<ProjectDAO> result = new ArrayList<ProjectDAO>();
        
        // not good
        for( TerrainDAO t : account.getTerains()){
            for( ProjectDAO p : ProjectDAO.findAllByTerrain(t) ){
                result.add( p );
            }
        }
        
        return result;
    }
    
    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
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
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the responsible
     */
    public AccountDAO getResponsible() {
        return responsible;
    }

    /**
     * @param responsible the responsible to set
     */
    public void setResponsible(AccountDAO responsible) {
        this.responsible = responsible;
    }

    /**
     * @return the terrain
     */
    public TerrainDAO getTerrain() {
        return terrain;
    }

    /**
     * @param terrain the terrain to set
     */
    public void setTerrain(TerrainDAO terrain) {
        this.terrain = terrain;
    }

    /**
     * @return the expenseTable
     */
    public String getExpenseTableString() {
        return expenseTableString;
    }


    public void setExpenseTableString(String tableString) {
        this.expenseTableString = tableString;
    }
}