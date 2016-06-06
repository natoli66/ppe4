package appli_etudiants;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author nc
 */
@DatabaseTable(tableName = "cv_informatique")
public class CVInfo{
    @DatabaseField(id=true)
    private Integer id_informatique;
    @DatabaseField
    private Integer id_utilisateur;
    @DatabaseField
    private String libelle_informatique;

    public Integer getId_informatique() {
        return id_informatique;
    }

    public void setId_informatique(Integer id_informatique) {
        this.id_informatique = id_informatique;
    }

    public Integer getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(Integer id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getLibelle_informatique() {
        return libelle_informatique;
    }

    public void setLibelle_informatique(String libelle_informatique) {
        this.libelle_informatique = libelle_informatique;
    }
    
    
    }