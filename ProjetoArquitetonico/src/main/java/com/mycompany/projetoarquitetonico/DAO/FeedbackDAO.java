package com.mycompany.projetoarquitetonico.DAO;


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
    private Integer id;
    private String message;
    @ManyToOne
    private AccountDAO author;
    
    
    public static List<FeedbackDAO> findAll(){
        List<FeedbackDAO> result;
        
        Connection.beginTransaction();
        
        String sql = "SELECT feedback FROM feedback feedback";
        Query query = Connection.getEntityManager().createQuery(sql);
        
        result = query.getResultList();
        
        Connection.commitTransaction();
        
        return result;
    }
    
    
    public static void save(FeedbackDAO feedback){
        Connection.beginTransaction();
        Connection.persist(feedback);
        Connection.commitTransaction();
    }
    
    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the author
     */
    public AccountDAO getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(AccountDAO author) {
        this.author = author;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    
}
