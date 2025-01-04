package com.mycompany.projetoarquitetonico.Controllers;


import com.mycompany.projetoarquitetonico.DAO.AccountDAO;
import com.mycompany.projetoarquitetonico.DAO.Connection;
import com.mycompany.projetoarquitetonico.DAO.FeedbackDAO;
import com.mycompany.projetoarquitetonico.forms.frmClientFeedback;
import javax.swing.JOptionPane;


public class FeedbackController {
    private final frmClientFeedback view;
    private final FeedbackDAO feedback;
    
    
    public FeedbackController(frmClientFeedback feedbackView) {
        this.view = feedbackView;
        this.feedback = new FeedbackDAO();
    }


    public void handleSubmit() {
        setMessage( view.getMessageText() );
        setAuthor( LoginController.getAccount() );
        
        Connection.beginTransaction();
        Connection.persist(feedback);
        Connection.commitTransaction();
        
        JOptionPane.showMessageDialog(view, "Feedback enviado.");
        view.dispose();
    }

    
    public void handleProjectFind(){
        
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