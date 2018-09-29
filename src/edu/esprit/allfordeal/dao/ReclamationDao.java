/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.dao;

import edu.esprit.allfordeal.entities.Reclamation;
import edu.esprit.allfordeal.handler.ReclamationHandler;
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
public class ReclamationDao {

    Reclamation[] reclamationTab;
    HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/allfordeal/j2me/ReclamationDao.php?action=";

    public void ajouterReclamation(Reclamation reclamation) {
        try {

            hc = (HttpConnection) Connector.
                    open(url + "ajouterReclamation" + "&id_reclamation=" + reclamation.getId() + "&titre="
                            + reclamation.getTitre().trim() + "&etat=" + reclamation.getEtat().trim() + "&description=" + reclamation.getDescription().trim()
                            + "&id_client=" + reclamation.getClient().getId() + "&date=" + reclamation.getDate().trim());
            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void modifierReclamation(Reclamation reclamation) {
        try {

            hc = (HttpConnection) Connector.
                    open(url + "modifierReclamation" + "&id_reclamation=" + reclamation.getId() + "&titre="
                            + reclamation.getTitre() + "&etat=" + reclamation.getEtat() + "&description=" + reclamation.getDescription()
                            + "&id_client=" + reclamation.getClient().getId() + "&date=" + reclamation.getDate());

            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void supprimerReclamation(Reclamation reclamation) {
        try {

            hc = (HttpConnection) Connector.
                    open(url + "supprimerReclamation" + "&id_reclamation=" + reclamation.getId());
            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public Reclamation[] findAll() {
        try {

            ReclamationHandler reclamationHandler = new ReclamationHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findAll");//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, reclamationHandler);
            // display the result
            reclamationTab = reclamationHandler.getReclamation();
            dis.close();
            hc.close();
            return reclamationTab;
        } catch (ParserConfigurationException ex) {
            return null;
        } catch (SAXException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }

    public Reclamation findById(int id) {
        try {

            ReclamationHandler reclamationHandler = new ReclamationHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findById&id=" + id);//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, reclamationHandler);
            // display the result
            reclamationTab = reclamationHandler.getReclamation();
            dis.close();
            hc.close();
            return reclamationTab[0];
        } catch (ParserConfigurationException ex) {
            return null;
        } catch (SAXException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }
}
