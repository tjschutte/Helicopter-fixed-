package schutte;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Tile {
    public static final int TILE_SIZE = 32;
    
    private int x;
    private int y;
    boolean safe;
    
    public Tile(int x, int y, boolean safe){
        this.x = x;
        this.y = y;
        this.safe = safe;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, TILE_SIZE, TILE_SIZE);
    }
    
    public void draw(Graphics g){
        if (!safe){
           g.setColor(Color.BLACK);
           g.fillRect(x, y, TILE_SIZE, TILE_SIZE); 
        }
        else{
           g.setColor(Color.GREEN);
           g.fillRect(x, y, TILE_SIZE, TILE_SIZE);
        }
        
    }
}
