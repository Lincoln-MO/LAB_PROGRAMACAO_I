package com.mycompany.projetoarquitetonico.Controllers;


import com.mycompany.projetoarquitetonico.forms.frmClient;
import com.mycompany.projetoarquitetonico.forms.frmClientFeedback;
import com.mycompany.projetoarquitetonico.forms.frmProjectHistory;
import javax.swing.JOptionPane;


public class ClientController {
    private final frmClient view;

    
    public ClientController(frmClient view) {
        this.view = view;
    }


    public void openFeedbackForm() {
        frmClientFeedback feedbackForm = new frmClientFeedback(view, true);
        feedbackForm.setVisible(true);
    }

    
    
    public void openProjectHistoryForm(){
        frmProjectHistory frm = new frmProjectHistory(view, true);
        frm.setClientMode();
        frm.getController().setAccount( LoginController.getAccount() );
        frm.getController().loadProjectList();
        frm.setVisible(true);
    }
    

    public void logout() {
        int choice = JOptionPane.showConfirmDialog(view, "Tem certeza que deseja sair?", "Sair", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            view.dispose();
            LoginController.startNewSession();
        }
    }
}
