package edu.esprit.allfordeal.handler;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.esprit.allfordeal.dao.ClientDao;
import edu.esprit.allfordeal.dao.ProduitDao;
import edu.esprit.allfordeal.dao.ServiceDao;
import edu.esprit.allfordeal.entities.Client;
import edu.esprit.allfordeal.entities.CommentaireProduit;
import edu.esprit.allfordeal.entities.CommentaireProduit;
import java.util.Date;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CommentaireProduitHandler extends DefaultHandler {

    private Vector commentaireVector;

    public CommentaireProduitHandler() {
        commentaireVector = new Vector();
    }

    public CommentaireProduit[] getCommentaire() {
        CommentaireProduit[] commentaireTab = new CommentaireProduit[commentaireVector.size()];
        commentaireVector.copyInto(commentaireTab);
        return commentaireTab;
    }
    private CommentaireProduit currentCommentaire;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("commentaire_produit")) {

            int id_commentaire = Integer.parseInt(attributes.getValue("id_commentaire"));
            
            String commentaire = attributes.getValue("commentaire");
            int id_client = Integer.parseInt(attributes.getValue("id_client"));
            int id_produit = Integer.parseInt(attributes.getValue("id_produit"));
            String date = attributes.getValue("date");
            ClientDao cd = new ClientDao();
            ProduitDao pd = new ProduitDao();
            currentCommentaire = new CommentaireProduit(id_commentaire, commentaire, cd.findById(id_client), pd.findById(id_produit), date);
            

        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("commentaire_produit")) {
            commentaireVector.addElement(currentCommentaire);
            currentCommentaire = null;
        }
    }

}
