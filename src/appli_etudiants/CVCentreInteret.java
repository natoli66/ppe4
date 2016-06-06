/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appli_etudiants;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author nc
 */
@DatabaseTable(tableName = "cv_centre_interet")
public class CVCentreInteret{
    
    @DatabaseField(id=true)
    private Integer id_centre_interet;
    @DatabaseField
    private Integer id_utilisateur;
    @DatabaseField
    private String libelle_centre_interet;

    public Integer getId_centre_interet() {
        return id_centre_interet;
    }

    public void setId_centre_interet(Integer id_centre_interet) {
        this.id_centre_interet = id_centre_interet;
    }

    public Integer getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(Integer id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getLibelle_centre_interet() {
        return libelle_centre_interet;
    }

    public void setLibelle_centre_interet(String libelle_centre_interet) {
        this.libelle_centre_interet = libelle_centre_interet;
    }
}
