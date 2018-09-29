/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.gui;

import edu.esprit.allfordeal.dao.ClientDao;
import edu.esprit.allfordeal.dao.Evaluation_produitDao;
import edu.esprit.allfordeal.dao.PanierDao;
import edu.esprit.allfordeal.entities.Evaluation_produit;
import edu.esprit.allfordeal.entities.Produit;
import edu.esprit.allfordeal.midlet.Midlet;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;

/**
 *
 * @author Yesmine
 */
public class DescriptionCanvas extends Canvas implements CommandListener {

    Command cmdback = new Command("back", Command.BACK, 0);
    Command cmdexit = new Command("exit", Command.EXIT, 0);
    Command cmdcommenter = new Command("Commentaires", Command.EXIT, 0);
    Command ajouter = new Command("Panier", Command.SCREEN, 0);
    Command supprimer = new Command("Supprimer", Command.SCREEN, 0);
    Command noter = new Command("Noter", Command.EXIT, 0);

    int w = getWidth();
    int h = getHeight();
    HttpConnection hc;
    DataInputStream dis;
    int position = 1;
    int note = 3;
    Image img = null;
    Produit p;
    int ligne = 0;
    int ligne2 = 0;
    String finalDescrip, allCommentaire;
    float moyenne;

    public DescriptionCanvas(Produit produit) {

        this.p = produit;
        addCommand(cmdback);
        addCommand(cmdcommenter);
        PanierDao pd = new PanierDao();
        int in = pd.inPanier(Midlet.c, p);
        if (in == 1) {
            addCommand(supprimer);
        } else {
            addCommand(ajouter);
        }

        addCommand(noter);
        setCommandListener(this);

        try {
            hc = (HttpConnection) Connector.open("http://localhost:80/allfordealweb/web/frontoffice/images/uploads/" + p.getPict());

            dis = new DataInputStream(hc.openDataInputStream());
            int size = (int) hc.getLength();
            byte[] tab;
            if (size != -1) {
                tab = new byte[size];
                dis.readFully(tab);
                img = Image.createImage(tab, 0, size);
                img = CanvasMenu.resizeImage(img, (w), (h / 3));
                dis.close();
                hc.close();
            }
            dis.close();
            hc.close();
        } catch (IOException ex) {
            System.out.println("" + ex.getMessage());

        }
        Evaluation_produitDao epd = new Evaluation_produitDao();
        moyenne = epd.calculeMoyenne(p);
//
//        String descrip = "Description : " + p.getDescription();
//        ligne = 0;
//        int len = descrip.length();
//        String finalDescrip = "";
//
//        while (len > 37) {
//            finalDescrip = finalDescrip + descrip.substring(ligne * 37, (ligne * 37) + 37) + "\n";
//            ligne++;
//            len -= 37;
//        }
//        finalDescrip = finalDescrip + descrip.substring(ligne * 37);
//        ligne++;
//
//        CommentaireProduitDao cpd = new CommentaireProduitDao();
//
//        CommentaireProduit[] pd = cpd.findByProduit(p);
//
//        allCommentaire = "";
//
//        for (int x = 0; x < pd.length; x++) {
//            allCommentaire = allCommentaire + "\n Par :" + pd[x].getClient().getNom() + " " + pd[x].getClient().getPrenom() + ":\n" + pd[x].getCommentaire();
//        }

    }

