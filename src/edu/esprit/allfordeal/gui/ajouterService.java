/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.gui;

import edu.esprit.allfordeal.dao.ServiceDao;
import edu.esprit.allfordeal.entities.Categorie_service;
import edu.esprit.allfordeal.entities.Service;
import edu.esprit.allfordeal.handler.Categorie_serviceHandler;
import edu.esprit.allfordeal.midlet.Midlet;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.TextField;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author AZIZ
 */
public class ajouterService extends Form implements CommandListener {

    Categorie_service[] serviceTab;
    HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/j2mtest/ServiceDao.php?action=cmb";
    TextField tfTitre = new TextField("Titre", "", 50, TextField.ANY);
    // TextField tfid_cat = new TextField("Id Categorie", "", 50, TextField.DECIMAL);
    ChoiceGroup cmb;
    DateField tfdatefin = new DateField("Date fin", DateField.DATE);
    TextField tfdesc = new TextField("Description", "", 50, TextField.ANY);
    // TextField tfcomp = new TextField("Competence" ,"", 50, TextField.ANY);
    ChoiceGroup cmb1;
    
    Command ajouter = new Command("Ajouter", Command.SCREEN, 0);
    Command back = new Command("Back", Command.SCREEN, 0);
    Alert sp = new Alert("welcome");

    public ajouterService(String title) {
        super(title);
        //Categorie_serviceDao sd = new Categorie_serviceDao();
        append(tfTitre);
        cmbbyname();
        //serviceTab = sd.findAll();
        append(tfdatefin);
        append(tfdesc);
        // append(tfcomp);
        cmbbyname1();
        
        addCommand(ajouter);
        addCommand(back);
        setCommandListener(this);

    }

    public void cmbbyname() {
        try {
            Categorie_serviceHandler testHandler = new Categorie_serviceHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            try {
                // get an InputStream from somewhere (could be HttpConnection, for example)
                hc = (HttpConnection) Connector.open(url);//people.xml est un exemple

                dis = new DataInputStream(hc.openDataInputStream());

                parser.parse(dis, testHandler);
                dis.close();
                hc.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            // display the result

            serviceTab = testHandler.getCategorie_service();
            String[] cmbbs = new String[serviceTab.length];

            for (int i = 0; i < serviceTab.length; i++) {
                System.out.println(serviceTab[i].getNom_categorie());
                cmbbs[i] = serviceTab[i].getNom_categorie();
            }
            cmb = new ChoiceGroup("service Categorie", ChoiceGroup.EXCLUSIVE, cmbbs, null);
            append(cmb);

            //       cmb.set(i,serviceTab[i].getNom_categorie(),null);
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        }

    }

    public void cmbbyname1() {
        try {
            Categorie_serviceHandler testHandler = new Categorie_serviceHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            try {
                // get an InputStream from somewhere (could be HttpConnection, for example)
                hc = (HttpConnection) Connector.open(url);//people.xml est un exemple

                dis = new DataInputStream(hc.openDataInputStream());

                parser.parse(dis, testHandler);
                dis.close();
                hc.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (SAXException ex) {
                ex.printStackTrace();
            }
            // display the result

            serviceTab = testHandler.getCategorie_service();
            String[] cmbbs1 = new String[serviceTab.length];

            for (int i = 0; i < serviceTab.length; i++) {
                System.out.println(serviceTab[i].getNom_categorie());
                cmbbs1[i] = serviceTab[i].getNom_categorie();
            }
            cmb1 = new ChoiceGroup("Competence", ChoiceGroup.EXCLUSIVE, cmbbs1, null);
            append(cmb1);
            //       cmb.set(i,serviceTab[i].getNom_categorie(),null);
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        }

    }

    public void commandAction(Command c, Displayable d) {
        if (c == ajouter) {
//    ClientDao cd = new ClientDao();
            Service serv = new Service(1, tfTitre.getString(), serviceTab[cmb.getSelectedIndex()], null, tfdesc.getString(), serviceTab[cmb1.getSelectedIndex()], Midlet.c);//null, tfTitre.getString() ,serviceTab[cmb.getSelectedIndex()],tfdatefin.getString() , tfdesc.getString(),null,null );
            //         serv.setCategorie(serviceTab[cmb.getSelectedIndex()]);
            ServiceDao td = new ServiceDao();
            td.ajouterService(serv);

//        Alert alert=new Alert("BienVenue","",null, AlertType.ALARM);
//                    alert.setTitle("Erreur");
//                    alert.setString("BienVenue");
//                    alert.setType(AlertType.ERROR);
//                    alert.setTimeout(2000);
        } else if (c == back) {
            Midlet.INSTANCE.disp.setCurrent(new Canvas1());
        }
    }

}
