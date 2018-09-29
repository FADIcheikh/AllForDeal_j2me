package edu.esprit.allfordeal.handler;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.esprit.allfordeal.entities.Evaluation_service;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Evaluation_serviceHandler extends DefaultHandler {

    private Vector evaluation_serviceVector;

    public Evaluation_serviceHandler() {
        evaluation_serviceVector = new Vector();
    }

    public Evaluation_service[] getEvaluation_service() {
        Evaluation_service[] evaluation_serviceTab = new Evaluation_service[evaluation_serviceVector.size()];
        evaluation_serviceVector.copyInto(evaluation_serviceTab);
        return evaluation_serviceTab;
    }
    private Evaluation_service currentEvaluation_service;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("evaluation_service")) {

            int id_evaluation = Integer.parseInt(attributes.getValue("id_evaluation"));
            int note = Integer.parseInt(attributes.getValue("note"));
            int id_client = Integer.parseInt(attributes.getValue("id_client"));
            int id_service = Integer.parseInt(attributes.getValue("id_service"));
            System.out.println(id_client);
            currentEvaluation_service = new Evaluation_service(id_evaluation, note, id_client, id_service);

        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("evaluation_service")) {
            evaluation_serviceVector.addElement(currentEvaluation_service);
            currentEvaluation_service = null;
        }
    }

}
