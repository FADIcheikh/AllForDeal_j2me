package edu.esprit.allfordeal.handler;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.esprit.allfordeal.entities.Categorie_produit;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Categorie_produitHandler extends DefaultHandler {

    private Vector categorie_produitVector;

    public Categorie_produitHandler() {
        categorie_produitVector = new Vector();
    }

    public Categorie_produit[] getCategorie_produit() {
        Categorie_produit[] categorie_produitTab = new Categorie_produit[categorie_produitVector.size()];
        categorie_produitVector.copyInto(categorie_produitTab);
        return categorie_produitTab;
    }
    private Categorie_produit currentCategorie_produit;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("categorie_produit")) {

            int id_categorie_produit = Integer.parseInt(attributes.getValue("id_categorie_produit"));
            String nom_categorie_produit = attributes.getValue("nom_categorie_produit");
            int nb_pts_categorie_produit = Integer.parseInt(attributes.getValue("nb_pts_categorie_produit"));
            currentCategorie_produit = new Categorie_produit(id_categorie_produit, nom_categorie_produit, nb_pts_categorie_produit);

        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("categorie_produit")) {
            categorie_produitVector.addElement(currentCategorie_produit);
            currentCategorie_produit = null;
        }
    }

}
