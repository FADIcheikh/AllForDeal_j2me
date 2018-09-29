/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.gui;

import edu.esprit.allfordeal.dao.ProduitDao;
import edu.esprit.allfordeal.entities.Categorie_produit;
import edu.esprit.allfordeal.entities.Produit;
import edu.esprit.allfordeal.midlet.Midlet;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.game.Sprite;

/**
 *
 * @author Yesmine
 */
public class CanvasMenu extends Canvas implements
        CommandListener {

    int h = getHeight();
    int w = getWidth();
    Image img = null;
    int position = 1;
    int decalage = 0;
    Produit[] ProduitTab;
    Command cmds = new Command("select", Command.SCREEN, 0);
    Command cmdback = new Command("back", Command.BACK, 0);

    HttpConnection hc;
    DataInputStream dis;

    public CanvasMenu(Categorie_produit cp) {

        ProduitDao td = new ProduitDao();
        ProduitTab = td.findByCategorie(cp);
        addCommand(cmdback);
        addCommand(cmds);
        setCommandListener(this);

    }

    protected void paint(Graphics g) {
        g.setColor(255, 255, 255);
        g.fillRect(0, 0, w, h);
        int maximum = 0;
        if (ProduitTab != null) {

            for (int i = decalage; i < ProduitTab.length; i++) {
                Double interx = new Double(((i - decalage) % 3));
                int x = interx.intValue();
                Double intery = new Double(Math.floor((i - decalage) / 3));
                int y = intery.intValue();
                
                try {
                    System.out.println(ProduitTab[i].getPict());
                    hc = (HttpConnection) Connector.open("http://localhost:80/allfordealweb/web/frontoffice/images/uploads/" + ProduitTab[i].getPict());

                    dis = new DataInputStream(hc.openDataInputStream());
                    int size = (int) hc.getLength();
                    byte[] tab;
                    if (size != -1) {
                        tab = new byte[size];
                        dis.readFully(tab);
                        img = Image.createImage(tab, 0, size);
                        img = resizeImage(img, w / 3, h / 3);
                        dis.close();
                        hc.close();
                    }
                    dis.close();
                    hc.close();
                } catch (IOException ex) {
                    System.out.println("" + ex.getMessage());
                }
                

                g.setColor(0, 0, 0);

                g.drawString(ProduitTab[i].getTitre(), ((w / 3) * (x)) + (w / 6), ((h / 3) * y) + (h / 6), Graphics.BASELINE | Graphics.HCENTER);
                g.drawImage(img, ((w / 3) * (x)) + (w / 6), ((h / 3) * y) + (h / 6), Graphics.VCENTER | Graphics.HCENTER);
                g.setColor(255, 0, 0);
                g.drawRect(((w / 3) * (x)), ((h / 3) * y), w / 3, h / 3);
                maximum++;
                if (maximum > 9) {
                    break;
                }
            }
        } else {
            g.setColor(0, 0, 0);
            g.drawString("Aucun Produit", w / 2, h / 3, Graphics.BASELINE | Graphics.HCENTER);
        }
        if (ProduitTab != null) {
            g.setColor(0, 0, 255);
            Double interx = new Double((((position - decalage) - 1) % 3));
            int x = interx.intValue();
            Double intery = new Double(Math.floor(((position - decalage) - 1) / 3));
            int y = intery.intValue();
            g.drawRect(((w / 3) * x) + 1, ((h / 3) * y) + 1, (w / 3) - 2, (h / 3) - 2);
        }

    }

    protected void keyPressed(int keyCode) {
        int code = getGameAction(keyCode);
        switch (code) {
            case UP:
                if (ProduitTab.length > 3) {
                    position = position - 3;
                }
                break;

            case DOWN:
                if (ProduitTab.length > 3) {
                    position = position + 3;
                }
                break;

            case RIGHT:
                position++;

                break;

            case LEFT:
                position--;
                break;

            case FIRE:
                System.out.println("Produit:"+ProduitTab[position - 1].getTitre()+ "  Client:"+Midlet.c.getId());
                Midlet.INSTANCE.disp.setCurrent(new DescriptionCanvas(ProduitTab[position - 1]));
                break;
        }
        if (position <= 0) {
            position = position + ProduitTab.length;
        }

        if (position > ProduitTab.length) {
            position = position - ProduitTab.length;
        }
        while (position - decalage > 9) {
            decalage = decalage + 3;
        }
        while (position - decalage < 1) {
            decalage = decalage - 3;
        }

        repaint();
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdback) {
            Midlet.INSTANCE.disp.setCurrent(new ListCategorieProduit("Categorie Produit", List.IMPLICIT));

        }

        if (c == cmds) {
     //       Midlet.INSTANCE.disp.setCurrent(new DescriptionCanvas());
        }
    }

    public static Image resizeImage(Image image, int resizedWidth, int resizedHeight) {

        int width = image.getWidth();
        int height = image.getHeight();

        if (height / resizedHeight >= width / resizedWidth) {
            int ratio = height / resizedHeight;

            resizedWidth = width / ratio;
        } else {
            int ratio = width / resizedWidth;
            resizedHeight = height / ratio;
        }

        int[] in = new int[width];
        int[] out = new int[resizedWidth * resizedHeight];

        int dy, dx;
        for (int y = 0; y < resizedHeight; y++) {

            dy = y * height / resizedHeight;
            image.getRGB(in, 0, width, 0, dy, width, 1);

            for (int x = 0; x < resizedWidth; x++) {
                dx = x * width / resizedWidth;
                out[(resizedWidth * y) + x] = in[dx];
            }

        }

        return Image.createRGBImage(out, resizedWidth, resizedHeight, true);

    }

}
