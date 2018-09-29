/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.allfordeal.gui;

import edu.esprit.allfordeal.dao.ProduitDao;
import edu.esprit.allfordeal.midlet.Midlet;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.List;

/**
 *
 * @author Yesmine
 */
public class StatCanvas extends Canvas implements CommandListener{

    int h = getHeight();
    int w = getWidth();
    
    ProduitDao td = new ProduitDao();
    
    Command cmds = new Command("select", Command.SCREEN, 0);
    Command cmdback = new Command("back", Command.BACK, 0);
    
    protected void paint(Graphics g) {
        g.setColor(255,255,255);
        g.fillRect(0, 0, w, h);
        

        g.setColor(51,133,255);
        g.fillArc(w/4, w/4, w/2, w/2, 0, 260);
        
        
    }
    
    
    public StatCanvas(){
    addCommand(cmdback);
        addCommand(cmds);

        setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdback) {
            Midlet.INSTANCE.disp.setCurrent(new listePS("Menu", List.IMPLICIT));

        }

        if (c == cmds) {
     //       Midlet.INSTANCE.disp.setCurrent(new DescriptionCanvas());
        }
    }
    
}
