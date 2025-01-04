package com.mycompany.projetoarquitetonico.utils;

import com.mycompany.projetoarquitetonico.DAO.Connection;
import javax.persistence.Query;


/**
 *
 * @author yurit
 */
public class Validation {
    public static boolean isCpfValid(String cpf){
  
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^\\d]", "");

        // Verifica se o CPF possui 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais (ex: 111.111.111-11), o que é inválido
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            // Valida os dígitos verificadores
            int soma = 0;
            int peso = 10;
            for (int i = 0; i < 9; i++) {
                soma += (cpf.charAt(i) - '0') * peso--;
            }
            int primeiroDigito = 11 - (soma % 11);
            if (primeiroDigito > 9) {
                primeiroDigito = 0;
            }

            if (primeiroDigito != cpf.charAt(9) - '0') {
                return false;
            }

            soma = 0;
            peso = 11;
            for (int i = 0; i < 10; i++) {
                soma += (cpf.charAt(i) - '0') * peso--;
            }
            int segundoDigito = 11 - (soma % 11);
            if (segundoDigito > 9) {
                segundoDigito = 0;
            }

            return segundoDigito == cpf.charAt(10) - '0';
        } catch (Exception e) {
            return false;
        }
    }
  
    
    public static boolean isPasswordValid(String password){
        return !password.equals("");
    }
    
    
    public static boolean isProjectNameValid(String name){
        return !name.equals("");
    }
    
    
    public static boolean isDateValid(String date){
        return !date.equals("");
    }
    
    
    public static boolean isNameValid(String name){
        return !name.equals("");
    }  
    
    /**
    * Verifica se o usuário já está cadastrado no banco de dados pelo CPF.
    * @param cpf CPF do usuário.
    * @return true se o usuário já existe, false caso contrário.
    */
    public static boolean isRegisterValid(String cpf){
        String sql = "SELECT COUNT(account) FROM account account WHERE cpf = :cpf";
        Query query = Connection.getEntityManager().createQuery(sql);
        query.setParameter("cpf", cpf);

        Long count = (Long) query.getSingleResult();
        return count > 0; // Retorna true se o número de registros for maior que zero
    }
}
