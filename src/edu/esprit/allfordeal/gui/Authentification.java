/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.gui;

import edu.esprit.allfordeal.dao.ClientDao;
import edu.esprit.allfordeal.entities.Client;
import edu.esprit.allfordeal.midlet.Midlet;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Vector;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;

/**
 *
 * @author FADI
 */
public class Authentification extends Form implements CommandListener {

    StringBuffer sb;
    Client pers;
    Display disp;

    String url = "http://localhost/allfordeal/j2me/fichier.php?";

    Command cminscrit = new Command("S'inscrire", Command.SCREEN, 0);
    Command cmlogin = new Command("Login", Command.SCREEN, 1);

    TextField login = new TextField("Login", null, 500, TextField.ANY);
    TextField password = new TextField("Mot de passe ", null, 500, TextField.PASSWORD);

    public Authentification(String title, Display disp) {
        super(title);
        try {
            append(new ImageItem(null, Image.createImage("/Images/alll.png"), ImageItem.LAYOUT_CENTER, "image not found"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        append(login);
        append(password);
        addCommand(cmlogin);
        addCommand(cminscrit);
        setCommandListener(this);

    }

    public void commandAction(Command c, Displayable d) {

        if (c == cminscrit) {
            Midlet.INSTANCE.disp.setCurrent(new Inscription("Inscription", Midlet.INSTANCE.disp));
        }
        if (c == cmlogin) {
            url += "&login=" + login.getString().trim() + "&password=" + password.getString().trim();
            try {
                HttpConnection hc = (HttpConnection) Connector.open(url);
                DataInputStream dis = new DataInputStream(hc.openDataInputStream());

                int ch;
                sb = new StringBuffer();
                while ((ch = dis.read()) != -1) {
                    sb.append((char) ch);
                }
                String[] tab = Split(sb.toString().trim(), "+");
                System.out.println(tab[0]);
                dis.close();
                hc.close();
                if ((sb.toString().trim().equals("no"))/*||(password.getString()=="")*/) {
                    Alert erreur = new Alert("Attention!", "Veuillez verifier vos informations", null, AlertType.ERROR);
                    ClientDao cd = new ClientDao();
                    Midlet.c=cd.findById(57);
                    Midlet.INSTANCE.disp.setCurrent(new listePS("Acceuil",List.IMPLICIT));
                    
                    login.setString("");
                    password.setString("");
                } else {

                    Alert a = new Alert("Bienvenue ", login.getString(), null, AlertType.ALARM);
                    a.setTimeout(3000);
                    ClientDao cd = new ClientDao();
                    Midlet.c = cd.findByLogin(login.getString().trim());
                    
                    Midlet.c = new Client();
                       Midlet.c=cd.findByLogin(login.getString().trim());
                       Midlet.c=cd.findById(57);
//                    Midlet.c.setId(56);
//                    System.out.println("connecter en tant que "+Midlet.c.getId());
                    Midlet.INSTANCE.disp.setCurrent(a, new listePS("Menu", List.IMPLICIT));
                    //  Midlet.mid.dis.setCurrent(new acceuil("Bienvenue",Midlet.mid.dis));
                }

            } catch (IOException ex) {

            }
        }

    }

    public static String[] Split(String splitStr, String delimiter) {
        StringBuffer token = new StringBuffer();
        Vector tokens = new Vector();
        // split
        char[] chars = splitStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (delimiter.indexOf(chars[i]) != -1) {
                // we bumbed into a delimiter
                if (token.length() > 0) {
                    tokens.addElement(token.toString());
                    token.setLength(0);
                }
            } else {
                token.append(chars[i]);
            }
        }
        // don't forget the "tail"...
        if (token.length() > 0) {
            tokens.addElement(token.toString());
        }
        // convert the vector into an array
        String[] splitArray = new String[tokens.size()];
        for (int i = 0; i < splitArray.length; i++) {
            splitArray[i] = (String) tokens.elementAt(i);
        }
        return splitArray;
    }
}
