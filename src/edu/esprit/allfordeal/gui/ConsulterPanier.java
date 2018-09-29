/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.gui;

import edu.esprit.allfordeal.dao.PanierDao;

import edu.esprit.allfordeal.entities.Panier;
import edu.esprit.allfordeal.midlet.Midlet;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;

/**
 *
 * @author AZIZ
 */
public class ConsulterPanier extends List implements CommandListener {

    Panier[] cs;
    Command back = new Command("Retour", Command.SCREEN, 0);
    Command consulter = new Command("Consulter",Command.SCREEN,0);

    public ConsulterPanier(String title, int listType) {
        super(title, listType);
        PanierDao pd = new PanierDao();

        cs = pd.findByClient(Midlet.c);
        System.out.println(Midlet.c.getId());
        if (cs != null) {
            for (int i = 0; i < cs.length; i++) {
                append(cs[i].getP().getTitre(), null);
            }
        } else {
            append("Aucun Produit", null);
        }
        addCommand(back);
        addCommand(consulter);
        setCommandListener(this);

    }

    public void commandAction(Command c, Displayable d) {
        if (c == back) {
            Midlet.INSTANCE.disp.setCurrent(new listePS("Menu", List.IMPLICIT));
        }
        if (c == consulter) {
            Midlet.INSTANCE.disp.setCurrent(new DescriptionCanvas(cs[getSelectedIndex()].getP()));
        }
    }
}
