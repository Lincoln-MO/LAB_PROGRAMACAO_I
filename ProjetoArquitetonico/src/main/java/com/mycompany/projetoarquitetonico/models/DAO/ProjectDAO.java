package com.mycompany.projetoarquitetonico.models.DAO;


import com.mycompany.projetoarquitetonico.models.entities.Account;
import com.mycompany.projetoarquitetonico.models.entities.Project;
import com.mycompany.projetoarquitetonico.models.entities.Terrain;
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
    private String model3DFilePath = null;
    
    public ProjectDAO(){
        this.name = "";
        this.startDate = "";
        this.responsible = null;
        this.terrain = null;
        this.expenseTableString = "";
        this.model3DData = null;
        this.model3DFilePath = null;
    }
    
    
    private ProjectDAO(Project proj){
        if(proj.getId() >= 0) this.id = proj.getId();
        this.name = proj.getName();
        this.startDate = proj.getStartDate();
        this.responsible = new AccountDAO(proj.getResponsible());
        this.terrain = new TerrainDAO(proj.getTerrain());
        this.expenseTableString = proj.getExpenseTableString();
        this.model3DData = proj.getModel3DData();
        this.model3DFilePath = proj.getModel3DFilePath();
    }
    
    
    public static void save(Project project){
        ProjectDAO proj = new ProjectDAO(project);
        
        Connection.beginTransaction();
        
        // makes the project.terrain persistent 
        proj.setTerrain(Connection.getEntityManager().find(TerrainDAO.class, proj.getTerrain().getId()));
        // makes the project.responsible persistent 
        proj.setResponsible(Connection.getEntityManager().find(AccountDAO.class, proj.getResponsible().getId()));
        
        Connection.persist(proj);
        Connection.commitTransaction();
        System.out.println("Persist");
    }
    
    
    public static void update(Project project){
        ProjectDAO proj = new ProjectDAO(project);
        
        Connection.beginTransaction();
        
        // makes the project.terrain persistent 
        proj.setTerrain(Connection.getEntityManager().find(TerrainDAO.class, proj.getTerrain().getId()));
        // makes the project.responsible persistent
        proj.setResponsible(Connection.getEntityManager().find(AccountDAO.class, proj.getResponsible().getId()));
        
        Connection.merge(proj);
        Connection.commitTransaction();
        System.out.println("Persist");
    }
    
    
    public static Project findById(int id){
        ProjectDAO result;
        
        Connection.beginTransaction();
        
        String sql = "SELECT project FROM project project WHERE "+
            "(id = :id)";

        Query query = Connection.getEntityManager().createQuery(sql);
        query.setParameter("id", id);
        result = (ProjectDAO) query.getSingleResult();
        
        return result.toProject();
    }
    
    
    public static List<Project> findAllByTerrain(Terrain terrain){
        List<ProjectDAO> queryResult;
        List<Project> result = new ArrayList<>();
        
        Connection.beginTransaction();
        
        String sql = "SELECT project FROM project project WHERE "+
            "(terrain_id = :id)";

        Query query = Connection.getEntityManager().createQuery(sql);
        query.setParameter("id", terrain.getId());
        
        queryResult = query.getResultList();
        
        Connection.commitTransaction();
        
        for( ProjectDAO dao : queryResult ){
            result.add( dao.toProject() );
        }
        
        return result;
    }
    
    
    public static List<Project> findAllByUser(Account account){
        List<Project> result = new ArrayList<>();
        
        // not good
        List<TerrainDAO> terrains = TerrainDAO.FindByOwner(new AccountDAO(account));
        if( terrains == null ){
            System.out.println("no terrains");
            return result;
        }
        
        for( TerrainDAO t : terrains){
            for( Project p : ProjectDAO.findAllByTerrain(t.toTerrain()) ){
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

            this.setModel3DData(fileData);
            this.setModel3DFilePath(filePath);

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
            fileOutputStream.write(this.getModel3DData());
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

    
    public Project toProject(){
        Project result = new Project();
        
        result.setId(id);
        result.setName(name);
        result.setStartDate(startDate);
        if(responsible != null) result.setResponsible( responsible.toAccount() );
        result.setTerrain( terrain.toTerrain() );
        result.setExpenseTableString(expenseTableString);
        result.setModel3DData(model3DData);
        result.setModel3DFilePath(model3DFilePath);
        
        return result;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Account getResponsible() {
        return responsible.toAccount();
    }

    public void setResponsible(AccountDAO responsible) {
        this.responsible = responsible;
    }

    public TerrainDAO getTerrain() {
        return terrain;
    }

    public void setTerrain(TerrainDAO terrain) {
        this.terrain = terrain;
    }

    public String getExpenseTableString() {
        return expenseTableString;
    }

    public void setExpenseTableString(String expenseTableString) {
        this.expenseTableString = expenseTableString;
    }

    public byte[] getModel3DData() {
        return model3DData;
    }

    public void setModel3DData(byte[] model3DData) {
        this.model3DData = model3DData;
    }

    public String getModel3DFilePath() {
        return model3DFilePath;
    }

    public void setModel3DFilePath(String model3DFilePath) {
        this.model3DFilePath = model3DFilePath;
    }
}