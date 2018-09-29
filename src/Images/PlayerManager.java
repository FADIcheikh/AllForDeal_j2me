package tn.esprit.mcrowdrise.utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.PlayerListener;

/**
 *
 * @author hp
 */
public class PlayerManager implements Runnable {

     List list;
    Player player;
    String locator;

    public PlayerManager(String locator) {
        
        this.locator = locator;
    }

    public void run() {

        try {

            player = Manager.createPlayer(locator);

            player.setLoopCount(-1); // play indefinitely
            player.prefetch(); // prefetch
            player.realize(); // realize

            player.start(); // and start
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }

    }

 

}
