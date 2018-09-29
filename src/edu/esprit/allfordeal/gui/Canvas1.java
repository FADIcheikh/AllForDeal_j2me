/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.gui;
import edu.esprit.allfordeal.midlet.Midlet;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.Canvas.*;
//import static javax.microedition.lcdui.Canvas.DOWN;
//import static javax.microedition.lcdui.Canvas.FIRE;
//import static javax.microedition.lcdui.Canvas.UP;
import javax.microedition.lcdui.Graphics;

/**
 *
 * @author AZIZ
 */
public class Canvas1 extends Canvas implements CommandListener {
     int w = this.getWidth();
    int h = this.getHeight();
    Command cmdcfm = new Command("confirm", Command.SCREEN, 0);
    Command cmdback = new Command("Retour", Command.BACK, 0); 
    
    int i=w;
    int j=h/3;
    int k=0;
    
    int p=0;
    
    public Canvas1(){
        addCommand(cmdcfm);
        addCommand(cmdback);
        setCommandListener(this);
    }

    protected void paint(Graphics g) {
        g.setColor(27,60,102);
        g.fillRect(0, 0 , w, h);
        
        
        
        g.setColor(255,255,255);
        g.fillRect(0, k, i, j);
        
        g.setColor(0,0,0);
        g.drawString("Ajouter Service", w/2-40, 50, 0);
        
        g.setColor(0,0,0);
        g.drawString("Modifier & Supprimer Service", w/2-90, h/2, 0);
        
        g.setColor(0,0,0);
        g.drawString("Lister les produit", w/2-50, h/2+90, 0);
        
    }
    
    protected void keyPressed(int keyCode){
        int action = getGameAction(keyCode);
        if(action==DOWN){
           // j=j+(h/3);
            k=k+(h/3);
            p++;
        }else if (action==UP){
            k=k-(h/3);
            p--;
        }if(action==FIRE){
            if(p==0){
                
            
        Midlet.INSTANCE.disp.setCurrent(new ajouterService("Ajouter service"));
        
        }else if(p==1){
            Midlet.INSTANCE.disp.setCurrent(new modifierService("Modifier service"));
        }
            else if(p==2){
            Midlet.INSTANCE.disp.setCurrent(new ListExplicite("lister les service", List.IMPLICIT, 1));
        }
        }
        
        repaint();
        
    }

    public void commandAction(Command c, Displayable d) {
        if (c==cmdback) {
            Midlet.INSTANCE.disp.setCurrent(new listePS("Menu", List.IMPLICIT));
        }
    }

    
}
