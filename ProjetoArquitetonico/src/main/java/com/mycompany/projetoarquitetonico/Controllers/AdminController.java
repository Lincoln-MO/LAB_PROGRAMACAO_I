package com.mycompany.projetoarquitetonico.Controllers;


import com.mycompany.projetoarquitetonico.DAO.AccountDAO;
import com.mycompany.projetoarquitetonico.DAO.Connection;
import com.mycompany.projetoarquitetonico.forms.frmAccountFind;
import com.mycompany.projetoarquitetonico.forms.frmAdmin;
import javax.swing.JOptionPane;


/**
 *
 * @author lincoln
 */
public class AdminController {
    private final frmAdmin view;
    private AccountDAO account = null;
    
    
    public AdminController(frmAdmin view) {
        this.view = view;
    }

    
    public void handleSubmit() {   
        Connection.beginTransaction();
        
        view.hideErrorMessage();
        
        // Form validation start
        if( account == null ){
            view.showError("Conta inválida", "account");
            return;
        }
        // Form validation end
        
        account = AccountDAO.findByCPF( account.getCpf() );
        
        account.setClientAccess( view.isClientSelected() );
        account.setEngineerAccess( view.isEngineerSelected() );
        account.setAdminAccess( view.isAdminSelected() );
        
        Connection.commitTransaction();
        
        JOptionPane.showMessageDialog(view, "Alterações salvas.");
        view.clearForm();
    }
    
    
    public void handleSearchAccount(){
        this.account = frmAccountFind.getAccount("_ANY");
        
        if( account == null ) return;
        
        view.setAccountName( account.getName() );
        view.uncheckAll();
        if( account.isClient() )    view.check("client");
        if( account.isEngineer())   view.check("engineer");
        if( account.isAdmin())      view.check("admin");
    }


    public void handleLogout() {
        if( LoginController.handleLogout() ) view.dispose();
    }
    
    
    public void handleDeleteAccount(){
        int confirm = JOptionPane.showConfirmDialog(view, "Deseja realmente excluir a conta?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            account.makeInactive();
            view.clearForm();
            JOptionPane.showMessageDialog(view, "Conta excluida");
        }
    }
}
