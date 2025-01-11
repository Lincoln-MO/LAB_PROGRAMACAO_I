package com.mycompany.projetoarquitetonico.utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;


/**
 *
 * @author yurit
 */
public class Validation {
    public static boolean isCpfValid(String cpf){
        if( !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}") ) return false;
        
        int sum;
        int firstVerificationDigit;
        int lastVerificationDigit;
        
        // remove non-digit characters
        cpf = cpf.replaceAll("[^\\d]", "");
        
        firstVerificationDigit = Integer.parseInt( String.valueOf(cpf.charAt(9)) );
        lastVerificationDigit = Integer.parseInt( String.valueOf(cpf.charAt(10)) );
        
        // verifies the first verification digit
        sum = 0;
        for(int i = 0; i < 9; i++){
            int digit = Integer.parseInt( String.valueOf(cpf.charAt(i)) );
            sum += digit * (10 - i);
        }
        if( (sum*10) % 11 != firstVerificationDigit ) return false;
        
        // verifies the second verification digit
        sum = 0;
        for(int i = 0; i < 10; i++){
            int digit = Integer.parseInt( String.valueOf(cpf.charAt(i)) );
            sum += digit * (11 - i);
        }
        return (sum*10) % 11 == lastVerificationDigit;
    }
    
    
    public static boolean isPasswordValid(String password){
        // password is valid if it doesn't start or finish with spaces
        if( password.equals("") ) return false;
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
    
    
    public static boolean isEmailValid(String email){
        return email.matches("[A-Za-z0-9._]*+\\@[A-Za-z0-9]*+\\.[A-Za-z0-9]*");
    }
    
    
    public static boolean isDateValid(String date){
        if( !date.matches("\\d{2}/\\d{2}/\\d{4}") ) return false;

        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    
    
    public static boolean isBirthDateValid(String date){
        if( !isDateValid(date) ) return false;
        
        LocalDateTime now = LocalDateTime.now();
        String[] strDateSplit = date.split("/");
        int day = Integer.parseInt( strDateSplit[0] );
        int month = Integer.parseInt( strDateSplit[1] );
        int year = Integer.parseInt( strDateSplit[2] );
        
        if( year < now.getYear() -1 ) return true;
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
}
