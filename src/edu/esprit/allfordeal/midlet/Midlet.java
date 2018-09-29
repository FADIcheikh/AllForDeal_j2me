/*
 * To chyange this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.allfordeal.midlet;

import edu.esprit.allfordeal.dao.ProduitDao;
import edu.esprit.allfordeal.entities.Client;
import edu.esprit.allfordeal.gui.Authentification;
import edu.esprit.allfordeal.gui.Splashscreen;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.*;
import tn.esprit.mcrowdrise.utils.PlayerManager;

/**
 * @author Yesmine
 */
public class Midlet extends MIDlet {

    //  Produit[] pTab;
    public static Midlet INSTANCE = null;
    public Display disp = Display.getDisplay(this);
    public static Client c;

    public void startApp() {
//        ProduitDao pd = new ProduitDao();
//     
//        Categorie_produit cp = new Categorie_produit();
//        cp.setId_categorie(1);
//        Client c = new Client();
//        c.setId_client(1);
//        Float f = new Float(123);
//        Produit p = new Produit(0,"koukou",cp,"niff",f,"2000-10-10",1,1,1,"jjjjj","ggg",c);
//
//        pd.ajouterProduit(p);
//        System.out.println("after ajout");
//        pTab = pd.findAll();
//        for (int i = 0 ; i<pTab.length;i++)
//        {
//            System.out.println(pTab[i].getTitre());
//        }
//        p.setId_produit(1);
//        p.setTitre("ka7louch");
//        
//        pd.modifierProduit(p);
//        System.out.println("after modif");
//        pTab = pd.findAll();
//        for (int i = 0 ; i<pTab.length;i++)
//        {
//            System.out.println(pTab[i].getTitre());
//        }
//        
//        System.out.println("after supp");

//        pTab = pd.findAll();
//        for (int i = 0 ; i<pTab.length;i++)
//        {
//            System.out.println(pTab[i].getTitre());
//        }
        INSTANCE = this;
        ProduitDao pd = new ProduitDao();
//        String[] str = {"Consulter Produit", " Réclamer"};
//        disp.setCurrent(new listePS("All For Deal",List.IMPLICIT));
        //      disp.setCurrent(new Authentification("Authentification",this.disp));
        disp.setCurrent(new Splashscreen(this));
        
        //app audio 
 

 playMedia();
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
    
            public void playMedia()
    {
        String locator = "http://localhost/allfordeal/j2me/images/Fireflies-%20Owl%20City.mp3";
        PlayerManager playManager=new PlayerManager(locator);
        Thread runner=new Thread(playManager);
        runner.start();
    }
}
