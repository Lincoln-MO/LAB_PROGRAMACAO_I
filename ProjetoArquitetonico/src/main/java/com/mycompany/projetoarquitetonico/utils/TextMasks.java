package com.mycompany.projetoarquitetonico.utils;


import java.text.NumberFormat;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;


/**
 *
 * @author yurit
 */
public class TextMasks {
    public static void installCPFMask(JFormattedTextField txtField){
        MaskFormatter mask;
        try {
            mask = new MaskFormatter("###'.###'.###'-##");
            mask.setPlaceholderCharacter('X');
            mask.install( txtField );
        } catch (ParseException ex) {
            System.out.println(ex.toString());
        }
    }
    
    
    public static void installDateMask(JFormattedTextField txtField){
        MaskFormatter mask;
        try {
            mask = new MaskFormatter("##'/##'/####");
            mask.setPlaceholderCharacter('-');
            mask.install( txtField );
        } catch (ParseException ex) {
            System.out.println(ex.toString());
        }
    }
    
    
    public static void installFloatMask(JFormattedTextField txtField){
        /*
        MaskFormatter mask;
        try {
            mask = new MaskFormatter("");
            mask.setPlaceholder("");
            mask.install( txtField );
        } catch (ParseException ex) {
            System.out.println(ex.toString());
        }
        */
    }
}
