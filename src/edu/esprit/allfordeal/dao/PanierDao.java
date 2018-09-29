/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.dao;

import edu.esprit.allfordeal.entities.Client;
import edu.esprit.allfordeal.entities.Panier;
import edu.esprit.allfordeal.entities.Produit;
import edu.esprit.allfordeal.handler.PanierHandler;
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
 * @author Maynoo
 */
public class PanierDao {

    Panier[] panierTab;
    HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/allfordeal/j2me/PanierDao.php?action=";

    public void ajouterPanier(Client c, Produit p) {
        try {

            hc = (HttpConnection) Connector.
                    open(url + "ajouterPanier" + "&id_client=" + c.getId() + "&id_produit="
                            + p.getId_produit());
            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void supprimerPanier(Client c, Produit p) {
        try {

            hc = (HttpConnection) Connector.
                    open(url + "supprimerPanier" + "&id_client=" + c.getId() + "&id_produit="
                            + p.getId_produit());
            dis = hc.openDataInputStream();
            System.out.println(url + "supprimerPanier" + "&id_client=" + c.getId() + "&id_produit="
                    + p.getId_produit());
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public Panier[] findAll() {
        try {

            PanierHandler panierHandler = new PanierHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findAll");//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, panierHandler);
            // display the result
            panierTab = panierHandler.getPanier();
            dis.close();
            hc.close();
            return panierTab;
        } catch (ParserConfigurationException ex) {
            return null;
        } catch (SAXException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }

    public Panier[] findByClient(Client c) {
        try {

            PanierHandler panierHandler = new PanierHandler();
            // get a parser object  
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findByClient&id_client=" + c.getId());//people.xml est un exemple
            System.out.println(url + "findByClient&id_client=" + c.getId());
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, panierHandler);
            // display the result
            panierTab = panierHandler.getPanier();
            dis.close();
            hc.close();
            return panierTab;
        } catch (ParserConfigurationException ex) {
            return null;
        } catch (SAXException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }

    public int inPanier(Client c, Produit p) {
        try {

            PanierHandler panierHandler = new PanierHandler();
            // get a parser object  
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "inPanier&id_client=" + c.getId() + "&id_produit=" + p.getId_produit());//people.xml est un exemple

            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, panierHandler);
            // display the result
            panierTab = panierHandler.getPanier();
            dis.close();
            hc.close();
            if (panierTab == null) {
                return 0;
            } else {
                return 1;
            }
        } catch (ParserConfigurationException ex) {
            return 0;
        } catch (SAXException ex) {
            return 0;
        } catch (IOException ex) {
            return 0;
        }
    }

}
