import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
/**
 * Re-locating position of x,y
 * (0,0) in C-application= (0,1000) in  java application
 * (x,y) in C-application= (x, 1000-y) in java application.
 */
public class Game2 extends JPanel {
	public Color abc(){
		// Will produce a random colour with more red in it (usually "pink-ish")
		Random rand = new Random();
		int R = (int)(Math.random()*256);
		int G = (int)(Math.random()*256);
		int B= (int)(Math.random()*256);
		Color randomColor = new Color(R, G, B); //random color, but can be bright or dull
		return randomColor;
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(abc());//Color.RED
		/**
		 * We receive balls coordinate at the center
		 */
		//g2d.fillOval(0, 0, 40, 40);
		/**
		 * Added balls
		 */
		g2d.fillOval(150, 320, 40, 40);
		g2d.fillOval(650, 180, 40, 40);
		g2d.fillOval(750, 200, 40, 40);
		g2d.fillOval(800, 330, 40, 40);
		g2d.fillOval(900, 274, 40, 40);
		/**
		 * Coordinate:(900,900)= (900,1000-900)
		 * 900-20; 100-20
		 */
		g2d.setColor(abc());
		g2d.drawOval(900-20, 1000-900-20, 40, 40);	
		
		g2d.setColor(abc());
		//coordinates (500,300) and (100,750)
		g2d.drawLine(500, 1000-300, 1000, 1000-750);
		g2d.setColor(abc());//Color.CYAN
		//coordinates (20,750) and (500,100)
		g2d.drawLine(20, 1000-750, 500, 1000-100);

		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("My GUI");
		frame.add(new Game2());
		frame.setSize(1000, 1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}