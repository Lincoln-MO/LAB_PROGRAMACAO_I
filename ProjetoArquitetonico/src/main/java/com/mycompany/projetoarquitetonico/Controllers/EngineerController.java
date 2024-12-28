/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.Controllers;

import com.mycompany.projetoarquitetonico.forms.*;


/**
 *
 * @author lincoln
 */


public class EngineerController {
    private final frmEngineer view;

    
    public EngineerController(frmEngineer view) {
        this.view = view;
    }

    
    public void openProjectRegistrationForm() {
        frmProjectRegistration projectView = new frmProjectRegistration(view, true);
        projectView.setVisible(true);
    }

    
    public void openClientRegistrationForm() {
        frmClientRegistration clientView = new frmClientRegistration(view, true);
        clientView.setVisible(true);
    }

    
    public void openTerrainRegistrationForm() {
        frmTerrainRegistration terrainView = new frmTerrainRegistration(view, true);
        terrainView.setVisible(true);
    }

    
    public void open3DViewForm() {
        frmProject3DView view3D = new frmProject3DView(view, true);
        view3D.setVisible(true);
    }

    
    public void openProjectHistoryForm() {
        frmProjectHistory historyView = new frmProjectHistory(view, true);
        historyView.setVisible(true);
    }
    

    public void logout() {
        // Fecha a tela atual e volta para a tela de login (se existir)
        view.dispose();
        // Aqui podemos abrir a tela de login, se necessário:
        frmLogin loginView = new frmLogin();
        loginView.setVisible(true);
    }
}
