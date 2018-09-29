/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.entities;

import java.util.Date;

/**
 *
 * @author lenovo i5
 */
public class Reclamation {
    
    int id;
    String titre;
    String etat;
    String description;
    Client client;
    String date;

    public Reclamation(int id, String titre, String etat, String description, Client client, String date) {
        this.id = id;
        this.titre = titre;
        this.etat = etat;
        this.description = description;
        this.client = client;
        this.date = date;
    }

    public Reclamation() {
    }

    
    
    
    
    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setDate(String date) {
        this.date = date;
    }

    
    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getEtat() {
        return etat;
    }

    public String getDescription() {
        return description;
    }

    public Client getClient() {
        return client;
    }

    public String getDate() {
        return date;
    }
    
    
}
