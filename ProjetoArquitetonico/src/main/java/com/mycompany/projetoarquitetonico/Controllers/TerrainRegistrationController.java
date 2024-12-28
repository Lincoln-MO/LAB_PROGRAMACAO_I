/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.Controllers;

import com.mycompany.projetoarquitetonico.DAO.AccountDAO;
import com.mycompany.projetoarquitetonico.DAO.TerrainDAO;
import com.mycompany.projetoarquitetonico.forms.frmAccountFind;
import com.mycompany.projetoarquitetonico.forms.frmTerrainRegistration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author lincoln
 */
public class TerrainRegistrationController {
    private frmTerrainRegistration view;
    private String terrainName = null;
    private AccountDAO terrainOwner = null;
    private String terrainArea = null;
    private String terrainLocation = null;
        
    
    public TerrainRegistrationController(frmTerrainRegistration view) {
        this.view = view;
    }


    public void submit() {
        TerrainDAO t = new TerrainDAO();
        
        t.setName( terrainName );
        t.setOwner( terrainOwner );
        t.setArea( terrainArea );
        t.setLocation( terrainLocation );
        
        TerrainDAO.save(t);
    }

    
    public void searchOwner(){
        this.terrainOwner = frmAccountFind.getAccount("client");
        view.setOwnerName( terrainOwner.getName() );
    }
    
    
    private void closeForm() {
        // Fechar o formulário sem realizar nenhuma ação
        view.dispose();
    }

    
    /**
     * @return the terrainName
     */
    public String getTerrainName() {
        return terrainName;
    }
    

    /**
     * @param terrainName the terrainName to set
     */
    public void setTerrainName(String terrainName) {
        this.terrainName = terrainName;
    }

    
    /**
     * @return the owner
     */
    public AccountDAO getTerrainOwner() {
        return terrainOwner;
    }

    
    /**
     * @param owner the owner to set
     */
    public void setTerrainOwner(AccountDAO owner) {
        this.terrainOwner = owner;
    }
    

    /**
     * @return the terrainArea
     */
    public String getTerrainArea() {
        return terrainArea;
    }

    
    /**
     * @param terrainArea the terrainArea to set
     */
    public void setTerrainArea(String terrainArea) {
        this.terrainArea = terrainArea;
    }

    
    /**
     * @return the terrainLocation
     */
    public String getTerrainLocation() {
        return terrainLocation;
    }

    
    /**
     * @param terrainLocation the terrainLocation to set
     */
    public void setTerrainLocation(String terrainLocation) {
        this.terrainLocation = terrainLocation;
    }
}
