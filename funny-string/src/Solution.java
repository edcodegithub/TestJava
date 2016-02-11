import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner sc=new Scanner(System.in);
    int t= sc.nextInt();
    int[] res=new int[t+1];
    // Setting result values to zero
    for(int i=0;i<=t;i++){
    	res[i]=0;
    }
    for(int i=0;i<=t;i++){
    	
    		String s=sc.nextLine();
        	String r=new StringBuilder(s).reverse().toString();
        	for(int j=1;j<s.length();j++){
        		int test=Math.abs(s.charAt(j)-s.charAt(j-1));
        		int test1=Math.abs(r.charAt(j)-r.charAt(j-1));
        		if(test!=test1){
        		 res[i]=1;
        		 break;
        		}
        	}
    	}
    
    for(int i=1;i<=t;i++){
    	if(res[i]==0){
    		System.out.println("Funny");
    	}
    	else{
    		System.out.println("Not Funny");
    	}
    }
    System.out.println("Arry zero o/p="+res[0]);
    sc.close();
    }
}