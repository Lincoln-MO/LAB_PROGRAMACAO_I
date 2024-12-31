package com.mycompany.projetoarquitetonico.Controllers;


import com.mycompany.projetoarquitetonico.DAO.AccountDAO;
import com.mycompany.projetoarquitetonico.DAO.ProjectDAO;
import com.mycompany.projetoarquitetonico.forms.frmAccountFind;
import com.mycompany.projetoarquitetonico.forms.frmProjectHistory;
import com.mycompany.projetoarquitetonico.forms.frmProjectRegistration;
import java.util.List;
import javax.swing.DefaultListModel;


/**
 *
 * @author lincoln
 */
public class ProjectHistoryController {
    private final frmProjectHistory view;
    private DefaultListModel tableModel = new DefaultListModel();
    private AccountDAO account = null;
    private List<ProjectDAO> projects = null;
    private ProjectDAO selectedProject = null;
    
    
    public ProjectHistoryController(frmProjectHistory view) {
        this.view = view;
        
        view.setEngineerMode();
    }

    
    public void handleEditSelectedProject(){
        frmProjectRegistration frm = new frmProjectRegistration(null, true);
        frm.getController().editProject(selectedProject);
        frm.setVisible(true);
        
    }
    
    
    public void handleFindAccount(){
        account = frmAccountFind.getAccount( "client" );
        if( account != null ){
            view.setClientName( account.getName());
        }
        
        loadProjectList();
    }
    
    
    public void loadProjectList(){
        this.projects = ProjectDAO.findAllByUser(account);
        
        for( ProjectDAO p : projects ){
            view.addProject(p);
        }
        
    }
    
    
    public void setAccount(AccountDAO account){
        this.account = account;
    }
    
    
    public void handleProjectSelection(){
        view.clearTable();
        selectedProject = view.getSelectedProject();
        if(selectedProject == null) return;
        
        // add rows in the table
        for( String row : selectedProject.getExpenseTableString().split("\n") ){
            String[] args = row.split("\t");
            String name         = args[0];
            float quantity      = Float.parseFloat(args[1]);
            float price         = Float.parseFloat(args[2]);
            String description  = args[3];
            view.addTableRow(name, quantity, price, description);
        }
    }
}
