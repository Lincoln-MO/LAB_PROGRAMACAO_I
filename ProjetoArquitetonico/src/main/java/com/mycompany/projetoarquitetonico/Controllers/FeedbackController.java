/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.Controllers;

import com.mycompany.projetoarquitetonico.DAO.AccountDAO;
import com.mycompany.projetoarquitetonico.DAO.Connection;
import com.mycompany.projetoarquitetonico.DAO.FeedbackDAO;
import com.mycompany.projetoarquitetonico.forms.frmClientFeedback;
import javax.swing.JOptionPane;

/**
 *
 * @author lincoln
 */


public class FeedbackController {
    private final frmClientFeedback view;
    private FeedbackDAO feedback;
    
    
    public FeedbackController(frmClientFeedback feedbackView) {
        this.view = feedbackView;
        this.feedback = new FeedbackDAO();
    }


    // Processa o envio do feedback
    public void submit() {
        Connection.beginTransaction();
        Connection.persist(feedback);
        Connection.commitTransaction();
        Connection.closeConnection();
    }

    
    // Método para cancelar o feedback
    public void cancel() {
        view.dispose(); // Fecha a tela de feedback sem enviar
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return feedback.getMessage();
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.feedback.setMessage(message);
    }

    /**
     * @return the author
     */
    public AccountDAO getAuthor() {
        return feedback.getAuthor();
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(AccountDAO author) {
        this.feedback.setAuthor(author);
    }
}