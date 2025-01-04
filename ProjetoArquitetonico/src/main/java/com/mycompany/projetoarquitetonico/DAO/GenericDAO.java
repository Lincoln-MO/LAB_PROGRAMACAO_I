package com.mycompany.projetoarquitetonico.DAO;


/**
 *
 * @author yurit
 */
public abstract class GenericDAO {
    public abstract void save();
    public abstract Object load(Object obj);
    public abstract void update(Object obj);
    public abstract void delete(Object obj);
    public abstract Object findAll();
}
