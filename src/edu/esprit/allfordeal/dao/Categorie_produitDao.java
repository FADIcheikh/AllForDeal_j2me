/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.dao;

import edu.esprit.allfordeal.entities.Categorie_produit;
import edu.esprit.allfordeal.handler.Categorie_produitHandler;
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
 * @author Yesmine
 */
public class Categorie_produitDao {

    Categorie_produit[] categorie_produitTab;
    HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/allfordeal/j2me/Categorie_produitDao.php?action=";

    public void ajouterCategorie_produit(Categorie_produit categorie_produit) {
        try {

            hc = (HttpConnection) Connector.
                        open(url + "ajouterCategorie_produit" + "&id_categorie_produit=" + categorie_produit.getId_categorie_produit()+ "&nom_categorie_produit=" + categorie_produit.getNom_categorie_produit()+ "&nb_pts_categorie_produit=" + categorie_produit.getNb_pts_categorie_produit());
            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void modifierCategorie_produit(Categorie_produit categorie_produit) {
        try {

            hc = (HttpConnection) Connector.
                        open(url + "modifierCategorie_produit" + "&id_categorie_produit=" + categorie_produit.getId_categorie_produit()+ "&nom_categorie_produit=" + categorie_produit.getNom_categorie_produit()+ "&nb_pts_categorie_produit=" + categorie_produit.getNb_pts_categorie_produit());
            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void supprimerCategorie_produit(Categorie_produit categorie_produit) {
        try {

            hc = (HttpConnection) Connector.
                        open(url + "supprimerCategorie_produit" + "&id_categorie_produit=" + categorie_produit.getId_categorie_produit());
            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public Categorie_produit[] findAll() {
        try {

            Categorie_produitHandler categorie_produitHandler = new Categorie_produitHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findAll");//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, categorie_produitHandler);
            dis.close();
            hc.close();
            // display the result
            categorie_produitTab = categorie_produitHandler.getCategorie_produit();
            return categorie_produitTab;
        } catch (ParserConfigurationException ex) {
            return null;
        } catch (SAXException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }

    public Categorie_produit findById(int id) {
        try {

            Categorie_produitHandler categorie_produitHandler = new Categorie_produitHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findById&id_categorie_produit=" + id);//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, categorie_produitHandler);
            dis.close();
            hc.close();
            // display the result
            categorie_produitTab = categorie_produitHandler.getCategorie_produit();
            return categorie_produitTab[0];
        } catch (ParserConfigurationException ex) {
            return null;
        } catch (SAXException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }
}
