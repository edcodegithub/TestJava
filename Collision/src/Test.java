import java.awt.Graphics2D;


public class Test {
public static void main(String[] args){
	//declaring coordinates
	int x1 = 50;
	int y1 = 100; 
	int x2 = 250;
	int y2 = 150;
	 
	//drawing line
	Graphics2D.lineStyle(3); 
	Graphics2D.moveTo(x1, y1);
	graphics.lineTo(x2, y2)
	 
	//forming line vectors
	line = new Vector2D(x2 - x1, y2 - y1);
	leftNormal = line.rotate(Math.PI * -0.5);
	
}

}
