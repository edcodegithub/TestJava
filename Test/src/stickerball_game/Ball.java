package stickerball_game;
/*
 *   *       Please Visit us at www.codemiles.com     *
 *  This Program was Developed by www.codemiles.com forums Team
 *  *           Please Don't Remove This Comment       *
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.applet.*; // Don't forget this import statement!
import java.awt.*; // Or this one for the graphics!
/**
 *
 * @author Mohamed Eldib
 */
public class Ball {
    
    /** Creates a new instance of Ball */
    
    private int Reduis;
    public int x;
    public int y;
    public int vx;
    public int vy;
    private int BALL_TOP;
    private int BALL_LEFT;
    private int BALL_RIGHT;
    private int BALL_DOWN;
    
    private int PLAYER_TOP;
    private int PLAYER_DOWN;
    private int PLAYER_RIGHT;
    
    private int COMP_TOP;
    private int COMP_DOWN;
    private int COMP_LEFT;
    
    private int max_vx=5;
    private int max_vy=5;
    
    public  Component myBase;
    private Color BallColor;
    
    private Image myImg;
    public Ball(int r, int x,int y,int vx,int vy,Color BallColor,Component newBase) 
    {
        
        Reduis=r;
        this.x=x;
        this.y=y;
        this.vx=vx;
        this.vy=vy;
        myBase=newBase;
        myImg= ((Applet) myBase).getImage (((Applet) myBase).getCodeBase(), "images/Ball.gif");
        this.BallColor=BallColor;
    }
     
    public void move() {
      
        if (vx > max_vx) vx = max_vx;
        else if (vx < -max_vx) vx = -max_vx;
        else if (vy > max_vy) vy = max_vy;
        else if (vy < -max_vy) vy = -max_vy;
      //  else if (vx == 0 && !isStoped) vx = 1;
        
        x += vx;
        y += vy;
    }
    public int wheresBall() {
        if (vy > 0) {
            if (y > 280)					 
            {
               
                vy = -vy;
                return 0;
            }
        } else if (vy < 0) {
            if (y < 40)						 
            {
                vy = -vy;
                 
                return 0;
            }
        }
        if(x<20)
            return 1;
        else if(x>375)
            return 2;
        
         
                      
            return 0;
        
    }
     public void PCollision(Player PlayerStick,AudioClip hitSound) {
       
        BALL_TOP = y - Reduis;
        BALL_DOWN = y + Reduis;
        BALL_LEFT = x - Reduis;
        BALL_RIGHT = x + Reduis;
        
 
        PLAYER_TOP = PlayerStick.y;
        PLAYER_DOWN = PlayerStick.y + PlayerStick.sizey;
        
     
        if ((BALL_TOP >= PLAYER_TOP  - 10) && (BALL_DOWN <= PLAYER_DOWN + 10)) {
   
            if (BALL_LEFT <= 30 ) {
              
                 
                
            hitSound.play();
                vx = - vx;
                
             
                if (PlayerStick.vy < 0) {
                    vy --;
                   
                } else if (PlayerStick.vy > 0) {
                    vy += PlayerStick.vy;
               
                }
            }
        }
    }
    
    public void CCollision(Computer CompStick,AudioClip hitSound) {
 
           BALL_TOP = y - Reduis;
        BALL_DOWN = y + Reduis;
        BALL_LEFT = x - Reduis;
        BALL_RIGHT = x + Reduis;
        
       
        COMP_TOP = CompStick.y;
        COMP_DOWN= CompStick.y + CompStick.sizey;
    
 
        if ((BALL_TOP >= COMP_TOP - 10) && (BALL_DOWN <= COMP_DOWN + 10)) {
             
            if (BALL_RIGHT >= 370 ) {
  
                 hitSound.play();
       
         
                vx = - vx;
             
                 
              
                if (CompStick.vy < 0) {
                    vy --;
                } else if (CompStick.vy > 0) {
                    vy += CompStick.vy;
                }
              
            }
        }
    }
     public void DrawBall(Graphics g) {
        g.setColor(BallColor);
        
        g.drawImage(myImg,x - Reduis, y - Reduis,myBase);
         
    }
   
}

/*
 *   *       Please Visit us at www.codemiles.com     *
 *  This Program was Developed by www.codemiles.com forums Team
 *  *           Please Don't Remove This Comment       *
 */