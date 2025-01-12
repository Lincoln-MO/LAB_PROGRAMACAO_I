package com.mycompany.projetoarquitetonico.models.entities;


import com.mycompany.projetoarquitetonico.models.DAO.TerrainDAO;
import java.util.List;


/**
 *
 * @author tainope
 */
public class Account {
    private int id;
    private String name;
    private String cpf;
    private String email;
    private String password = "";
    private String birthDate;
    private String sex;
    private boolean isActive;
    private boolean isClient;
    private boolean isEngineer;
    private boolean isAdmin;
    private List<TerrainDAO> terrains;
    
    
    public Account() {
        this.id = -1;
        this.name = "";
        this.cpf = "";
        this.email = "";
        this.birthDate = "";
        this.sex = "";
        this.password = "";
        this.isClient = false;
        this.isEngineer = false;
        this.isAdmin = false;
        this.isActive = true;
        this.terrains = null;
    }
    
    
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public String getCpf() {
        return cpf;
    }

    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
    public String getEmail() {
        return email;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }

    
    public String getPassword() {
        return password;
    }

   
    public void setPassword(String password) {
        this.password = password;
    }

    
    public String getBirthDate() {
        return birthDate;
    }

   
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    
    public String getSex() {
        return sex;
    }

    
    public void setSex(String sex) {
        this.sex = sex;
    }

    
    public boolean isActive() {
        return isActive;
    }

    
    public void setActive(boolean arg){
        this.isActive = arg;
    }
    
    
    public boolean isClient() {
        return isClient;
    }


    public boolean isEngineer() {
        return isEngineer;
    }

    
    public boolean isAdmin() {
        return isAdmin;
    }

    
    public void setClientAccess(boolean arg){
        this.isClient = arg;
    }
    
    
    public void setEngineerAccess(boolean arg){
        this.isEngineer = arg;
    }
    
    
    public void setAdminAccess(boolean arg){
        this.isAdmin = arg;
    }

    public void makeInactive() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<TerrainDAO> getTerrains() {
        return terrains;
    }

    public void setTerrains(List<TerrainDAO> terrains) {
        this.terrains = terrains;
    }
}
