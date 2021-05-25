/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Logic.ActionPerf;
import Logic.KeyLis;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author rahimgng
 */
public class Gameplay extends JPanel{
    public boolean play = false;
    public int scores = 0;
    
    public int totalBricks = 21;
    
    public int delay = 5;
    
    public int playerX = 310;
    
    public int ballposX = 120;
    public int ballposY = 350;
    public int ballXdir = -1;
    public int ballYdir = -2;
    
    public MapGenerator map;
    
    ActionPerf oy;
    KeyListener key;

    BufferedImage bg;
    BufferedImage top;
    BufferedImage tahta;
    BufferedImage won;
    BufferedImage lose;
    
 
    public Gameplay() {
        
        try {
            bg = ImageIO.read(new File("bg.jpg"));
            top = ImageIO.read(new File("top.png"));
            tahta = ImageIO.read(new File("tahta.png"));
            won = ImageIO.read(new File("won.png"));
            lose = ImageIO.read(new File("gameova.png"));
        } catch (IOException ex) {
            Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
        }
        addKeyListener(getKey());
        addActionListener(getOy());
        
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
        
        Timer timer = new Timer(delay,getOy());
        timer.start();
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);//boyayamadığım kısımlar olursa boyayabilmek için kullanırız..
        //arkaplan  
        g.drawImage(bg, 0, 0, null);
        /*g.setColor(Color.BLACK);
        g.fillRect(1, 1, 692, 592);*/
        
        //map i çiz
        map.draw((Graphics2D)g);
        
        //skor
        g.setColor(Color.white);
        g.setFont(new Font("serif",Font.BOLD,25));
        g.drawString(""+scores, 592, 30);
        
        //tahta(paddle)   
        g.drawImage(tahta, playerX, 550, null);

        //top  
        g.drawImage(top, ballposX, ballposY, null);

        if(totalBricks <= 0){
             play = false;
             ballXdir = 0;
             ballYdir = 0;
             
             g.drawImage(won, 0, 0, null);
             g.setColor(Color.white);
             g.setFont(new Font("Verdana",Font.BOLD,20));
             g.drawString("SKOR : "+scores, 10, 500);       
        }
        
        if(ballposY > 570){
             play = false;
             ballXdir = 0;
             ballYdir = 0;
             
             g.drawImage(lose, 0, 0, null);
             g.setColor(Color.white);
             g.setFont(new Font("Verdana",Font.BOLD,30));
             
             g.drawString("SKOR : "+scores, 10, 500);
             
             g.setFont(new Font("Verdana",Font.BOLD,20));
             g.drawString("YENIDEN BASLAMAK ICIN ENTER'A BASIN", 10, 530);    
        }
        
        g.dispose();
    }
    
    public KeyListener getKey() {
        if(key == null){
            key = new KeyLis(this);
        }
        return key;
    }

    public void setKey(KeyListener key) {
        this.key = key;
    }
    
    public ActionPerf getOy() {
        if(oy == null){
          oy = new ActionPerf(this);  
        }
        return oy;
    }

    public void setOy(ActionPerf oy) {
        this.oy = oy;
    }
    
    public void moveRight() {
        play = true;
        playerX += 25; 
    }
    public void moveLeft() {
        play = true;
        playerX -= 25; 
    }

    public MapGenerator getMap() {
        //if(map == null)
           map = new MapGenerator(3, 7);
        
        return map;
    }
   
}
