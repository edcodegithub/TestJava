import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
public class SolClass {
	public class Point{
		public double x;
		public double y;
		public Point(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
private HashMap<Double, Integer> hashMap;
    
	public int maxPoints(ArrayList<Double> A, ArrayList<Double> B) {
		Double key=0.0;
	    hashMap = new HashMap<>();
	    
	    if (A == null || B == null)
	        return -1;
	    
	    if (A.size() == 0)
	        return 0;
	    
	    int n = A.size();
	    Double x1;
		Double y1;
		Double x2;
		Double y2;
	    int val;
	    int max = 0;
	    
	    for (int i = 0; i < n; i++) {
	        
	        x1 = A.get(i);
	        y1 = B.get(i);
	        hashMap.clear();
	        
	        for (int j = 0; j < n; j++) {
	            
	            if (i == j)
	                continue;
	            
	            x2 = A.get(j);
	            y2 = B.get(j);
	            
	            double slope = y2 - y1;
	            double den = x2 - x1;
	            
	            if (den == 0)
	                slope = Double.POSITIVE_INFINITY;
	            else
    	            slope = slope / den;
	            
	            val = 1;
	            
	            if (hashMap.containsKey(slope)) {
	                val = hashMap.get(slope) + 1;
	                //System.out.println("( "+x2+","+y2+" )"+"  "+slope);
	            }
	            
	            hashMap.put(slope, val);
	            
	        }
	        
	        for (Map.Entry<Double, Integer> entry : hashMap.entrySet()) {
    	        val = entry.getValue();
    	        max = Math.max(max, val);
    	        int a=0;
    	        
    	        if(a<val){
    	        	val=a;
    	        	key=entry.getKey();    	        	
    	        }
	        }	        
	    }
	    System.out.println(key);
	    
	    return max + 1;
	}
	public HashSet<Point> myAlgo(ArrayList<Double> x,ArrayList<Double> y){
		Point[] pp=new Point[x.size()];
		//HashMap<Integer, Point> in=new HashMap<>();
		for(int i=0;i<x.size();i++){
			pp[i]=new Point(x.get(i), y.get(i));
			//in.put(i, new Point(x.get(i), y.get(i)));
			
		}
		
		HashMap<Point,HashSet<Point>> aa=new HashMap<>();
		//HashMap<Double,HashSet<Point>> hh=new HashMap<Double,HashSet<Point>>();
		int maxLength=0;
		HashSet<Point> ans=new HashSet<Point>();
		for(int i=0;i<x.size()-1;i++){
			HashMap<Double,HashSet<Point>> hh=new HashMap<Double,HashSet<Point>>();
			//HashSet<Point> ans=new HashSet<Point>();
			for(int j=i+1;j<x.size();j++){
				Double slope;
				// Handing tan(pi/2) condition
				if(pp[j].x-pp[i].x==0.0){
					slope=Double.MAX_VALUE;
				}else{
					slope=(pp[j].y-pp[i].y)/(pp[j].x-pp[i].x);
				}
				if(pp[j].y-pp[i].y==0){
					slope=0.0;
				}
				if(hh.containsKey(slope)){
					HashSet<Point> set=hh.get(slope);
					set.add(pp[i]);
					set.add(pp[j]);
					/*if(slope.equals(1.0)){
					System.out.println("( "+pp[i].x+","+pp[i].y+" ) "+"( "+pp[j].x+","+pp[j].y+" ) ");
					}*/
					if(set.size()>maxLength){						
						maxLength=set.size();
						ans=set;
					}
					hh.replace(slope, set);					
				}else{
					HashSet<Point> set=new HashSet<Point>();
					set.add(pp[i]);
					set.add(pp[j]);
					if(set.size()>maxLength){						
						maxLength=set.size();
						ans=set;
					}
					/*if(slope.equals(1.0)){
						System.out.println("( "+pp[i].x+","+pp[i].y+" ) "+"( "+pp[j].x+","+pp[j].y+" ) ");
						}*/
					hh.put(slope,set);
					if(maxLength<2){
						maxLength =2;
					}
				}
				
			}
			
		}
		if(maxLength==0){
			HashSet<Point> ab=new HashSet<>();
			ab.add(pp[0]);
			return ab;
		}
		return ans;
	}
	
	public static void main(String[] args) throws IOException{		
		FileReader ff=new FileReader("./src/abc.txt");
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br=new BufferedReader(ff);
		String i;
		int c=0;
		int len=Integer.parseInt(br.readLine());
		Double[] a=new Double[len];
		Double[] b=new Double[len];
		while((i=br.readLine())!=null){
			String[] j=i.split(" ");			
			a[c]=Double.parseDouble(j[0]);
			b[c]=Double.parseDouble(j[1]);
			c++;			
		}		
		/*for(Double ij :a){
		 System.out.println(ij);
		 }
		System.out.println("end of x");
		System.out.println();
		for(Double ij :b){
			 System.out.println(ij);
			 }*/
		SolClass sl =new SolClass();
		//Iterator ii=sl.myAlgo(a, b).iterator();
		ArrayList<Double> t1=new ArrayList<>(Arrays.asList(a));
		ArrayList<Double> t2=new ArrayList<>(Arrays.asList(b));
		 for (Iterator iterator = sl.myAlgo(t1,t2).iterator(); iterator.hasNext();) {
		        Point type = (Point) iterator.next();
		        System.out.println(type.x+" "+type.y);
		    }
		System.out.println("Answe:");
		System.out.println(sl.maxPoints(t1, t2));	
		//System.out.println(Double.MAX_VALUE);
		br.close();
	}

}
