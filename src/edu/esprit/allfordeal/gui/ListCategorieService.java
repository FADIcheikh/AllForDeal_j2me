/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.gui;

import edu.esprit.allfordeal.dao.Categorie_serviceDao;
import edu.esprit.allfordeal.dao.ServiceDao;
import edu.esprit.allfordeal.entities.Categorie_service;
import edu.esprit.allfordeal.entities.Service;
import edu.esprit.allfordeal.midlet.Midlet;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;

/**
 *
 * @author AZIZ
 */
public class ListCategorieService extends List implements CommandListener {

    Categorie_service[] cs;
    Command choisir = new Command("Choisir", Command.SCREEN, 0);
    Command back = new Command("Back", Command.SCREEN, 0);

    public ListCategorieService(String title, int listType) {
        super(title, listType);

        Categorie_serviceDao csd = new Categorie_serviceDao();

        cs = csd.findAll();
        if (cs != null) {
            for (int i = 0; i < cs.length; i++) {
                append(cs[i].getNom_categorie(), null);
            }
        }else{
            append("Aucune Categorie Service",null);
        }
        addCommand(back);
        addCommand(choisir);

        setCommandListener(this);

    }

    public void commandAction(Command c, Displayable d) {
        if (c == back) {
            Midlet.INSTANCE.disp.setCurrent(new listePS("Menu", List.IMPLICIT));
        }
    }
}
