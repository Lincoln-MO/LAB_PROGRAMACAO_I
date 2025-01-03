package com.mycompany.projetoarquitetonico.Controllers;


import com.mycompany.projetoarquitetonico.DAO.AccountDAO;
import com.mycompany.projetoarquitetonico.forms.frmClient;
import com.mycompany.projetoarquitetonico.forms.frmEngineer;
import com.mycompany.projetoarquitetonico.forms.frmAdmin;
import com.mycompany.projetoarquitetonico.forms.frmLogin;
import com.mycompany.projetoarquitetonico.utils.Validation;
import javax.swing.JOptionPane;


public class LoginController {
    private static frmLogin view;
    private static AccountDAO account;
    private static String cpf;
    private static String password;
    private static String accountType;
 
    public static boolean handleLogout(){
        int confirm = JOptionPane.showConfirmDialog(view, "Deseja realmente sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            LoginController.startNewSession();
            return true;
        }
        
        return false;
    }
    
    
    public static void startNewSession(){
        view = new frmLogin();
        view.setVisible(true);
    }
    
    
    public static void handleSubmit() {
        cpf = view.getLoginText();
        password = view.getPasswordText();
        accountType = view.getSelectedAccountType();
        
        // Form validation start
        if( !Validation.isCpfValid( cpf )){
            view.showError("CPF inválido", "cpf");
            return;
        }
        
        if( !Validation.isPasswordValid( password )){
            view.showError("Senha inválida", "password");
            return;
        }
        
        if( accountType == null ){
            view.showError("Selecione uma opção de login", "");
            return;
        }
        // Form validation end
        
        /*
        Checks if the account exists with the selected accountType permission
        */
        account = AccountDAO.find(cpf, password);
        
        if( account == null ){
            view.showError("Conta não encontrada", "");
            return;
        }
        
        if( accountType.equals("client") && account.isClient() ){
            redirectUser("client", cpf);
            return;
        }
        
        if( accountType.equals("engineer") && account.isClient() ){
            redirectUser("engineer", cpf);
            return;
        }
        
        if( accountType.equals("admin") && account.isClient() ){
            redirectUser("admin", cpf);
            return;
        }
        
        view.showError("Acesso negado", "");
    }


    private static void redirectUser(String tipoConta, String cpf) {
        switch (tipoConta) {
            case "client":
                frmClient clientView = new frmClient();
                clientView.setVisible(true);
                clientView.setLoginText("Logado como: " + cpf);
                view.dispose();
                break;

            case "engineer":
                frmEngineer engineerView = new frmEngineer(null, false);
                engineerView.setVisible(true);
                engineerView.setLoginText("Logado como: " + cpf);
                view.dispose();
                break;

            case "admin":
                frmAdmin adminView = new frmAdmin();
                adminView.setVisible(true);
                adminView.setLoginText("Logado como: " + cpf);
                view.dispose();
                break;

            default:
                JOptionPane.showMessageDialog(view, "Tipo de conta desconhecido.", "Erro", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }
    

    /**
     * @return the account
     */
    public static AccountDAO getAccount() {
        return account;
    }
}
