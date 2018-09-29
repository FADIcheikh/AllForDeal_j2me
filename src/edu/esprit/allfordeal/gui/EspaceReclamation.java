/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.gui;

import edu.esprit.allfordeal.dao.ReclamationDao;
import edu.esprit.allfordeal.entities.Reclamation;
import edu.esprit.allfordeal.midlet.Midlet;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.Ticker;

/**
 *
 * @author lenovo i5
 */
public class EspaceReclamation extends List implements CommandListener {

    Ticker ticker = new Ticker("Nous sommes entrain de trater vos reclamations");
    Reclamation[] testTab;
    //String[] str_acceuil = {"Envoyer une reclamation" , "Annuler un reclamation ", "Consulter les reclamation en cours"};
    Command cmd = new Command("next", Command.SCREEN, 0);
    Command cmdexit = new Command("retour", Command.SCREEN, 0);
    String envoi = "Envyer une reclamation";
    String afficher = "Afficher mes reclamations";
    Reclamation[] r;

    public EspaceReclamation(String title, int listType) {
        super(title, listType);

        ReclamationDao rd = new ReclamationDao();
        addCommand(cmdexit);
        this.setTicker(ticker);

        setCommandListener(this);
        r = rd.findAll();
        if (r != null) {
            for (int i = 0; i < r.length; i++) {
                System.out.println(r[i].getTitre());
                
                System.out.println(r[i].getDescription());
                append(r[i].getTitre(),null);
                append(r[i].getDescription(), null);
                append(r[i].getEtat(), null);
                append("Envoyé le " + r[i].getDate(), null);
                append("***********************************", null);

            }
        } else {
            append("Aucune Reclamation", null);
        }

        //  List lst_acceuil = new List("zzz", IMPLICIT, str_acceuil, null);
        //  lst_acceuil.addCommand(cmd);
//        testTab = td.findAll();
//        
//        for (int i = 0; i < testTab.length; i++) {
//            append(testTab[i].getTitre(),null);
//      }
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdexit) {
            Midlet.INSTANCE.disp.setCurrent(new EnvoyerReclamation("Espace Reclamation"));
        }


    }

}
