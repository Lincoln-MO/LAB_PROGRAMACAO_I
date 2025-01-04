package com.mycompany.projetoarquitetonico.Controllers;


import com.mycompany.projetoarquitetonico.DAO.AccountDAO;
import com.mycompany.projetoarquitetonico.DAO.ProjectDAO;
import com.mycompany.projetoarquitetonico.DAO.TerrainDAO;
import com.mycompany.projetoarquitetonico.forms.frmFileChooser;
import com.mycompany.projetoarquitetonico.forms.frmAccountFind;
import com.mycompany.projetoarquitetonico.forms.frmProjectRegistration;
import com.mycompany.projetoarquitetonico.forms.frmTerrainFind;
import com.mycompany.projetoarquitetonico.utils.Validation;
import javax.swing.JOptionPane;


public class ProjectRegistrationController {
    private int projectId = -1;   // used in project editing
    private String projectName = null;
    private String startDate = null;
    private AccountDAO responsible = null;
    private TerrainDAO terrain = null;
    private String model3DFilePath = null;
    private String expenseTableString = null;
    private final frmProjectRegistration view;

    
    public ProjectRegistrationController(frmProjectRegistration view) {
        this.view = view;
    }

    
    public void handleSubmit(){
        projectName = view.getNameText();
        startDate = view.getStartDateText();
        
        view.hideErrorMessage();
        
        // Form validarion start
        if( !Validation.isNameValid(projectName) ){
            view.showError("Nome inválido", "name");
            return;
        }
        
        if( !Validation.isDateValid(startDate) ){
            view.showError("Data inválida", "date");
            return;
        }
        
        if( responsible == null ){
            view.showError("Responsável inválido", "responsible");
            return;
        }
        
        if( terrain == null ){
            view.showError("Terreno inválido", "terrain");
            return;
        }
        
        /*
        This error SHOULDN'T show up by any means, but if the magic
        happens it would treat it like the most mundane thing ever, so it will not
        scary away the end user
        */
        if ( !responsible.isEngineer() ){
            view.showError("Responsável não é engenheiro", "responsible");
            return;
        }
        // Form validation end
        
        // Save/update project
        ProjectDAO p;
        // if projectId >= 0 then is on edit mode
        if( projectId >= 0){
            p = ProjectDAO.findById(projectId);
        }else{
            p = new ProjectDAO();
        }
        
        p.setName(projectName);
        p.setStartDate(startDate);
        p.setResponsible(responsible);
        p.setTerrain(terrain);  
        p.setExpenseTableString(view.getTableString());
        
        if( model3DFilePath != null ){
            p.set3DModelFromFile( model3DFilePath );
        }
        
        if( projectId >= 0){    
            ProjectDAO.update(p); // edit mode
            JOptionPane.showMessageDialog(view, "Alterações salvas.");
        }else{
            ProjectDAO.save(p); // register mode
            JOptionPane.showMessageDialog(view, "Projeto cadastrado.");
        }
        
        view.clearForm();
    }
    
    
    public void handle3DModelFind(){
        model3DFilePath = frmFileChooser.chooseFile();
        if( model3DFilePath != null ){
            view.setFileName( model3DFilePath );
        }else{
            view.setFileName("");
        }
    }
    
    
    public void editProject(ProjectDAO project){
        System.out.println("\n\nedit\n\n");
        this.projectId = project.getId();
        this.projectName = project.getName();
        this.startDate = project.getStartDate();
        this.responsible = project.getResponsible();
        System.out.println(project.getResponsible().getCpf());
        this.terrain = project.getTerrain();
        this.expenseTableString = project.getExpenseTableString();
        
        view.setEditMode();
        view.setProjectName(projectName);
        view.setStartDate(startDate);
        view.setResponsibleCPF(responsible.getCpf());
        view.setTerrainName(terrain.getName());
        view.setExpenseTable(expenseTableString);
    }
    
    
    public void handleResponsibleFind(){
        AccountDAO resp = frmAccountFind.getAccount("engineer");
        this.responsible = resp;
        
        if( resp != null ) view.setResponsibleCPF(resp.getCpf());
        else view.setResponsibleCPF("");
    }
    
    
    public void handleTerrainFind(){
        TerrainDAO ter = frmTerrainFind.getTerrain();
        this.terrain = ter;
        
        if( ter != null) view.setTerrainName(ter.getName());
        else view.setTerrainName("");
    }
    
    

    public String getProjectName() {
        return projectName;
    }


    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    public String getStartDate() {
        return startDate;
    }


    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }


    public AccountDAO getResponsible() {
        return responsible;
    }


    public void setResponsible(AccountDAO responsible) {
        this.responsible = responsible;
    }


    public TerrainDAO getTerrain() {
        return terrain;
    }


    public void setTerrain(TerrainDAO terrain) {
        this.terrain = terrain;
    }


    public String getExpenseTableString() {
        return expenseTableString;
    }


    public void setExpenseTableString(String tableString) {
        this.expenseTableString = tableString;
    }
}
