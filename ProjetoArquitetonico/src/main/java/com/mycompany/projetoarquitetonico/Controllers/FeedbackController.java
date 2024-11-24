/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.Controllers;

import com.mycompany.projetoarquitetonico.forms.frmClientFeedback;
import javax.swing.JOptionPane;

/**
 *
 * @author lincoln
 */


public class FeedbackController {
    private final frmClientFeedback feedbackView;

    public FeedbackController(frmClientFeedback feedbackView) {
        this.feedbackView = feedbackView;
        initializeActions();
    }

    // Inicializa os listeners da interface de feedback
    private void initializeActions() {
        feedbackView.getBtnSubmit().addActionListener(e -> handleSubmitFeedback());
        feedbackView.getBtnCancel().addActionListener(e -> handleCancel());
    }

    // Processa o envio do feedback
    public void handleSubmitFeedback() {
        String feedback = feedbackView.getTextAreaFeedback().getText().trim();
        
        if (feedback.isEmpty()) {
            JOptionPane.showMessageDialog(feedbackView, "Por favor, insira seu feedback.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Aqui adicionamos a lógica para salvar o feedback no banco de dados ou em um arquivo
        
        
        JOptionPane.showMessageDialog(feedbackView, "Feedback enviado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        feedbackView.dispose(); // Fecha a tela de feedback após envio
    }

    // Método para cancelar o feedback
    public void handleCancel() {
        feedbackView.dispose(); // Fecha a tela de feedback sem enviar
    }    
}