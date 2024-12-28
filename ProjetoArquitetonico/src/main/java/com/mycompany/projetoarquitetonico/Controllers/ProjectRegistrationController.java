/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.Controllers;

import com.mycompany.projetoarquitetonico.DAO.AccountDAO;
import com.mycompany.projetoarquitetonico.DAO.ProjectDAO;
import com.mycompany.projetoarquitetonico.DAO.TerrainDAO;
import com.mycompany.projetoarquitetonico.forms.frmProjectRegistration;

/**
 *
 * @author lincoln
 */
public class ProjectRegistrationController {
    private String projectName = null;
    private String startDate = null;
    private AccountDAO responsible = null;
    private TerrainDAO terrain = null;
    private String expenseTableString = null;
    
    private frmProjectRegistration view;

    public ProjectRegistrationController(frmProjectRegistration view) {
        this.view = view;
    }

    
    public void submit(){
        if ( responsible == null ){
            System.out.println("Responsible ID not found");
            return;
        }
        
        if ( !responsible.isEngineer() ){
            System.out.println("Rsponsible is not engineer");
            return;
        }
        
        ProjectDAO p = new ProjectDAO();
        p.setName(projectName);
        p.setStartDate(startDate);
        p.setResponsible(responsible);
        p.setTerrain(terrain);  
        p.setExpenseTableString(expenseTableString);
        ProjectDAO.save(p);
    }
    

    /**
     * @return the projectName
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectName the projectName to set
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
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

    /**
     * @param expenseTable the expenseTable to set
     */
    public void setExpenseTableString(String tableString) {
        this.expenseTableString = tableString;
    }
}
