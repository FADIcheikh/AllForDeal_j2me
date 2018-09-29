/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.gui;

import edu.esprit.allfordeal.dao.Categorie_produitDao;
import edu.esprit.allfordeal.dao.Categorie_serviceDao;
import edu.esprit.allfordeal.dao.CommentaireProduitDao;
import edu.esprit.allfordeal.entities.Categorie_produit;
import edu.esprit.allfordeal.entities.Categorie_service;
import edu.esprit.allfordeal.entities.CommentaireProduit;
import edu.esprit.allfordeal.entities.Produit;
import edu.esprit.allfordeal.midlet.Midlet;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;

/**
 *
 * @author AZIZ
 */
public class ListCommentaire extends List implements CommandListener {

    CommentaireProduit[] cs;
    Command back = new Command("Retour", Command.SCREEN, 0);
    Command cmt = new Command("Commenter", Command.SCREEN, 0);
    Produit p;

    public ListCommentaire(String title, int listType, Produit produit) {
        super(title, listType);
        this.p = produit;
        CommentaireProduitDao cpd = new CommentaireProduitDao();

        cs = cpd.findByProduit(p);
        if (cs != null) {
            for (int i = 0; i < cs.length; i++) {
                append(cs[i].getClient().getLastName()+ " " +
                       cs[i].getClient().getFirstName()+ "\n" + cs[i].getCommentaire(), null);
                append("-----------------------", null);
            }
        }else{
            append("Aucun Commentaire",null);
        }
        addCommand(back);
        addCommand(cmt);
        setCommandListener(this);

    }

    public void commandAction(Command c, Displayable d) {
        if (c == back) {
            Midlet.INSTANCE.disp.setCurrent(new DescriptionCanvas(p));
        }
        if (c == cmt) {
            Midlet.INSTANCE.disp.setCurrent(new Commentaire("Commenter sur " + p.getTitre(), p));
        }

    }
}
