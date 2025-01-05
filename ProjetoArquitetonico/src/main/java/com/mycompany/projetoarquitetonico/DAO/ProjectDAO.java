package com.mycompany.projetoarquitetonico.DAO;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Query;


/**
 *
 * @author yurit
 */
@Entity(name = "project")
public class ProjectDAO{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String startDate;
    
    @ManyToOne
    private AccountDAO responsible;
    
    @OneToOne
    private TerrainDAO terrain;
    
    @Column(nullable = true)
    private String expenseTableString;
    
    @Lob
    @Column(nullable = true)
    private byte[] model3DData = null;
    
    @Column(nullable = true)
    private String model3DFileName = null;
    
    
    public static void save(ProjectDAO proj){
        Connection.beginTransaction();
        
        // makes the project.terrain persistent 
        proj.setTerrain(Connection.getEntityManager().find(TerrainDAO.class, proj.getTerrain().getId()));
        // makes the project.responsible persistent 
        proj.setResponsible(Connection.getEntityManager().find(AccountDAO.class, proj.getResponsible().getId()));
        
        Connection.persist(proj);
        Connection.commitTransaction();
        System.out.println("Persist");
    }
    
    
    public static void update(ProjectDAO proj){
        Connection.beginTransaction();
        
        // makes the project.terrain persistent 
        proj.setTerrain(Connection.getEntityManager().find(TerrainDAO.class, proj.getTerrain().getId()));
        // makes the project.responsible persistent
        proj.setResponsible(Connection.getEntityManager().find(AccountDAO.class, proj.getResponsible().getId()));
        
        Connection.merge(proj);
        Connection.commitTransaction();
        System.out.println("Persist");
    }
    
    
    public static ProjectDAO findById(int id){
        ProjectDAO result;
        
        Connection.beginTransaction();
        
        String sql = "SELECT project FROM project project WHERE "+
            "(id = :id)";

        Query query = Connection.getEntityManager().createQuery(sql);
        query.setParameter("id", id);
        result = (ProjectDAO) query.getSingleResult();
        
        return result;
    }
    
    
    public static List<ProjectDAO> findAllByTerrain(TerrainDAO terrain){
        List<ProjectDAO> result;
        
        Connection.beginTransaction();
        
        String sql = "SELECT project FROM project project WHERE "+
            "(terrain_id = :id)";

        Query query = Connection.getEntityManager().createQuery(sql);
        query.setParameter("id", terrain.getID());
        result = query.getResultList();
        
        Connection.commitTransaction();
        
        return result;
    }
    
    
    public static List<ProjectDAO> findAllByUser(AccountDAO account){
        List<ProjectDAO> result = new ArrayList<ProjectDAO>();
        
        // not good
        for( TerrainDAO t : account.getTerains() ){
            for( ProjectDAO p : ProjectDAO.findAllByTerrain(t) ){
                result.add( p );
            }
        }
        
        return result;
    }
    
    
    public void set3DModelFromFile(String filePath){
        File file = new File(filePath);
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] fileData = new byte[(int) file.length()];
            fileInputStream.read(fileData);

            this.model3DData = fileData;
            this.model3DFileName = filePath;

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    
    
    public String exportTemp3DModel(){
        String path = System.getProperty("user.dir") + "\\TEMP.obj";
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(path);
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write( this.model3DData );
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
    
    
    public boolean has3DModel(){
        return this.model3DFileName != null;
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
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }
    

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    

    /**
     * @return the responsible
     */
    public AccountDAO getResponsible() {
        return responsible;
    }
    

    /**
     * @param responsible the responsible to set
     */
    public void setResponsible(AccountDAO responsible) {
        this.responsible = responsible;
    }

    
    /**
     * @return the terrain
     */
    public TerrainDAO getTerrain() {
        return terrain;
    }

    
    /**
     * @param terrain the terrain to set
     */
    public void setTerrain(TerrainDAO terrain) {
        this.terrain = terrain;
    }
    
    
    /**
     * @return the expenseTable
     */
    public String getExpenseTableString() {
        return expenseTableString;
    }


    public void setExpenseTableString(String tableString) {
        this.expenseTableString = tableString;
    }
}