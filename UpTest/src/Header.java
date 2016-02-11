
public class Header {
	// number of lines (No_Lines)
	private static final int obstrucles=2;
	//number of balls dropped (No_Balls)
	private static final int bDropTotal=5;
	private static final int radius=20;
	private static final int ball_drop=4;//ball drops every 4seconds
	private static final double t_reso=0.001;//calculate position after every 1ms (resolution)
	private static final double ay=-9800;//gravity
	/**
	 * Initial ball co-ordinates
	 */
	float x_ini=(float) 900.00;
	float y_ini=(float) 900.00;
	//initial velocity
	float ux_ini=(float) 0.00;
	float uy_ini=(float) 0.00;
	//keeping track of balls
	float gNo_of_Balls_Entered;
	float gNo_of_Balls_Present;
	// Creating array of class Ball and line
	Ball[] balls=new Ball[bDropTotal];
	Line[] lines=new Line[bDropTotal];
	//Goes out of the box then false. Otherwise true
	boolean[] Ball_Tracker=new boolean[bDropTotal];
	
	/**
	 * Initialization
	 */
	public void Initialization()
	{
		int i;

		for(i = 0; i < bDropTotal; i++)
		{
			balls[i].x		= x_ini;
			balls[i].y		= y_ini;

			balls[i].vx		= 0;
			balls[i].vy		= 0;


			balls[i].collided_flag = 0;
			balls[i].coll_detected = 0;
		}

		for(i = 0; i < obstrucles; i++)
		{
			lines[i].A = (lines[i].Line_Y2 - Lines[i].Line_Y1);
			lines[i].B = (lines[i].Line_X1 - Lines[i].Line_X2);
			lines[i].C = (lines[i].Line_X2 * Lines[i].Line_Y1) - (lines[i].Line_X1 * lines[i].Line_Y2);
		}
	}
	
	
	
	

}
