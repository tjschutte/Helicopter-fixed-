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
    private final double GRAV;
    private final double CLIMB;
    public static BufferedImage heli;

    static {
        try {
            heli = ImageIO.read(new File("Helicopter.png"));
        } catch (IOException ex) {
            Logger.getLogger(Helicopter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Helicopter(double x, double y, double grav, double climb) {
        this.x = x;
        this.y = y;
        this.GRAV = grav;
        this.CLIMB = climb;
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
        if (speed == GRAV){
        	if (this.ySpeed < GRAV){
        		ySpeed += 0.02;
        	}
        } else if (speed == CLIMB) {
			if (ySpeed > CLIMB){
				ySpeed -= 0.1;
			}
		} else if (speed == 0){
			ySpeed = 0;
		}
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
