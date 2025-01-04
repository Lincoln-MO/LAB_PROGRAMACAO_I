package com.mycompany.projetoarquitetonico.DAO;


import com.mycompany.projetoarquitetonico.models.Terrain;
import java.util.List;
import javax.persistence.*;


/**
 *
 * @author yurit
 */
@Entity(name = "terrain")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TerrainDAO extends GenericDAO{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AccountDAO owner;
    private String name;
    private String area;
    private String location;

    
    public TerrainDAO(){
    }
    
    
    public TerrainDAO(Terrain terrain){
        this.name = terrain.getName();
        this.area = terrain.getArea();
        this.location = terrain.getLocation();
        this.owner = terrain.getOwner();
    }
    
    
    public static TerrainDAO findById(int id){
        return Connection.getEntityManager().find(TerrainDAO.class, id);
    }
    
    
    public static void save(TerrainDAO terrain){
        Connection.beginTransaction();
        
        // makes the terrain.owner persistent 
        terrain.owner = Connection.getEntityManager().find(AccountDAO.class, terrain.owner.getId());
        
        Connection.persist(terrain);

        Connection.commitTransaction();
        System.out.println("Persist");
    }
    
    
    public static List<TerrainDAO> search(String search){
        List<TerrainDAO> result;
        
        Connection.beginTransaction();
        
        String sql = "SELECT terrain FROM terrain terrain WHERE "+
                "(name LIKE :name or location LIKE :location)";

        Query query = Connection.getEntityManager().createQuery(sql);
        query.setParameter("name", (search + "%"));   // "%" for the LIKE operator
        query.setParameter("location", (search + "%"));
        result = query.getResultList();
        
        Connection.commitTransaction();
        
        return result;
    }
    
    
    public static List<TerrainDAO> FindByOwner(AccountDAO owner){
        String sql = "SELECT terrain FROM terrain terrain WHERE "+
                "(owner_id = id)";

        Query query = Connection.getEntityManager().createQuery(sql);
        query.setParameter("id", owner.getId());
        
        return query.getResultList();
    }
    

    @Override
    public Object load(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

    @Override
    public void update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

    @Override
    public void delete(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

    @Override
    public Object findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    

    /**
     * @return the owner
     */
    public AccountDAO getOwner() {
        return owner;
    }

    
    /**
     * @param owner the owner to set
     */
    public void setOwner(AccountDAO owner) {
        this.owner = owner;
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
     * @return the area
     */
    public String getArea() {
        return area;
    }

    
    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    
    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }
    

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }
    

    int getID() {
        return this.id;
    }
}
