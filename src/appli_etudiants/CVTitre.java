package appli_etudiants;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author nc
 */
@DatabaseTable(tableName = "cv_titre")
public class CVTitre{
    
    @DatabaseField(id=true)
    private Integer id_utilisateur;
    @DatabaseField
    private String libelle_titre;

    public Integer getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(Integer id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getLibelle_titre() {
        return libelle_titre;
    }

    public void setLibelle_titre(String libelle_titre) {
        this.libelle_titre = libelle_titre;
    }
    
    }