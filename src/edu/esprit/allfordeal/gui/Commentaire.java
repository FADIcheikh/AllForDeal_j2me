/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.gui;

import edu.esprit.allfordeal.dao.CommentaireProduitDao;
import edu.esprit.allfordeal.entities.Client;
import edu.esprit.allfordeal.entities.CommentaireProduit;
import edu.esprit.allfordeal.entities.Produit;
import edu.esprit.allfordeal.entities.Reclamation;
import edu.esprit.allfordeal.midlet.Midlet;
import java.util.Date;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;

/**
 *
 * @author Maynoo
 */
public class Commentaire extends Form implements CommandListener {

    TextField tfCommentaire = new TextField("Commenter", "", 50, TextField.ANY);
    Command ajouter = new Command("Commenter", Command.SCREEN, 0);
    Command retour = new Command("retour", Command.SCREEN, 0);
    Produit p;

    public Commentaire(String title, Produit produit) {

        super(title);
        this.p = produit;
        append(tfCommentaire);
        addCommand(ajouter);
        addCommand(retour);
        setCommandListener(this);

    }

//    public void commandAction(Command c, Displayable d) {
//        Test t = new Test(0, tfNom.getString(), tfPrenom.getString());
//        TestDao td = new TestDao();
//        td.ajouterTest(t);
//
//    }
    public void commandAction(Command c, Displayable d) {
        if (c == ajouter) {

            CommentaireProduit cp = new CommentaireProduit();
            cp.setClient(Midlet.c);
            cp.setProduit(p);
            cp.setId_commentaire(0);
            CommentaireProduitDao cpd = new CommentaireProduitDao();

            cp.setCommentaire(tfCommentaire.getString());
            Date jjj = new Date();
            cp.setDate("2000-01-01");

            cpd.ajouterCommentaire(cp);
            Midlet.INSTANCE.disp.setCurrent(new ListCommentaire("Commentaires de "+p.getTitre(),List.IMPLICIT,p));

        }
        if (c == retour) {
            Midlet.INSTANCE.disp.setCurrent(new ListCommentaire("Commentaires de "+p.getTitre(),List.IMPLICIT,p));

        }
    }

}
