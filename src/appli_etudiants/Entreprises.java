/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appli_etudiants;

/**
 *
 * @author nc
 */
public class Entreprises {
    private String nom;
   
    private String adresse;
    private Utilisateur contact;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Utilisateur getContact() {
        return contact;
    }

    public void setContact(Utilisateur contact) {
        this.contact = contact;
    }
    
}
