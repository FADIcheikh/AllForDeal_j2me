/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.dao;

import edu.esprit.allfordeal.entities.Categorie_produit;
import edu.esprit.allfordeal.entities.Produit;
import edu.esprit.allfordeal.handler.ProduitHandler;
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
public class ProduitDao {

    Produit[] ProdutiTab;
    HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/allfordeal/j2me/ProduitDao.php?action=";

    public void ajouterProduit(Produit produit) {
        try {

            hc = (HttpConnection) Connector.
                    open(url + "ajouterProduit" + "&id_produit=" + produit.getId_produit()
                            + "&titre=" + produit.getTitre()
                            + "&categorie=" + produit.getCategorie().getId_categorie_produit()
                            + "&marque=" + produit.getMarque()
                            + "&prix=" + produit.getPrix()
                            + "&date_fin=" + produit.getDate_fin()
                            + "&est_valide=" + produit.getEstValide()
                            + "&quantite=" + produit.getQuantite()
                            + "&estAchetee=" + produit.getEstAchetee()
                            + "&pict=" + produit.getPict()
                            + "&description=" + produit.getDescription()
                            + "&id_cliente=" + produit.getClient().getId());
            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void modifierProduit(Produit produit) {
        try {

            hc = (HttpConnection) Connector.
                    open(url + "modifierProduit" + "&id_produit=" + produit.getId_produit()
                            + "&titre=" + produit.getTitre()
                            + "&categorie=" + produit.getCategorie().getId_categorie_produit()
                            + "&marque=" + produit.getMarque()
                            + "&prix=" + produit.getPrix()
                            + "&date_fin=" + produit.getDate_fin()
                            + "&est_valide=" + produit.getEstValide()
                            + "&quantite=" + produit.getQuantite()
                            + "&estAchetee=" + produit.getEstAchetee()
                            + "&pict=" + produit.getPict()
                            + "&description=" + produit.getDescription()
                            + "&id_cliente=" + produit.getClient().getId());
            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void supprimerProduit(Produit produit) {
        try {

            hc = (HttpConnection) Connector.
                    open(url + "supprimerProduit" + "&id_produit=" + produit.getId_produit());
            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public Produit[] findAll() {
        try {

            ProduitHandler ProduitHandler = new ProduitHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findAll");//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, ProduitHandler);
            // display the result
            ProdutiTab = ProduitHandler.getProduit();
            dis.close();
            hc.close();
            return ProdutiTab;
        } catch (ParserConfigurationException ex) {
            return null;
        } catch (SAXException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }

    public Produit findById(int id) {
        try {

            ProduitHandler testHandler = new ProduitHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findById&id_produit=" + id);//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, testHandler);
            // display the result
            ProdutiTab = testHandler.getProduit();
            dis.close();
            hc.close();
            return ProdutiTab[0];
        } catch (ParserConfigurationException ex) {
            return null;
        } catch (SAXException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }

    public Produit[] findByCategorie(Categorie_produit c) {
        try {

            ProduitHandler ProduitHandler = new ProduitHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findByCategorie&categorie=" + c.getId_categorie_produit());//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, ProduitHandler);
            // display the result
            
            ProdutiTab = ProduitHandler.getProduit();
            dis.close();
            hc.close();

            return ProdutiTab;
        } catch (ParserConfigurationException ex) {
            return null;
        } catch (SAXException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }
}
