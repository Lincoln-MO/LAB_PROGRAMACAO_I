/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.Controllers;

import com.mycompany.projetoarquitetonico.DAO.EngineerAccountDAO;
import com.mycompany.projetoarquitetonico.DAO.ProjectDAO;
import com.mycompany.projetoarquitetonico.DAO.TerrainDAO;
import com.mycompany.projetoarquitetonico.forms.frmProjectRegistration;
import javax.swing.JOptionPane;

/**
 *
 * @author lincoln
 */
public class ProjectRegistrationController {
    
    private frmProjectRegistration view;

    public ProjectRegistrationController(frmProjectRegistration view) {
        this.view = view;
        
        // Adicionando os listeners aos campos de entrada
        this.view.getBtnRegister().addActionListener(e -> onRegisterButtonClicked());
    }

    // Método que será chamado quando o botão de cadastro for pressionado
    private void onRegisterButtonClicked() {
        // Obter os valores dos campos
        String projectName = view.getTxtProjectName().getText();
        String startDate = view.getTxtStartDate().getText();
        int responsible = Integer.parseInt(view.getResponsibleCPF());
        int terrain = Integer.parseInt(view.getTerrainId());

        ProjectDAO p = new ProjectDAO();
        
        p.setName(projectName);
        p.setStartDate(startDate);
        p.setResponsible(EngineerAccountDAO.findById(responsible)); ///////
        p.setTerrain(TerrainDAO.findById(terrain));
        
        ProjectDAO.save(p);
        /*
        // Validar os campos
        if (projectName.isEmpty() || startDate.isEmpty() || responsible == null || terrain == null) {
            JOptionPane.showMessageDialog(view, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            // Aqui depois vamos adicionar a lógica para criar um novo projeto, 
            // mas como ainda não tem a DAO ou a classe Project apenas exibimos uma mensagem de sucesso.
            JOptionPane.showMessageDialog(view, "Projeto cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
        */
        
        
    }
    
}
