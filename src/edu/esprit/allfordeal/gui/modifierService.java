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
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author AZIZ
 */
public class modifierService extends Form implements CommandListener {

    Categorie_service[] serviceTab;
    HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/j2mtest/ServiceDao.php?action=cmb";
    TextField tfTitre = new TextField("Titre", "", 50, TextField.ANY);
    // TextField tfid_cat = new TextField("Id Categorie", "", 50, TextField.DECIMAL);

    TextField tfdatefin = new TextField("Date fin", "", 50, TextField.ANY);
    TextField tfdesc = new TextField("Description", "", 50, TextField.ANY);
    // TextField tfcomp = new TextField("Competence" ,"", 50, TextField.ANY);
    TextField tfidcl = new TextField("Id Client", "", 50, TextField.DECIMAL);
    Command ajouter = new Command("Modifier", Command.SCREEN, 0);
    Command supprimer = new Command("supprimer", Command.SCREEN, 2);
    Command back = new Command("Back", Command.SCREEN, 0);
    // Command supprimer = new Command("supprimer", Command.SCREEN, 2);
    ChoiceGroup cmb;
    ChoiceGroup cmb1;

    public modifierService(String title) {
        super(title);
        append(tfTitre);
        cmbbyname();

        append(tfdatefin);
        append(tfdesc);
        cmbbyname1();
        append(tfidcl);
        addCommand(ajouter);
        addCommand(back);
        addCommand(supprimer);
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
            } catch (SAXException ex) {
                ex.printStackTrace();
            }
            // display the result

            serviceTab = testHandler.getCategorie_service();
            String[] cmbbs = new String[serviceTab.length];

            if (serviceTab != null) {
                for (int i = 0; i < serviceTab.length; i++) {
                    System.out.println(serviceTab[i].getNom_categorie());
                    cmbbs[i] = serviceTab[i].getNom_categorie();
                }
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
            Service serv = new Service(0, tfTitre.getString(), serviceTab[cmb.getSelectedIndex()], null, tfdesc.getString(), serviceTab[cmb1.getSelectedIndex()], Midlet.c);//null, tfTitre.getString() ,serviceTab[cmb.getSelectedIndex()],tfdatefin.getString() , tfdesc.getString(),null,null );
            //         serv.setCategorie(serviceTab[cmb.getSelectedIndex()]);

            ServiceDao td = new ServiceDao();

            td.modifierService(serv);
        }
        if (c == supprimer) {
            Service serv = new Service(tfTitre.getString());//null, tfTitre.getString() ,serviceTab[cmb.getSelectedIndex()],tfdatefin.getString() , tfdesc.getString(),null,null );
            //         serv.setCategorie(serviceTab[cmb.getSelectedIndex()]);

            ServiceDao td = new ServiceDao();

            td.supprimerService(serv);
        }
        if (c == back) {

            Midlet.INSTANCE.disp.setCurrent(new Canvas1());

        }
    }
}
