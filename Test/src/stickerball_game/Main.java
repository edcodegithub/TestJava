package stickerball_game;
/*
 *   *       Please Visit us at www.codemiles.com     *
 *  This Program was Developed by www.codemiles.com forums Team
 *  *           Please Don't Remove This Comment       *
 */


import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.applet.*;
import java.awt.*;


/**
 *
 * @author Mohamed Eldib
 */
public class Main extends  Applet implements Runnable  ,MouseMotionListener,MouseListener {
    
    /** Creates a new instance of Main */
    
    private final int UP = 38;
    private final int DOWN = 40;
    private Player myPlayer;
    private Computer myComp;
    private Ball myBall;
    private Image  dbImage;
    private Image GameName;
    private AudioClip kicknoise;
    private Graphics dbg;
    private Thread th;
    private boolean GAME_STARTED;
    private boolean GAME_OPTION;
    private boolean GAME_OVER;
    private int CScore=0;
    private int PScore=0   ;
    private int TopScore=5;
    
    public void init() {
        GAME_OPTION=true;
        GAME_STARTED=false;
        GAME_OVER=false;
        CScore=0;
        PScore=0;
        TopScore=5;
        myPlayer=new Player(20,125,10,50,Color.GREEN.darker());
        myComp=new Computer(370,124,10,50,Color.RED);
        myBall=new Ball(8,200,150,2,-2,Color.blue,this);
        
       
        
        
        addMouseMotionListener(this);
        addMouseListener(this);
        kicknoise = getAudioClip(getCodeBase(), "hit.au");
        
        GameName= ((Applet) this).getImage(((Applet) this).getCodeBase(), "images/gamename.gif");
        
        
    }
    public void start() {
        
    }
    public void stop() {
        th.interrupt();
    }
    
    public void paint(Graphics g) {
        if(GAME_OPTION) {
            Image codemiles= ((Applet) this).getImage(((Applet) this).getCodeBase(), "images/codemiles.gif");
            
            g.setColor(Color.GRAY);
            
            g.fillRect(0,0,400,400);
            g.setColor(Color.white);
            
            g.drawString("Press Mouse Click To Start Ball Sticker",100,100);
            g.drawImage(codemiles,150,150,this);
            g.drawString("Visit us at << http://codemiles.com/ >> for more online games",35,250);
            g.drawImage( GameName,100,275,this);
            
        } else if(GAME_STARTED) {
            g.fillRect(0,0,400,300);
            
            myPlayer.DrawStrick(g);
            myComp.DrawStrick(g);
            myBall.DrawBall(g);
            g.setColor(Color.YELLOW);
            g.drawLine(25,32,375,32);
            g.drawLine(25,292,375,292);
            g.setColor(Color.GRAY);
            g.fillRect(400,300,400,100);
            g.setColor(Color.BLACK);
            g.drawString("Player Score :"+Integer.toString(PScore),50,350);
            g.drawString("Computer Score :"+Integer.toString(CScore),250,350);
            
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    public void update(Graphics g) {
        
        if (dbImage == null) {
            dbImage = createImage(this.getSize().width, this.getSize().height);
            dbg = dbImage.getGraphics();
        }
        
        
        dbg.setColor(getBackground());
        dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);
        
        
        dbg.setColor(getForeground());
        paint(dbg);
     
        
        g.drawImage(dbImage, 0, 0, this);
    }
    public void run() {
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        
        while (true) {
            
            
            
            repaint();
            myBall.move();
            
            
            myComp.ComputerMove(myBall);
            
            
            int  whosgoal = myBall.wheresBall();
            
            
            if (whosgoal != 0) {
                if(whosgoal==1)
                    CScore++;
                else
                    PScore++;
                
                if(PScore==5) {
                    GAME_STARTED=false;
                    GAME_OVER=GAME_OPTION=true;
                    th.interrupt();
                      repaint();
                }else if(CScore==5) {
                    GAME_STARTED=false;
                    GAME_OVER=GAME_OPTION=true;
                    th.interrupt();
                      repaint();
                }
                
                myBall.x= 200;
                myBall.vx = 3;
                myBall.vy = -3;
                
                
            }
            
            
            
            
            
            if (myBall.vx < 0) {
                myBall.PCollision(myPlayer,kicknoise);
            } else if (myBall.vx > 0) {
                myBall.CCollision(myComp,kicknoise);
            }
            
            try {
                
                Thread.sleep(15);
            } catch (InterruptedException ex) {
                break;
            }
            
            
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        }
        
    }
    
    
    
    
    
    public void mouseDragged(MouseEvent e) {
    }
    
    public void mouseMoved(MouseEvent e) {
        int y=e.getY();
        if(y<250&&y>25)
            myPlayer.MoveByMouse(y);
        
    }
    
    public void mouseClicked(MouseEvent e) {
        
        if(!GAME_STARTED) {
            GAME_STARTED=true;
            GAME_OPTION=false;
            CScore=0;
            PScore=0;
            TopScore=5;
            
            myBall.vx = 3;
            myBall.vy = -3;
            th=new Thread(this);
            th.start();
            
        }
    }
    
    public void mousePressed(MouseEvent e) {
    }
    
    public void mouseReleased(MouseEvent e) {
    }
    
    public void mouseEntered(MouseEvent e) {
    }
    
    public void mouseExited(MouseEvent e) {
    }
    
    
}
/*
 *   *       Please Visit us at www.codemiles.com     *
 *  This Program was Developed by www.codemiles.com forums Team
 *  *           Please Don't Remove This Comment       *
 */