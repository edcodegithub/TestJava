import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * Note: An empty string is always a sub-string
 * @author srinath
 *
 */
public class Solution {
	
	//public static HashMap<String,String> h=new HashMap<String,String>();
	public static String  equal(String w1, String w2) {
		HashMap<String,String> h=new HashMap<String,String>();
		String w;
		int a=w1.length();
		int b=w2.length();
		if(a>b){
			w=w1;
			w1=w2;
			w2=w;
		}
		int seet=0;
		for(int j=0;j<w2.length();j++){				
			String q2=w2.charAt(j)+"";
		     h.put(q2,q2);								
		}		
	    
	    // Display elements
		for(int is=0;is<w1.length();is++){
			String qq=w1.charAt(is)+"";
		     if(h.containsKey(qq)){
		    	 seet=1;					
					break;
		     }
		     
						
		}
		if(seet==1){
		return "YES";	
		}else{
			return "NO";
		}	
		}    

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
     Scanner sc= new Scanner(System.in);
     int ic= sc.nextInt();
     sc.nextLine();
     String[] Output=new String[ic];
     for(int i=0;i<ic;i++){
    	 Output[i]= equal(sc.next(),sc.next());
     }
    	
     for(int i=0;i<ic;i++){
    	 System.out.println(Output[i]);;
     }
    
     
     
    }
}