/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.entities;

/**
 *
 * @author macbookpro
 */
public class Produit {

    private int id_produit;
    private String titre;
    private Categorie_produit categorie;
    private String marque;
    private Float prix;
    private String date_fin;
    private int estValide;
    private int quantite;
    private int estAchetee;
    private String pict;

    private String description;

    private Client Client;

    public Produit() {
    }

    public Produit(int id_produit, String titre, Categorie_produit categorie, String marque, Float prix, String date_fin, int estValide, int quantite, int estAchetee, String pict, String description, Client Client) {
        this.id_produit = id_produit;
        this.titre = titre;
        this.categorie = categorie;
        this.marque = marque;
        this.prix = prix;
        this.date_fin = date_fin;
        this.estValide = estValide;
        this.quantite = quantite;
        this.estAchetee = estAchetee;
        this.pict = pict;
        this.description = description;
        this.Client = Client;
    }

    

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Categorie_produit getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie_produit categorie) {
        this.categorie = categorie;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public int getEstValide() {
        return estValide;
    }

    public void setEstValide(int estValide) {
        this.estValide = estValide;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEstAchetee() {
        return estAchetee;
    }

    public void setEstAchetee(int estAchetee) {
        this.estAchetee = estAchetee;
    }

    public Client getClient() {
        return Client;
    }

    public void setClient(Client Client) {
        this.Client = Client;
    }

    public String getPict() {
        return pict;
    }

    public void setPict(String pict) {
        this.pict = pict;
    }

}
