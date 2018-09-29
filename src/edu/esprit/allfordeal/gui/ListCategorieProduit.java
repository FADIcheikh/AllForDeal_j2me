/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.gui;

import edu.esprit.allfordeal.dao.Categorie_produitDao;
import edu.esprit.allfordeal.dao.Categorie_serviceDao;
import edu.esprit.allfordeal.entities.Categorie_produit;
import edu.esprit.allfordeal.entities.Categorie_service;
import edu.esprit.allfordeal.midlet.Midlet;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;

/**
 *
 * @author AZIZ
 */
public class ListCategorieProduit extends List implements CommandListener {

    Categorie_produit[] cs;
    Command choisir = new Command("Choisir", Command.SCREEN, 0);
    Command back = new Command("Retour", Command.SCREEN, 0);

    public ListCategorieProduit(String title, int listType) {
        super(title, listType);

        Categorie_produitDao cpd = new Categorie_produitDao();

        cs = cpd.findAll();
        if (cs != null) {
            for (int i = 0; i < cs.length; i++) {
                append(cs[i].getNom_categorie_produit(), null);
            }
        }else{
            append("Aucune Categorie",null);
        }
        addCommand(back);
        addCommand(choisir);

        setCommandListener(this);

    }

    public void commandAction(Command c, Displayable d) {
        if (c == back) {
            Midlet.INSTANCE.disp.setCurrent(new listePS("Menu", List.IMPLICIT));
        }
        if (c == choisir) {
            Midlet.INSTANCE.disp.setCurrent(new CanvasMenu(cs[getSelectedIndex()]));
        }
    }
}
