package stickerball_game;
/*
 *   *       Please Visit us at www.codemiles.com     *
 *  This Program was Developed by www.codemiles.com forums Team
 *  *           Please Don't Remove This Comment       *
 */
 

import java.awt.Color;
import java.awt.Graphics;
import java.applet.*; 
import java.awt.*;  
/**
 *
 * @author Mohamed Eldib
 */
public class Computer {
    public int x;
    public int y;
    public int sizex;
    public int sizey;
    public int vy;
    private int real_y;
    private Color StickColor;
    /** Creates a new instance of Computer */
    public Computer(int x,int y,int sizex,int sizey,Color StickColor) {
        this.x=x;
        this.y=y;
        this.sizex=sizex;
        this.sizey=sizey;
        this.StickColor=StickColor;
        vy = 4;
    }
        public void ComputerMove(Ball b) {
        real_y = y + (sizey / 2);
 
        if (b.vx < 0) {
       
            if (real_y < 150) {
                y += vy;
            }
           
            else if (real_y > 150) {
                y -= vy;
            }
        } else if (b.vx > 0) {
        
            if ( real_y != b.y) {
       
                if (b.y < real_y) {
                    y -= vy;
                }
      
                else if (b.y > real_y) {
                    y += vy;
                }
            }
        }
    }
    
     
    public void DrawStrick(Graphics g) {
        g.setColor(StickColor);
        g.fillRect(x, y, sizex, sizey);
    }
}
/*
 *   *       Please Visit us at www.codemiles.com     *
 *  This Program was Developed by www.codemiles.com forums Team
 *  *           Please Don't Remove This Comment       *
 */