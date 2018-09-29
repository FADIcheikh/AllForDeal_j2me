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
public class Panier {
    Client c;
    Produit p;

  
    
    
    public Panier() {
    }

   
    
    public Panier(Client c, Produit p) {
        this.c = c;
        this.p = p;
    }

    
    
    public Client getC() {
        return c;
    }

    public Produit getP() {
        return p;
    }

    public void setC(Client c) {
        this.c = c;
    }

    public void setP(Produit p) {
        this.p = p;
    }
    
    
    
}
