/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoarquitetonico.models;

/**
 *
 * @author tainope
 */
public class Account {

    /**
     * @return the accessLevel
     */
    public String getAccessLevel() {
        return accessLevel;
    }

    /**
     * @param accessLevel the accessLevel to set
     */
    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }
    private String name;
    private String cpf;
    private String password = "";
    private String birthDate;
    private String sex;
    private String accessLevel;
    
    public Account() {
        this.name = "";
        this.cpf = "";
        this.birthDate = "";
        this.sex = "";
        this.password = "";
        this.accessLevel = "";
    }
    
    public Account(String name, String cpf, String birthDate, String sex, String password, String accessLevel) {
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.sex = sex;
        this.password = password;
        this.accessLevel = accessLevel;
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
     * @return the accessLevel
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param accessLevel the accessLevel to set
     */
    public void setPassword(String accessLevel) {
        this.password = accessLevel;
    }
    
    
}
