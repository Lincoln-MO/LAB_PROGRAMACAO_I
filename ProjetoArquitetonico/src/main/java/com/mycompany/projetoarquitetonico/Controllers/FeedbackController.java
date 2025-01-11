package com.mycompany.projetoarquitetonico.Controllers;


import com.mycompany.projetoarquitetonico.models.DAO.FeedbackDAO;
import com.mycompany.projetoarquitetonico.forms.frmClientFeedback;
import com.mycompany.projetoarquitetonico.models.DAO.ConnectionException;
import com.mycompany.projetoarquitetonico.models.entities.Feedback;
import javax.swing.JOptionPane;


public class FeedbackController {
    private final frmClientFeedback view;
    
    
    public FeedbackController(frmClientFeedback feedbackView) {
        this.view = feedbackView;
    }


    public void handleSubmit(){
        try{
            String message = view.getMessageText();
            if( message.equals("") ){
                JOptionPane.showMessageDialog(view, "Mensagem inválida.");
                return;
            }

            Feedback feedback = new Feedback();

            feedback.setMessage( message );
            feedback.setAuthor( LoginController.getAccount() );

            FeedbackDAO.save(feedback);

            JOptionPane.showMessageDialog(view, "Feedback enviado.");
            view.dispose();
        }catch (ConnectionException e){
            JOptionPane.showMessageDialog(view, "Ocorreu um erro.");
        }
    }
}