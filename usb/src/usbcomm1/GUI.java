package usbcomm1;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.usb.UsbClaimException;
import javax.usb.UsbDisconnectedException;
import javax.usb.UsbException;
import javax.usb.UsbNotActiveException;
import javax.usb.UsbNotClaimedException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * 
 */

/**
 * @author Mithi.yan
 * 
 */
@SuppressWarnings("serial")
public class GUI extends JPanel {
	public static double Mass, Px, Py, Vx, Vy;
	public static double[] recv = new double[100];
	public static UsbComm usb;
	public static double mode, numBodies, weeks, days;
	public static double[] body_params = new double[250];
	public static int i = 0;
	static String[] Colours = new String[] {  "#FF0000", "#00FF00", "#0000FF", "#FFFF00", "#FF00FF", "#00FFFF", 
        "#800000", "#008000", "#000080", "#808000", "#800080", "#008080", "#808080", 
        "#C00000", "#00C000", "#0000C0", "#C0C000", "#C000C0", "#00C0C0", "#C0C0C0", 
        "#400000", "#004000", "#000040", "#404000", "#400040", "#004040", "#404040", 
        "#200000", "#002000", "#000020", "#202000", "#200020", "#002020", "#202020", 
        "#600000", "#006000", "#000060", "#606000", "#600060", "#006060", "#606060", 
        "#A00000", "#00A000", "#0000A0", "#A0A000", "#A000A0", "#00A0A0", "#A0A0A0", 
        "#E00000", "#00E000", "#0000E0", "#E0E000", "#E000E0", "#00E0E0", "#E0E0E0", };
	public static ArrayList<String> planet_Color = new ArrayList<String>();
	public static int[] x_Init_Coord = new int[50];
	public static int[] y_Init_Coord = new int[50];
	// public static panel myGUI=new panel();
	static double x = 0;// getWidth()/2;//370;
	static double y = 0;// getHeight()/2;//230;
	static double[] x2 = new double[250];
	static double[] y2 = new double[250];
	static int count = 0;
	static int index = 0;
	public static HashMap planet_Name = new HashMap();
	public static String[] planet = new String[] {"Sun", "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};

	public static void selectMode() throws IOException, UsbClaimException,
			UsbNotActiveException, UsbDisconnectedException, UsbException {
		usb = new UsbComm();

		// computation
		if (mode == 0) {
			// to clear file everytime before write
			FileWriter fw = new FileWriter(
					"F:/eclipseworkspace/GUI/src/final.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("");
			bw.close();
			fw.close();
			usb.sendInitialParams();
			for (int k = 0; k < numBodies; k++) {
				usb.receiveValFromCont();
			}
		}
		// Visualization
		else {
			FileWriter fw = new FileWriter(
					"F:/eclipseworkspace/GUI/src/viz.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("");
			bw.close();
			fw.close();

			// for(int k = 0;k<numBodies;k++){
			usb.sendInitialParams();
			while (true) {
				// startUI();
				usb.receiveValFromCont();
			}

			/*
			 * for(int m = 0; m < (numBodies*2); m++){ x_Init_Coord[m] =
			 * (int)recv[m]; y_Init_Coord[m] = (int)recv[m+1]; }
			 */
			// }

		}
	}

	public static void initValues() throws IOException {
		FileReader fr = new FileReader("F:/eclipseworkspace/GUI/src/init.txt");
		LineNumberReader lnr = new LineNumberReader(fr);
		String str = lnr.readLine();
		mode = Double.parseDouble(str);
		str = lnr.readLine();
		numBodies = Double.parseDouble(str);
		str = lnr.readLine();
		weeks = Double.parseDouble(str);
		str = lnr.readLine();
		days = Double.parseDouble(str);
		String line = lnr.readLine();
		try {
			while (line.isEmpty()) {
				int num = lnr.getLineNumber();
				lnr.setLineNumber(num);
				String string = lnr.readLine();
				if ((!string.isEmpty())) {
					Mass = Double.parseDouble(string);
					string = lnr.readLine();
					Px = Double.parseDouble(string);
					string = lnr.readLine();
					Py = Double.parseDouble(string);
					string = lnr.readLine();
					Vx = Double.parseDouble(string);
					string = lnr.readLine();
					Vy = Double.parseDouble(string);
					line = lnr.readLine();
					// body_params[i] = Mass;
					//System.out.println("Px" + Px);
					x_Init_Coord[i] = (int) Px;
					y_Init_Coord[i] = (int) Py;
					// body_params[i+3] = Vx;
					// body_params[i+4] = Vy;
					//System.out.println("x" + x_Init_Coord[i]);
					//System.out.println("y" + y_Init_Coord[i]);
					i++;
				} else {
					System.out.println("EOF");
				}
			}
		} catch (Exception e) {
			i = 0;
			//System.out.println("end");
		}
		fr.close();
	}

	public class DisplayPlanet extends JPanel {
		public double scale = 5e6;
		double sc;
		Image img;
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			Graphics2D g2d = (Graphics2D) g;
			
			try {
				img = ImageIO.read(new File("F:/eclipseworkspace/GUI/src/sky.gif"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(img, 10,60, null);
			/*
			 * g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			 * RenderingHints.VALUE_ANTIALIAS_ON); g2d.setColor(Color.red); //
			 * g2d.fillOval(0, 460, 20, 20); // g2d.fillOval(0, getHeight() -
			 * 20, 20, 20); g2d.setColor(Color.ORANGE); g2d.fillOval((getWidth()
			 * / 2) - (20), (getHeight() / 2 - (20)), 20, 20);
			 * g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			 * RenderingHints.VALUE_ANTIALIAS_ON);
			 */
			double maxX=0,maxY=0;
			for(int k=0;k<numBodies;k++){
				if(Math.abs(x2[k])>Math.abs(maxX)){
					maxX=x2[k];
					//System.out.println("max" +maxX);
				}
				if(Math.abs(y2[k])>Math.abs(maxY)){
					maxY=y2[k];
				}
			}
			//System.out.println("div" +maxX/scale);
			//System.out.println(getWidth());
			while((((getWidth() / 2) - 20 + (int) (maxX / scale))>getWidth())||((getHeight() / 2) - 20 + (int) (maxY / scale)>getHeight())){
				scale*=2;
			}
			for (int k = 0; k < numBodies; k++) {
				Color col = Color.decode(planet_Color.get(k));
				//Color col = Color.WHITE;
				g2d.setColor(col);
				// g2d.fillOval(370, 230, 20, 20); //40cm away radius
				if(numBodies < 9)
					sc = 6E8;
				else if(numBodies == 9)
					sc = 1E10;
				g2d.fillOval((getWidth() / 2) - 20 + (int) (x2[k] / scale),
						(getHeight() / 2) - 20 + (int) (y2[k] / scale), 15, 15);
				if(numBodies==9){
					g2d.drawString((String)planet_Name.get(k), (getWidth() / 2) - 20 + (int) (x2[k] / scale), (getHeight() / 2) - 20 + (int) (y2[k] / scale));
				}
				else{
					g2d.drawString(String.valueOf(k), (getWidth() / 2) - 20 + (int) (x2[k] / scale), (getHeight() / 2) - 20 + (int) (y2[k] / scale));
				}
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
			}
		}

	}

	public static void main(String[] args) throws UsbClaimException,
			UsbNotActiveException, UsbDisconnectedException, IOException,
			UsbException {
		//OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
		//System.out.println(osBean.getAvailableProcessors());
		
		initValues();
		// selectMode();
		if (mode == 0) {
			selectMode();
		} else {
			for (int j = 0; j <= numBodies; j++) {
				planet_Color.add(Colours[j % 55]);
			}
			if(numBodies==9){
				for(int j = 0; j< numBodies; j++){
					planet_Name.put(j, planet[j]);
				}
			}
				
				
		
			JFrame frame = new JFrame("N-body Simulation");
			//frame.setBackground(Color.BLACK);
			GUI gu = new GUI();
			DisplayPlanet dp = gu.new DisplayPlanet();
		
			dp.setBackground(Color.BLACK);
			frame.add(dp);
			frame.setSize(1366, 768);
			// frame.setSize(660, 520); // actual resolution is 640X480
			frame.setVisible(true);
			//frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			usb = new UsbComm();
			usb.sendInitialParams();
			int count = 0;
			double[] recvval = new double[100];
			while (true) {

					recvval = usb.receiveValFromCont();
					//System.out.println(recvval);
					if(recvval.equals(null)){
						//System.out.println("null");
						break;
					}
					index = (int) recvval[0];
					//System.out.println(index);
				if(index > numBodies || index < 0){
					//System.out.println("greater");
					continue;
				}
				x2[index] = recvval[1];
				y2[index] = recvval[2];
				//System.out.println(x2[7]);
				//for (long k = 10000000; k > 0; k--)
					//;
				//count++;
				if (index == numBodies) {
					dp.repaint();
					//count = 0;
				}

			}

		}
	}

}


