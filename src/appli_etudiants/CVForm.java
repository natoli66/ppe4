package appli_etudiants;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author nc
 */
@DatabaseTable(tableName = "cv_formation")
public class CVForm{
    @DatabaseField(id=true)
    private Integer id_formation;
    @DatabaseField
    private Integer id_utilisateur;
    @DatabaseField
    private String libelle_formation;

    public Integer getId_formation() {
        return id_formation;
    }

    public void setId_formation(Integer id_formation) {
        this.id_formation = id_formation;
    }

    public Integer getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(Integer id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getLibelle_formation() {
        return libelle_formation;
    }

    public void setLibelle_formation(String libelle_formation) {
        this.libelle_formation = libelle_formation;
    }
    
    
}