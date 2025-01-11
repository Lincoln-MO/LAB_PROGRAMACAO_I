package com.mycompany.projetoarquitetonico.utils;


/**
 *
 * @author yurit
 */
public class SendEmail {
    public static boolean SendMessage(String title, String message, String target){
        System.out.println("email\n\t" + target + "\n\t" + title + "\n\t" + message);
        return true;
    }
}
