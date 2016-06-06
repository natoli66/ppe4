package appli_etudiants;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author nc
 */
@DatabaseTable(tableName = "cv_experience_prof")
public class CVEP{
    
    @DatabaseField(id=true)
    private Integer id_experience_prof;
    @DatabaseField
    private Integer id_utilisateur;
    @DatabaseField
    private String libelle_experience_prof;

    public Integer getId_experience_prof() {
        return id_experience_prof;
    }

    public void setId_experience_prof(Integer id_experience_prof) {
        this.id_experience_prof = id_experience_prof;
    }

    public Integer getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(Integer id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getLibelle_experience_prof() {
        return libelle_experience_prof;
    }

    public void setLibelle_experience_prof(String libelle_experience_prof) {
        this.libelle_experience_prof = libelle_experience_prof;
    }

   
}