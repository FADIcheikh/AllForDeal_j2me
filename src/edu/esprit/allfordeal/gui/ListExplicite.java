/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.gui;

import edu.esprit.allfordeal.dao.ServiceDao;
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
public class ListExplicite extends List implements CommandListener {

    Service[] s;
    Command back = new Command("Back", Command.SCREEN, 0);

    public ListExplicite(String title, int listType, int id_client) {
        super(title, listType);

        ServiceDao td = new ServiceDao();
        s = td.findByClient(id_client);

        if (s != null) {
            for (int i = 0; i < s.length; i++) {
                //append(s[i].getTitre(),null);
                append("Nom:" + s[i].getTitre() + "\nNom:" + s[i].getDate_fin(), null);
            }
        }else{
            append("Aucun Service",null);
        }
        addCommand(back);
        setCommandListener(this);

    }

    public void commandAction(Command c, Displayable d) {
        if (c == back) {
            Midlet.INSTANCE.disp.setCurrent(new Canvas1());
        }
    }
}
