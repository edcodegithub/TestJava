package com.Level2.Problems.CoverPoints;
import java.util.ArrayList;

public class Solution {	
	  // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
    	int ans=0;
    	for(int i=0;i<X.size()-1;i++){
    		int a=Math.abs(X.get(i)-X.get(i+1));
    		int b=Math.abs(Y.get(i)-Y.get(i+1));    		
    		if(a<b){
    			ans+= b;
    		}else{
    			ans+= a;
    		}
    		
    	}    	
		return ans;
    }
    
    public static void main(String[] args){
    	Integer dd=Integer.MIN_VALUE;
    	System.out.println(dd);
    }
}


