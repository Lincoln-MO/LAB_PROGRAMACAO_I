/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.Controllers;

import com.mycompany.projetoarquitetonico.forms.frmClient;
import com.mycompany.projetoarquitetonico.forms.frmClientFeedback;
import com.mycompany.projetoarquitetonico.forms.frmProject3DView;
import com.mycompany.projetoarquitetonico.forms.frmExpenseReport;
import com.mycompany.projetoarquitetonico.forms.frmProjectHistory;
import javax.swing.JOptionPane;

/**
 *
 * @author lincoln
 */

public class ClientController {
    private frmClient view;

    
    public ClientController(frmClient view) {
        this.view = view;
    }


    public void openFeedbackForm() {
        frmClientFeedback feedbackForm = new frmClientFeedback(view, true);
        feedbackForm.setVisible(true);
    }

    
    public void open3DViewForm() {
        frmProject3DView view3D = new frmProject3DView(view, true);
        view3D.setVisible(true);
    }
    
    
    public void openProjectHistoryForm(){
        frmProjectHistory frm = new frmProjectHistory(view, true);
        frm.setClientMode();
        frm.getController().setAccount( LoginController.getAccount() );
        frm.getController().loadProjectList();
        frm.setVisible(true);
    }
    

    public void logout() {
        int choice = JOptionPane.showConfirmDialog(view, "Você tem certeza que deseja sair?", "Sair", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            // Aqui, adicionaremos a lógica de logout (ex: voltar à tela de login)
            view.dispose();
        }
    } 
}
