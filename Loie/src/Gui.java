import acm.program.*;
import acm.graphics.*;


public class Gui extends GraphicsProgram {
	
	/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 1000;
	public static final int APPLICATION_HEIGHT = 1000;
	
	private static final int OBSTACLE_WIDTH = 100;
	
	private GOval balls;
	private GLine obstacle1, obstacle2;
	
	public void run(){
		setUpObstacle();
	}
	
	private void setUpObstacle(){
		obstacle1 = new GLine(200, 750, 300, 550);
		obstacle2 = new GLine(300, 650, 400, 450);
		add(obstacle1);
		add(obstacle2);
	}

}
