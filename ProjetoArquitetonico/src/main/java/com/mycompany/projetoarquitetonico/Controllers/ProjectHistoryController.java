/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.Controllers;

import com.mycompany.projetoarquitetonico.DAO.AccountDAO;
import com.mycompany.projetoarquitetonico.DAO.Connection;
import com.mycompany.projetoarquitetonico.DAO.ProjectDAO;
import com.mycompany.projetoarquitetonico.forms.frmAccountFind;
import com.mycompany.projetoarquitetonico.forms.frmProjectHistory;
import com.mycompany.projetoarquitetonico.models.Account;
import java.util.List;
import javax.persistence.Query;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author lincoln
 */

public class ProjectHistoryController {
    private frmProjectHistory view;
    private DefaultListModel tableModel = new DefaultListModel();
    private AccountDAO account = null;
    private List<ProjectDAO> projects = null;
    
    
    public ProjectHistoryController(frmProjectHistory view) {
        this.view = view;
        
        /*
        if( clientMode ) view.setClientMode();
        else view.setEngineerMode();
        */
        view.setEngineerMode();
    }

    
    // Método para carregar os projetos associados ao cliente
    private void loadProjectsForClient(String clientCPF) { 
    }

    
    // Método para carregar o histórico ou informações do projeto selecionado
    private void loadProjectHistory(String projectName) {
    }
    
    
    public void findAccount(){
        account = frmAccountFind.getAccount( "client" );
        if( account != null ){
            view.setClientName( account.getName());
        }
        
        loadProjectList();
    }
    
    
    public void loadProjectList(){
        this.projects = ProjectDAO.findAllByUser(account);
        
        for( ProjectDAO p : projects ){
            view.addProject(p);
        }
        
    }
    
    
    public void setAccount(AccountDAO account){
        this.account = account;
    }
    
    
    public void handleProjectSelection(){
        view.clearTable();
        ProjectDAO project = view.getSelectedProject();
        if(project == null) return;
        
        // add rows in the table
        for( String row : project.getExpenseTableString().split("\n") ){
            String[] args = row.split("\t");
            String name         = args[0];
            float quantity      = Float.parseFloat(args[1]);
            float price         = Float.parseFloat(args[2]);
            String description  = args[3];
            view.addTableRow(name, quantity, price, description);
        }
    }
}
