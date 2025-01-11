package com.mycompany.projetoarquitetonico.models.DAO;


import com.mycompany.projetoarquitetonico.models.entities.Account;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


/**
 *
 * @author yurit
 */
@Entity(name = "account")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AccountDAO{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(unique = true, nullable = false)
    private String cpf;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String password = "";
    
    @Column(nullable = false)
    private String birthDate;
    
    @Column(nullable = false)
    private String sex;
    
    @Column(nullable = false)
    private boolean isActive;
    
    @Column(nullable = false)
    private boolean isClient;
    
    @Column(nullable = false)
    private boolean isEngineer;
    
    @Column(nullable = false)
    private boolean isAdmin;
    
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TerrainDAO> terrains;
    
    
    public AccountDAO(){
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
    }
    
    
    public AccountDAO(Account account){
        if(account.getId() >= 0) this.id = account.getId();
        this.name = account.getName();
        this.cpf = account.getCpf();
        this.email = account.getEmail();
        this.birthDate = account.getBirthDate();
        this.sex = account.getSex();
        this.password = account.getPassword();
        this.isClient = account.isClient();
        this.isEngineer = account.isEngineer();
        this.isAdmin = account.isAdmin();
        this.isActive = account.isActive();
        this.terrains = account.getTerrains();
    }
    
    
    public static void makeInactive(Account acc){
        acc.setActive(false);
        
        AccountDAO dao = new AccountDAO(acc);
        
        Connection.beginTransaction();
        Connection.merge(dao);
        Connection.commitTransaction();
    }
    
    
    public static void makeActive(Account acc){
        acc.setActive(true);
        
        AccountDAO dao = new AccountDAO(acc);
        
        Connection.beginTransaction();
        Connection.merge(dao);
        Connection.commitTransaction();
    }
    
    
    public Account toAccount(){
        Account result = new Account();
        
        if( this.id != null ) result.setId(this.id);
        result.setName(this.name);
        result.setCpf(this.cpf);
        result.setEmail(this.email);
        result.setPassword(this.password);
        result.setBirthDate(this.birthDate);
        result.setSex(this.sex);
        result.setActive(this.isActive);
        result.setClientAccess(this.isClient);
        result.setEngineerAccess(this.isEngineer);
        result.setAdminAccess(this.isAdmin);
        
        return result;
    }
    
    
    public static Account find(String cpf, String password){
        List<AccountDAO> result;
        
        Connection.beginTransaction();

        String sql = "SELECT account FROM account account WHERE cpf = :cpf and password = :passw";
        Query query = Connection.getEntityManager().createQuery(sql);
        query.setParameter("cpf", cpf);
        query.setParameter("passw", password);

        result = query.getResultList();
        
        Connection.commitTransaction();
        
        if( !result.isEmpty() ){
            return result.get(0).toAccount();
        }else{
            return null;
        }
    }
    
    
    public static List<Account> findAllByName(String name){
        List<AccountDAO> queryResult;
        List<Account> result = new ArrayList<Account>();
        
        Connection.beginTransaction();
        
        String sql = "SELECT account FROM account account WHERE name LIKE :name";
        Query query = Connection.getEntityManager().createQuery(sql);
        query.setParameter("name", (name + "%")); // "%" for the LIKE operator
        
        queryResult = query.getResultList();
        
        Connection.commitTransaction();
        
        for( AccountDAO dao : queryResult ){
            result.add( dao.toAccount() );
        }
        
        return result;
    }
    
    
    public static List<Account> findAllByCPF(String cpf){
        List<AccountDAO> queryResult;
        List<Account> result = new ArrayList<Account>();
        
        Connection.beginTransaction();
        
        String sql = "SELECT account FROM account account WHERE cpf LIKE :cpf";
        Query query = Connection.getEntityManager().createQuery(sql);
        query.setParameter("cpf", (cpf + "%")); // "%" for the LIKE operator
        
        queryResult = query.getResultList();
        
        Connection.commitTransaction();
        
        for( AccountDAO dao : queryResult ){
            result.add( dao.toAccount() );
        }
        
        return result;
    }
    
    
    public static List<Account> findAllByNameOrCPF(String search){
        List<AccountDAO> queryResult;
        List<Account> result = new ArrayList<Account>();
        
        Connection.beginTransaction();
        
        String sql = "SELECT account FROM account account WHERE (name LIKE :name or cpf LIKE :cpf)";
        Query query = Connection.getEntityManager().createQuery(sql);
        query.setParameter("name", (search + "%")); // "%" for the LIKE operator
        query.setParameter("cpf", (search + "%"));  // "%" for the LIKE operator
        
        queryResult = query.getResultList();
        
        Connection.commitTransaction();
        
        for( AccountDAO dao : queryResult ){
            result.add( dao.toAccount() );
        }
        
        return result;
    }
    
    
    public static List<Account> findAllByNameOrCPF(String search, String accountType){
        List<AccountDAO> queryResult;
        List<Account> result = new ArrayList<>();
        
        Connection.beginTransaction();
        
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
        
        queryResult = query.getResultList();
        
        Connection.commitTransaction();
        
        for( AccountDAO dao : queryResult ){
            result.add( dao.toAccount() );
        }
        
        return result;
    }
    
    
    public static Account findByCPF(String cpf){
        Connection.beginTransaction();
        
        String sql = "SELECT account FROM account account WHERE cpf = :cpf";
        Query query = Connection.getEntityManager().createQuery(sql);
        query.setParameter("cpf", cpf);
        
        List<AccountDAO> result = query.getResultList();

        Connection.commitTransaction();
        
        if( !result.isEmpty() ){
            return result.get(0).toAccount();
        }else{
            return null;
        }
    }
    
    
    public static Account findById(int id){
        Connection.beginTransaction();
        Account result = getPersistentById(id).toAccount();
        Connection.commitTransaction();
        
        return result;
    }
    
    
    public static AccountDAO getPersistentById(int id){
        //Connection.beginTransaction();
        
        String sql = "SELECT account FROM account account WHERE id = :id";
        Query query = Connection.getEntityManager().createQuery(sql);
        query.setParameter("id",  id);
        
        List<AccountDAO> result = query.getResultList();
        
        //  Connection.commitTransaction();
        
        if( !result.isEmpty() ){
            return result.get(0);
        }else{
            return null;
        }
    }

    
    public static void save(Account account){
        AccountDAO dao = new AccountDAO(account);
        
        Connection.beginTransaction();
        
        Connection.persist( dao );
        
        Connection.commitTransaction();
        
        System.out.println("Persist");
    }
    
    
    public static void update(Account account){
        Connection.beginTransaction();
        
        Connection.merge(new AccountDAO(account) );
        
        Connection.commitTransaction();
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

    
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    
    public boolean isClient() {
        return isClient;
    }

    
    public void setClientAccess(boolean isClient) {
        this.isClient = isClient;
    }

    
    public boolean isEngineer() {
        return isEngineer;
    }

    
    public void setEngineerAccess(boolean isEngineer) {
        this.isEngineer = isEngineer;
    }

    
    public boolean isAdmin() {
        return isAdmin;
    }

    
    public void setAdminAccess(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    
    public List<TerrainDAO> getTerrains() {
        return terrains;
    }

    
    public void setTerrains(List<TerrainDAO> terrains) {
        this.terrains = terrains;
    }
}
