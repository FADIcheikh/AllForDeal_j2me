/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.dao;

import edu.esprit.allfordeal.entities.Reservation;
import edu.esprit.allfordeal.handler.ReservationHandler;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author Saif Eddine
 */
public class ReservationDao {
    Reservation [] reservationTab;
    HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/allfordeal/j2me/ReservationDao.php?action=";
    public void ajouterReservation(Reservation reservation) {
        try {

            hc = (HttpConnection) Connector.
                        open(url + "ajouterReservation" + 
                                "&id_reservation=" + reservation.getId_reservation()+
                                "&date_fin_reservation=" + reservation.getDate_Fin_Reservation()+ 
                                "&id_produit=" + reservation.getProduit().getId_produit()+
                                "&id_client=" +reservation.getClient().getId());
            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
   
    public void modifierReservation(Reservation reservation) {
        try {

            hc = (HttpConnection) Connector.
                        open(url + "modifierReservation"+
                                "&id_reservation=" + reservation.getId_reservation()+
                                "&date_fin_reservation=" + reservation.getDate_Fin_Reservation()+ 
                                "&id_produit=" + reservation.getProduit().getId_produit()+
                                "&id_client=" +reservation.getClient().getId());
            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    
     public void supprimerReservation(Reservation reservation) {
        try {

            hc = (HttpConnection) Connector.
                        open(url + "supprimerReservation" + "&id_reservation=" + reservation.getId_reservation());
            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }  
   
     public Reservation[] findAll() {
        try {

            ReservationHandler reservationHandler = new ReservationHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findAll");//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, reservationHandler);
            // display the result
            reservationTab = reservationHandler.getReservations();
            dis.close();
            hc.close();
            return reservationTab;
        } catch (ParserConfigurationException ex) {
            return null;
        } catch (SAXException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }
     
    public Reservation findById(int id_reservation) {
        try {

            ReservationHandler reservationHandler = new ReservationHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findById&id_reservation=" + id_reservation);//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, reservationHandler);
            // display the result
            reservationTab = reservationHandler.getReservations();
            dis.close();
            hc.close();
            return reservationTab[0];
        } catch (ParserConfigurationException ex) {
            return null;
        } catch (SAXException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }
    public Reservation[] findByClient(int id_client) {
        try {

            ReservationHandler reservationHandler = new ReservationHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findByClient&id_client=" + id_client);//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, reservationHandler);
            // display the result
            reservationTab = reservationHandler.getReservations();
            dis.close();
            hc.close();
            return reservationTab;
        } catch (ParserConfigurationException ex) {
            return null;
        } catch (SAXException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }
}
