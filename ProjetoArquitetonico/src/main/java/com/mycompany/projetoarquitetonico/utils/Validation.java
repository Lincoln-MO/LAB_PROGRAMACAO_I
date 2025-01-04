package com.mycompany.projetoarquitetonico.utils;


import java.time.LocalDateTime;


/**
 *
 * @author yurit
 */
public class Validation {
    public static boolean isCpfValid(String cpf){
        return cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
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
}
