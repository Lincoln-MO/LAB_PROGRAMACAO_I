/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico;


/**
 *
 * @author lincoln
 */

import com.mycompany.projetoarquitetonico.forms.frmMain;
import com.mycompany.projetoarquitetonico.Controllers.LoginController;
import com.mycompany.projetoarquitetonico.forms.frmClientRegistration;
import com.mycompany.projetoarquitetonico.Controllers.ClientRegistrationController;
import com.mycompany.projetoarquitetonico.forms.frmEngineer;
import com.mycompany.projetoarquitetonico.Controllers.EngineerController;

public class Main {
    public static void main(String[] args) {
        frmMain mainView = new frmMain();
        LoginController loginController = new LoginController(mainView);
        mainView.setVisible(true);
        
        java.awt.EventQueue.invokeLater(() -> {
            frmClientRegistration dialog = new frmClientRegistration(new javax.swing.JFrame(), true);
            new ClientRegistrationController(dialog); // Inicializa o controlador
            dialog.setVisible(true);
        });
        java.awt.EventQueue.invokeLater(() -> {
            frmEngineer engineerView = new frmEngineer();
            new EngineerController(engineerView);
            engineerView.setVisible(true);
        });
    }
}
