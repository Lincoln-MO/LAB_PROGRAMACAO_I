package com.mycompany.projetoarquitetonico.Controllers;


import com.mycompany.projetoarquitetonico.models.DAO.TerrainDAO;
import com.mycompany.projetoarquitetonico.forms.frmAccountFind;
import com.mycompany.projetoarquitetonico.forms.frmTerrainRegistration;
import com.mycompany.projetoarquitetonico.models.DAO.ConnectionException;
import com.mycompany.projetoarquitetonico.models.entities.Account;
import com.mycompany.projetoarquitetonico.models.entities.Terrain;
import com.mycompany.projetoarquitetonico.utils.SendEmail;
import com.mycompany.projetoarquitetonico.utils.Validation;
import javax.swing.JOptionPane;


public class TerrainRegistrationController {
    private final frmTerrainRegistration view;
    private String terrainName = null;
    private Account terrainOwner = null;
    private String terrainArea = null;
    private String terrainLocation = null;
    
    
    public TerrainRegistrationController(frmTerrainRegistration view) {
        this.view = view;
    }


    public void handleSubmit(){
        
        try{
            terrainName = view.getTerrainNameText();
            terrainArea = view.getTerrainAreaText();
            terrainLocation = view.getTerrainLocationText();

            view.hideErrorMessage();

            // Form validation start
            if( !Validation.isNameValid(terrainName) ){
                view.showError("Nome de terreno inválido", "terrain");
                return;
            }

            if( !Validation.isFloat(terrainArea) ){
                view.showError("Área do terreno inválida", "area");
                return;
            }

            if( !Validation.isAddressValid(terrainLocation) ){
                view.showError("Localização do terreno inválido", "location");
                return;
            }
            // Form validation end

            Terrain t = new Terrain();
            t.setName( terrainName );
            t.setOwner( terrainOwner );
            t.setArea( terrainArea );
            t.setLocation( terrainLocation );
            TerrainDAO.save(t);

            view.clearForm();

            if(
                    SendEmail.SendMessage(
                    "Terreno cadastrado", 
                    "Um novo terreno foi cadastrado em seu nome",
                    terrainOwner.getEmail())){
                JOptionPane.showMessageDialog(view, "Terreno cadastrado. Cliente notificado por email.");
            }else{
                JOptionPane.showMessageDialog(view, "Terreno cadastrado. Não foi possível notificar o cliente por email.");
            }
        }catch (ConnectionException e){
            JOptionPane.showMessageDialog(view, "Ocorreu um erro.");
        }
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
