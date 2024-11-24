/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.Controllers;

import com.mycompany.projetoarquitetonico.forms.frmProject3DView;
import javax.swing.JOptionPane;

/**
 *
 * @author lincoln
 */
public class Project3DController {
    private final frmProject3DView project3DView;

    public Project3DController(frmProject3DView project3DView) {
        this.project3DView = project3DView;
        initializeActions();
    }

    // Inicializa os listeners da interface
    private void initializeActions() {
        project3DView.getBtnSave().addActionListener(e -> handleSave());
        project3DView.getBtnClose().addActionListener(e -> handleClose());
    }

    // Lida com a ação de salvar
    public void handleSave() {
        // Lógica para salvar o projeto 3D
        // Aqui  adicionamos a lógica para salvar o projeto ou os dados necessários

        JOptionPane.showMessageDialog(project3DView, "Projeto 3D salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        project3DView.dispose();  // Fecha a janela após salvar
    }

    // Lida com a ação de fechar
    public void handleClose() {
        project3DView.dispose();  // Fecha a janela sem salvar
    }   
}
