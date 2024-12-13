package com.mycompany.projetoarquitetonico.Controllers;

import com.mycompany.projetoarquitetonico.DAO.AccountDAO;
import com.mycompany.projetoarquitetonico.DAO.AdminAccountDAO;
import com.mycompany.projetoarquitetonico.forms.frmClient;
import com.mycompany.projetoarquitetonico.forms.frmEngineer;
import com.mycompany.projetoarquitetonico.forms.frmAdmin;
import com.mycompany.projetoarquitetonico.forms.frmLogin;
import javax.swing.JOptionPane;

public class LoginController {
    private final frmLogin mainView;
    private String selectedAccountType = null; // Armazena o tipo de conta selecionado
    private AccountDAO accountDao = new AccountDAO();
    

    public LoginController(frmLogin mainView) {
        this.mainView = mainView;
        initializeActions();
    }

    // Inicializa os listeners da interface principal
    private void initializeActions() {
        //??????????????
        //mainView.getBtnSubmit().addActionListener(e -> handleSubmit());
    }

    // Método para processar o botão "Entrar"
    public void handleSubmit() {
        String login = mainView.getTxtLogin().getText().trim();
        System.out.println("Login attempt");
        String password = new String(mainView.getTxtPassword().getPassword()); 
        
        JOptionPane.showMessageDialog(mainView, "Login: " + login + "\nPassword: " + password);
        accountDao.find(login, password, "admin");
        
        AdminAccountDAO acc = new AdminAccountDAO();
        acc.setLogin(login);
        acc.setPassword(password);
        acc.save();
        
        
        
        
        
        /*
        
        if (selectedAccountType == null) {
            JOptionPane.showMessageDialog(mainView, "Selecione um tipo de conta.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (login.isEmpty() || login.isEmpty()) {
            JOptionPane.showMessageDialog(mainView, "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!isCPFValid(login)) {
            JOptionPane.showMessageDialog(mainView, "CPF inválido! Insira no formato XXX.XXX.XXX-XX", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (validateLogin(login, password, selectedAccountType)) {
            JOptionPane.showMessageDialog(mainView, "Login bem-sucedido!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            redirectUser(selectedAccountType, login);
        } else {
            JOptionPane.showMessageDialog(mainView, "CPF ou senha inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        */
    }

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

    // Valida o formato do CPF
    private boolean isCPFValid(String cpf) {
        return cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
    }

    // Simula a validação no banco de dados (substitua pela lógica real)
    private boolean validateLogin(String cpf, String senha, String tipoConta) {
        // Aqui você pode implementar a lógica de validação real
        return true; // Simulação: login sempre válido
    }

    // Redireciona o usuário com base no tipo de conta
    private void redirectUser(String tipoConta, String cpf) {
        switch (tipoConta) {
            case "Cliente":
                frmClient clientView = new frmClient();
                clientView.setVisible(true);
                clientView.getTxtLoginName().setText("Logado como: " + cpf);
                mainView.dispose();  // Fecha a janela principal de login
                break;

            case "Engenheiro":
                JOptionPane.showMessageDialog(mainView, "Redirecionando para a interface de Engenheiro.");
                frmEngineer engineerView = new frmEngineer();
                engineerView.setVisible(true);
                mainView.dispose();  // Fecha a janela principal de login
                break;

            case "Administrador":
                JOptionPane.showMessageDialog(mainView, "Redirecionando para a interface de Administrador.");
                frmAdmin adminView = new frmAdmin();
                adminView.setVisible(true);
                mainView.dispose();  // Fecha a janela principal de login
                break;

            default:
                JOptionPane.showMessageDialog(mainView, "Tipo de conta desconhecido.", "Erro", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }
}
