package appli_etudiants;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author nc
 */
@DatabaseTable(tableName = "cv_langue")
public class CVLangue{
    @DatabaseField(id=true)
    private Integer id_langue;
    @DatabaseField
    private Integer id_utilisateur;
    @DatabaseField
    private String libelle_langue;

    public Integer getId_langue() {
        return id_langue;
    }

    public void setId_langue(Integer id_langue) {
        this.id_langue = id_langue;
    }

    public Integer getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(Integer id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getLibelle_langue() {
        return libelle_langue;
    }

    public void setLibelle_langue(String libelle_langue) {
        this.libelle_langue = libelle_langue;
    }
    
    
}