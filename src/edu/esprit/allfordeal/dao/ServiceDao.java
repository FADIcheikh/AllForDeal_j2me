/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.dao;

import edu.esprit.allfordeal.entities.Service;
import edu.esprit.allfordeal.handler.ServiceHandler;
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
 * @author lenovo i5
 */
public class ServiceDao {

    Service[] serviceTab;
    HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/allfordeal/j2me/ServiceDao.php?action=";

    public void ajouterService(Service serv) {
        try {

            hc = (HttpConnection) Connector.
                        open(url + "ajouterService" + "&titre=" + serv.getTitre() + "&id_categorie=" + serv.getCategorie().getId_categorie() + "&date_fin=" + serv.getDate_fin() + "&description=" + serv.getDescription() + "&competence=" + serv.getCompetence().getId_categorie() + "&id_client=" + serv.getClient().getId());
//            hc = (HttpConnection) Connector.
//                    open("http://localhost/j2mtest/ServiceDao.php/?action=ajouterService&titre=eee&id_categorie=1&date_fin=1-1-2006&description=hhhhhhhhhhh&competence=1&id_client=1");
//            
            dis = hc.openDataInputStream();
            dis.close();
            hc.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void modifierService(Service serv) {
        try {

            hc = (HttpConnection) Connector.
                        open(url + "modifierService" + "&titre=" + serv.getTitre() + "&id_categorie=" + serv.getCategorie().getId_categorie() + "&date_fin=" + serv.getDate_fin() + "&description=" + serv.getDescription() + "&competence=" + serv.getCompetence().getId_categorie() + "&id_client=" + serv.getClient().getId());
            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void supprimerService(Service serv) {
        try {

            hc = (HttpConnection) Connector.
                        open(url + "supprimerService" + "&id_service=" + serv.getId_service());
            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public Service[] findAll() {
        try {

            ServiceHandler testHandler = new ServiceHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findAll");//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, testHandler);
            // display the result
            serviceTab = testHandler.getService();
            dis.close();
            hc.close();
            return serviceTab;
        } catch (ParserConfigurationException ex) {
            return null;
        } catch (SAXException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }

    public Service findById(int id) {

        try {

            ServiceHandler testHandler = new ServiceHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findById&id_service=" + id);//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, testHandler);
            // display the result
            serviceTab = testHandler.getService();
            dis.close();
            hc.close();
            return serviceTab[0];
        } catch (ParserConfigurationException ex) {
            return null;
        } catch (SAXException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }

    public Service[] findByClient(int id_client) {
        try {

            ServiceHandler testHandler = new ServiceHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findByClient&id_client=" + id_client);//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, testHandler);
            // display the result
            serviceTab = testHandler.getService();
            dis.close();
            hc.close();
            return serviceTab;
        } catch (ParserConfigurationException ex) {
            return null;
        } catch (SAXException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }

}
