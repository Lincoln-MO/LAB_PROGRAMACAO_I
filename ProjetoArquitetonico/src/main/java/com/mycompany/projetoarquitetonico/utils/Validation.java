package com.mycompany.projetoarquitetonico.utils;


import java.time.LocalDateTime;


/**
 *
 * @author yurit e lincoln
 */
public class Validation {
    
    // Validação de CPF
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
        // password is valid if it doesn't start or finish with spaces
        return !password.matches("^ | .* $");
    }
    
    
    public static boolean isNameValid(String name){
        // name is valid if it doesnt start or finish with spaces,
        // and contains only letters
        return name.matches("^[A-Za-z]+(?: [A-Za-z]+)*$");
    }
    
    
    public static boolean isAddressValid(String addr){
        if( addr.equals("") ) return false;
        // looks similar enough
        return isPasswordValid(addr);
    }
    
    
    /*
    This date validation method is the type of shit some dumbass could implement
    in a very important system without anybody fucking noticing, until the whole
    system is down and the company looses millions by a god damn "31 of february"
    */
    public static boolean isDateValid(String date){
System.out.println(date);
        if( !date.matches("\\d{2}/\\d{2}/\\d{4}") ) return false;

        System.out.println("date test");
        
        String[] strDateSplit = date.split("/");
        int day = Integer.parseInt( strDateSplit[0] );
        int month = Integer.parseInt( strDateSplit[1] );
        int year = Integer.parseInt( strDateSplit[2] );
        
        if( day <= 0    || day > 31) return false;
        if( month <= 0  || month > 12) return false;
        if( year < 1000 || year > 9999) return false;
        
        return true;
    }
    
    
    public static boolean isBirthDateValid(String date){
        if( !isDateValid(date) ) return false;
        
        LocalDateTime now = LocalDateTime.now();
        String[] strDateSplit = date.split("/");
        int day = Integer.parseInt( strDateSplit[0] );
        int month = Integer.parseInt( strDateSplit[1] );
        int year = Integer.parseInt( strDateSplit[2] );
        
        if( year < now.getYear() ) return true;
        if( year > now.getYear() ) return false;
        if( year == now.getYear() ){
            if( month > now.getMonthValue() ) return false;
            if( month < now.getMonthValue() ) return true;
            if( month == now.getMonthValue() ){
                if( day > now.getDayOfMonth() ) return false;
            }
        }
        
        return true;
    }
    
    
    public static boolean isFloat(String arg){
        return arg.matches("^\\d*\\.\\d+$");
    }
    
    // Validação de registro (consulta ao banco de dados ou outros critérios)
    public static boolean isRegisterValid(String cpf){
        if (cpf == null || cpf.trim().isEmpty()) {
            return false;
        }
        
        // Aqui você pode adicionar lógica para verificar se o CPF já está cadastrado
        // Exemplo de consulta no banco de dados:
        // return AccountDAO.isUserRegistered(cpf);

        // Em caso de erro na consulta, retorna falso
        return true; // Apenas para teste, ajuste conforme necessidade
    }
}
