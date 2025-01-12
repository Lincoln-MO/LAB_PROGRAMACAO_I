package com.mycompany.projetoarquitetonico.utils;


import java.io.IOException;


/**
 *
 * @author yurit
 */
public class View3DModel {
    // path to software used for viewing the 3D model
    private static final String viewerPath = System.getProperty("user.dir") + 
            "\\src\\main\\java\\com\\mycompany\\projetoarquitetonico\\OMV\\viewer.exe";

    
    // no penguin support
    public static void openFromFile(String filePath){
        String command = String.format("%s %s", viewerPath, filePath);
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException ex) {
        }
    }
}
