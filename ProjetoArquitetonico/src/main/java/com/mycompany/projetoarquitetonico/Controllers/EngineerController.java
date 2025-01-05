package com.mycompany.projetoarquitetonico.Controllers;


import com.mycompany.projetoarquitetonico.forms.*;
import javax.swing.JOptionPane;


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


    public void openClientFeedbackForm(){
        frmViewClientFeedback frm = new frmViewClientFeedback(view, true);
        frm.setVisible(true);
    }
    
    public void openProjectHistoryForm() {
        frmProjectHistory historyView = new frmProjectHistory(view, true);
        historyView.setVisible(true);
    }
    

    public void logout() {
        int choice = JOptionPane.showConfirmDialog(view, "Tem certeza que deseja sair?", "Sair", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            view.dispose();
            LoginController.startNewSession();
        }
    }
}
