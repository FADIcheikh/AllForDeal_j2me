package edu.esprit.allfordeal.handler;

import edu.esprit.allfordeal.dao.Categorie_serviceDao;
import edu.esprit.allfordeal.dao.ClientDao;
import edu.esprit.allfordeal.entities.Service;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ServiceHandler extends DefaultHandler {

    private Vector serviceVector;

    public ServiceHandler() {
        serviceVector = new Vector();
    }

    public Service[] getService() {
        Service[] serviceTab = new Service[serviceVector.size()];
        serviceVector.copyInto(serviceTab);
        return serviceTab;
    }
    private Service currentService;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("service")) {

            int id_service = Integer.parseInt(attributes.getValue("id_service"));
            String titre= attributes.getValue("titre");
            int categorie = Integer.parseInt(attributes.getValue("id_categorie"));
            String date_fin= attributes.getValue("date_fin");
            String description= attributes.getValue("description");
            int Competence= Integer.parseInt(attributes.getValue("competence"));
            int client= Integer.parseInt(attributes.getValue("id_client"));
            Categorie_serviceDao csd =new Categorie_serviceDao();
            ClientDao cd = new ClientDao();
            currentService = new Service(id_service,titre,csd.findById(categorie),date_fin,description,csd.findById(Competence),cd.findById(client));
            System.out.println(currentService.getTitre());

        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("service")) {
            serviceVector.addElement(currentService);
            currentService = null;
        }
    }

}
