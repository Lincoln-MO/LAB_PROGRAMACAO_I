package com.mycompany.projetoarquitetonico.Controllers;

import com.mycompany.projetoarquitetonico.forms.frmViewClientFeedback;
import com.mycompany.projetoarquitetonico.models.DAO.AccountDAO;
import com.mycompany.projetoarquitetonico.models.DAO.FeedbackDAO;
import com.mycompany.projetoarquitetonico.models.entities.Feedback;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author yurit
 */
public final class ViewClientFeedbackController {
    frmViewClientFeedback view;
    List<Feedback> feedbacks;
    int selectedFeedbackId;
    
    
    public ViewClientFeedbackController(frmViewClientFeedback frm){
        this.view = frm;
        loadFeedbacks();
    }
    
    
    public void loadFeedbacks(){
        view.clearForm();
        feedbacks = new ArrayList<>();
        
        for( Feedback fb : FeedbackDAO.findAll() ){
            if( !fb.isActive() ) continue;
            String authorName = fb.getAuthor().getName();//AccountDAO.findById( fb.getAuthor().getId() ).getName();
            view.addFeedback(fb.getId() + " - " + authorName);
            feedbacks.add(fb);
        }
        
        // selects the next available feedback
        handleFeedbackSelection();
    }
    
    
    public void handleFeedbackSelection(){
        if(feedbacks.size() <= 0 ){
            view.setMarkAsReadedButtonEnabled(false);
            return;
        }
        
        selectedFeedbackId = view.getSelectedFeedbackIndex();
        view.setMessageText( feedbacks.get(selectedFeedbackId).getMessage() );
        view.setMarkAsReadedButtonEnabled(true);
    }
    
    
    public void handleMarkAsReaded(){
        Feedback fb = feedbacks.get(selectedFeedbackId);
        fb.setActive(false);
        FeedbackDAO.update(fb);
        view.setMarkAsReadedButtonEnabled(false);
        
        // updates the feedback list
        loadFeedbacks();
    }
}
