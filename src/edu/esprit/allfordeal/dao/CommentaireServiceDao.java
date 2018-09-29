/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.dao;

import edu.esprit.allfordeal.entities.CommentaireService;
import edu.esprit.allfordeal.entities.CommentaireService;
import edu.esprit.allfordeal.handler.CommentaireServiceHandler;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author Maynoo
 */
public class CommentaireServiceDao {

    CommentaireService[] commentaireTab;
    HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/allfordeal/j2me/CommentaireServiceDao.php?action=";

    public void ajouterCommentaire(CommentaireService commentaireService) {
        try {

            hc = (HttpConnection) Connector.
                        open(url + "ajouterCommentaire" + "&id_commentaire="
                                    + commentaireService.getId_commentaire() + "&commentaire="
                                    + commentaireService.getCommentaire()
                                    + "&id_client=" + commentaireService.getClient().getId() + "&id_service="
                                    + commentaireService.getService().getId_service() + "&date=" + commentaireService.getDate());
            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void supprimerCommentaire(CommentaireService commentaireService) {
        try {

            hc = (HttpConnection) Connector.
                        open(url + "supprimerCommentaire" + "&id_commentaire=" + commentaireService.getId_commentaire());
            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public CommentaireService[] findAll() {
        try {

            CommentaireServiceHandler commentaireServiceHandler = new CommentaireServiceHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findAll");//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, commentaireServiceHandler);
            // display the result
            commentaireTab = commentaireServiceHandler.getCommentaire();
            dis.close();
            hc.close();
            return commentaireTab;
        } catch (ParserConfigurationException ex) {
            return null;
        } catch (SAXException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }

    public CommentaireService findById(int id) {
        try {

            CommentaireServiceHandler commentaireServiceHandler = new CommentaireServiceHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findById&id_commentaire=" + id);//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, commentaireServiceHandler);
            // display the result
            commentaireTab = commentaireServiceHandler.getCommentaire();
            dis.close();
            hc.close();
            return commentaireTab[0];
        } catch (ParserConfigurationException ex) {
            return null;
        } catch (SAXException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }
}
