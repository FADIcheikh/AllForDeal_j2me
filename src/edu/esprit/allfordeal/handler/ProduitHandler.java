package edu.esprit.allfordeal.handler;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import edu.esprit.allfordeal.dao.Categorie_produitDao;
import edu.esprit.allfordeal.dao.ClientDao;
import edu.esprit.allfordeal.entities.Client;
import edu.esprit.allfordeal.entities.Produit;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class ProduitHandler extends DefaultHandler {
    // this will hold all the data we read
    private Vector produitVector;
 
    public ProduitHandler() {
        produitVector = new Vector();
    }
 
    public Produit[] getProduit() {
        Produit[] produitTab = new Produit[produitVector.size()];
        produitVector.copyInto(produitTab);
        return produitTab;
    }
 
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
 
    private Produit currentProduit;
 
    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
 
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("produit")) {
		    // create new Person object
            
            
            // "attributes" holds name and value pairs from inside the tag
            int id_produit = Integer.parseInt(attributes.getValue("id_produit"));
            String titre = attributes.getValue("titre");
            int categorie = Integer.parseInt(attributes.getValue("categorie"));
            String marque = attributes.getValue("marque");
            Float prix = Float.valueOf(attributes.getValue("prix"));
            String date_fin = attributes.getValue("date_fin");
            int estValide = Integer.parseInt(attributes.getValue("est_valide"));
            int quantite = Integer.parseInt(attributes.getValue("quantite"));

            int estAchetee = Integer.parseInt(attributes.getValue("estAchetee"));
            String pict = attributes.getValue("pict");
            String description = attributes.getValue("description");
            int id_client = Integer.parseInt(attributes.getValue("id_cliente"));
            ClientDao cd = new ClientDao();
            Categorie_produitDao csd = new Categorie_produitDao();
            currentProduit = new Produit(id_produit,titre,csd.findById(categorie),marque,prix,date_fin,estValide,quantite,estAchetee,pict,description,cd.findById(id_client));
        }   
    }
 
    // endElement is the closing part ("</tagname>"), or the opening part if it ends with "/>"
    // so, a tag in the form "<tagname/>" generates both startElement() and endElement()
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("produit")) {
            // add completed Person object to collection
              produitVector.addElement(currentProduit);
            
            // we are no longer processing a <person.../> tag
            currentProduit = null;
        } 
    }
 
}