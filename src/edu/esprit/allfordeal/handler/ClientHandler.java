package edu.esprit.allfordeal.handler;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.esprit.allfordeal.dao.Categorie_serviceDao;
import edu.esprit.allfordeal.entities.Categorie_service;
import edu.esprit.allfordeal.entities.Client;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ClientHandler extends DefaultHandler {

    private Vector clientVector;

    public ClientHandler() {
        clientVector = new Vector();
    }

    public Client[] getClient() {
        Client[] clientTab = new Client[clientVector.size()];
        clientVector.copyInto(clientTab);
        return clientTab;
    }
    private Client currentClient;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("client")) {

            int id = Integer.parseInt(attributes.getValue("id"));
            String nom = attributes.getValue("lastName");
            String prenom = attributes.getValue("firstName");
            Date date_naissance = new Date();
//            attributes.getValue("date_naissance")
            String email = attributes.getValue("email");
            int telephone = Integer.parseInt(attributes.getValue("telephone"));
            String login = attributes.getValue("username");
            String password = attributes.getValue("email");
//            Date date_inscription= attributes.getValue("date_inscription");
            Date date_inscription = new Date();
            int sexe = Integer.parseInt(attributes.getValue("sexe"));
            String salt = attributes.getValue("salt");
            String adresse = attributes.getValue("adresse");
            int nb_pts = Integer.parseInt(attributes.getValue("nb_pts"));
//             String nb_pts  = attributes.getValue("nb_pts");

            Categorie_serviceDao csd = new Categorie_serviceDao();
            currentClient = new Client(id, login, email, salt, password, adresse, prenom, nom, telephone, sexe, date_naissance, date_inscription, nb_pts);
            System.out.println(currentClient.getLastName());
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("client")) {
            clientVector.addElement(currentClient);
            currentClient = null;
        }
    }

}
