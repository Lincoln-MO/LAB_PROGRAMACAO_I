/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.models;

import javax.persistence.Entity;

/**
 *
 * @author tainope
 */

public class Account {
    private String name;
    private String cpf;
    private String password = "";
    private String birthDate;
    private String sex;
    private boolean isClient;
    private boolean isEngineer;
    private boolean isAdmin;    
    private boolean isActive;
    
    public Account() {
        this.name = "";
        this.cpf = "";
        this.birthDate = "";
        this.sex = "";
        this.password = "";
    }
    
    public Account(String name, String cpf, String birthDate, String sex, String password) {
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.sex = sex;
        this.password = password;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the birthDate
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the isClient
     */
    public boolean isClient() {
        return isClient;
    }

    /**
     * @param isClient the isClient to set
     */
    public void setIsClient(boolean isClient) {
        this.isClient = isClient;
    }

    /**
     * @return the isEngineer
     */
    public boolean isEngineer() {
        return isEngineer;
    }

    /**
     * @param isEngineer the isEngineer to set
     */
    public void setIsEngineer(boolean isEngineer) {
        this.isEngineer = isEngineer;
    }

    /**
     * @return the isAdmin
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * @param isAdmin the isAdmin to set
     */
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * @return the isActive
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    
}
