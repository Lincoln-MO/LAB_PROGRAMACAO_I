package com.mycompany.projetoarquitetonico;


import com.mycompany.projetoarquitetonico.Controllers.*;
import com.mycompany.projetoarquitetonico.DAO.Connection;


public class ProjetoArquitetonico {
    public static void main(String[] args) {      
        Connection.openConnection();
        LoginController.startNewSession();
    }
}
