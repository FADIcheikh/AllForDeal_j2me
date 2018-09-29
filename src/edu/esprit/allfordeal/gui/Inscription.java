/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.gui;

import edu.esprit.allfordeal.entities.Client;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;
import edu.esprit.allfordeal.midlet.Midlet;

/**
 *
 * @author FADI
 */
public class Inscription extends Form implements CommandListener, Runnable {

    Client user;
    HttpConnection ht;
    HttpConnection htt;
    DataInputStream dtt;
    DataInputStream dt;
    int x;
    int ch;
    Display disp;

    TextField tfprenom = new TextField("prenom", null, 20, TextField.ANY);
    TextField tfNom = new TextField("Nom", null, 20, TextField.ANY);
    TextField tfmail = new TextField("Email", null, 500, TextField.ANY);
    TextField tftel = new TextField("Telephone", null, 500, TextField.NUMERIC);
    TextField tfLogin = new TextField("Login", null, 20, TextField.ANY);
    TextField tfPassword = new TextField("Mot de passe", null, 50, TextField.ANY);
    DateField date = new DateField("Date", DateField.DATE);

    String[] tabSexe = {"Homme", "Femme"};
    ChoiceGroup sexe = new ChoiceGroup("Sexe", ChoiceGroup.POPUP, tabSexe, null);
    
    String[] tabCouv = {"Ariana", "Béja","Ben Arous","Bizerte","Gabes","Gafsa","Jendouba","Kairouan","Kasserine","Kebili",
    "Mannouba","Kef","Mahdia","Medenine","Monastir","Nabeul","Sfax","Sidi Bouzid","Siliana","Sousse","Tataouine","Tozeur",
    "Tunis","Zaghouan"};
    ChoiceGroup gouv = new ChoiceGroup("Gouvernorat", ChoiceGroup.POPUP, tabCouv, null);
    
    Command inscrit = new Command("Submit", Command.SCREEN, 0);
    Command back = new Command("Retour", Command.SCREEN, 1);
    Alert alt = new Alert(null, null, null, AlertType.CONFIRMATION);

    public Inscription(String title, Display disp) {
        super(title);
        try {
            append(new ImageItem(null, Image.createImage("/Images/1.jpg"), ImageItem.LAYOUT_CENTER, "image not found"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Thread th = new Thread(this);
        th.start();
        append(tfprenom);
        append(tfNom);
        append(tfmail);
        append(tftel);
        append(tfLogin);
        append(tfPassword);
        append(date);
        append(sexe);
        append(gouv);

        addCommand(inscrit);
        addCommand(back);
        setCommandListener(this);
    }

    public Inscription(String title) {
        super(title);
//        append(tfnom);
//        append(tfusername);
//        append(tfemail);
//        append(tfmotdepasee);
//        setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == inscrit) {
            Thread th = new Thread(this);
            th.start();

        }

        if (c == back) {

            Midlet.INSTANCE.disp.setCurrent(new Authentification("Authentification", this.disp));

        }
    }

    public void run() {
             Calendar cal = Calendar.getInstance();

            StringBuffer str = new StringBuffer();
            String prenom = tfprenom.getString().trim();
            String nom = tfNom.getString().trim();
            String mail = tfmail.getString().trim();
            int telephone = Integer.parseInt(tftel.getString());
            String login = tfLogin.getString().trim();
            String password = tfPassword.getString().trim();
            String datee = (cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH)).trim();
            String sexee = String.valueOf(sexe.getString(sexe.getSelectedIndex())).trim();
            String couvv = String.valueOf(gouv.getString(gouv.getSelectedIndex())).trim();

        try {

       
            

            ht = (HttpConnection) Connector.open("http://localhost/allfordeal/j2me/insert.php?"
                    + "prenom=" + prenom
                    + "&nom=" + nom
                    + "&telephone=" + telephone
                    + "&mail=" + mail
                    + "&login=" + login
                    + "&password=" + password
                    + "&date_naissance=" + datee
                    + "&sexe=" + sexee
                    +  "&adresse=" + couvv);

            dt = ht.openDataInputStream();
            InputStreamReader r = new InputStreamReader(dt, "UTF-8");

            while ((ch = dt.read()) != -1) {
                str.append((char) ch);
                
       

            }
            dt.close();
            ht.close();
            System.out.print("Inscription avec Succes");
            Alert a = new Alert(prenom, " est ajouté avec succés ", null, AlertType.CONFIRMATION);
    

            Midlet.INSTANCE.disp.setCurrent(a, this);
            Thread.sleep(1000);
          
        
            
          
           
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } 
        
                           try {
          

            htt = (HttpConnection) Connector.open("http://localhost/allfordeal/j2me/mail/mail_fadi.php?"
                    + "mail=" + mail
                    + "&login=" + login
                    + "&password=" + password);
            dtt = htt.openDataInputStream();
               InputStreamReader y = new InputStreamReader(dt, "UTF-8");
               
               dtt.close();
            htt.close();
            while ((x = dtt.read())!= -1) {
                System.out.println((char) x);

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
           
       
         Midlet.INSTANCE.disp.setCurrent(new Authentification("Authentification ", Midlet.INSTANCE.disp));


    }
}
