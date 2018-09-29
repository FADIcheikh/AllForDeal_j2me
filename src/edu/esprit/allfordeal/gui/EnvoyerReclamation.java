/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.gui;

import edu.esprit.allfordeal.dao.ReclamationDao;
import edu.esprit.allfordeal.entities.Client;
import edu.esprit.allfordeal.entities.Reclamation;
import edu.esprit.allfordeal.midlet.Midlet;
import java.util.Calendar;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;
import javax.microedition.lcdui.Ticker;

/**
 *
 * @author Maynoo
 */
public class EnvoyerReclamation extends Form implements CommandListener {

    Calendar z = Calendar.getInstance();
    String time;
    TextField tfTitre = new TextField("Titre", "", 50, TextField.ANY);
    TextField tfDes = new TextField("Description", "", 50, TextField.ANY);
    Ticker ticker = new Ticker("Nous traiterons votre reclamation avec plaisir");
    Alert alt= new  Alert("Ajout effectuer avec succées","",null,AlertType.CONFIRMATION);
    Command ajouter = new Command("Ajouter", Command.SCREEN, 0);
    Command retour = new Command("retour", Command.SCREEN, 0);
    Command aff  = new Command("Mes Reclamations",Command.SCREEN,0);
    Reclamation r = new Reclamation();

    public EnvoyerReclamation(String title) {
        super(title);

        this.setTicker(ticker);
        append(tfTitre);
        append(tfDes);
        
        addCommand(retour);
        addCommand(ajouter);
        addCommand(aff);
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

            time = z.get(Calendar.YEAR) + "-" + z.get(Calendar.MONTH)
                    + "-" + z.get(Calendar.DAY_OF_MONTH);

            Client x = new Client();
            x.setId(1);
            ReclamationDao rd = new ReclamationDao();
            r.setTitre(tfTitre.getString());
            
            r.setDescription(tfDes.getString());
            r.setDate(time);
            r.setEtat("Actif");
            r.setClient(x);
            rd.ajouterReclamation(r);
            Midlet.INSTANCE.disp.setCurrent(alt);
        }
        if (c == retour) {
            Midlet.INSTANCE.disp.setCurrent(new listePS("Menu", List.IMPLICIT));
        }
        if (c == aff) {
            Midlet.INSTANCE.disp.setCurrent(new EspaceReclamation("Mes Reclamations", List.IMPLICIT));
        }
    }

}
