
package edu.esprit.allfordeal.entities;

/**
 *
 * @author Achref
 */
public class Categorie_service {
    
    int id_categorie;
    String nom_categorie;
    int nb_pts;

    public Categorie_service() {
    }

    public Categorie_service(int id_categorie, String nom_categorie, int nb_pts) {
        this.id_categorie = id_categorie;
        this.nom_categorie = nom_categorie;
        this.nb_pts = nb_pts;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getNom_categorie() {
        return nom_categorie;
    }

    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

    public int getNb_pts() {
        return nb_pts;
    }

    public void setNb_pts(int nb_pts) {
        this.nb_pts = nb_pts;
    }
    
   
    
}
