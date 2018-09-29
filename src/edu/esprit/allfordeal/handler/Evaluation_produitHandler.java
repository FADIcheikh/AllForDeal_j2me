package edu.esprit.allfordeal.handler;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.esprit.allfordeal.entities.Evaluation_produit;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Evaluation_produitHandler extends DefaultHandler {
    
    private Vector evaluation_produitVector;

    public Evaluation_produitHandler() {
        evaluation_produitVector = new Vector();
    }

    public Evaluation_produit[] getEvaluation_produit() {
        Evaluation_produit[] evaluation_produitTab = new Evaluation_produit[evaluation_produitVector.size()];
        evaluation_produitVector.copyInto(evaluation_produitTab);
        return evaluation_produitTab;
    }
    private Evaluation_produit currentEvaluation_produit;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("evaluation_produit")) {

                   
            int id_evaluation = Integer.parseInt(attributes.getValue("id_evaluation"));
            int note = Integer.parseInt(attributes.getValue("note"));
           int id_client = Integer.parseInt(attributes.getValue("id_client")); 
           int id_produit = Integer.parseInt(attributes.getValue("id_produit"));
           currentEvaluation_produit = new Evaluation_produit(id_evaluation,note,id_client,id_produit);

        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("evaluation_produit")) {
            evaluation_produitVector.addElement(currentEvaluation_produit);
            currentEvaluation_produit = null;
        }
    }

}
