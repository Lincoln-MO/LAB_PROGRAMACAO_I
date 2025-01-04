package com.mycompany.projetoarquitetonico.Controllers;


import com.mycompany.projetoarquitetonico.DAO.AccountDAO;
import com.mycompany.projetoarquitetonico.DAO.TerrainDAO;
import com.mycompany.projetoarquitetonico.forms.frmAccountFind;
import com.mycompany.projetoarquitetonico.forms.frmTerrainRegistration;
import com.mycompany.projetoarquitetonico.utils.Validation;
import javax.swing.JOptionPane;


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
        
        view.hideErrorMessage();
        
        // Form validation start
        if( !Validation.isNameValid(terrainName) ){
            view.showError("Nome de terreno inválido", "terrain");
        }
        
        if( !Validation.isFloat(terrainArea) ){
            view.showError("Área do terreno inválida", "area");
        }
        
        if( !Validation.isAddressValid(terrainLocation) ){
            view.showError("Localização do terreno inválido", "location");
        }
        // Form validation end
        
        TerrainDAO t = new TerrainDAO();
        t.setName( terrainName );
        t.setOwner( terrainOwner );
        t.setArea( terrainArea );
        t.setLocation( terrainLocation );
        TerrainDAO.save(t);
        
        JOptionPane.showMessageDialog(view, "Terreno cadastrado.");
    }

    
    public void handleSearchOwner(){
        this.terrainOwner = frmAccountFind.getAccount("client");
        if(this.terrainOwner != null){
            view.setOwnerName( terrainOwner.getCpf());
        }else{
            view.setOwnerName("");
        }
    }
}
