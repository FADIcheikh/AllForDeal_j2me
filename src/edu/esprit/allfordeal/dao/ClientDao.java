/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.allfordeal.dao;

import edu.esprit.allfordeal.entities.Client;
import edu.esprit.allfordeal.handler.ClientHandler;
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
public class ClientDao {
    
    Client[] clientTab;
    HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/allfordeal/j2me/ClientDao.php?action=";

    public void ajouterClient(Client client) {
        try {

            hc = (HttpConnection) Connector.
                    open(url + "ajouterClient"
                            + "&id_client=" + client.getId()
                            + "&nom=" + client.getLastName()
                            + "&prenom=" + client.getFirstName()
                            + "&date_naissance" + client.getDateNaissance()
                            + "&mail=" + client.getEmail()
                            + "&telephone=" + client.getTelephone()
                            + "&login=" + client.getUsername()
                            + "&password=" + client.getPassword()
                            + "&date_inscription=" + client.getDateInscription()
                            + "&sexe=" + client.getSexe());

            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void modifierClient(Client client) {
        try {

            hc = (HttpConnection) Connector.
                    open(url + "modifierClient"
                            + "&id_client=" + client.getId()
                            + "&nom=" + client.getLastName()
                            + "&prenom=" + client.getFirstName()
                            + "&date_naissance" + client.getDateNaissance()
                            + "&mail=" + client.getEmail()
                            + "&telephone=" + client.getTelephone()
                            + "&login=" + client.getUsername()
                            + "&password=" + client.getPassword()
                            
                            + "&date_inscription=" + client.getDateInscription()
                            + "&sexe=" + client.getSexe());
                          
            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void supprimerClient(Client client) {
        try {

            hc = (HttpConnection) Connector.
                    open(url + "supprimerClient" + "&id=" + client.getId());
            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public Client[] findAll() {
        try {

            ClientHandler clientHandler = new ClientHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findAll");//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, clientHandler);
            // display the result
            clientTab = clientHandler.getClient();
            dis.close();
            hc.close();
            return clientTab;
        } catch (ParserConfigurationException ex) {
            return null;
        } catch (SAXException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }

    public Client findById(int id_client) {
        try {

            ClientHandler clientHandler = new ClientHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findById&id=" + id_client);//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, clientHandler);
            // display the result
            clientTab = clientHandler.getClient();
            dis.close();
            hc.close();
            return clientTab[0];
        } catch (ParserConfigurationException ex) {
            return null;
        } catch (SAXException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }
    public Client findByLogin(String login) {
        try {

            ClientHandler clientHandler = new ClientHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findByLogin&username=" + login);//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, clientHandler);
            // display the result
            clientTab = clientHandler.getClient();
            dis.close();
            hc.close();
            return clientTab[0];
        } catch (ParserConfigurationException ex) {
            return null;
        } catch (SAXException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }
    
}
