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
public class CommentaireService {
    int id_commentaire;
    String commentaire;
    Client client;
    Service service;
    String date;

    public CommentaireService(int id_commentaire, String commentaire, Client client, Service service, String date) {
        this.id_commentaire = id_commentaire;
        this.commentaire = commentaire;
        this.client = client;
        
        this.service = service;
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

    public Service getService() {
        return service;
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

    public void setProduit(Service service) {
        this.service = service;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    
}
