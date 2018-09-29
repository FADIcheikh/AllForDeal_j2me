package edu.esprit.allfordeal.handler;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.esprit.allfordeal.dao.ClientDao;
import edu.esprit.allfordeal.entities.Client;
import edu.esprit.allfordeal.entities.Reclamation;
import java.util.Date;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReclamationHandler extends DefaultHandler {

    private Vector reclamationVector;

    public ReclamationHandler() {
        reclamationVector = new Vector();
    }

    public Reclamation[] getReclamation() {
        Reclamation[] reclamationTab = new Reclamation[reclamationVector.size()];
        reclamationVector.copyInto(reclamationTab);
        return reclamationTab;
    }
    private Reclamation currentReclamation;


    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("reclamation")) {

            int id_reclamation = Integer.parseInt(attributes.getValue("id_reclamation"));
            String titre = attributes.getValue("titre");
            String etat = attributes.getValue("etat");
            String description = attributes.getValue("description");
            int id_client = Integer.parseInt(attributes.getValue("id_client"));
            
            String date = attributes.getValue("date");
            
            ClientDao cd = new ClientDao();
            currentReclamation = new Reclamation(id_reclamation,titre,etat,description,cd.findById(id_client),date);

        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("reclamation")) {
            reclamationVector.addElement(currentReclamation);
            currentReclamation = null;
        }
    }

}
