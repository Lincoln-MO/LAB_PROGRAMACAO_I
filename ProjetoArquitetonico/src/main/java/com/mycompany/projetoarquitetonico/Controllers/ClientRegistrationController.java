package com.mycompany.projetoarquitetonico.Controllers;


import com.mycompany.projetoarquitetonico.DAO.AccountDAO;
import com.mycompany.projetoarquitetonico.forms.frmClientRegistration;
import com.mycompany.projetoarquitetonico.models.Account;
import com.mycompany.projetoarquitetonico.utils.Validation;


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
        String name = view.getNameText();
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
        
        if( !Validation.isCpfValid( cpf ) ){
            view.showError("CPf inválido", "cpf");
            return;
        }
        
        if( !Validation.isDateValid( birthDate ) ){
            view.showError("Data inválida", "birthDate");
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
        // Form validation end
        
        
        Account acc = new Account();
        acc.setName(name);
        acc.setCpf(cpf);
        acc.setBirthDate(birthDate);
        acc.setPassword(password);
        acc.setSex(sex);
        acc.setIsClient(true);
        acc.setIsActive(true);
        
        AccountDAO.save(acc);
    }
}
