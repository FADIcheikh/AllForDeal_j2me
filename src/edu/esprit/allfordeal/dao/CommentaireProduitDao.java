/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.dao;

import edu.esprit.allfordeal.entities.CommentaireProduit;
import edu.esprit.allfordeal.entities.Produit;
import edu.esprit.allfordeal.handler.CommentaireProduitHandler;
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
public class CommentaireProduitDao {

    CommentaireProduit[] commentaireTab;
    HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/allfordeal/j2me/CommentaireProduitDao.php?action=";

    public void ajouterCommentaire(CommentaireProduit commentaireProduit) {
        try {

            hc = (HttpConnection) Connector.
                        open(url + "ajouterCommentaire" + "&id_commentaire="
                                    + commentaireProduit.getId_commentaire() + "&commentaire="
                                    + commentaireProduit.getCommentaire()
                                    + "&id_client=" + commentaireProduit.getClient().getId() + "&id_produit="
                                    + commentaireProduit.getProduit().getId_produit() + "&date=" + commentaireProduit.getDate());

            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void supprimerCommentaire(CommentaireProduit commentaireProduit) {
        try {

            hc = (HttpConnection) Connector.
                        open(url + "supprimerCommentaire" + "&id_commentaire="
                                    + commentaireProduit.getId_commentaire());
            dis = hc.openDataInputStream();
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public CommentaireProduit[] findAll() {
        try {
            System.out.println("test0");
            CommentaireProduitHandler commentaireProduitHandler = new CommentaireProduitHandler();
            // get a parser object
            System.out.println("test1");
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findAll");//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, commentaireProduitHandler);
            // display the result
            System.out.println("test2");
            commentaireTab = commentaireProduitHandler.getCommentaire();
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

    public CommentaireProduit[] findByProduit(Produit p) {
        try {
            System.out.println("test0");
            CommentaireProduitHandler commentaireProduitHandler = new CommentaireProduitHandler();
            // get a parser object
            System.out.println("test1");
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findByProduit&id_produit=" + p.getId_produit());//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, commentaireProduitHandler);
            // display the result
            System.out.println("test2");
            commentaireTab = commentaireProduitHandler.getCommentaire();
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

    public CommentaireProduit findById(int id) {
        try {

            CommentaireProduitHandler commentaireProduitHandler = new CommentaireProduitHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            hc = (HttpConnection) Connector.open(url + "findById&id_commentaire=" + id);//people.xml est un exemple
            dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, commentaireProduitHandler);
            // display the result
            commentaireTab = commentaireProduitHandler.getCommentaire();
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
