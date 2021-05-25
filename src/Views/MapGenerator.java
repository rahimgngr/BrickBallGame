package Views;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class MapGenerator {

    public int map[][];
    public int brickWidth;
    public int brickHeight;

    BufferedImage brick;
    BufferedImage brick1;
    BufferedImage brick2;

    public MapGenerator(int row, int col) {
        map = new int[row][col];

        for (int[] map1 : map) {
            for (int j = 0; j < map[0].length; j++) {
                map1[j] = 1; //çizdirmek için değer atıyorum
            }
        }
        brickWidth = 560 / col;
        brickHeight = 150 / row;
        try {
            brick = ImageIO.read(new File("brick.png"));
            brick1 = ImageIO.read(new File("brick1.png"));
            brick2 = ImageIO.read(new File("brick2.png"));
        } catch (IOException ex) {
            Logger.getLogger(MapGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void draw(Graphics2D g) {

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) { //çizdirmek istiyorsam                
                    g.drawImage(brick, j * brickWidth + 80, i * brickHeight + 50, null);
                    /*g.setColor(Color.DARK_GRAY);
                   g.fillRect(j * brickWidth +80,i * brickHeight +50 , brickWidth, brickHeight);   */
                }
                g.setStroke(new BasicStroke(1)); //blokların çerçevesi
                g.setColor(new Color(255, 255, 255, 100));
                g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
            }
        }
        for (int i = 1; i < 2; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) { //çizdirmek istiyorsam                
                    g.drawImage(brick1, j * brickWidth + 80, i * brickHeight + 50, null);
                    /*g.setColor(Color.DARK_GRAY);
                   g.fillRect(j * brickWidth +80,i * brickHeight +50 , brickWidth, brickHeight);   */
                }
                g.setStroke(new BasicStroke(1)); //blokların çerçevesi
                g.setColor(new Color(255, 255, 255, 100));
                g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
            }

        }
        for (int i = 2; i < 3; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) { //çizdirmek istiyorsam                
                    g.drawImage(brick2, j * brickWidth + 80, i * brickHeight + 50, null);
                    /*g.setColor(Color.DARK_GRAY);
                   g.fillRect(j * brickWidth +80,i * brickHeight +50 , brickWidth, brickHeight);   */
                }
                g.setStroke(new BasicStroke(1)); //blokların çerçevesi
                g.setColor(new Color(255, 255, 255, 100));
                g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
            }

        }
    }

    public void setBrickValue(int value, int row, int col) {
        map[row][col] = value;
    }
}
