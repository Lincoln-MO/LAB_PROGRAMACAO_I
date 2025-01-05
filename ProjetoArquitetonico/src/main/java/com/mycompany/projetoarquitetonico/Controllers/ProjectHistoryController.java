package com.mycompany.projetoarquitetonico.Controllers;


import com.mycompany.projetoarquitetonico.DAO.AccountDAO;
import com.mycompany.projetoarquitetonico.DAO.ProjectDAO;
import com.mycompany.projetoarquitetonico.forms.frmAccountFind;
import com.mycompany.projetoarquitetonico.forms.frmProjectHistory;
import com.mycompany.projetoarquitetonico.forms.frmProjectRegistration;
import com.mycompany.projetoarquitetonico.utils.View3DModel;
import java.util.List;


public class ProjectHistoryController {
    private final frmProjectHistory view;
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
            loadProjectList();
        }
    }
    
    
    public void handleView3DModel(){
        if( selectedProject != null ){
            String path = selectedProject.exportTemp3DModel();
            System.out.println(path);
            View3DModel.openFromFile(path);
        }
    }
    
    
    public void loadProjectList(){
        this.projects = ProjectDAO.findAllByUser(account);
        
        for( ProjectDAO p : projects ){
            view.addProject(p);
        }
        
    }
    
    
    public void setAccount(AccountDAO account){
        this.account = account;
        view.setClientName(account.getCpf());
    }
    
    
    public void handleProjectSelection(){
        view.clearTable();
        selectedProject = view.getSelectedProject();
        if(selectedProject == null) return;
        
        // enables the 3D View button if the project has a 3D model file on it
        view.setView3DModelButtonEnabled( selectedProject.has3DModel() );
        
        // add rows in the table (if it's not empty)
        String tableString = selectedProject.getExpenseTableString();
        System.out.println("\n\n\nts: " + tableString);
        if( tableString.equals("") ) return;
        
        for( String row : tableString.split("\n") ){
            String[] args = row.split("\t");
            String name         = args[0].equals("null") ? "" : args[0];
            float quantity      = args[1].equals("null") ? 0 : Float.parseFloat(args[1]);
            float price         = args[2].equals("null") ? 0 : Float.parseFloat(args[2]);
            String description  = args[3].equals("null") ? "" : args[3];
            view.addTableRow(name, quantity, price, description);
        }
    }
}
