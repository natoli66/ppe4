/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appli_etudiants;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author nc
 */
@DatabaseTable(tableName = "utilisateurs")
public class Etudiants{
    
    @DatabaseField(id=true)
    private String identifiant;
    @DatabaseField
    private String mot_de_passe;
    @DatabaseField
    private String nom;
    @DatabaseField
    private String prenom;
    @DatabaseField
    private String adresse_rue;
    @DatabaseField
    private String adresse_cp;
    @DatabaseField
    private String adresse_ville;
    @DatabaseField
    private String tel_professionnel;
    @DatabaseField
    private String tel_personnel;
    @DatabaseField
    private String courriel;
    @DatabaseField
    private String site_web;
    
    //accesseurs
    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse_rue() {
        return adresse_rue;
    }

    public void setAdresse_rue(String adresse_rue) {
        this.adresse_rue = adresse_rue;
    }

    public String getAdresse_cp() {
        return adresse_cp;
    }

    public void setAdresse_cp(String adresse_cp) {
        this.adresse_cp = adresse_cp;
    }

    public String getAdresse_ville() {
        return adresse_ville;
    }

    public void setAdresse_ville(String adresse_ville) {
        this.adresse_ville = adresse_ville;
    }

    public String getTel_professionnel() {
        return tel_professionnel;
    }

    public void setTel_professionnel(String tel_professionnel) {
        this.tel_professionnel = tel_professionnel;
    }

    public String getTel_personnel() {
        return tel_personnel;
    }

    public void setTel_personnel(String tel_personnel) {
        this.tel_personnel = tel_personnel;
    }

    public String getSite_web() {
        return site_web;
    }

    public void setSite_web(String site_web) {
        this.site_web = site_web;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
     
}