    protected void paint(Graphics g) {

        g.setColor(255, 255, 255);
        g.fillRect(0, 0, w, h);

        g.drawImage(img, w / 2, position + (h / 4), Graphics.HCENTER | Graphics.VCENTER);

        g.setColor(54, 156, 255);
        if (moyenne != 0) {
            String ms = String.valueOf(moyenne);
            g.drawString(ms, w / 6, position + (h / 4), Graphics.BASELINE | Graphics.HCENTER);
        }
        g.fillRect(0, position, w, 20);
        g.setColor(255, 255, 255);
        g.drawString(p.getTitre(), w / 2, position + 15, Graphics.BASELINE | Graphics.HCENTER);
        g.setColor(0, 0, 0);

        g.drawString("Marque : " + p.getMarque(), w / 2, position + ((h / 2) + 14), Graphics.BASELINE | Graphics.HCENTER);
        g.drawString("prix : " + p.getPrix(), w / 2, position + ((h / 2) + 40), Graphics.BASELINE | Graphics.HCENTER);
        g.drawString("quantite : " + p.getQuantite(), w / 2, position + ((h / 2) + 66), Graphics.BASELINE | Graphics.HCENTER);
//        g.drawString(finalDescrip, 0, position + ((h / 2) + 92), Graphics.BASELINE | Graphics.LEFT);

        // gauge
         
        //rectangle noir
        g.setColor(0, 0, 0);
        g.fillRect((w / 6), position + ((h / 2) + 92 + (ligne * 15)) + 10, 2 * (w / 3), (w / 6) - 30);
        //les deux triangles
        g.setColor(54, 156, 255);
        g.fillArc((w / 12) - 30, position + ((h / 2) + 92 + (ligne * 15) - 10) + 10, 30, 30, -20, 40);
        g.fillArc(w - (w / 12), position + ((h / 2) + 92 + (ligne * 15) - 10) + 10, 30, 30, 160, 40);
     
         //rectangle bleu
        
        g.fillRect((w / 6), position + ((h / 2) + 92 + (ligne * 15)) + 10, ((2 * (w / 3)) / 5) * note, (w / 6) - 30);
        
//        g.fillArc(w - (w / 12), position + ((h / 2) + 92 + (ligne * 15)) + 10, 30, 30, 70, 40);
//        System.out.println("nigaaaaaaaaaa" + allCommentaire);
//        g.drawString("Commentaire", 0, position + ((h / 2) + 92 + (ligne * 15)) + 40, Graphics.BASELINE | Graphics.LEFT);
//        g.setColor(0, 0, 0);
//        g.drawString(allCommentaire, 0, position + ((h / 2) + 92 + (ligne * 15)) + 60, Graphics.BASELINE | Graphics.LEFT);
         
           
    }

    protected void keyPressed(int keyCode) {
        int code = getGameAction(keyCode);
        switch (code) {
            case UP: {

            }
            break;

            case DOWN:

                break;

            case RIGHT:
                
                note++;
                if (note > 5) {
                    note = 5;
                }

                break;

            case LEFT:
                note--;
                if (note < 0) {
                    note = 0;
                }
                break;

            case FIRE: {
            }

            break;
        }
        repaint();
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdback) {
            Midlet.INSTANCE.disp.setCurrent(new CanvasMenu(p.getCategorie()));

        }
        if (c == cmdcommenter) {
            Midlet.INSTANCE.disp.setCurrent(new ListCommentaire("Commentaires de " + p.getTitre(), List.IMPLICIT, p));

        }
        if (c == ajouter) {
            PanierDao pd = new PanierDao();
            pd.ajouterPanier(Midlet.c, p);
            Alert a = new Alert("Panier ", "Produit Ajoute Au Panier", null, AlertType.ALARM);
            a.setTimeout(3000);
            Midlet.INSTANCE.disp.setCurrent(a, new CanvasMenu(p.getCategorie()));
        }
        if (c == supprimer) {
            PanierDao pd = new PanierDao();
            pd.supprimerPanier(Midlet.c, p);
            Alert a = new Alert("Panier ", "Produit Supprimer Du Panier", null, AlertType.ALARM);
            a.setTimeout(3000);
            Midlet.INSTANCE.disp.setCurrent(a, new CanvasMenu(p.getCategorie()));
        }
        if (c == noter) {
            boolean verif = false;
            Evaluation_produitDao epd = new Evaluation_produitDao();
            Evaluation_produit[] x = epd.findByProduit(p);
            if (x != null) {
                for (int i = 0; i < x.length; i++) {
                    if (x[i].getId_client() == Midlet.c.getId()) {
                        x[i].setNote(note);
                        epd.modifierEvaluation_produit(x[i]);
                        verif = true;
                        break;
                    }
                }
            }
            if (verif == false) {
                Evaluation_produit y = new Evaluation_produit(0, note, Midlet.c.getId(), p.getId_produit());
                epd.ajouterEvaluation_produit(y);
            }
            repaint();
        }

    }

}
