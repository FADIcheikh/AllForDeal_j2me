/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.allfordeal.handler;

import edu.esprit.allfordeal.dao.ClientDao;
import edu.esprit.allfordeal.dao.ProduitDao;
import edu.esprit.allfordeal.entities.Panier;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author lenovo i5
 */
public class PanierHandler extends DefaultHandler {

    private Vector panierVector;

    public PanierHandler() {
        panierVector = new Vector();
    }

    public Panier[] getPanier() {
        Panier[] panierTab = new Panier[panierVector.size()];
        panierVector.copyInto(panierTab);
        return panierTab;
    }
    private Panier currentPanier;


    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("panier")) {

            int id_produit = Integer.parseInt(attributes.getValue("id_produit"));
            int id_client = Integer.parseInt(attributes.getValue("id_client"));
            
            
           
            
            ClientDao cd = new ClientDao();
            ProduitDao pd=new ProduitDao();
            currentPanier = new Panier(cd.findById(id_client),pd.findById(id_produit));

        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("panier")) {
            panierVector.addElement(currentPanier);
            currentPanier = null;
        }
    }

}
