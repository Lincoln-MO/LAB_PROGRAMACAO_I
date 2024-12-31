package com.mycompany.projetoarquitetonico.Controllers;


import com.mycompany.projetoarquitetonico.DAO.AccountDAO;
import com.mycompany.projetoarquitetonico.DAO.TerrainDAO;
import com.mycompany.projetoarquitetonico.forms.frmAccountFind;
import com.mycompany.projetoarquitetonico.forms.frmTerrainRegistration;


/**
 *
 * @author lincoln
 */
public class TerrainRegistrationController {
    private final frmTerrainRegistration view;
    private String terrainName = null;
    private AccountDAO terrainOwner = null;
    private String terrainArea = null;
    private String terrainLocation = null;
    
    
    public TerrainRegistrationController(frmTerrainRegistration view) {
        this.view = view;
    }


    public void handleSubmit() {
        terrainName = view.getTerrainNameText();
        terrainArea = view.getTerrainAreaText();
        terrainLocation = view.getTerrainLocationText();
        
        TerrainDAO t = new TerrainDAO();
        t.setName( terrainName );
        t.setOwner( terrainOwner );
        t.setArea( terrainArea );
        t.setLocation( terrainLocation );
        TerrainDAO.save(t);
    }

    
    public void handleSearchOwner(){
        this.terrainOwner = frmAccountFind.getAccount("client");
        view.setOwnerName( terrainOwner.getName() );
    }
}
