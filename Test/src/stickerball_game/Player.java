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
public class Player {
    public int x;
    public int y;
    public int sizex;
    public int sizey;
    public int vy;
    private Color StickColor;
    
    /** Creates a new instance of Player */
    public Player(int x,int y,int sizex,int sizey,Color StickColor) {
        this.x=x;
        this.y=y;
        vy=0;
        this.sizex=sizex;
        this.sizey=sizey;
        this.StickColor=StickColor;
        
    }
    public void Move(int dy) {
        y+=dy;
    }
    public void MoveByMouse(int newy)
    {
        y=newy;
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