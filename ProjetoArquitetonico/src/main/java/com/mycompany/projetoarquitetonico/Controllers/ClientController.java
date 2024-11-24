/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.Controllers;

import com.mycompany.projetoarquitetonico.forms.frmClient;
import com.mycompany.projetoarquitetonico.forms.frmClientFeedback;
import com.mycompany.projetoarquitetonico.forms.frmProject3DView;
import com.mycompany.projetoarquitetonico.forms.frmSpendReport;
import javax.swing.JOptionPane;

/**
 *
 * @author lincoln
 */

public class ClientController {
    private frmClient view;

    public ClientController(frmClient view) {
        this.view = view;
        addEventListeners();
    }

    private void addEventListeners() {
        // Relatório de Gastos
        view.getBtnSpendReport().addActionListener(evt -> openSpendReport());

        // Enviar Feedback
        view.getBtnSendFeedback().addActionListener(evt -> openFeedbackForm());

        // Visualização 3D
        view.getBtn3DView().addActionListener(evt -> open3DView());

        // Sair
        view.getBtnLogout().addActionListener(evt -> logout());
    }

    private void openSpendReport() {
        frmSpendReport spendReport = new frmSpendReport(view, true);
        spendReport.setVisible(true);
    }

    private void openFeedbackForm() {
        frmClientFeedback feedbackForm = new frmClientFeedback(view, true);
        feedbackForm.setVisible(true);
    }

    private void open3DView() {
        frmProject3DView view3D = new frmProject3DView(view, true);
        view3D.setVisible(true);
    }

    private void logout() {
        int choice = JOptionPane.showConfirmDialog(view, "Você tem certeza que deseja sair?", "Sair", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            // Aqui, adicionaremos a lógica de logout (ex: voltar à tela de login)
            view.dispose();
        }
    } 
}
