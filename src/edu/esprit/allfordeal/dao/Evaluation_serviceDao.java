/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.dao;

import edu.esprit.allfordeal.entities.Evaluation_service;
import edu.esprit.allfordeal.handler.Evaluation_serviceHandler;
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
public class Evaluation_serviceDao {

    Evaluation_service[] evaluation_serviceTab;
    HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/allfordeal/j2me/Evaluation_serviceDao.php?action=";

    public void ajouterEvaluation_service(Evaluation_service evaluation_service) {
        try {

            hc = (HttpConnection) Connector.
                        open(url + "ajouterEvaluation_service" + "&id_evaluation=" + evaluation_service.getId_evaluation()+ "&note=" + evaluation_service.getNote()+ "&id_client=" + evaluation_service.getId_client()+ "&id_service=" + evaluation_service.getId_service());
            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void modifierEvaluation_service(Evaluation_service evaluation_service) {
        try {

            hc = (HttpConnection) Connector.
                         open(url + "modifierEvaluation_service" + "&id_evaluation=" + evaluation_service.getId_evaluation()+ "&note=" + evaluation_service.getNote()+ "&id_client=" + evaluation_service.getId_client()+ "&id_service=" + evaluation_service.getId_service());
             dis = hc.openDataInputStream();
             dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void supprimerEvaluation_service(Evaluation_service evaluation_service) {
        try {

            hc = (HttpConnection) Connector.
                        open(url + "supprimerEvaluation_service" + "&id_evaluation=" + evaluation_service.getId_evaluation());
            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public Evaluation_service[] findAll() {
        try {

            Evaluation_serviceHandler evaluation_serviceHandler = new Evaluation_serviceHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findAll");//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, evaluation_serviceHandler);
            // display the result
            evaluation_serviceTab = evaluation_serviceHandler.getEvaluation_service();
            dis.close();
            hc.close();
            return evaluation_serviceTab;
        } catch (ParserConfigurationException ex) {
            return null;
        } catch (SAXException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }

    public Evaluation_service findById(int id) {
        try {

            Evaluation_serviceHandler evaluation_serviceHandler = new Evaluation_serviceHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findById&id=" + id);//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, evaluation_serviceHandler);
            // display the result
            evaluation_serviceTab = evaluation_serviceHandler.getEvaluation_service();
            dis.close();
            hc.close();
            return evaluation_serviceTab[0];
        } catch (ParserConfigurationException ex) {
            return null;
        } catch (SAXException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }
    
    public Evaluation_service[] findByService(float id) {
        try {

            Evaluation_serviceHandler evaluation_serviceHandler = new Evaluation_serviceHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findByService&id_service="+id);//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, evaluation_serviceHandler);
            // display the result
            evaluation_serviceTab = evaluation_serviceHandler.getEvaluation_service();
            dis.close();
            hc.close();
            return evaluation_serviceTab;
        } catch (ParserConfigurationException ex) {
            return null;
        } catch (SAXException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }
    
    public float calculeMoyenne(float id)
    {
        Evaluation_service[] evaluation = findByService(id);
        
        float moyenneservice=0;
        for (int i = 0; i < evaluation.length; i++) {
            
            moyenneservice=moyenneservice+evaluation[i].getNote();
           
        }
        moyenneservice = moyenneservice/(evaluation.length);
        System.out.println(moyenneservice);
        return moyenneservice;
    }

}
    
    
    

