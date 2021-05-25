/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Views.Gameplay;
import Views.MapGenerator;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 *
 * @author Ogrenci
 */
public class KeyLis implements KeyListener {
    Gameplay k;
    ActionPerf p;
    MapGenerator m;
    public KeyLis (Gameplay k){          
        this.k = k;
        this.m = k.getMap();
        this.p = k.getOy();
        
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(k.playerX >= 600)
                k.playerX = 600;
            else
                k.moveRight();
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(k.playerX < 10)
                k.playerX = 10;
            else
                k.moveLeft();
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            if(!k.play){
                k.play = true;
                k.ballposX = 120;
                k.ballposY = 350;
                k.ballXdir = -1;
                k.ballYdir = -2;
                k.playerX = 310;
                k.scores = 0;
                k.totalBricks = 21; 
                k.getMap();      
                
                k.repaint();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
