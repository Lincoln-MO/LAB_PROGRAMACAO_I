package com.mycompany.projetoarquitetonico.Controllers;


import com.mycompany.projetoarquitetonico.models.DAO.AccountDAO;
import com.mycompany.projetoarquitetonico.forms.frmAccountFind;
import com.mycompany.projetoarquitetonico.forms.frmAdmin;
import com.mycompany.projetoarquitetonico.models.entities.Account;
import javax.swing.JOptionPane;


/**
 *
 * @author lincoln
 */
public class AdminController {
    private final frmAdmin view;
    private Account account = null;
    
    
    public AdminController(frmAdmin view) {
        this.view = view;
    }

    
    public void handleSubmit() {   
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
        
        AccountDAO.update(account);
        
        
        JOptionPane.showMessageDialog(view, "Alterações salvas.");
        view.clearForm();
    }
    
    
    public void handleSearchAccount(){
        this.account = frmAccountFind.getAccount("_ANY");
        view.hideErrorMessage();
        
        if( account == null ){
            view.setDeleteAccountButtonEnable(false);
            return;
        }
        
        if( !account.isActive() ){
            view.showError("A conta está marcada como desativada", "");
            view.setControlsEnabled(false);
        }else{
            view.setControlsEnabled(true);
            view.setDeleteAccountButtonEnable(true);
        }
        
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
