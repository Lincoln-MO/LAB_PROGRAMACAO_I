/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.Controllers;

import com.mycompany.projetoarquitetonico.DAO.ClientAccountDAO;
import com.mycompany.projetoarquitetonico.DAO.Connection;
import com.mycompany.projetoarquitetonico.forms.frmAdmin;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author lincoln
 */
public class AdminController {
    private final frmAdmin view;

    public AdminController(frmAdmin view) {
        this.view = view;
        initController();
    }
    

    private void initController() {
        // Configura os eventos dos botões
        view.getBtnSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveUserAccess();
            }
        });

        view.getBtnLogout().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });
    }

    
    private void saveUserAccess() {   
        String cpf = view.getTxtCPF().getText().trim();
        String[] accessLevel = view.getSelectedAccessLevel();

        if (cpf.isEmpty()) {
            JOptionPane.showMessageDialog(view, "O CPF não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        
        /*

        // Lógica para salvar o nível de acesso no sistema
        // Aqui podemos chamar um método na classe de modelo ou DAO para salvar os dados
        JOptionPane.showMessageDialog(view, "Nível de acesso salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        */  
        
        Connection.beginTransaction();
        ClientAccountDAO client = ClientAccountDAO.findByCPF(cpf);
        
        client.setClientAccess( view.isClientSelected() );
        client.setEngineerAccess( view.isEngineerSelected() );
        client.setAdminAccess( view.isAdminSelected() );
        
        Connection.commitTransaction();

    }
    

    private void logout() {
        // Lógica de logout (ex.: fechar a janela atual e retornar à tela de login)
        int confirm = JOptionPane.showConfirmDialog(view, "Deseja realmente sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            view.dispose(); // Fecha a janela atual
            // Aqui vamos redirecionar para a tela de login se necessário
        }
    }
}
