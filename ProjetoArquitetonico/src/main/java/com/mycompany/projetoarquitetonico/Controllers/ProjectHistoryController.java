/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.Controllers;

import com.mycompany.projetoarquitetonico.forms.frmProjectHistory;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author lincoln
 */

public class ProjectHistoryController {
    
    private frmProjectHistory view;

    public ProjectHistoryController(frmProjectHistory view) {
        this.view = view;
        
        // Adicionando o listener para o botão "Fechar"
        this.view.getBtnClose().addActionListener(e -> onCloseButtonClicked());

        // Adicionando o listener para os campos e combo boxes
        this.view.getTxtClientCPF().addActionListener(e -> onClientCPFChanged());
        this.view.getComboProject().addActionListener(e -> onProjectSelectionChanged());
    }

    // Método que será chamado quando o botão de fechar for pressionado
    private void onCloseButtonClicked() {
        // Fechar a janela
        view.dispose();
    }

    // Método chamado quando o CPF do cliente é alterado
    private void onClientCPFChanged() {
        String clientCPF = view.getTxtClientCPF().getText();

        // Lógica para verificar se o CPF é válido e carregar projetos
        
        
        if (clientCPF.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Por favor, insira o CPF do cliente.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            loadProjectsForClient(clientCPF);
        }
    }

    // Método chamado quando o projeto é selecionado no combo box
    private void onProjectSelectionChanged() {
        String selectedProject = (String) view.getComboProject().getSelectedItem();
        if (selectedProject != null) {
            // Lógica para carregar os detalhes ou históricos do projeto
            loadProjectHistory(selectedProject);
        }
    }

    // Método para carregar os projetos associados ao cliente
    private void loadProjectsForClient(String clientCPF) {
        
        // Aqui poderemos adicionar a lógica para buscar os projetos relacionados ao CPF.    
        // Por enquanto, apenas um exemplo de como carregar dados na lista
        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("Projeto 1");
        model.addElement("Projeto 2");
        model.addElement("Projeto 3");

        view.getListClientProjects().setModel(model);
    }

    // Método para carregar o histórico ou informações do projeto selecionado
    private void loadProjectHistory(String projectName) {
        
        // adicionaremos aqui posteriormente a lógica para buscar o histórico de um projeto do banco de dados
        
        JOptionPane.showMessageDialog(view, "Carregando histórico do projeto: " + projectName);
    }
    
}
