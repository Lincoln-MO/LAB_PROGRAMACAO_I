package com.mycompany.projetoarquitetonico.Controllers;


import com.mycompany.projetoarquitetonico.models.DAO.ProjectDAO;
import com.mycompany.projetoarquitetonico.forms.frmFileChooser;
import com.mycompany.projetoarquitetonico.forms.frmAccountFind;
import com.mycompany.projetoarquitetonico.forms.frmProjectRegistration;
import com.mycompany.projetoarquitetonico.forms.frmTerrainFind;
import com.mycompany.projetoarquitetonico.models.DAO.ConnectionException;
import com.mycompany.projetoarquitetonico.models.entities.Account;
import com.mycompany.projetoarquitetonico.models.entities.Project;
import com.mycompany.projetoarquitetonico.models.entities.Terrain;
import com.mycompany.projetoarquitetonico.utils.SendEmail;
import com.mycompany.projetoarquitetonico.utils.Validation;
import javax.swing.JOptionPane;


public class ProjectRegistrationController {
    private int projectId = -1;   // used in project editing
    private String projectName = null;
    private String startDate = null;
    private Account responsible = null;
    private Terrain terrain = null;
    private String model3DFilePath = null;
    private String expenseTableString = null;
    private final frmProjectRegistration view;

    
    public ProjectRegistrationController(frmProjectRegistration view) {
        this.view = view;
    }

    
    public void handleSubmit(){
        try{
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
            Project p;
            // if projectId >= 0 then is on edit mode
            if( projectId >= 0){
                p = ProjectDAO.findById(projectId);
            }else{
                p = new Project();
            }

            p.setName(projectName);
            p.setStartDate(startDate);
            p.setResponsible(responsible);
            p.setTerrain(terrain);  
            p.setExpenseTableString(view.getTableString());

            if( model3DFilePath != null ){
                p.set3DModelFromFile( model3DFilePath );
            }

            String dialogMessage, emailTitle, emailMessage;
            if( projectId >= 0){    
                ProjectDAO.update(p); // edit mode
                dialogMessage = "Alterações salvas.";
                emailTitle = "Cadastro de projeto";
                emailMessage = "Seu projeto recebeu uma ou mais modificações.";
            }else{
                ProjectDAO.save(p); // register mode
                dialogMessage = "Projeto cadastrado.";
                emailTitle = "Alteração no projeto";
                emailMessage = "Foi cadastrado um novo projeto em seu nome.";
            }

            view.clearForm();

            if(
                SendEmail.SendMessage(
                    emailTitle, 
                    emailMessage,
                    terrain.getOwner().getEmail())){
                JOptionPane.showMessageDialog(view, dialogMessage + " Cliente notificado por email.");
            }else{
                JOptionPane.showMessageDialog(view, dialogMessage + " Não foi possível notificar o cliente por email.");
            }
            view.dispose();
        }catch (ConnectionException e){
            JOptionPane.showMessageDialog(view, "Ocorreu um erro.");
        }
    }
    
    
    public void handle3DModelFind(){
        model3DFilePath = frmFileChooser.chooseFile();
        if( model3DFilePath != null ){
            view.setFilePath( model3DFilePath );
        }else{
            view.setFilePath("");
        }
    }
    
    
    public void editProject(Project project){
        this.projectId = project.getId();
        this.projectName = project.getName();
        this.startDate = project.getStartDate();
        this.responsible = project.getResponsible();
        this.terrain = project.getTerrain();
        this.expenseTableString = project.getExpenseTableString();
        this.model3DFilePath = project.getModel3DFilePath();
        
        view.setEditMode();
        view.setProjectName(projectName);
        view.setStartDate(startDate);
        view.setResponsibleCPF(responsible.getCpf());
        view.setTerrainName(terrain.getName());
        view.setFilePath(startDate);
        view.setExpenseTable(expenseTableString);
        view.setFilePath(model3DFilePath);
    }
    
    
    public void handleResponsibleFind(){
        Account resp = frmAccountFind.getAccount("engineer");
        this.responsible = resp;
        
        if( resp != null ) view.setResponsibleCPF(resp.getCpf());
        else view.setResponsibleCPF("");
    }
    
    
    public void handleTerrainFind(){
        Terrain ter = frmTerrainFind.getTerrain();
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


    public Account getResponsible() {
        return responsible;
    }


    public void setResponsible(Account responsible) {
        this.responsible = responsible;
    }


    public Terrain getTerrain() {
        return terrain;
    }


    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }


    public String getExpenseTableString() {
        return expenseTableString;
    }


    public void setExpenseTableString(String tableString) {
        this.expenseTableString = tableString;
    }
}
