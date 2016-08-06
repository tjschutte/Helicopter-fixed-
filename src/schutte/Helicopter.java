package schutte;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Tom
 */
public class Helicopter {

    private double ySpeed;
    private double xSpeed;
    private double x;
    private double y;
    public static BufferedImage heli;

    static {
        try {
            heli = ImageIO.read(new File("Helicopter.png"));
        } catch (IOException ex) {
            Logger.getLogger(Helicopter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Helicopter(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void Move(int speed) {
        x += (speed * xSpeed);
        y += (speed * ySpeed);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, Tile.TILE_SIZE * 2, Tile.TILE_SIZE);
    }

    public void setSpeed(int speed) {
        this.xSpeed = speed;
    }

    public void setVertSpeed(double speed) {
        ySpeed = speed;
    }
    
    public int getX(){
        return (int)x;
    }
    
    public int geyY(){
        return (int)y;
    }

    public void draw(Graphics g) {
        g.drawImage(heli, (int) x, (int) y, null);

    }
}
