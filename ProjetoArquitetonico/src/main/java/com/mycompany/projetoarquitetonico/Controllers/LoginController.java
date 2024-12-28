package com.mycompany.projetoarquitetonico.Controllers;

import com.mycompany.projetoarquitetonico.DAO.*;
import com.mycompany.projetoarquitetonico.forms.frmClient;
import com.mycompany.projetoarquitetonico.forms.frmEngineer;
import com.mycompany.projetoarquitetonico.forms.frmAdmin;
import com.mycompany.projetoarquitetonico.forms.frmLogin;
import com.mycompany.projetoarquitetonico.models.*;
import javax.swing.JOptionPane;

public class LoginController {
    private static frmLogin view;
    private static String selectedAccountType = null; // Armazena o tipo de conta selecionado
    private static AccountDAO account;
    

    public LoginController(frmLogin mainView) {
        view = mainView;
    }

    
    // Método para processar o botão "Entrar"
    public static void submit(String cpf, String password, String accountType) {
        System.out.println("Login attempt");
        selectedAccountType = accountType;
        
        account = AccountDAO.find(cpf, password);
        
        if(getAccount() == null){
                System.out.println("not found");
                return;
        }
        
        switch (accountType) {
            case "client" -> {
                if ( getAccount().isAdmin() ){
                    redirectUser("client", cpf);
                }
            }
            case "engineer" -> {
                if ( getAccount().isEngineer() ){
                    redirectUser("engineer", cpf);
                }
            }
            case "admin" -> {
                if ( getAccount().isAdmin() ){
                    redirectUser("admin", cpf);
                }
            }
        }

        // No account type selected
        if (selectedAccountType == null) {
            JOptionPane.showMessageDialog(view, "Selecione um tipo de conta.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Has empty fields
        if (cpf.isEmpty() || cpf.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        /*
        // CPF validation
        if (!isCPFValid(cpf)) {
            JOptionPane.showMessageDialog(mainView, "CPF inválido! Insira no formato XXX.XXX.XXX-XX", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        */

        /*
        if (validateLogin(cpf, password, selectedAccountType)) {
            JOptionPane.showMessageDialog(mainView, "Login bem-sucedido!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            redirectUser(selectedAccountType, cpf);
        } else {
            JOptionPane.showMessageDialog(mainView, "CPF ou senha inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        */
    }

    /*
    // Lida com a entrada no campo de login
    public void handleLoginInput() {
        String login = mainView.getTxtLogin().getText().trim();
        if (login.isEmpty()) {
            JOptionPane.showMessageDialog(mainView, "O campo de login está vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Lida com a entrada no campo de senha
    public void handlePasswordInput() {
        String password = new String(mainView.getTxtPassword().getPassword()).trim();
        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(mainView, "O campo de senha está vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Lida com a seleção do tipo de conta
    public void handleAccountTypeSelection(String accountType) {
        this.selectedAccountType = accountType;
        //JOptionPane.showMessageDialog(mainView, "Tipo de conta selecionado: " + accountType, "Informação", JOptionPane.INFORMATION_MESSAGE);
    }
    */

    
    // Valida o formato do CPF
    private static boolean isCPFValid(String cpf) {
        return cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
    }

    
    // Simula a validação no banco de dados (substitua pela lógica real)
    private static boolean validateLogin(String cpf, String password, String accountType) {
        String redirect = null;
        System.out.println("login validation");
        
        switch(accountType){
            case "client":
                break;
            case "engineer":
                break;
            case "admin":
                break;
        }
        return false;
    }
    

    // Redireciona o usuário com base no tipo de conta
    private static void redirectUser(String tipoConta, String cpf) {
        switch (tipoConta) {
            case "client":
                frmClient clientView = new frmClient();
                clientView.setVisible(true);
                clientView.getTxtLoginName().setText("Logado como: " + cpf);
                view.dispose();  // Fecha a janela principal de login
                break;

            case "engineer":
                //JOptionPane.showMessageDialog(mainView, "Redirecionando para a interface de Engenheiro.");
                frmEngineer engineerView = new frmEngineer(null, false);
                engineerView.setVisible(true);
                view.dispose();  // Fecha a janela principal de login
                break;

            case "admin":
                //JOptionPane.showMessageDialog(mainView, "Redirecionando para a interface de Administrador.");
                frmAdmin adminView = new frmAdmin();
                adminView.setVisible(true);
                view.dispose();  // Fecha a janela principal de login
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
