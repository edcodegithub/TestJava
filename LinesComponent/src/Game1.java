import javax.swing.JFrame;

public class Game1 {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Mini Tennis");
		frame.setSize(1000, 1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**
		 * Re-locating position of x,y
		 * (0,0) in C-application= (0,1000) in  java application
		 * (x,y) in C-application= (x, 1000-y) in java application.
		 */
	}
}