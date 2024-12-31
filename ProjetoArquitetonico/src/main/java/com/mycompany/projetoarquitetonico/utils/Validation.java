package com.mycompany.projetoarquitetonico.utils;


/**
 *
 * @author yurit
 */
public class Validation {
    public static boolean isCpfValid(String cpf){
        return cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
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
}
