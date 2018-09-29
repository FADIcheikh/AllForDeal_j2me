/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.entities;

/**
 *
 * @author Saif Eddine
 */
public class Reservation {
    int id_reservation;
    String Date_Fin_Reservation;
    Produit produit;
    Client client;

    public Reservation(int id_reservation, String Date_Fin_Reservation, Produit id_produit, Client id_client) {
        this.id_reservation = id_reservation;
        this.Date_Fin_Reservation = Date_Fin_Reservation;
        this.produit = id_produit;
        this.client = id_client;
    }

    public Reservation(String Date_Fin_Reservation, Produit id_produit, Client id_client) {
        this.Date_Fin_Reservation = Date_Fin_Reservation;
        this.produit = id_produit;
        this.client = id_client;
    }

    public int getId_reservation() {
        return id_reservation;
    }

    public String getDate_Fin_Reservation() {
        return Date_Fin_Reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public void setDate_Fin_Reservation(String Date_Fin_Reservation) {
        this.Date_Fin_Reservation = Date_Fin_Reservation;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id_reservation;
        hash = 97 * hash + (this.Date_Fin_Reservation != null ? this.Date_Fin_Reservation.hashCode() : 0);
        hash = 97 * hash + (this.produit != null ? this.produit.hashCode() : 0);
        hash = 97 * hash + (this.client != null ? this.client.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reservation other = (Reservation) obj;
        if (this.id_reservation != other.id_reservation) {
            return false;
        }
        if ((this.Date_Fin_Reservation == null) ? (other.Date_Fin_Reservation != null) : !this.Date_Fin_Reservation.equals(other.Date_Fin_Reservation)) {
            return false;
        }
        if (this.produit != other.produit && (this.produit == null || !this.produit.equals(other.produit))) {
            return false;
        }
        if (this.client != other.client && (this.client == null || !this.client.equals(other.client))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "Reservation{" + "id_reservation=" + id_reservation + ", Date_Fin_Reservation=" + Date_Fin_Reservation + ", produit=" + produit + ", client=" + client + '}';
    }

 
    
}
