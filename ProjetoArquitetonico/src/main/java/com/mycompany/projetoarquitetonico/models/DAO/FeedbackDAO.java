package com.mycompany.projetoarquitetonico.models.DAO;


import com.mycompany.projetoarquitetonico.models.entities.Account;
import com.mycompany.projetoarquitetonico.models.entities.Feedback;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Query;


/**
 *
 * @author yurit
 */
@Entity(name = "feedback")
public class FeedbackDAO{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String message;
    @ManyToOne
    private AccountDAO author;
    private boolean isActive;
    
    
    public FeedbackDAO(){
        this.message = "";
        this.author = null;
        this.isActive = true;
    }
    
    
    public FeedbackDAO(Feedback feedback) throws ConnectionException{
        Connection.beginTransaction();
        AccountDAO persistentAccount = AccountDAO.getPersistentById(feedback.getAuthor().getId());
        Connection.commitTransaction();
        
        if(feedback.getId() >= 0) this.id = feedback.getId();
        this.message = feedback.getMessage();
        this.author = persistentAccount;
        this.isActive = feedback.isActive();
    }
    
    
    public static void update(Feedback feedback) throws ConnectionException{
        FeedbackDAO dao = new FeedbackDAO(feedback);
        
        Connection.beginTransaction();
        
        Connection.merge(dao);
        
        Connection.commitTransaction();
    }
    
            
    public static List<Feedback> findAll() throws ConnectionException{
        List<FeedbackDAO> queryResult;
        List<Feedback> result = new ArrayList<>();
        
        Connection.beginTransaction();
        
        String sql = "SELECT feedback FROM feedback feedback";
        Query query = Connection.getEntityManager().createQuery(sql);
        
        queryResult = query.getResultList();
        
        Connection.commitTransaction();
        
        
        for( FeedbackDAO dao : queryResult ){
            result.add( dao.toFeedback() );
        }
        
        return result;
    }
    
    
    public static void save(Feedback feedback) throws ConnectionException{
        FeedbackDAO fb = new FeedbackDAO(feedback);
        Connection.beginTransaction();
        Connection.persist( fb );
        Connection.commitTransaction();
    }
    
    
    public Feedback toFeedback(){
        Feedback result = new Feedback();
        
        result.setId( id );
        result.setMessage( message );
        result.setAuthor( author.toAccount() );
        result.setActive( isActive );
        
        return result;
    }
    
    
    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public AccountDAO getAuthor() {
        return author;
    }


    public void setAuthor(Account author) {
        this.author = new AccountDAO(author);
    }


    public int getId() {
        return id;
    }
    
    
    public boolean isActive(){
        return this.isActive;
    }
    
    
    public void setActive(boolean state){
        this.isActive = state;
    }
}
