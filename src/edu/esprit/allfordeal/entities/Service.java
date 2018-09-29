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
public class Service {
    
    int id_service;
    String titre;
    Categorie_service categorie;
    int id_cat;
    String date_fin;
    String description;
    Categorie_service Competence;
    int comp;
    Client client;
    int id_client;
    public Service() {
    }

    public Service(String titre, int id_cat, String date_fin, String description, int comp, int id_client) {
        
        this.titre = titre;
        this.id_cat = id_cat;
        this.date_fin = date_fin;
        this.description = description;
        this.comp = comp;
        this.id_client = id_client;
    }

    public Service(int id_service, String titre, Categorie_service id_categorie, String date_fin, String description, Categorie_service Competence, Client id_client) {
        this.id_service = id_service;
        this.titre = titre;
        this.categorie = id_categorie;
        this.date_fin = date_fin;
        this.description = description;
        this.Competence = Competence;
        this.client = id_client;
    }

    public Service(String titre, Categorie_service id_categorie, String date_fin, String description, Categorie_service Competence, Client id_client) {
        this.titre = titre;
        this.categorie = id_categorie;
        this.date_fin = date_fin;
        this.description = description;
        this.Competence = Competence;
        this.client = id_client;
    }

    public Service(String titre) {
        this.titre = titre;
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public int getComp() {
        return comp;
    }

    public void setComp(int comp) {
        this.comp = comp;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_service() {
        return id_service;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Categorie_service getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie_service id_categorie) {
        this.categorie = id_categorie;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categorie_service getCompetence() {
        return Competence;
    }

    public void setCompetence(Categorie_service Competence) {
        this.Competence = Competence;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client id_client) {
        this.client = id_client;
    }

    
}
