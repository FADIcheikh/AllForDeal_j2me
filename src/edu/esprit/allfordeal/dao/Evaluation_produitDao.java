/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.dao;

import edu.esprit.allfordeal.entities.Evaluation_produit;
import edu.esprit.allfordeal.entities.Produit;
import edu.esprit.allfordeal.handler.Evaluation_produitHandler;
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
public class Evaluation_produitDao {

    Evaluation_produit[] evaluation_produitTab;
    HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/allfordeal/j2me/Evaluation_produitDao.php?action=";

    public void ajouterEvaluation_produit(Evaluation_produit evaluation_produit) {
        try {

            hc = (HttpConnection) Connector.
                        open(url + "ajouterEvaluation_produit" + "&id_evaluation=" + evaluation_produit.getId_evaluation() + "&note=" + evaluation_produit.getNote() + "&id_client=" + evaluation_produit.getId_client() + "&id_produit=" + evaluation_produit.getId_produit());
            dis = hc.openDataInputStream();
            System.out.println(url + "ajouterEvaluation_produit" + "&id_evaluation=" + evaluation_produit.getId_evaluation() + "&note=" + evaluation_produit.getNote() + "&id_client=" + evaluation_produit.getId_client() + "&id_produit=" + evaluation_produit.getId_produit());
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void modifierEvaluation_produit(Evaluation_produit evaluation_produit) {
        try {

            hc = (HttpConnection) Connector.
                        open(url + "modifierEvaluation_produit" + "&id_evaluation=" + evaluation_produit.getId_evaluation() + "&note=" + evaluation_produit.getNote() + "&id_client=" + evaluation_produit.getId_client() + "&id_produit=" + evaluation_produit.getId_produit());
            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void supprimerEvaluation_produit(Evaluation_produit evaluation_produit) {
        try {

            hc = (HttpConnection) Connector.
                        open(url + "supprimerEvaluation_produit" + "&id_evaluation=" + evaluation_produit.getId_evaluation());
            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public Evaluation_produit[] findAll() {
        try {

            Evaluation_produitHandler evaluation_produitHandler = new Evaluation_produitHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findAll");//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, evaluation_produitHandler);
            // display the result
            evaluation_produitTab = evaluation_produitHandler.getEvaluation_produit();
            dis.close();
            hc.close();
            return evaluation_produitTab;
        } catch (ParserConfigurationException ex) {
            return null;
        } catch (SAXException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }

    public Evaluation_produit findById(int id) {
        try {

            Evaluation_produitHandler evaluation_produitHandler = new Evaluation_produitHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findById&id=" + id);//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, evaluation_produitHandler);
            // display the result
            evaluation_produitTab = evaluation_produitHandler.getEvaluation_produit();
            dis.close();
            hc.close();
            return evaluation_produitTab[0];
        } catch (ParserConfigurationException ex) {
            return null;
        } catch (SAXException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }

    public Evaluation_produit[] findByProduit(Produit p) {
        try {

            Evaluation_produitHandler evaluation_produitHandler = new Evaluation_produitHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findByProduit&id_produit=" + p.getId_produit());//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, evaluation_produitHandler);
            // display the result
            evaluation_produitTab = evaluation_produitHandler.getEvaluation_produit();
            dis.close();
            hc.close();
            return evaluation_produitTab;
        } catch (ParserConfigurationException ex) {
            return null;
        } catch (SAXException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }

    public float calculeMoyenne(Produit p) {
        Evaluation_produit[] evaluation = findByProduit(p);

        float moyenneproduit = 0;
        if (evaluation != null) {
            for (int i = 0; i < evaluation.length; i++) {

                moyenneproduit = moyenneproduit + evaluation[i].getNote();

            }
            moyenneproduit = moyenneproduit / (evaluation.length);
            System.out.println(moyenneproduit);

        }
        return moyenneproduit;
    }

}
