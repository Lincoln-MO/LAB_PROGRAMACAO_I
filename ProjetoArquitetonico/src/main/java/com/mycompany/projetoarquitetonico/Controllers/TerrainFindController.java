package com.mycompany.projetoarquitetonico.Controllers;


import com.mycompany.projetoarquitetonico.forms.frmTerrainFind;
import com.mycompany.projetoarquitetonico.models.DAO.ConnectionException;
import com.mycompany.projetoarquitetonico.models.DAO.TerrainDAO;
import com.mycompany.projetoarquitetonico.models.entities.Terrain;
import java.util.List;


/**
 *
 * @author yurit
 */
public class TerrainFindController {
    frmTerrainFind view;
    private Terrain selectedTerrain;
    private List<Terrain> foundTerrains = null;
    
    
    public TerrainFindController(frmTerrainFind view){
        this.view = view;
    }
    
    
    public Terrain getSelectedTerrain(){
        return selectedTerrain;
    }
    
    
    public void handleSelectTerrain(){
        int id = view.getSelectedIndex();
        
        if( id >= 0) this.selectedTerrain = this.foundTerrains.get(id);
        else this.selectedTerrain = null;
        
        view.setVisible(false); // need this for frmTerrainFind.getTerrain() 
    }
    
    
    public void handleTextType() throws ConnectionException{
        String search = view.getSearchText();
        this.foundTerrains = TerrainDAO.search(search);
        
        view.clearComboItems();
        if( search.equals("") ){
            view.setFoundTerrainsCounterText("0");
            return;
        }
        
        view.setFoundTerrainsCounterText(String.valueOf( this.foundTerrains.size() ));
        for( Terrain terr : this.foundTerrains ){
            view.addComboItem(terr.getName() + " : " + terr.getLocation());
        }
    }
    
    
    public Terrain handleGetTerrain(){
        Terrain result;
        frmTerrainFind frm = new frmTerrainFind(null, true);
        frm.setVisible(true);
        
         // returns when frm is not visible
        result = selectedTerrain;
        frm.dispose();
        return result;
    }
}
