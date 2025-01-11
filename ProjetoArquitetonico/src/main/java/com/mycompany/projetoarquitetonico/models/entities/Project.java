package com.mycompany.projetoarquitetonico.models.entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 *
 * @author tainope
 */
public class Project {
    private int id;
    private String name;
    private String startDate;
    private Account responsible;
    private Terrain terrain;
    private String expenseTableString;
    private byte[] model3DData = null;
    private String model3DFilePath = null;
    
    
    public Project(){
        this.id = -1;
        this.name = "";
        this.startDate = "";
        this.responsible = null;
        this.terrain = null;
        this.expenseTableString = "";
        this.model3DData = null;
        this.model3DFilePath = null;
    }

    
    public boolean has3DModel(){
        return this.model3DFilePath != null;
    }
    
    
    public Integer getId() {
        return id;
    }
    

    public void setId(Integer id) {
        this.id = id;
    }
    

    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }
    

    public String getStartDate() {
        return startDate;
    }
    

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    

    public Account getResponsible() {
        return responsible;
    }
    

    public void setResponsible(Account responsible) {
        this.responsible = responsible;
    }
    

    public Terrain getTerrain() {
        return terrain;
    }
    

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    
    public String getExpenseTableString() {
        return expenseTableString;
    }

    
    public void setExpenseTableString(String expenseTableString) {
        this.expenseTableString = expenseTableString;
    }

    
    public byte[] getModel3DData() {
        return model3DData;
    }

    
    public void setModel3DData(byte[] model3DData) {
        this.model3DData = model3DData;
    }
    

    public String getModel3DFilePath() {
        return model3DFilePath;
    }

    
    public void setModel3DFilePath(String model3DFileName) {
        this.model3DFilePath = model3DFileName;
    }

    
    public void set3DModelFromFile(String filePath) {
        File file = new File(filePath);
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] fileData = new byte[(int) file.length()];
            fileInputStream.read(fileData);

            this.setModel3DData(fileData);
            this.setModel3DFilePath(filePath);

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    
    public String exportTemp3DModel() {
        String path = System.getProperty("user.dir") + "\\TEMP.obj";
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(path);
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(this.getModel3DData());
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }
        return path;
    }
}
