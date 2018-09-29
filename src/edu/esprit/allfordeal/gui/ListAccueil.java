/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.gui;

import edu.esprit.allfordeal.midlet.Midlet;
import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;

/**
 *
 * @author Yesmine
 */
public class ListAccueil extends List implements CommandListener {

    String[] str_acceuil = {"Envoyer une reclamation", "Voir mes reclamations"};
    Command cmdexit = new Command("exit", Command.EXIT, 0);
    Command cmd = new Command("next", Command.SCREEN, 0);

    public ListAccueil(String title, int listType) {
        super(title, listType);
        this.addCommand(cmd);

        this.setCommandListener(this);

    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdexit) {
            Midlet.INSTANCE.notifyDestroyed();
        }
        if (c == cmd) {
            if (this.getSelectedIndex() == 0) {
                Midlet.INSTANCE.disp.setCurrent(new EnvoyerReclamation("Espace d'envoie des reclamations"));

            }
            if (this.getSelectedIndex() == 1) {
                Midlet.INSTANCE.disp.setCurrent(new EspaceReclamation("Espace reclamation", List.IMPLICIT));
            }

        }
    }

}
