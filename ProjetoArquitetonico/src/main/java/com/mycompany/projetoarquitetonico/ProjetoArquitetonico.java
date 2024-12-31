/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico;



/**
 *
 * @author lincoln
 */

import com.mycompany.projetoarquitetonico.forms.*;
import com.mycompany.projetoarquitetonico.Controllers.*;
import com.mycompany.projetoarquitetonico.DAO.Connection;

public class ProjetoArquitetonico {
    public static void main(String[] args) {
        Connection.openConnection();
        
        LoginController.startNewSession();
        
        // main form
        
        /*
        frmLogin mainView = new frmLogin();
        LoginController loginController = new LoginController(mainView);  // Conecta a view ao controlador
        mainView.setVisible(true);
        */
        
        /*
        // 3D view
        frmProject3DView frm = new frmProject3DView(null, false); 
        frm.setVisible(true);
        /*
        
        */
        /*
        //terrain reg. test
        frmTerrainRegistration frm = new frmTerrainRegistration(null, false); 
        frm.setVisible(true);
        */
        
        /*
        //project reg. test
        frmProjectRegistration frm = new frmProjectRegistration(null, false);
        frm.setVisible(true);
        */
        
        /*
        // admin test
        frmAdmin frm = new frmAdmin();
        frm.setVisible(true);
        */
        
        // project regist.
        /*
        frmProjectRegistration frm = new frmProjectRegistration(null, false); 
        frm.setVisible(true);
        */
        
        /*
        frmProjectHistory frm = new frmProjectHistory(null, false); 
        frm.setVisible(true);
        */
        
        /*
        java.awt.EventQueue.invokeLater(() -> {
            frmClientRegistration dialog = new frmClientRegistration(new javax.swing.JFrame(), true);
            new ClientRegistrationController(dialog); // Inicializa o controlador
            dialog.setVisible(true);
        });
        java.awt.EventQueue.invokeLater(() -> {
            frmEngineer engineerView = new frmEngineer();
            new EngineerController(engineerView); // Conecta a view ao controlador
            engineerView.setVisible(true);
        });
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frmAdmin adminView = new frmAdmin();
                new AdminController(adminView); // Conecta a view ao controlador
                adminView.setVisible(true);
            }
        });
        */
    }
}
