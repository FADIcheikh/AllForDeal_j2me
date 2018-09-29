package edu.esprit.allfordeal.handler;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.esprit.allfordeal.entities.Categorie_service;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Categorie_serviceHandler extends DefaultHandler {
    
    private Vector categorie_serviceVector;

    public Categorie_serviceHandler() {
        categorie_serviceVector = new Vector();
    }

    public Categorie_service[] getCategorie_service() {
        Categorie_service[] categorie_serviceTab = new Categorie_service[categorie_serviceVector.size()];
        categorie_serviceVector.copyInto(categorie_serviceTab);
        return categorie_serviceTab;
    }
    private Categorie_service currentCategorie_service;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("categorie_service")) {

            int id_categorie = Integer.parseInt(attributes.getValue("id_categorie"));
            String nom_categorie = attributes.getValue("nom_categorie");
            int nb_pts = Integer.parseInt(attributes.getValue("nb_pts"));
            currentCategorie_service = new Categorie_service(id_categorie, nom_categorie, nb_pts);

        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("categorie_service")) {
            categorie_serviceVector.addElement(currentCategorie_service);
            currentCategorie_service = null;
        }
    }

}
