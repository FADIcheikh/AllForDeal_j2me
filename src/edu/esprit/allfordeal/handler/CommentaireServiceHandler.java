package edu.esprit.allfordeal.handler;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.esprit.allfordeal.dao.ClientDao;
import edu.esprit.allfordeal.dao.ServiceDao;
import edu.esprit.allfordeal.entities.Client;
import edu.esprit.allfordeal.entities.CommentaireService;
import java.util.Date;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CommentaireServiceHandler extends DefaultHandler {

    private Vector commentaireVector;

    public CommentaireServiceHandler() {
        commentaireVector = new Vector();
    }

    public CommentaireService[] getCommentaire() {
        CommentaireService[] commentaireTab = new CommentaireService[commentaireVector.size()];
        commentaireVector.copyInto(commentaireTab);
        return commentaireTab;
    }
    private CommentaireService currentCommentaire;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("commentaire_service")) {

            int id_commentaire = Integer.parseInt(attributes.getValue("id_commentaire"));
            
            String commentaire = attributes.getValue("commentaire");
            int id_client = Integer.parseInt(attributes.getValue("id_client"));
            int id_service = Integer.parseInt(attributes.getValue("id_service"));
            String date = attributes.getValue("date");
            ClientDao cd = new ClientDao();
            ServiceDao sd = new ServiceDao();
            currentCommentaire = new CommentaireService(id_commentaire, commentaire, cd.findById(id_client), sd.findById(id_service), date);
            

        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("commentaire_service")) {
            commentaireVector.addElement(currentCommentaire);
            currentCommentaire = null;
        }
    }

}
