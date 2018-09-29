/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.entities;

/**
 *
 * @author lenovo i5
 */
public class CommentaireProduit {
    int id_commentaire;
    String commentaire;
    Client client;
    Produit produit;
    String date;

    public CommentaireProduit(int id_commentaire, String commentaire, Client client, Produit produit, String date) {
        this.id_commentaire = id_commentaire;
        this.commentaire = commentaire;
        this.client = client;
        this.produit = produit;
        this.date = date;
    }

    public int getId_commentaire() {
        return id_commentaire;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public Client getClient() {
        return client;
    }

    public Produit getProduit() {
        return produit;
    }

    public String getDate() {
        return date;
    }

    public void setId_commentaire(int id_commentaire) {
        this.id_commentaire = id_commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public CommentaireProduit() {
    }
    
    
    
    
    
}
