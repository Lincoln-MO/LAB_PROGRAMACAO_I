package com.mycompany.projetoarquitetonico.Controllers;


import com.mycompany.projetoarquitetonico.DAO.FeedbackDAO;
import com.mycompany.projetoarquitetonico.forms.frmClientFeedback;
import javax.swing.JOptionPane;


public class FeedbackController {
    private final frmClientFeedback view;
    
    
    public FeedbackController(frmClientFeedback feedbackView) {
        this.view = feedbackView;
    }


    public void handleSubmit() {
        String message = view.getMessageText();
        if( message.equals("") ){
            JOptionPane.showMessageDialog(view, "Mensagem inválida.");
            return;
        }
        
        FeedbackDAO feedback = new FeedbackDAO();
        
        feedback.setMessage( message );
        feedback.setAuthor( LoginController.getAccount() );
        
        FeedbackDAO.save(feedback);
        
        JOptionPane.showMessageDialog(view, "Feedback enviado.");
        view.dispose();
    }
}