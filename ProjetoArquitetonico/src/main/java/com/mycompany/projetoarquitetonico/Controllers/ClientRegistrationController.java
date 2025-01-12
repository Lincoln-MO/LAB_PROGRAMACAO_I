package com.mycompany.projetoarquitetonico.Controllers;


import com.mycompany.projetoarquitetonico.models.DAO.AccountDAO;
import com.mycompany.projetoarquitetonico.forms.frmClientRegistration;
import com.mycompany.projetoarquitetonico.models.DAO.ConnectionException;
import com.mycompany.projetoarquitetonico.models.entities.Account;
import com.mycompany.projetoarquitetonico.utils.Validation;
import javax.swing.JOptionPane;


/**
 *
 * @author lincoln
 */
public class ClientRegistrationController {
    private frmClientRegistration view;

    
    public ClientRegistrationController(frmClientRegistration view) {
        this.view = view;
    }
    

    public ClientRegistrationController() {
        
    }

    
    public void handleSubmit(){
        try{
            view.hideErrorMessage();

            String name = view.getNameText();
            String email = view.getEmailText();
            String cpf = view.getCPFText();
            String birthDate = view.getBirthDateText();
            String password = view.getPasswordText();
            String sex = null;
            if( view.isMasculineSelected() ){
                sex = "m";
            }else if( view.isFeminineSelected() ){
                sex = "f";
            }

            // Form validation stat
            if( !Validation.isNameValid( name ) ){
                view.showError("Nome inválido", "name");
                return;
            }

            if( !Validation.isEmailValid( email )){
                view.showError("Email inválido", "email");
                return;
            }

            if( !Validation.isCpfValid( cpf ) ){
                view.showError("CPf inválido", "cpf");
                return;
            }

            if( !Validation.isBirthDateValid( birthDate ) ){
                view.showError("Data inválida", "date");
                return;
            }

            if( !Validation.isPasswordValid( password ) ){
                view.showError("Senha inválido", "password");
                return;
            }

            if( sex == null ){
                view.showError("Selecione um sexo", "sex");
                return;
            }

            if( !AccountDAO.findAllByCPF(cpf).isEmpty() ){
                view.showError("CPF indisponível", "cpf");
                return;
            }
            // Form validation end


            Account acc = new Account();
            acc.setName(name);
            acc.setCpf(cpf);
            acc.setBirthDate(birthDate);
            acc.setPassword(password);
            acc.setSex(sex);
            acc.setEmail(email);
            acc.setClientAccess(true);
            acc.setActive(true);

            AccountDAO.save(acc);

            JOptionPane.showMessageDialog(view, "Cliente cadastrado.");
            view.clearForm();
        }catch (ConnectionException e){
            JOptionPane.showMessageDialog(view, "Ocorreu um erro.");
        }
    }
}
