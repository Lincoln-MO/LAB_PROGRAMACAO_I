package com.mycompany.projetoarquitetonico.models.DAO;


import com.mycompany.projetoarquitetonico.models.entities.Terrain;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


/**
 *
 * @author yurit
 */
@Entity(name = "terrain")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TerrainDAO{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private AccountDAO owner;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String area;
    
    @Column(nullable = false)
    private String location;

    
    public TerrainDAO(){
    }
    
    
    public TerrainDAO(Terrain terrain){
        if(terrain.getId() >= 0) this.id = terrain.getId();
        this.name = terrain.getName();
        this.area = terrain.getArea();
        this.location = terrain.getLocation();
        this.owner = new AccountDAO( terrain.getOwner() );
    }
    
    
    public static Terrain findById(int id) throws ConnectionException{
        return Connection.getEntityManager().find(TerrainDAO.class, id).toTerrain();
    }
    
    
    public static void save(Terrain terrain) throws ConnectionException{
        TerrainDAO terr = new TerrainDAO(terrain);
        
        Connection.beginTransaction();

        // makes the terrain.owner persistent 
        AccountDAO accDAO = AccountDAO.getPersistentById(terr.getOwner().getId());
        terr.setOwner(accDAO);
        
        Connection.persist(terr);

        Connection.commitTransaction();
        System.out.println("Persist");
    }
    
    
    public static List<Terrain> search(String search) throws ConnectionException{
        List<TerrainDAO> queryResult;
        List<Terrain> result = new ArrayList<>();
        
        
        Connection.beginTransaction();
        
        String sql = "SELECT terrain FROM terrain terrain WHERE "+
                "(name LIKE :name or location LIKE :location)";

        Query query = Connection.getEntityManager().createQuery(sql);
        query.setParameter("name", (search + "%"));   // "%" for the LIKE operator
        query.setParameter("location", (search + "%"));
        
        queryResult = query.getResultList();
        
        Connection.commitTransaction();
        
        for( TerrainDAO dao : queryResult ){
            result.add( dao.toTerrain() );
        }
        
        return result;
    }
    
    
    public static List<TerrainDAO> FindByOwner(AccountDAO owner) throws ConnectionException{
        List<TerrainDAO> result;
        
        String sql = "SELECT terrain FROM terrain terrain WHERE "+
                "(owner_id = :id)";

        Connection.beginTransaction();
        
        Query query = Connection.getEntityManager().createQuery(sql);
        query.setParameter("id", owner.getId());
        
        result = query.getResultList();
        
        Connection.commitTransaction();
        
        return result;
    }
    
    
    public Terrain toTerrain(){
        Terrain result = new Terrain();
        
        result.setId(id);
        result.setName(name);
        result.setOwner(owner.toAccount() );
        result.setArea(area);
        result.setLocation(location);
        
        return result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AccountDAO getOwner() {
        return owner;
    }

    public void setOwner(AccountDAO owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
