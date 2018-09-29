/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.entities;

/**
 *
 * @author Achref
 */
public class Categorie_produit {
    
    int id_categorie_produit;
    String nom_categorie_produit;
    int nb_pts_categorie_produit;

    public Categorie_produit() {
    }

    public Categorie_produit(int id_categorie_produit, String nom_categorie_produit, int nb_pts_categorie_produit) {
        this.id_categorie_produit = id_categorie_produit;
        this.nom_categorie_produit = nom_categorie_produit;
        this.nb_pts_categorie_produit = nb_pts_categorie_produit;
    }

    public int getId_categorie_produit() {
        return id_categorie_produit;
    }

    public void setId_categorie_produit(int id_categorie_produit) {
        this.id_categorie_produit = id_categorie_produit;
    }

    public String getNom_categorie_produit() {
        return nom_categorie_produit;
    }

    public void setNom_categorie_produit(String nom_categorie_produit) {
        this.nom_categorie_produit = nom_categorie_produit;
    }

    public int getNb_pts_categorie_produit() {
        return nb_pts_categorie_produit;
    }

    public void setNb_pts_categorie_produit(int nb_pts_categorie_produit) {
        this.nb_pts_categorie_produit = nb_pts_categorie_produit;
    }

    
    
}
