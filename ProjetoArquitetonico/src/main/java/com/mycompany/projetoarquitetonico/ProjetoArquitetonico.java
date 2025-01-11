package com.mycompany.projetoarquitetonico;


import com.mycompany.projetoarquitetonico.Controllers.*;
import com.mycompany.projetoarquitetonico.models.DAO.Connection;
import com.mycompany.projetoarquitetonico.models.DAO.ConnectionException;
import javax.swing.JOptionPane;


public class ProjetoArquitetonico {
    public static void main(String[] args) {
        try{
            Connection.openConnection();
            LoginController.startNewSession();
        }catch (ConnectionException e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro.");
        }
    }
}
