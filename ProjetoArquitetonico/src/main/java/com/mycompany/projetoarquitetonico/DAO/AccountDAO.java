package com.mycompany.projetoarquitetonico.DAO;

import com.mycompany.projetoarquitetonico.models.Account;
import java.util.List;
import javax.persistence.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yurit e lincoln
 */

@Entity(name = "account")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AccountDAO extends GenericDAO{
    // Identificador único da conta
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    // Atributos básicos da conta
    private Integer id;
    protected String name;
    protected String cpf;
    protected String password = "";
    protected String birthDate;
    protected String sex;
    protected boolean isActive;
    protected boolean isClient;
    protected boolean isEngineer;
    protected boolean isAdmin;
    
     // Lista de terrenos associados à conta
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TerrainDAO> terains;
    
    /**
     * Construtor padrão que inicializa os atributos com valores padrão.
     */
    public AccountDAO(){
        this.name = "";
        this.cpf = "";
        this.birthDate = "";
        this.sex = "";
        this.password = "";
        this.isClient = false;
        this.isEngineer = false;
        this.isAdmin = false;
        this.isActive = true;
    }
    
    /**
     * Construtor que inicializa os atributos com base em um objeto Account.
     * @param account Objeto Account com dados para inicialização.
     */
    public AccountDAO(Account account){
        this.name = account.getName();
        this.cpf = account.getCpf();
        this.birthDate = account.getBirthDate();
        this.sex = account.getSex();
        this.password = account.getPassword();
        this.isClient = account.isClient();
        this.isEngineer = account.isEngineer();
        this.isAdmin = account.isAdmin();
        this.isActive = account.isActive();
    }
    
    // GenericDAO interface implementation

     /**
     * Método para carregar uma conta específica.
     * @param obj Objeto para carregamento.
     * @return AccountDAO
     */
    public AccountDAO load(Object obj){
        System.out.println("Loading account...");
        return null;
    }
    
    /**
     * Atualiza uma conta específica.
     * @param obj Objeto para atualização.
     */
    public void update(Object obj){}
    
     /**
     * Exclui uma conta específica.
     * @param obj Objeto para exclusão.
     */
    public void delete(Object obj){}
    
     /**
     * Busca uma conta pelo CPF e senha.
     * @param cpf CPF da conta.
     * @param password Senha da conta.
     * @return AccountDAO correspondente ou null se não encontrada.
     */
    public static AccountDAO find(String cpf, String password){
        String sql = "SELECT account FROM account account WHERE cpf = :cpf and password = :passw";
        Query query = Connection.getEntityManager().createQuery(sql);
        query.setParameter("cpf", cpf);
        query.setParameter("passw", password);
        
        List<AccountDAO> result = query.getResultList();

        if( !result.isEmpty() ){
            return result.get(0);
        }else{
            return null;
        }
    }
    
     /**
     * Busca contas pelo nome.
     * @param name Nome da conta.
     * @return Lista de contas encontradas.
     */
    public static List<AccountDAO> findAllByName(String name){
        String sql = "SELECT account FROM account account WHERE name LIKE :name";
        Query query = Connection.getEntityManager().createQuery(sql);
        query.setParameter("name", (name + "%")); // "%" for the LIKE operator
        
        List<AccountDAO> result = query.getResultList();

        return result;
    }
    
     /**
     * Busca contas pelo CPF.
     * @param cpf CPF parcial ou completo.
     * @return Lista de contas encontradas.
     */
    public static List<AccountDAO> findAllByCPF(String cpf){
        String sql = "SELECT account FROM account account WHERE cpf LIKE :cpf";
        Query query = Connection.getEntityManager().createQuery(sql);
        query.setParameter("cpf", (cpf + "%")); // "%" for the LIKE operator

        return query.getResultList();
    }
    
    /**
     * Busca contas pelo nome ou CPF.
     * @param search Texto de busca.
     * @return Lista de contas encontradas.
     */
    public static List<AccountDAO> findAllByNameOrCPF(String search){
        String sql = "SELECT account FROM account account WHERE (name LIKE :name or cpf LIKE :cpf)";
        Query query = Connection.getEntityManager().createQuery(sql);
        query.setParameter("name", (search + "%")); // "%" for the LIKE operator
        query.setParameter("cpf", (search + "%"));  // "%" for the LIKE operator

        return query.getResultList();
    }
    
    
    public static List<AccountDAO> findAllByNameOrCPF(String search, String accountType){
        String sql = "SELECT account FROM account account WHERE (name LIKE :name or cpf LIKE :cpf)";
        switch(accountType){
            case "client" ->    sql += "and (isClient = true)";
            case "engineer" ->  sql += "and (isEngineer = true)";
            case "admin" ->     sql += "and (isAdmin = true)";
            case "_ANY" ->{ /* NO EXTRA CODE NEEDED */ }
        }
        
        Query query = Connection.getEntityManager().createQuery(sql);
        query.setParameter("name", (search + "%")); // "%" for the LIKE operator
        query.setParameter("cpf", (search + "%"));
        
        return query.getResultList();
    }
    
    /**
     * Define o CPF da conta.
     * @param cpf Novo CPF.
     */
    public static AccountDAO findByCPF(String cpf){
        String sql = "SELECT account FROM account account WHERE cpf = :cpf";
        Query query = Connection.getEntityManager().createQuery(sql);
        query.setParameter("cpf", cpf);
        
        List<AccountDAO> result = query.getResultList();

        if( !result.isEmpty() ){
            return result.get(0);
        }else{
            return null;
        }
    }
    
    
    public static AccountDAO findById(int id){
        String sql = "SELECT account FROM account account WHERE id = :id";
        Query query = Connection.getEntityManager().createQuery(sql);
        query.setParameter("id",  id);
        
        List<AccountDAO> result = query.getResultList();

        if( !result.isEmpty() ){
            return result.get(0);
        }else{
            return null;
        }
    }

    /**
     * Define a senha da conta.
     * @param password Nova senha.
     */
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public void setPassword(String password){
        this.password = password;
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
    
    public boolean isClient(){
        return this.isClient;
    }
    
    public boolean isEngineer(){
        return this.isEngineer;
    }

    public boolean isAdmin(){
        return this.isAdmin;
    }
    
    /**
     * Salva os dados de uma nova conta no banco de dados.
     * @param account Conta a ser salva.
     */
    public static void save(Account account){
        Connection.openConnection();
        Connection.beginTransaction();
        Connection.persist(new AccountDAO(account));
        Connection.commitTransaction();
        Connection.closeConnection();
        System.out.println("Persist");
    }
    
    @Override
    public void save() {
        
    }
    
    /**
     * Retorna o ID da conta.
     * @return ID da conta.
     */
    public int getID(){
        return this.getId();
    }

    @Override
    public Object findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Retorna o nome da conta.
     * @return Nome da conta.
     */
    public String getName() {
        return name;
    }

    /**
     * Retorna o CPF da conta.
     * @return CPF da conta.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @return the terains
     */
    public List<TerrainDAO> getTerains() {
        return terains;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
}
