package com.mycompany.projetoarquitetonico.Controllers;


import com.mycompany.projetoarquitetonico.forms.frmAccountFind;
import com.mycompany.projetoarquitetonico.models.DAO.AccountDAO;
import com.mycompany.projetoarquitetonico.models.DAO.ConnectionException;
import com.mycompany.projetoarquitetonico.models.entities.Account;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author yurit
 */
public class AccountFindController {
    frmAccountFind view;
    private String accountType;
    private Account selectedAccount;
    private List<Account> foundAccounts = null;
    
    
    public AccountFindController(frmAccountFind view){
        this.accountType = "";
        this.view = view;
    }
    
    
    public void handleSelectAccount(){
        int id = view.getSelectedIndex();
        
        if( id >= 0 ) this.selectedAccount = this.foundAccounts.get(id);
        else this.selectedAccount = null;
        
        /*
        need this for getAccount()
        (returns the selected account when the form is not visible)
        */
        view.setVisible(false);
    }
    
    
    public void handleTextType(){
        try{
            String search = view.getNameText();
            this.foundAccounts = AccountDAO.findAllByNameOrCPF(view.getSearchText(), this.accountType);

            view.clearComboItems();
            if( search.equals("") ){
                view.setFoundAccountsCounterText("0");
                return;
            }

            view.setFoundAccountsCounterText(String.valueOf( this.foundAccounts.size() ));
            for( Account acc : this.foundAccounts ){
                view.addComboItem(acc.getName() + " : " + acc.getCpf());
            }
        }catch (ConnectionException e){
            JOptionPane.showMessageDialog(view, "Ocorreu um erro.");
        }        
    }
    
    
    public Account handleGetAccount(String accountType){
        Account result;
        frmAccountFind frm = new frmAccountFind(null, true);
        frm.setAccountType(accountType);
        frm.setVisible(true);
        
        // returns when frm is not visible
        result = frm.getSelectedAccount();
        frm.dispose();
        return result;
    }
    
    
    public void setAccountType(String accountType){
        this.accountType = accountType;
    }
    
    
    public Account getSelectedAccount(){
        return this.selectedAccount;
    }
}
