/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;
import Views.Gameplay;
import Views.MapGenerator;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Ogrenci
 */
public class ActionPerf implements ActionListener {
    Gameplay o;
    MapGenerator map;
    
    public ActionPerf (Gameplay o){          
        this.o = o;
        this.map = o.getMap();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(o.play){
            if(new Rectangle(o.ballposX,o.ballposY,20,20).intersects(new Rectangle(o.playerX, 550, 100, 10))){
                o.ballYdir = -o.ballYdir;
            }
            
            A : for(int i = 0; i<map.map.length;i++){
                for (int j = 0; j<map.map[0].length;j++){
                    if(map.map[i][j] > 0){//bricklerin oluşup oluşmadığının kontrolü
                        int brickX = j* map.brickWidth +80;
                        int brickY = i*map.brickHeight +50;
                        int brickWidth = map.brickWidth;
                        int brickHeight = map.brickHeight;
                        
                        Rectangle rect = new Rectangle(brickX,brickY,brickWidth,brickHeight);
                        Rectangle ballRect = new Rectangle (o.ballposX,o.ballposY,20,20);
                        Rectangle brickRect = new Rectangle(brickX,brickY,brickWidth,brickHeight);
                        
                        if(ballRect.intersects(brickRect)){
                           
                            map.setBrickValue(0, i, j); //(1 olunca yazdırıyordum)çarpıştıkları zaman siliniyor
                            o.totalBricks--;
                            o.scores += 10;
                            
                            if(o.ballposX + 19 <= brickRect.x || o.ballposX +1 >= brickRect.x + brickRect.width){
                                o.ballXdir = -o.ballXdir;      
                            } 
                            else {
                                o.ballYdir = -o.ballYdir;
                            }
            break A;
                        }
                        
                        
                    }
                }
            }
            
            o.ballposX += o.ballXdir;
            o.ballposY += o.ballYdir;
            if(o.ballposX < 0)//sol
                o.ballXdir = -o.ballXdir;
            if(o.ballposY < 0)//üst
                o.ballYdir = -o.ballYdir;
            if(o.ballposX > 670)//sağ
                o.ballXdir = -o.ballXdir;
        }
        o.repaint();  
    }

    /*public MapGenerator getMap() {
        return map;
    }  */
}
