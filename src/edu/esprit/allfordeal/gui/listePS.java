/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.gui;

import edu.esprit.allfordeal.midlet.Midlet;
import java.io.IOException;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.Ticker;
import javax.obex.Authenticator;

/**
 *
 * @author Yesmine
 */
public class listePS extends List implements CommandListener {

    ImageItem ii;

//    Ticker ticker = new Ticker("All For Deal");
    Command cmdselect = new Command("select", Command.SCREEN, 0);
    Command cmdexit = new Command("exit", Command.EXIT, 0);

    public listePS(String title, int listType) {
        super(title, listType);
        this.append("Consulter Produits", null);
        this.append("Consulter Services", null);
        this.append("Deposer une Reclamation", null);
        this.append("Consulter Panier", null);

        this.append("Deconnexion", null);
        this.append("Statistiques", null);
        addCommand(cmdexit);
        addCommand(cmdselect);
        setCommandListener(this);

    }

    public void commandAction(Command c, Displayable d) {

        if (c == cmdexit) {
            Midlet.INSTANCE.notifyDestroyed();

        }

        if (c == cmdselect) {

            if (getSelectedIndex() == 0) {
                Midlet.INSTANCE.disp.setCurrent(new ListCategorieProduit("Categorie Produit", List.IMPLICIT));
            }
            if (getSelectedIndex() == 1) {
                Midlet.INSTANCE.disp.setCurrent(new Canvas1());
            }
            if (getSelectedIndex() == 2) {
                Midlet.INSTANCE.disp.setCurrent(new EnvoyerReclamation("Espace Reclamation"));
            }
            if (getSelectedIndex() == 3) {
                Midlet.INSTANCE.disp.setCurrent(new ConsulterPanier("Mon Panier", List.IMPLICIT));
                Midlet.c = null;
            }
            if (getSelectedIndex() == 4) {
                Midlet.INSTANCE.disp.setCurrent(new Authentification("Authentification", Midlet.INSTANCE.disp));
                Midlet.c = null;
            }
            
            if (getSelectedIndex() == 5) {
                Midlet.INSTANCE.disp.setCurrent(new StatCanvas());
            }

        }

    }

}
