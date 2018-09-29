/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.gui;

import edu.esprit.allfordeal.midlet.Midlet;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Calendar;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.TextField;

/**
 *
 * @author Yesmine
 */
public class publierProduit extends Form implements
            CommandListener {

    ImageItem ii;
    //textField
    TextField tftitre = new TextField("titre produit", "", 20, TextField.ANY);
    TextField tfcategorie = new TextField("Categorie", "", 20, TextField.ANY);
    TextField tfmarque = new TextField("marque", "", 20, TextField.ANY);
    TextField tfprix = new TextField("prix", "", 10, TextField.ANY | TextField.NUMERIC);
    DateField tfdatefin = new DateField("Date", DateField.DATE);
    TextField tfquantite = new TextField("quantite", "", 10, TextField.ANY);
    TextField tfDescription = new TextField("Description", "", 500, TextField.ANY);
    Calendar cal = Calendar.getInstance();
    //commandes
    Command cmdNext = new Command("next", Command.SCREEN, 0);
    Command cmdexit = new Command("exit", Command.EXIT, 0);

    //connecxion
    HttpConnection hc;
    DataInputStream dis;
    StringBuffer sb;
    String url = "http://localhost/allfordeal/j2me/ProduitDao.php?action";

    public publierProduit() {
        super("Publier Produit");
        append(tftitre);
        append(tfcategorie);
        append(tfmarque);
        append(tfdatefin);
        append(tfprix);
        append(tfquantite);
        addCommand(cmdNext);
        addCommand(cmdexit);
        setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdexit) {
            Midlet.INSTANCE.notifyDestroyed();

        }

        if (c == cmdNext) {
            try {
                String titre, categorie, marque, date_fin;
                titre = tftitre.getString();
                categorie = tfcategorie.getString();
                marque = tfmarque.getString();

                date_fin = (cal.get(Calendar.YEAR) + "-"
                            + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH)).trim();;

                hc = (HttpConnection) Connector.
                            open(url + "ajouterProduit" + "&titre=" + titre
                                        + "&categorie=" + categorie
                                        + "&marque=" + marque
                                        + "&date_fin=" + date_fin);
                dis = hc.openDataInputStream();
                dis.close();
                hc.close();
                int ascii;
                sb = new StringBuffer();

                while ((ascii = dis.read()) != -1) {

                    sb.append((char) ascii);

                }

                if (sb.toString().equals("successfully added")) {
                    Alert a = new Alert("Information", sb.toString(), null, AlertType.CONFIRMATION);
                    a.setTimeout(3000);
                    Midlet.INSTANCE.disp.setCurrent(a);
                } else {
                    Alert a = new Alert("Information", sb.toString(), null, AlertType.ERROR);
                    a.setTimeout(3000);
                    Midlet.INSTANCE.disp.setCurrent(a);
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }

}
