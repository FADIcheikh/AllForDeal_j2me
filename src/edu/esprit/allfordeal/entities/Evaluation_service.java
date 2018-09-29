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
public class Evaluation_service {
    
    int id_evaluation;
    int note;
    int id_client;
    int id_service;
    
 
    
    
    public Evaluation_service() {
        
        
    }

    public Evaluation_service(int id_evaluation, int note, int id_client, int id_service) {
        this.id_evaluation = id_evaluation;
        this.note = note;
        this.id_client = id_client;
        this.id_service = id_service;
    }
    

    public int getId_evaluation() {
        return id_evaluation;
    }

    public void setId_evaluation(int id_evaluation) {
        this.id_evaluation = id_evaluation;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
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
    
    
    
    
}
