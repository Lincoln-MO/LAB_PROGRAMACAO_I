package com.mycompany.projetoarquitetonico.DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yurit
 */
public abstract class GenericDAO {
    public abstract void save();
    public abstract Object load(Object obj);
    public abstract void update(Object obj);
    public abstract void delete(Object obj);
    //Object find(Object obj);
    public abstract Object findAll();
}
