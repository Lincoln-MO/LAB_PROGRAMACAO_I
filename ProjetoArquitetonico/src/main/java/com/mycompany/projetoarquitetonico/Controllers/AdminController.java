/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.Controllers;

import com.mycompany.projetoarquitetonico.DAO.AccountDAO;
import com.mycompany.projetoarquitetonico.DAO.Connection;
import com.mycompany.projetoarquitetonico.forms.frmAccountFind;
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
    private AccountDAO account = null;
    
    
    public AdminController(frmAdmin view) {
        this.view = view;
    }

    
    public void submit() {   
        Connection.beginTransaction();
        
        account = AccountDAO.findByCPF( account.getCpf() );
        
        account.setClientAccess( view.isClientSelected() );
        account.setEngineerAccess( view.isEngineerSelected() );
        account.setAdminAccess( view.isAdminSelected() );
        
        Connection.commitTransaction();
    }
    
    
    public void searchAccount(){
        this.account = frmAccountFind.getAccount("_ANY");
        view.setAccountName( account.getName() );
        view.uncheckAll();
        if( account.isClient() )    view.check("client");
        if( account.isEngineer())   view.check("engineer");
        if( account.isAdmin())      view.check("admin");
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
