/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.dao;

import edu.esprit.allfordeal.entities.Categorie_service;
import edu.esprit.allfordeal.handler.Categorie_serviceHandler;
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
 * @author Achref
 */
public class Categorie_serviceDao {

    Categorie_service[] categorie_serviceTab;
    HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/allfordeal/j2me/Categorie_serviceDao.php?action=";

    public void ajouterCategorie_service(Categorie_service categorie_service) {
        try {

            hc = (HttpConnection) Connector.
                        open(url + "ajouterCategorie_service" + "&id_categorie=" + categorie_service.getId_categorie()+ "&nom_categorie=" + categorie_service.getNom_categorie()+ "&nb_pts=" + categorie_service.getNb_pts());
            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void modifierCategorie_service(Categorie_service categorie_service) {
        try {

            hc = (HttpConnection) Connector.
                        open(url + "modifierCategorie_service" + "&id_categorie=" + categorie_service.getId_categorie()+ "&nom_categorie=" + categorie_service.getNom_categorie()+ "&nb_pts=" + categorie_service.getNb_pts());
            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void supprimerCategorie_service(Categorie_service categorie_service) {
        try {

            hc = (HttpConnection) Connector.
                        open(url + "supprimerCategorie_service" + "&id_categorie=" + categorie_service.getId_categorie());
            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public Categorie_service[] findAll() {
        try {

            Categorie_serviceHandler categorie_serviceHandler = new Categorie_serviceHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findAll");//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, categorie_serviceHandler);
            // display the result
            categorie_serviceTab = categorie_serviceHandler.getCategorie_service();
            dis.close();
            hc.close();
            return categorie_serviceTab;
        } catch (ParserConfigurationException ex) {
            return null;
        } catch (SAXException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }

    public Categorie_service findById(int id) {
        try {

            Categorie_serviceHandler categorie_serviceHandler = new Categorie_serviceHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findById&id=" + id);//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, categorie_serviceHandler);
            // display the result
            categorie_serviceTab = categorie_serviceHandler.getCategorie_service();
            dis.close();
            hc.close();
            return categorie_serviceTab[0];
        } catch (ParserConfigurationException ex) {
            return null;
        } catch (SAXException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }
}
