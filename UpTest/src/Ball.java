
	/**
	 * Ball class
	 */
	public class Ball{
		//initial coordinates
		public float x,y;
		//coordinates at time t
		public float xt,yt;
		//initial velocity
		public float ux,uy;
		//final velocity
		public float vx,vy;
		//speed of ball
		public double modV;
		public double getModV() {
			return modV;
		}
		public void setModV() {
		      //this.vx=vx;
		      //this.vy=vy;
		      double temp=(vx*vx)+(vy*vy);
		      modV=Math.sqrt(temp);
			
		}
		//collusion detection
		public int coll_flag;
		public boolean coll_dect; 
		//internal parameters
		double S1x,S2x,S1y,S2y;
	    double pt1y,pt1x;
	    double npx, npy, vix, viy, vfx, vfy;
	    double dotProd;
		public int collided_flag;

	}