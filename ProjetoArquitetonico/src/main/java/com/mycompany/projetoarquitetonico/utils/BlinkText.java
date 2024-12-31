package com.mycompany.projetoarquitetonico.utils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 *
 * @author yurit
 */
public class BlinkText {
    public static void blinkLabelRed(JLabel label, int repeat){
        Thread colorChangeThr = new Thread(() -> {
            for( int i = 0; i < repeat; i++){
                int red = 255;

                while( red > 0){
                    label.setForeground( new Color(red, 0, 0) );
                    _Sleep(3);
                    red -= 1;
                }
            } 
        });
        
        colorChangeThr.start();
    }
    
    
    public static void blinkTextFieldRed(JTextField txt, int repeat){
        Thread colorChangeThr = new Thread(() -> {
            for( int i = 0; i < repeat; i++){
                int red = 255;

                while( red > 0){
                    txt.setForeground( new Color(red, 0, 0) );
                    _Sleep(3);
                    red -= 1;
                }
            } 
        });
        
        colorChangeThr.start();
    }
    
    
    /*
    Internal methods
    */
    
    
    private static void _Sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {}
    }
}
